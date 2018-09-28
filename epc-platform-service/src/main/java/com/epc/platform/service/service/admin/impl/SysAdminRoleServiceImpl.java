package com.epc.platform.service.service.admin.impl;
import com.google.common.collect.Lists;

import com.epc.administration.facade.admin.dto.UpdateRoleDTO;
import com.epc.administration.facade.admin.handle.RoleHandle;
import com.epc.common.constants.Const;
import com.epc.platform.service.domain.admin.*;
import com.epc.platform.service.mapper.admin.SysAdminRoleMapper;
import com.epc.platform.service.mapper.admin.SysAdminRoleResourceMapper;
import com.epc.platform.service.service.admin.SysAdminRoleResourceService;
import com.epc.platform.service.service.admin.SysAdminRoleService;
import com.epc.platform.service.service.admin.SysAdminUserRoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-13 14:41
 * <p>@Author : wjq
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class SysAdminRoleServiceImpl implements SysAdminRoleService {
    private static final Logger LOGGER = LoggerFactory.getLogger(SysAdminRoleServiceImpl.class);

    @Autowired
    private SysAdminRoleMapper sysAdminRoleMapper;
    @Autowired
    private SysAdminRoleResourceMapper sysAdminRoleResourceMapper;
    @Autowired
    private SysAdminRoleResourceService sysAdminRoleResourceService;
    @Autowired
    private SysAdminUserRoleService sysAdminUserRoleService;


    @Override
    public List<SysAdminRole> findUserRole(String userName) {
        return sysAdminRoleMapper.findUserRole(userName);
    }

    @Override
    public List<SysAdminRole> findAllRole() {
        try {
            final SysAdminRoleCriteria criteria = new SysAdminRoleCriteria();
            criteria.setOrderByClause("id desc");
            return sysAdminRoleMapper.selectByExample(criteria);
        } catch (Exception e) {
            LOGGER.error("获取角色信息失败", e);
            return new ArrayList<>();
        }
    }

    @Override
    public RoleWithSource findRoleWithResource(Long roleId) {
        List<RoleWithSource> list = this.sysAdminRoleMapper.findById(roleId);
        List<Long> menuList = new ArrayList<>();
        for (RoleWithSource rws : list) {
            menuList.add(rws.getMenuId());
        }
        if (list.isEmpty()) {
            return null;
        }
        RoleWithSource roleWithMenu = list.get(0);
        roleWithMenu.setMenuIds(menuList);
        return roleWithMenu;
    }

    @Override
    public SysAdminRole findByName(String roleName) {
        final SysAdminRoleCriteria criteria = new SysAdminRoleCriteria();
        criteria.createCriteria().andNameEqualTo(roleName);
        List<SysAdminRole> list = sysAdminRoleMapper.selectByExample(criteria);
        return list.isEmpty()? null : list.get(0);
    }

    @Override
    public void addRole(RoleHandle role, Long[] resourceIds) {
        SysAdminRole sysAdminRole = new SysAdminRole();
        sysAdminRole.setMemo(role.getMemo());
        sysAdminRole.setName(role.getName());
        sysAdminRole.setDeptId(role.getDepId());
        sysAdminRole.setCreateAt(new Date());
        sysAdminRole.setUpdateAt(new Date());
        sysAdminRole.setIsDeleted(Const.IS_DELETED.NOT_DELETED);
        sysAdminRoleMapper.insertSelective(sysAdminRole);
        setRoleResources(sysAdminRole, resourceIds);
    }

    /**
     * 1.批量删除角色
     * 2.删除角色关联资源
     * 3.删除该角色对应用户
     * @param roleIds
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteRoles(String roleIds) {
        List<String> list = Arrays.asList(roleIds.split(","));
        List<Long> longList = list.stream().map(Long::parseLong).collect(Collectors.toList());
        this.batchDelete(longList);
        this.sysAdminRoleResourceService.deleteRoleResourceByRoleId(roleIds);
        this.sysAdminUserRoleService.deleteUserRolesByRoleId(roleIds);
    }

    @Override
    public void updateRole(UpdateRoleDTO updateRoleDTO, Long[] resourceIds) {
        SysAdminRole sysAdminRole = new SysAdminRole();
        sysAdminRole.setDeptId(updateRoleDTO.getDepId());
        sysAdminRole.setName(updateRoleDTO.getName());
        sysAdminRole.setMemo(updateRoleDTO.getMemo());
        sysAdminRole.setId(updateRoleDTO.getRoleId());
        sysAdminRole.setUpdateAt(new Date());
        this.sysAdminRoleMapper.updateByPrimaryKeySelective(sysAdminRole);
        final SysAdminRoleResourceCriteria criteria = new SysAdminRoleResourceCriteria();
        criteria.createCriteria().andAmdinRoleIdEqualTo(updateRoleDTO.getDepId());
        this.sysAdminRoleResourceMapper.deleteByExample(criteria);
        setRoleResources(sysAdminRole, resourceIds);
    }


    /**
     * 批量删除角色
     * @param longList
     * @return
     */
    public int batchDelete(List<Long> longList) {
        final SysAdminRoleCriteria criteria = new SysAdminRoleCriteria();
        criteria.createCriteria().andIdIn(longList);
        return this.sysAdminRoleMapper.deleteByExample(criteria);
    }

    /**
     * 添加角色相关权限
     * @param role
     * @param resourceIds
     */
    private void setRoleResources(SysAdminRole role, Long[] resourceIds) {
        Date date = new Date();
        Arrays.stream(resourceIds).forEach(resourceId -> {
            SysAdminRoleResource ar = new SysAdminRoleResource();
            ar.setAdminResourceId(resourceId);
            ar.setAmdinRoleId(role.getId());
            ar.setCreateAt(date);
            ar.setUpdateAt(date);
            ar.setIsDeleted(Const.IS_DELETED.NOT_DELETED);
            this.sysAdminRoleResourceMapper.insert(ar);
        });
    }

}
