package com.epc.platform.service.controller.admin;

import com.epc.administration.facade.admin.AdminUserService;
import com.epc.administration.facade.admin.dto.QueryUserDTO;
import com.epc.administration.facade.admin.handle.UserHandle;
import com.epc.common.Result;
import com.epc.common.util.MD5Util;
import com.epc.platform.service.domain.admin.SysAdminUser;
import com.epc.platform.service.domain.admin.UserWithRole;
import com.epc.platform.service.service.admin.SysAdminUserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-13 16:44
 * <p>@Author : wjq
 */
@RestController
public class UserController extends BaseController implements AdminUserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private SysAdminUserService sysAdminUserService;

    /**检查用户是否存在
     * @param username
     * @return
     */
    @Override
    public Result<Boolean> checkUserName(String username) {
        SysAdminUser result = this.sysAdminUserService.findByName(username,null);
        return Result.success(result==null?true:false);
    }

    /**获取用户详情
     * @param userId
     * @return
     */
    @Override
    public Result<UserWithRole> getUser(@RequestParam("userId") Long userId) {
        try {
            UserWithRole userWithRole = sysAdminUserService.findById(userId);
            return Result.success(userWithRole);
        } catch (Exception e) {
            LOGGER.error("获取用户失败", e);
            return Result.error("获取用户失败，请联系网站管理员！");
        }
    }

    /**获取用户信息 分页
     * @param queryUserDTO
     * @return
     */
    @Override
    public Result userList(@RequestBody QueryUserDTO queryUserDTO) {
        PageHelper.startPage(queryUserDTO.getPageNum(), queryUserDTO.getPageSize());
        List<SysAdminUser> list = this.sysAdminUserService.findUserWithDept(queryUserDTO);
        PageInfo<SysAdminUser> pageInfo = new PageInfo<>(list);
        return Result.success(getDataTable(pageInfo));
    }

    /**注冊
     * @param user
     * @return
     */
    @Override
    public Result regist(UserHandle user) {
        try {
            SysAdminUser result = this.sysAdminUserService.findByName(user.getName(),null);
            if (result != null) {
                return Result.error("该用户名已被使用！");
            }
            this.sysAdminUserService.registUser(user);
            return Result.success();
        } catch (Exception e) {
            LOGGER.error("注册失败", e);
            return Result.error("注册失败，请联系网站管理员！");
        }
    }

    /**新增用户
     * @param user
     * @return
     */
    @Override
    public Result addUser(@RequestBody UserHandle user) {
        try {
            this.sysAdminUserService.addUser(user);
            return Result.success("新增用户成功");
        } catch (Exception e) {
            LOGGER.error("新增用户失败", e);
            return Result.error("新增用户失败，请联系网站管理员！");
        }
    }

    /**修改用户角色
     * @param user
     * @return
     */
    @Override
    public Result updateUser(@RequestBody UserHandle user) {
        try {
            this.sysAdminUserService.updateUser(user);
            return Result.success("修改用户成功！");
        } catch (Exception e) {
            LOGGER.error("修改用户失败", e);
            return Result.error("修改用户失败，请联系网站管理员！");
        }
    }

    /**删除用户
     * @param ids
     * @return
     */
    @Override
    public Result deleteUsers(@RequestBody String ids) {
        try {
            this.sysAdminUserService.deleteUsers(ids);
            return Result.success("删除用户成功！");
        } catch (Exception e) {
            LOGGER.error("删除用户失败", e);
            return Result.error("删除用户失败，请联系网站管理员！");
        }
    }

    /**校验密码
     * @param password
     * @param httpServletRequest
     * @return
     */
    @Override
    public Result checkPassword(@RequestBody String password, @RequestParam("httpServletRequest")HttpServletRequest httpServletRequest) {
        SysAdminUser user = getCurrentUser(httpServletRequest);
        String encrypt = MD5Util.MD5EncodeUtf8(password);
        return Result.success(user.getPassword().equals(encrypt));
    }

    /**修改密码
     * @param userHandle
     * @return Result
     */
    @Override
    public Result updatePassword(@RequestBody UserHandle userHandle) {
        try {
            this.sysAdminUserService.updatePassword(userHandle);
            return Result.success("更改密码成功！");
        } catch (Exception e) {
            LOGGER.error("修改密码失败", e);
            return Result.error("更改密码失败，请联系网站管理员！");
        }
    }

    /**获取用户基本信息
     * @param userId
     * @return
     */
    @Override
    public Result getUserDetail(@RequestParam("userId") Long userId) {
        try {
            return Result.success(this.sysAdminUserService.findUserDetail(userId));
        } catch (Exception e) {
            LOGGER.error("获取用户信息失败", e);
            return Result.error("获取用户信息失败，请联系网站管理员！");
        }
    }

    /**更新用户信息
     * @param user
     * @return
     */
    @Override
    public Result updateUserProfile(@RequestBody UserHandle user){
        try {
            this.sysAdminUserService.updateUserDetail(user);
            return Result.success("更新个人信息成功！");
        } catch (Exception e) {
            LOGGER.error("更新用户信息失败", e);
            return Result.error("更新用户信息失败，请联系网站管理员！");
        }
    }


}
