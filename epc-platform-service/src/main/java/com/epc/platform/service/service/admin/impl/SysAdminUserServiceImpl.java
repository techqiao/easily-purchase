package com.epc.platform.service.service.admin.impl;

import com.epc.common.Result;
import com.epc.common.util.MD5Util;
import com.epc.platform.service.domain.admin.SysAdminUser;
import com.epc.platform.service.domain.admin.SysAdminUserCriteria;
import com.epc.platform.service.domain.admin.SysAdminUserRole;
import com.epc.platform.service.domain.admin.UserWithRole;
import com.epc.platform.service.mapper.admin.SysAdminUserMapper;
import com.epc.platform.service.mapper.admin.SysAdminUserRoleMapper;
import com.epc.platform.service.service.admin.SysAdminUserRoleService;
import com.epc.platform.service.service.admin.SysAdminUserService;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;
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
 * <p>Date : 2018-09-13 16:45
 * <p>@Author : wjq
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class SysAdminUserServiceImpl implements SysAdminUserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(SysAdminUserServiceImpl.class);

    @Autowired
    private SysAdminUserMapper sysAdminUserMapper;
    @Autowired
    private SysAdminUserRoleMapper sysAdminUserRoleMapper;
    @Autowired
    private SysAdminUserRoleService sysAdminUserRoleService;

    @Override
    public Result<SysAdminUser> login(String phone, String password) {
        Validate.notNull(phone);
        Validate.notNull(password);
        final SysAdminUserCriteria criteria = new SysAdminUserCriteria();
        final SysAdminUserCriteria.Criteria subCriteria= criteria.createCriteria();
        subCriteria.andPhoneEqualTo(password);
        subCriteria.andPasswordEqualTo(MD5Util.MD5EncodeUtf8(password));
        List<SysAdminUser> list = sysAdminUserMapper.selectByExample(criteria);
        if(list.isEmpty()){
            return Result.error("登录失败");
        }
        return Result.success(list.get(0));
    }

    @Override
    public SysAdminUser findByName(String userName, String phone) {
        final SysAdminUserCriteria criteria = new SysAdminUserCriteria();
        final SysAdminUserCriteria.Criteria subCriteria= criteria.createCriteria();
        if (StringUtils.isNotBlank(userName)) {
            subCriteria.andNameEqualTo(userName);
        }
        if(StringUtils.isNotBlank(phone)){
            subCriteria.andPhoneEqualTo(phone);
        }
        List<SysAdminUser> sysAdminUserList = sysAdminUserMapper.selectByExample(criteria);
        return sysAdminUserList.isEmpty() ? null : sysAdminUserList.get(0);
    }

    @Override
    public UserWithRole findById(Long userId) {
        List<UserWithRole> list = this.sysAdminUserMapper.findUserWithRole(userId);
        List<Long> roleList = list.stream().map(UserWithRole::getRoleId).collect(Collectors.toList());
        if (roleList.isEmpty()) {
            return null;
        }
        UserWithRole userWithRole = list.get(0);
        userWithRole.setRoleIds(roleList);
        return userWithRole;
    }

    @Override
    public List<SysAdminUser> findUserWithDept(SysAdminUser user) {
        try {
            return this.sysAdminUserMapper.findUserWithDept(user);
        } catch (Exception e) {
            LOGGER.error("error", e);
            return new ArrayList<>();
        }
    }

    @Override
    public void registUser(SysAdminUser user) {
        user.setCreateAt(new Date());
        user.setPassword(MD5Util.MD5EncodeUtf8(user.getPassword()));
        sysAdminUserMapper.insert(user);
        SysAdminUserRole ur = new SysAdminUserRole();
        ur.setAdminUserId(user.getId());
        //注册账号角色控制，只允许查看
        ur.setAdminRoleId(2L);
        sysAdminUserRoleMapper.insertSelective(ur);
    }

    @Override
    public void addUser(SysAdminUser user, Long[] roles) {
        user.setCreateAt(new Date());
        user.setPassword(MD5Util.MD5EncodeUtf8(user.getPassword()));
        sysAdminUserMapper.insertSelective(user);
        setUserRoles(user, roles);
    }

    @Override
    public void updateUser(SysAdminUser user, Long[] roles) {
        user.setCreateAt(new Date());
        sysAdminUserMapper.updateByPrimaryKeySelective(user);
        setUserRoles(user, roles);
    }

    @Override
    public void deleteUsers(String userIds) {
        List<String> list = Arrays.asList(userIds.split(","));
        List<Long> longList = list.stream().map(Long::parseLong).collect(Collectors.toList());
        this.batchDelete(longList);
        this.sysAdminUserRoleService.deleteUserRolesByUserId(userIds);
    }

    @Override
    public void updatePassword(SysAdminUser user,String password) {
        String newPassword = MD5Util.MD5EncodeUtf8(user.getPassword());
        user.setPassword(newPassword);
        this.sysAdminUserMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public SysAdminUser findUserDetail(SysAdminUser user) {
        return this.sysAdminUserMapper.selectByPrimaryKey(user.getId());
    }

    @Override
    public void updateUserDetail(SysAdminUser user) {
        if(StringUtils.isNotBlank(user.getPassword())){
            String newPassword = MD5Util.MD5EncodeUtf8(user.getPassword());
            user.setPassword(newPassword);
        }
        this.sysAdminUserMapper.updateByPrimaryKeySelective(user);
    }

    public int batchDelete(List<Long> longList) {
        final SysAdminUserCriteria criteria = new SysAdminUserCriteria();
        criteria.createCriteria().andIdIn(longList);
        return this.sysAdminUserMapper.deleteByExample(criteria);
    }

    private void setUserRoles(SysAdminUser user, Long[] roles) {
        Arrays.stream(roles).forEach(roleId -> {
            SysAdminUserRole ur = new SysAdminUserRole();
            ur.setAdminUserId(user.getId());
            ur.setAdminRoleId(roleId);
            this.sysAdminUserRoleMapper.insert(ur);
        });
    }




}
