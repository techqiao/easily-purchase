package com.epc.platform.service.service.admin.impl;
import java.util.Date;

import com.epc.administration.facade.admin.dto.QueryUserDTO;
import com.epc.administration.facade.admin.handle.LoginHandle;
import com.epc.administration.facade.admin.handle.ResourceHandle;
import com.epc.administration.facade.admin.handle.UserHandle;
import com.epc.common.Result;
import com.epc.common.constants.Const;
import com.epc.common.util.MD5Util;
import com.epc.common.util.Tree;
import com.epc.common.util.TreeUtils;
import com.epc.platform.service.domain.admin.*;
import com.epc.platform.service.mapper.admin.SysAdminRoleResourceMapper;
import com.epc.platform.service.mapper.admin.SysAdminUserMapper;
import com.epc.platform.service.mapper.admin.SysAdminUserRoleMapper;
import com.epc.platform.service.service.admin.SysAdminResourceService;
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

import java.util.*;
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
    @Autowired
    private SysAdminRoleResourceMapper sysAdminRoleResourceMapper;
    @Autowired
    private SysAdminResourceService sysAdminResourceService;
    /**
     * 登录
     * @param loginHandle
     * @return
     */
    @Override
    public Result login(LoginHandle loginHandle) {
        Validate.notNull(loginHandle.getPhone());
        Validate.notNull(loginHandle.getPassword());
        final SysAdminUserCriteria criteria = new SysAdminUserCriteria();
        final SysAdminUserCriteria.Criteria subCriteria= criteria.createCriteria();
        subCriteria.andPhoneEqualTo(loginHandle.getPassword());
        subCriteria.andPasswordEqualTo(MD5Util.MD5EncodeUtf8(loginHandle.getPassword()));
        List<SysAdminUser> list = sysAdminUserMapper.selectByExample(criteria);
        if(list.isEmpty()){
            return Result.error("登录失败");
        }
        Tree<SysAdminResource> resource = getResource();
        Map<String,Object>  resultMap = new HashMap<String, Object>();
        list.get(0).setPassword(null);
        resultMap.put("user",list.get(0));
        resultMap.put("resourceList",resource);
        return Result.success(resultMap);
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
        SysAdminUser sysAdminUser = sysAdminUserMapper.selectByPrimaryKey(userId);
        SysAdminUserRoleCriteria criteria = new SysAdminUserRoleCriteria();
        criteria.createCriteria().andAdminUserIdEqualTo(sysAdminUser.getId());
        List<SysAdminUserRole> sysAdminUserRoles = sysAdminUserRoleMapper.selectByExample(criteria);
        UserWithRole userWithRole = new UserWithRole();
        userWithRole.setUserId(sysAdminUser.getId());
        userWithRole.setName(sysAdminUser.getName());
        userWithRole.setPhone(sysAdminUser.getPhone());
        userWithRole.setDeptId(sysAdminUser.getDeptId());
        userWithRole.setCreateAt(sysAdminUser.getCreateAt());
        userWithRole.setUpdateAt(sysAdminUser.getUpdateAt());
        userWithRole.setIsDeleted(sysAdminUser.getIsDeleted());
        List<Long> roleIds = new LinkedList<>();
        for (SysAdminUserRole sysAdminUserRole : sysAdminUserRoles) {
            roleIds.add(sysAdminUserRole.getId()) ;
        }
        userWithRole.setRoleIds(roleIds);
        return userWithRole;
    }

    /**
     * 分页查询所有用户
     * @return
     */
    @Override
    public List<SysAdminUser> findUserWithDept(QueryUserDTO queryUserDTO) {
        SysAdminUser sysAdminUser = new SysAdminUser();
        sysAdminUser.setName(queryUserDTO.getUserName());
        sysAdminUser.setPhone(queryUserDTO.getPhone());
        sysAdminUser.setDeptId(queryUserDTO.getDeptId());
        try {
            return this.sysAdminUserMapper.findUserWithDept(sysAdminUser);
        } catch (Exception e) {
            LOGGER.error("error", e);
            return new ArrayList<>();
        }
    }

    @Override
    public void registUser(UserHandle user) {
        SysAdminUser sysAdminUser = new SysAdminUser();

        sysAdminUser.setCreateAt(new Date());
        sysAdminUser.setPassword(MD5Util.MD5EncodeUtf8(user.getPassword()));
        sysAdminUserMapper.insert(sysAdminUser);
        SysAdminUserRole ur = new SysAdminUserRole();
        ur.setAdminUserId(sysAdminUser.getId());
        //注册账号角色控制，只允许查看
        ur.setAdminRoleId(2L);
        sysAdminUserRoleMapper.insertSelective(ur);
    }

    @Override
    public void addUser(UserHandle userHandle) {
        Date date =  new Date();
        SysAdminUser sysAdminUser = new SysAdminUser();
         sysAdminUser.setName(userHandle.getName());
         sysAdminUser.setPhone(userHandle.getPhone());
        sysAdminUser.setCreateAt(date);
        sysAdminUser.setUpdateAt(date);
        sysAdminUser.setDeptId(userHandle.getDeptId());
        sysAdminUser.setIsDeleted(Const.IS_DELETED.NOT_DELETED);
        sysAdminUser.setPassword(MD5Util.MD5EncodeUtf8(userHandle.getPassword()));
        sysAdminUserMapper.insertSelective(sysAdminUser);
        setUserRoles(userHandle);
    }

    @Override
    public void updateUser(UserHandle userHandle) {
        SysAdminUser sysAdminUser = new SysAdminUser();
        sysAdminUser.setId(userHandle.getId());
        sysAdminUser.setName(userHandle.getName());
        sysAdminUser.setPhone(userHandle.getPhone());
        sysAdminUser.setPassword(MD5Util.MD5EncodeUtf8(userHandle.getPassword()));
        sysAdminUser.setDeptId(userHandle.getDeptId());
        sysAdminUser.setUpdateAt(new Date());
        sysAdminUser.setIsDeleted(userHandle.getIsDeleted());
        sysAdminUserMapper.updateByPrimaryKeySelective(sysAdminUser);

        SysAdminUserRoleCriteria criteria = new SysAdminUserRoleCriteria();
        criteria.createCriteria().andAdminUserIdEqualTo(sysAdminUser.getId());

        List<SysAdminUserRole> sysAdminUserRoles = sysAdminUserRoleMapper.selectByExample(criteria);

        for (SysAdminUserRole sysAdminUserRole : sysAdminUserRoles) {
            SysAdminRoleResourceCriteria roReCriteria = new SysAdminRoleResourceCriteria();
            roReCriteria.createCriteria().andAdminResourceIdEqualTo(sysAdminUserRole.getAdminRoleId());
            sysAdminRoleResourceMapper.deleteByExample(roReCriteria);
        }
        setUserRoles(userHandle);
    }

    @Override
    public void deleteUsers(String userIds) {
        List<String> list = Arrays.asList(userIds.split(","));
        List<Long> longList = list.stream().map(Long::parseLong).collect(Collectors.toList());
        this.batchDelete(longList);
        this.sysAdminUserRoleService.deleteUserRolesByUserId(userIds);
    }

    @Override
    public void updatePassword(UserHandle user, String password) {
        SysAdminUser sysAdminUser = new SysAdminUser();
        sysAdminUser.setPhone(user.getPhone());
        sysAdminUser.setPassword(user.getPassword());
        String newPassword = MD5Util.MD5EncodeUtf8(user.getPassword());
        user.setPassword(newPassword);
        this.sysAdminUserMapper.updateByPrimaryKeySelective(sysAdminUser);
    }

    @Override
    public SysAdminUser findUserDetail(UserHandle userHandle) {
        SysAdminUser sysAdminUser = new SysAdminUser();
        sysAdminUser.setId(userHandle.getId());
        return this.sysAdminUserMapper.selectByPrimaryKey(userHandle.getId());
    }

    @Override
    public void updateUserDetail(UserHandle userHandle) {
        SysAdminUser sysAdminUser = new SysAdminUser();
        sysAdminUser.setUpdateAt(new Date());
        sysAdminUser.setIsDeleted(userHandle.getIsDeleted());
        sysAdminUser.setPhone(userHandle.getPhone());
        sysAdminUser.setId(userHandle.getId());
        sysAdminUser.setName(userHandle.getName());
        sysAdminUser.setDeptId(userHandle.getDeptId());
        if(sysAdminUser.getPassword()!=null){
            String newPassword = MD5Util.MD5EncodeUtf8(sysAdminUser.getPassword());
            sysAdminUser.setPassword(newPassword);
        }
        this.sysAdminUserMapper.updateByPrimaryKeySelective(sysAdminUser);
    }

    public int batchDelete(List<Long> longList) {
        final SysAdminUserCriteria criteria = new SysAdminUserCriteria();
        criteria.createCriteria().andIdIn(longList);
        return this.sysAdminUserMapper.deleteByExample(criteria);
    }

    private void setUserRoles(UserHandle userHandle) {
        Long[] roles = userHandle.getRoles();
        for (Long role : roles) {
            SysAdminUserRole ur = new SysAdminUserRole();
            ur.setAdminUserId(userHandle.getId());
            ur.setAdminRoleId(role);
            ur.setIsDeleted(Const.IS_DELETED.NOT_DELETED);
            this.sysAdminUserRoleMapper.insertSelective(ur);
        }
    }

    public Tree<SysAdminResource> getResource(){
        List<Tree<SysAdminResource>> trees = new ArrayList<>();
        List<SysAdminResource> sysAdminResources = sysAdminResourceService.findAllResources(new ResourceHandle());
        for (SysAdminResource sysAdminResource : sysAdminResources) {
            Tree<SysAdminResource> tree = new Tree<>();
            tree.setId(sysAdminResource.getId().toString());
            tree.setParentId(sysAdminResource.getParentId().toString());
            tree.setText(sysAdminResource.getName());
            tree.setUrl(sysAdminResource.getUrl());
            trees.add(tree);
        }
        return TreeUtils.build(trees);
    }

}
