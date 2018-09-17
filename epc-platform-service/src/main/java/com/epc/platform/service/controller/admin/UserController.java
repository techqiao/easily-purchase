package com.epc.platform.service.controller.admin;

import com.epc.common.QueryRequest;
import com.epc.common.Result;
import com.epc.common.util.MD5Util;
import com.epc.platform.service.domain.admin.SysAdminUser;
import com.epc.platform.service.service.admin.SysAdminUserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-13 16:44
 * <p>@Author : wjq
 */
@RestController
public class UserController extends BaseController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private SysAdminUserService sysAdminUserService;

    //检查用户是否存在
    public boolean checkUserName(String username, String oldusername) {
        if (StringUtils.isNotBlank(oldusername) && username.equalsIgnoreCase(oldusername)) {
            return true;
        }
        SysAdminUser result = this.sysAdminUserService.findByName(username,null);
        return result == null;
    }

    //获取用户详情
    public Result getUser(Long userId) {
        try {
            SysAdminUser user = this.sysAdminUserService.findById(userId);
            return Result.success(user);
        } catch (Exception e) {
            LOGGER.error("获取用户失败", e);
            return Result.error("获取用户失败，请联系网站管理员！");
        }
    }

    //获取用户信息 分页
    public Map<String, Object> userList(QueryRequest request, SysAdminUser user) {
        PageHelper.startPage(request.getPageNum(), request.getPageSize());
        List<SysAdminUser> list = this.sysAdminUserService.findUserWithDept(user);
        PageInfo<SysAdminUser> pageInfo = new PageInfo<>(list);
        return getDataTable(pageInfo);
    }

    //注冊
    public Result regist(SysAdminUser user) {
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

    //新增用户
    public Result addUser(SysAdminUser user, Long[] roles) {
        try {
            this.sysAdminUserService.addUser(user, roles);
            return Result.success("新增用户成功！");
        } catch (Exception e) {
            LOGGER.error("新增用户失败", e);
            return Result.error("新增用户失败，请联系网站管理员！");
        }
    }

    //修改用户角色
    public Result updateUser(SysAdminUser user, Long[] rolesSelect) {
        try {
            this.sysAdminUserService.updateUser(user, rolesSelect);
            return Result.success("修改用户成功！");
        } catch (Exception e) {
            LOGGER.error("修改用户失败", e);
            return Result.error("修改用户失败，请联系网站管理员！");
        }
    }

    //删除用户
    public Result deleteUsers(String ids) {
        try {
            this.sysAdminUserService.deleteUsers(ids);
            return Result.success("删除用户成功！");
        } catch (Exception e) {
            LOGGER.error("删除用户失败", e);
            return Result.error("删除用户失败，请联系网站管理员！");
        }
    }

    //校验密码
    public boolean checkPassword(String password,HttpServletRequest httpServletRequest) {
        SysAdminUser user = getCurrentUser(httpServletRequest);
        String encrypt = MD5Util.MD5EncodeUtf8(password);
        return user.getPassword().equals(encrypt);
    }

    //修改密码
    public Result updatePassword(String newPassword,HttpServletRequest httpServletRequest) {
        try {
            SysAdminUser user = getCurrentUser(httpServletRequest);
            this.sysAdminUserService.updatePassword(user,newPassword);
            return Result.success("更改密码成功！");
        } catch (Exception e) {
            LOGGER.error("修改密码失败", e);
            return Result.error("更改密码失败，请联系网站管理员！");
        }
    }

    //获取用户基本信息
    public Result getUserDetail(Long userId) {
        try {
            SysAdminUser user = new SysAdminUser();
            user.setId(userId);
            return Result.success(this.sysAdminUserService.findUserDetail(user));
        } catch (Exception e) {
            LOGGER.error("获取用户信息失败", e);
            return Result.error("获取用户信息失败，请联系网站管理员！");
        }
    }

    //更新用户信息
    public Result updateUserProfile(SysAdminUser user) {
        try {
            this.sysAdminUserService.updateUserDetail(user);
            return Result.success("更新个人信息成功！");
        } catch (Exception e) {
            LOGGER.error("更新用户信息失败", e);
            return Result.error("更新用户信息失败，请联系网站管理员！");
        }
    }
}
