package com.epc.platform.service.controller.admin;

import com.epc.common.Result;
import com.epc.common.constants.Const;
import com.epc.common.util.Tree;
import com.epc.platform.service.domain.admin.SysAdminResource;
import com.epc.platform.service.service.admin.SysAdminResourceService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-12 20:35
 * <p>@Author : wjq
 */
@RestController
public class ResourceController extends BaseController{

    private static final Logger LOGGER = LoggerFactory.getLogger(ResourceController.class);


    @Autowired
    private SysAdminResourceService sysAdminResourceService;

    //获取菜单信息
    @GetMapping(value ="getResource" )
    public Result getResource(String phone){
        try {
            List<SysAdminResource> sysAdminResources = sysAdminResourceService.findResource(phone);
            return Result.success(sysAdminResources);
        }catch (Exception e) {
            LOGGER.error("获取菜单失败", e);
            return Result.error("获取菜单失败！");
        }
    }

    //根据资源Id获取资源
    @GetMapping(value ="getResourceById" )
    public Result getResource(Long resourceId) {
        try {
            SysAdminResource menu = sysAdminResourceService.findById(resourceId);
            return Result.success(menu);
        } catch (Exception e) {
            LOGGER.error("获取菜单信息失败", e);
            return Result.error("获取信息失败，请联系网站管理员！");
        }
    }


    //根据资源Id获取资源列表
    @GetMapping(value = "getResourceButtonTree")
    public Result getResourceButtonTree() {
        try {
            Tree<SysAdminResource> tree = sysAdminResourceService.getResourceButtonTree();
            return Result.success(tree);
        } catch (Exception e) {
            LOGGER.error("获取菜单列表失败", e);
            return Result.error("获取菜单列表失败！");
        }
    }

    //获取菜单树
    public Result getRsourceTree() {
        try {
            Tree<SysAdminResource> tree = sysAdminResourceService.getResourceTree();
            return Result.success(tree);
        } catch (Exception e) {
            LOGGER.error("获取菜单树失败", e);
            return Result.error("获取菜单树失败！");
        }
    }

    //获取菜单集合
    public List<SysAdminResource> rsourceList(SysAdminResource sysAdminResource) {
        try {
            return this.sysAdminResourceService.findAllResources(sysAdminResource);
        } catch (Exception e) {
            LOGGER.error("获取菜单集合失败", e);
            return new ArrayList<>();
        }
    }

    //查看资源是否存在
    public boolean checkResourceName(String resourceName, String type, String oldResourceName) {
        if (StringUtils.isNotBlank(oldResourceName) && resourceName.equalsIgnoreCase(oldResourceName)) {
            return true;
        }
        SysAdminResource result = this.sysAdminResourceService.findByNameAndType(resourceName, type);
        return result == null;
    }

    //新增页面或者按钮
    public Result addResource(SysAdminResource sysAdminResource) {
        String name;
        if (Const.RESOURCE_TYPE.PAGE.equals(sysAdminResource.getType())) {
            name = "页面";
        } else {
            name = "功能";
        }
        try {
            this.sysAdminResourceService.addResource(sysAdminResource);
            return Result.success("新增" + name + "成功！");
        } catch (Exception e) {
            LOGGER.error("新增{}失败", name, e);
            return Result.error("新增" + name + "失败，请联系网站管理员！");
        }
    }

    //删除页面
    public Result deleteMenus(String ids) {
        try {
            this.sysAdminResourceService.deleteResources(ids);
            return Result.success("删除成功！");
        } catch (Exception e) {
            LOGGER.error("获取菜单失败", e);
            return Result.error("删除失败，请联系网站管理员！");
        }
    }

    //修改页面
    public Result updateMenu(SysAdminResource resource) {
        String name;
        if (Const.RESOURCE_TYPE.PAGE.equals(resource.getType()))
            name = "菜单";
        else
            name = "按钮";
        try {
            this.sysAdminResourceService.updateResource(resource);
            return Result.success("修改" + name + "成功！");
        } catch (Exception e) {
            LOGGER.error("修改{}失败", name, e);
            return Result.error("修改" + name + "失败，请联系网站管理员！");
        }
    }

    //获取所有页面
    public List<Map<String, String>> getAllUrl() {
        return this.sysAdminResourceService.getAllUrl("1");
    }

}
