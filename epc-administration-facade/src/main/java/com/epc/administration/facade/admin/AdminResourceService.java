package com.epc.administration.facade.admin;

import com.epc.administration.facade.admin.handle.ResourceHandle;
import com.epc.common.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-15 10:04
 * <p>@Author : luozhixin
 */
public interface AdminResourceService {

    /**获取菜单信息
     * @param phone
     * @return
     */
    @GetMapping(value ="getResource" , consumes = "application/json; charset=UTF-8")
     Result getResource(@RequestBody String phone);

    /**根据资源Id获取资源
     * @param resourceId
     * @return
     */
    @GetMapping(value ="getResourceById", consumes = "application/json; charset=UTF-8" )
     Result getResource(@RequestBody Long resourceId);


    /**根据资源Id获取资源列表
     * @return
     */
    @GetMapping(value = "getResourceButtonTree", consumes = "application/json; charset=UTF-8")
     Result getResourceButtonTree();

    /**获取菜单树
     * @return
     */
    @PostMapping(value = "getResourceTree", consumes = "application/json; charset=UTF-8")
     Result getResourceTree();

    /**获取菜单集合
     * @param resourceHandle
     * @return
     */
    @PostMapping(value = "resourceList", consumes = "application/json; charset=UTF-8")
     Result resourceList(ResourceHandle resourceHandle);

    /**查看资源是否存在
     * @param resourceName
     * @param type
     * @param oldResourceName
     * @return
     */
    @PostMapping(value = "checkResourceName", consumes = "application/json; charset=UTF-8")
     Result checkResourceName(@RequestParam("resourceName") String resourceName,
                              @RequestParam("type") String type,
                              @RequestParam("oldResourceName") String oldResourceName);

    /**新增页面或者按钮
     * @param resourceHandle
     * @return
     */
    @PostMapping(value = "addResource", consumes = "application/json; charset=UTF-8")
     Result addResource(@RequestBody ResourceHandle resourceHandle) ;

    /**删除页面
     * @param ids
     * @return
     */
    @PostMapping(value = "deleteMenus", consumes = "application/json; charset=UTF-8")
     Result deleteMenus(@RequestBody String ids) ;

    /**修改页面
     * @param resourceHandle
     * @return
     */
    @PostMapping(value = "updateMenu", consumes = "application/json; charset=UTF-8")
     Result updateMenu(@RequestBody ResourceHandle resourceHandle) ;

    /**获取所有页面
     * @return
     */
    @PostMapping(value = "getAllUrl" , consumes = "application/json; charset=UTF-8")
     Result getAllUrl();
}
