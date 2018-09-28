package com.epc.platform.service.controller.admin;

import com.epc.administration.facade.admin.AdminResourceService;
import com.epc.administration.facade.admin.handle.ResourceHandle;
import com.epc.common.Result;
import com.epc.common.constants.Const;
import com.epc.common.util.Tree;
import com.epc.platform.service.domain.admin.SysAdminResource;
import com.epc.platform.service.service.admin.SysAdminResourceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-12 20:35
 * <p>@Author : wjq
 */
@Api(value = "资源服务", description = "资源服务")
@RestController
public class ResourceController extends BaseController implements AdminResourceService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ResourceController.class);

    @Autowired
    private SysAdminResourceService sysAdminResourceService;

    /**获取菜单信息
     * @param phone
     * @return
     */
    @Override
    public Result getResource(@RequestBody String phone){

        try {
            List<SysAdminResource> sysAdminResources = sysAdminResourceService.findResource(phone);
            return Result.success(sysAdminResources);
        }catch (Exception e) {
            LOGGER.error("获取菜单失败", e);
            return Result.error("获取菜单失败！");
        }
    }

    /**根据资源Id获取资源
     * @param resourceId
     * @return
     */
    @Override
    public Result getResource(@RequestBody Long resourceId) {
        try {
            SysAdminResource menu = sysAdminResourceService.findById(resourceId);
            return Result.success(menu);
        } catch (Exception e) {
            LOGGER.error("获取菜单信息失败", e);
            return Result.error("获取信息失败，请联系网站管理员！");
        }
    }


    /**根据资源Id获取资源列表
     * @return
     */
    @ApiOperation(value = "根据资源Id获取资源列表", notes = "根据资源Id获取资源列表")
    @Override
    public Result getResourceButtonTree() {
        try {
            Tree<SysAdminResource> tree = sysAdminResourceService.getResourceButtonTree();
            return Result.success(tree);
        } catch (Exception e) {
            LOGGER.error("获取菜单列表失败", e);
            return Result.error("获取菜单列表失败！");
        }
    }

    /**获取菜单树
     * @return
     */
    @ApiOperation(value = "获取菜单树", notes = "获取菜单树")
    @Override
    public Result getResourceTree() {
        try {
            Tree<SysAdminResource> tree = sysAdminResourceService.getResourceTree();
            return Result.success(tree);
        } catch (Exception e) {
            LOGGER.error("获取菜单树失败", e);
            return Result.error("获取菜单树失败！");
        }
    }

    /**获取菜单集合
     * @param resourceHandle
     * @return
     */
    @ApiOperation(value = "获取菜单集合", notes = "获取菜单集合")
    @Override
    public Result resourceList(@RequestBody ResourceHandle resourceHandle) {
        try {
            return Result.success(sysAdminResourceService.findAllResources(resourceHandle));
        } catch (Exception e) {
            LOGGER.error("获取菜单集合失败", e);
            return Result.success(new ArrayList<>());
        }
    }

    /**查看资源是否存在
     * @param resourceName
     * @param type
     * @param oldResourceName
     * @return
     */
    @ApiOperation(value = "查看资源是否存在", notes = "查看资源是否存在")
    @Override
    public Result checkResourceName(@RequestBody String resourceName, String type, String oldResourceName) {
        if (StringUtils.isNotBlank(oldResourceName) && resourceName.equalsIgnoreCase(oldResourceName)) {
            return Result.success();
        }
        SysAdminResource result = this.sysAdminResourceService.findByNameAndType(resourceName, type);
        return Result.success(result);
    }

    /**新增页面或者按钮
     * @param resourceHandle
     * @return
     */
    @ApiOperation(value = "新增页面或者按钮", notes = "新增页面或者按钮")
    @Override
    public Result addResource(@RequestBody ResourceHandle resourceHandle) {
        String name;
        if (Const.RESOURCE_TYPE.PAGE.equals(resourceHandle.getType())) {
            name = "页面";
        } else {
            name = "功能";
        }
        try {
            this.sysAdminResourceService.addResource(resourceHandle);
            return Result.success("新增" + name + "成功！");
        } catch (Exception e) {
            LOGGER.error("新增{}失败", name, e);
            return Result.error("新增" + name + "失败，请联系网站管理员！");
        }
    }

    /**删除页面
     * @param ids
     * @return
     */
    @ApiOperation(value = "删除页面", notes = "删除页面")
    @Override
    public Result deleteMenus(@RequestBody String ids) {
        try {
            this.sysAdminResourceService.deleteResources(ids);
            return Result.success("删除成功！");
        } catch (Exception e) {
            LOGGER.error("获取菜单失败", e);
            return Result.error("删除失败，请联系网站管理员！");
        }
    }

    /**修改页面
     * @param resourceHandle
     * @return
     */
    @ApiOperation(value = "修改页面", notes = "修改页面")
    @Override
    public Result updateMenu(@RequestBody ResourceHandle resourceHandle) {
        String name;
        if (Const.RESOURCE_TYPE.PAGE.equals(resourceHandle.getType())) {
            name = "菜单";
        } else {
            name = "按钮";
        }
        try {
            this.sysAdminResourceService.updateResource(resourceHandle);
            return Result.success("修改" + name + "成功！");
        } catch (Exception e) {
            LOGGER.error("修改{}失败", name, e);
            return Result.error("修改" + name + "失败，请联系网站管理员！");
        }
    }

    /**获取所有页面
     * @return
     */
    @ApiOperation(value = "获取所有页面", notes = "获取所有页面")
    @Override
    public Result getAllUrl() {
        return Result.success(this.sysAdminResourceService.getAllUrl("1"));
    }

}
