package com.epc.administration.client.controller.admin;

import com.epc.administration.client.controller.admin.handle.ClientResourceHandle;
import com.epc.administration.client.remoteapi.admin.adminResourceClient;
import com.epc.administration.facade.admin.handle.ResourceHandle;
import com.epc.common.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-15 10:21
 * <p>@Author : luozhixin
 */
@Api(value = "系统资源",tags = {"系统资源服务"})
@RestController
@RequestMapping(value = "/resource", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class AdminResourceController {

    @Autowired
    private adminResourceClient sysAdminResourceClient;


    /**
     * 获取菜单信息
     * @param phone
     * @return
     */
    @ApiOperation(value = "获取菜单信息", notes = "获取菜单信息")
    @PostMapping(value = "getResource")
    public Result getResource(@RequestBody String phone){
       return  sysAdminResourceClient.getResource(phone);
    }

    /**根据资源Id获取资源
     * @param resourceId
     * @return
     */
    @ApiOperation(value = "根据资源Id获取资源", notes = "根据资源Id获取资源")
    @PostMapping(value = "getResourceById")
    public Result getResource(@RequestBody Long resourceId) {
        return  sysAdminResourceClient.getResource(resourceId);
    }


    /**获取资源列表
     * @return
     */
    @ApiOperation(value = "获取资源列表", notes = "获取资源列表")
    @PostMapping(value = "getResourceButtonTree")
    public Result getResourceButtonTree() {
        return  sysAdminResourceClient.getResourceButtonTree();
    }

    /**获取菜单树
     * @return
     */
    @ApiOperation(value = "获取菜单树", notes = "获取菜单树")
    @PostMapping(value = "getResourceTree")
    public Result getResourceTree() {

        return sysAdminResourceClient.getResourceTree();
    }

    /**获取菜单集合
     * @param clientResourceHandle
     * @return
     */
    @ApiOperation(value = "获取菜单集合", notes = "获取菜单集合")
    @PostMapping(value = "resourceList")
    public Result resourceList(@RequestBody ClientResourceHandle clientResourceHandle) {
        ResourceHandle resourceHandle = new ResourceHandle();
        BeanUtils.copyProperties(clientResourceHandle,resourceHandle);
       return  sysAdminResourceClient.resourceList(resourceHandle);
    }

    /**查看资源是否存在
     * @param resourceName
     * @param type
     * @param oldResourceName
     * @return
     */
    @ApiOperation(value = "查看资源是否存在", notes = "查看资源是否存在")
    @PostMapping(value = "checkResourceName")
    public Result checkResourceName(@RequestParam("resourceName") String resourceName,
                                    @RequestParam("type") String type,
                                    @RequestParam("oldResourceName") String oldResourceName) {
        return  sysAdminResourceClient.checkResourceName(resourceName, type, oldResourceName);
    }

    /**新增页面或者按钮
     * @param clientResourceHandle
     * @return
     */
    @ApiOperation(value = "新增页面或者按钮", notes = "新增页面或者按钮")
    @PostMapping(value = "addResource")
    public Result addResource(@RequestBody ClientResourceHandle clientResourceHandle) {
        ResourceHandle  resourceHandle = new ResourceHandle();
        BeanUtils.copyProperties(clientResourceHandle,resourceHandle);
       return  sysAdminResourceClient.addResource(resourceHandle);
    }

    /**删除页面
     * @param ids
     * @return
     */
    @ApiOperation(value = "删除页面", notes = "删除页面")
    @PostMapping(value = "deleteMenus")
    public Result deleteMenus(String ids) {
       return  sysAdminResourceClient.deleteMenus(ids);
    }

    /**修改页面
     * @param clientResourceHandle
     * @return
     */
    @ApiOperation(value = "修改页面", notes = "修改页面")
    @PostMapping(value = "updateMenu")
    public Result updateMenu(@RequestBody ClientResourceHandle clientResourceHandle) {
        ResourceHandle resourceHandle = new ResourceHandle();
        BeanUtils.copyProperties(clientResourceHandle,resourceHandle);
        return  sysAdminResourceClient.updateMenu(resourceHandle);
    }

    /**获取所有页面
     * @return
     */
    @ApiOperation(value = "获取所有页面", notes = "获取所有页面")
    @PostMapping(value = "getAllUrl")
    public Result getAllUrl() {
        return this.sysAdminResourceClient.getAllUrl();
    }

}
