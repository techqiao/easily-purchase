package com.epc.platform.service.service.admin.impl;

import com.epc.platform.service.domain.admin.SysAdminUserRoleCriteria;
import com.epc.platform.service.mapper.admin.SysAdminUserRoleMapper;
import com.epc.platform.service.service.admin.SysAdminUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-13 16:33
 * <p>@Author : luozhixin
 */
@Service
public class SysAdminUserRoleServiceImpl implements SysAdminUserRoleService {

    @Autowired
    private SysAdminUserRoleMapper sysAdminUserRoleMapper;

    /**
     * 删除用户角色根据角色id
     * @param roleIds
     */
    @Override
    public void deleteUserRolesByRoleId(String roleIds) {
        List<String> list = Arrays.asList(roleIds.split(","));
        List<Long> longList = list.stream().map(Long::parseLong).collect(Collectors.toList());
        this.batchDeleteByRoleId(longList);
    }

    /**
     * 删除用户角色根据用户id
     * @param userIds
     */
    @Override
    public void deleteUserRolesByUserId(String userIds) {
        List<String> list = Arrays.asList(userIds.split(","));
        List<Long> longList = list.stream().map(Long::parseLong).collect(Collectors.toList());
        this.batchDeleteByUserId(longList);
    }

    /**
     * 根据角色id删除角色关联用户
     * @param longList
     * @return
     */
    public int batchDeleteByRoleId(List<Long> longList) {
        final SysAdminUserRoleCriteria criteria = new SysAdminUserRoleCriteria();
        criteria.createCriteria().andAdminRoleIdIn(longList);
        return this.sysAdminUserRoleMapper.deleteByExample(criteria);
    }

    /**
     * 根据用户id删除角色关联用户
     * @param longList
     * @return
     */
    public int batchDeleteByUserId(List<Long> longList) {
        final SysAdminUserRoleCriteria criteria = new SysAdminUserRoleCriteria();
        criteria.createCriteria().andAdminUserIdIn(longList);
        return this.sysAdminUserRoleMapper.deleteByExample(criteria);
    }


}
