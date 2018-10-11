package com.epc.platform.service.service.admin.impl;
import java.util.Date;

import com.epc.administration.facade.admin.dto.QueryUserDTO;
import com.epc.administration.facade.admin.handle.LoginHandle;
import com.epc.administration.facade.admin.handle.UserHandle;
import com.epc.administration.facade.admin.vo.userVO;
import com.epc.common.Result;
import com.epc.common.constants.Const;
import com.epc.common.util.MD5Util;
import com.epc.common.util.Tree;
import com.epc.common.util.TreeUtils;
import com.epc.platform.service.domain.admin.*;
import com.epc.platform.service.mapper.admin.SysAdminResourceMapper;
import com.epc.platform.service.mapper.admin.SysAdminRoleResourceMapper;
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

import java.util.*;
import java.util.stream.Collectors;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-13 16:45
 * <p>@Author : luozhixin
 */
@Service
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
    private SysAdminResourceMapper sysAdminResourceMapper;
    /**
     * 登录
     * @param loginHandle
     * @return
     */
    @Override
    public Result<Map<String,Object>> login(LoginHandle loginHandle,String token) {
        Validate.notNull(loginHandle.getPhone());
        Validate.notNull(loginHandle.getPassword());
        final SysAdminUserCriteria criteria = new SysAdminUserCriteria();
        final SysAdminUserCriteria.Criteria subCriteria= criteria.createCriteria();
        subCriteria.andPhoneEqualTo(loginHandle.getPhone());
        subCriteria.andPasswordEqualTo(MD5Util.MD5EncodeUtf8(loginHandle.getPassword()));
        List<SysAdminUser> sysAdminUsers = sysAdminUserMapper.selectByExample(criteria);
        if(sysAdminUsers.isEmpty()){
            return Result.error("登录失败");
        }
        SysAdminUser sysAdminUser = sysAdminUsers.get(0);
        Map<String,Object>  resultMap = new HashMap<String, Object>(16);
        sysAdminUser.setPassword(null);
        resultMap.put("user",sysAdminUser);
        Tree<SysAdminResource> resource = getResource(sysAdminUser.getId());
        resultMap.put("resourceList",resource);
        resultMap.put("epc-token", token);
        return Result.success(resultMap);
    }

    /**
     * 根据name查找用户信息
     * @param userName
     * @param phone
     * @return
     */
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

    /**
     * 根据id查找用户信息
     * @param userId
     * @return
     */
    @Override
    public UserWithRole findById(Long userId) {
        SysAdminUser sysAdminUser = sysAdminUserMapper.selectByPrimaryKey(userId);
        SysAdminUserRoleCriteria criteria = new SysAdminUserRoleCriteria();
        criteria.createCriteria().andAdminUserIdEqualTo(sysAdminUser.getId());
        List<SysAdminUserRole> sysAdminUserRoles = sysAdminUserRoleMapper.selectByExample(criteria);
        UserWithRole userWithRole = new UserWithRole();
        userWithRole.setId(sysAdminUser.getId());
        userWithRole.setName(sysAdminUser.getName());
        userWithRole.setPhone(sysAdminUser.getPhone());
        userWithRole.setDeptId(sysAdminUser.getDeptId());
        userWithRole.setCreateAt(sysAdminUser.getCreateAt());
        userWithRole.setUpdateAt(sysAdminUser.getUpdateAt());
        userWithRole.setIsDeleted(sysAdminUser.getIsDeleted());
        List<Long> roleIds = new LinkedList<>();
        for (SysAdminUserRole sysAdminUserRole : sysAdminUserRoles) {
            roleIds.add(sysAdminUserRole.getAdminRoleId()) ;
        }
        userWithRole.setRoleIds(roleIds);
        return userWithRole;
    }

    /**
     * 分页查询所有用户
     * @return
     */
    @Override
    public List<userVO> findUserWithDept(QueryUserDTO queryUserDTO) {
        SysAdminUser sysAdminUser = new SysAdminUser();
        String phone = queryUserDTO.getPhone();
        String userName = queryUserDTO.getUserName();
        if(!StringUtils.isNotBlank(phone)){
            phone="%"+phone+"%";
        }
        if(StringUtils.isNotBlank(userName)){
            userName="%"+userName+"%";
        }
        sysAdminUser.setName(userName);
        sysAdminUser.setPhone(phone);
        sysAdminUser.setDeptId(queryUserDTO.getDeptId());
        try {
            return this.sysAdminUserMapper.findUserWithDept(sysAdminUser);
        } catch (Exception e) {
            LOGGER.error("findUserWithDept", e);
            return new ArrayList<>();
        }
    }

    /**
     * 校验用户
     * @param user
     */
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

    /**
     * 添加用户
     * @param userHandle
     */
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
        userHandle.setId(sysAdminUser.getId());
        setUserRoles(userHandle);
    }

    /**
     * 修改用户
     * @param userHandle
     */
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

    /**
     * 删除用户
     * @param userIds
     */
    @Override
    public void deleteUsers(String userIds) {
        List<String> list = Arrays.asList(userIds.split(","));
        List<Long> longList = list.stream().map(Long::parseLong).collect(Collectors.toList());
        //不允许删除admin管理员
        for (Long aLong : longList) {
            if(5==aLong){
                longList.remove(aLong);
            }
        }
        this.batchDelete(longList);
        this.sysAdminUserRoleService.deleteUserRolesByUserId(userIds);
    }

    /**
     * 修改密码
     * @param user
     */
    @Override
    public void updatePassword(UserHandle user) {
        SysAdminUser sysAdminUser = new SysAdminUser();
        sysAdminUser.setId(user.getId());
        String newPassword = MD5Util.MD5EncodeUtf8(user.getPassword());
        sysAdminUser.setPassword(newPassword);
        this.sysAdminUserMapper.updateByPrimaryKeySelective(sysAdminUser);
    }

    /**
     * 根据用户id查找用户详情
     * @param userId
     * @return
     */
    @Override
    public SysAdminUser findUserDetail(Long userId) {
        SysAdminUser sysAdminUser = sysAdminUserMapper.selectByPrimaryKey(userId);
        sysAdminUser.setPassword(null);
        return sysAdminUser;
    }

    /**
     * 修改用户详情
     * @param userHandle
     */
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

    /**
     * 批量删除用户
     * @param longList
     * @return
     */
    public int batchDelete(List<Long> longList) {
        final SysAdminUserCriteria criteria = new SysAdminUserCriteria();
        criteria.createCriteria().andIdIn(longList);
        return this.sysAdminUserMapper.deleteByExample(criteria);
    }

    /**
     * 添加用户角色
     * 插入用户对应的角色 分方法
     * @param userHandle
     */
    private void setUserRoles(UserHandle userHandle) {
        Long[] roles = userHandle.getRoles();
        for (Long role : roles) {
            SysAdminUserRole ur = new SysAdminUserRole();
            ur.setAdminUserId(userHandle.getId());
            ur.setAdminRoleId(role);
            ur.setIsDeleted(Const.IS_DELETED.NOT_DELETED);
            sysAdminUserRoleMapper.insertSelective(ur);
        }
    }

    /**
     * 获取登录用户对应的角色和资源
     * @param id
     * @return
     */
    public Tree<SysAdminResource> getResource(Long id){
        List<Tree<SysAdminResource>> trees = new ArrayList<>();
        //取出用户对应角色
        SysAdminUserRoleCriteria criteria = new SysAdminUserRoleCriteria();
        criteria.createCriteria().andAdminUserIdEqualTo(id);
        List<SysAdminUserRole> sysAdminUserRoles = sysAdminUserRoleMapper.selectByExample(criteria);
        if(sysAdminUserRoles==null){
            return null;
        }
        List<Long> roleIds =  new ArrayList<>();
        for (SysAdminUserRole sysAdminUserRole : sysAdminUserRoles) {
            roleIds.add(sysAdminUserRole.getAdminRoleId());
        }
        //取出角色对应资源
        Set<Long> resourceIds  = new HashSet<>();
        for (Long roleId : roleIds) {
            SysAdminRoleResourceCriteria sysAdminRoleResourceCriteria = new SysAdminRoleResourceCriteria();
            sysAdminRoleResourceCriteria.createCriteria().andAmdinRoleIdEqualTo(roleId);
            List<SysAdminRoleResource> sysAdminRoleResources = sysAdminRoleResourceMapper.selectByExample(sysAdminRoleResourceCriteria);
            if(sysAdminRoleResources==null){
                return null;
            }
            for (SysAdminRoleResource sysAdminRoleResource : sysAdminRoleResources) {
                resourceIds.add(sysAdminRoleResource.getAdminResourceId());
            }
        }
        for (Long toGetResourceId : resourceIds) {
            SysAdminResource sysAdminResource = sysAdminResourceMapper.selectByPrimaryKey(toGetResourceId);
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
