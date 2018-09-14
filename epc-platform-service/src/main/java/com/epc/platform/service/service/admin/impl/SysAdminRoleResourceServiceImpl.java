package com.epc.platform.service.service.admin.impl;

import com.epc.platform.service.domain.admin.SysAdminRoleResourceCriteria;
import com.epc.platform.service.mapper.admin.SysAdminRoleResourceMapper;
import com.epc.platform.service.service.admin.SysAdminRoleResourceService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-13 16:29
 * <p>@Author : wjq
 */
@Service
public class SysAdminRoleResourceServiceImpl implements SysAdminRoleResourceService {

    private SysAdminRoleResourceMapper sysAdminRoleResourceMapper;

    @Override
    public void deleteRoleResourceByRoleId(String roleIds) {
        List<String> list = Arrays.asList(roleIds.split(","));
        List<Long> longList = list.stream().map(Long::parseLong).collect(Collectors.toList());
        this.batchDelete(longList);
    }

    /**
     * 根据角色id删除角色关联资源
     * @param longList
     * @return
     */
    public int batchDelete(List<Long> longList) {
        final SysAdminRoleResourceCriteria criteria = new SysAdminRoleResourceCriteria();
        criteria.createCriteria().andIdIn(longList);
        return this.sysAdminRoleResourceMapper.deleteByExample(criteria);
    }
}
