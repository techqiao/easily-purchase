package com.epc.platform.service.service.admin.impl;

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
    public List<SysAdminRole> findAllRole(SysAdminRole role) {
        try {
            final SysAdminRoleCriteria criteria = new SysAdminRoleCriteria();
            criteria.setOrderByClause("id desc");
            criteria.createCriteria().andNameEqualTo(role.getMemo());
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
    public void addRole(SysAdminRole role, Long[] resourceIds) {
        role.setCreateAt(new Date());
        role.setUpdateAt(new Date());
        role.setIsDeleted(Const.IS_DELETED.NOT_DELETED);
        sysAdminRoleMapper.insertSelective(role);
        setRoleResources(role, resourceIds);
    }

    @Override
    @Transactional
    public void deleteRoles(String roleIds) {
        //1.批量删除角色
        //2.删除角色关联资源
        //3.删除该角色对应用户
        List<String> list = Arrays.asList(roleIds.split(","));
        List<Long> longList = list.stream().map(Long::parseLong).collect(Collectors.toList());
        this.batchDelete(longList);
        this.sysAdminRoleResourceService.deleteRoleResourceByRoleId(roleIds);
        this.sysAdminUserRoleService.deleteUserRolesByRoleId(roleIds);
    }

    @Override
    public void updateRole(SysAdminRole role, Long[] resourceIds) {
        role.setUpdateAt(new Date());
        this.sysAdminRoleMapper.updateByPrimaryKeySelective(role);
        final SysAdminRoleResourceCriteria criteria = new SysAdminRoleResourceCriteria();
        criteria.createCriteria().andAmdinRoleIdEqualTo(role.getId());
        this.sysAdminRoleResourceMapper.deleteByExample(criteria);
        setRoleResources(role, resourceIds);
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
        Arrays.stream(resourceIds).forEach(resourceId -> {
            SysAdminRoleResource ar = new SysAdminRoleResource();
            ar.setAdminResourceId(resourceId);
            ar.setAmdinRoleId(role.getId());
            this.sysAdminRoleResourceMapper.insert(ar);
        });
    }

}
