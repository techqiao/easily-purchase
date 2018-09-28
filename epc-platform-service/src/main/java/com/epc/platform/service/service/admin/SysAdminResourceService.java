package com.epc.platform.service.service.admin;

import com.epc.administration.facade.admin.handle.ResourceHandle;
import com.epc.common.util.Tree;
import com.epc.platform.service.domain.admin.SysAdminResource;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;
import java.util.Map;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-12 20:37
 * <p>@Author : wjq
 */
public interface SysAdminResourceService {

    /**
     *
     * @param userName
     * @return
     */
    List<SysAdminResource> findUserPermissions(String userName);

    /**
     * 根据手机号查询该手机号权限资源,去重
     * @param phone
     * @return
     */
    List<SysAdminResource> findResource(String phone);


    /**
     *  根据资源id获取资源
     * @param resourceId
     * @return
     */
    SysAdminResource findById(Long resourceId);

    /**
     * 获取菜单列表
     * @return
     */
    Tree<SysAdminResource> getResourceButtonTree();

    /**
     * 获取菜单树
     * @return
     */
    Tree<SysAdminResource> getResourceTree();

    /**
     * 获取菜单集合
     * @param
     * @return
     */
    List<SysAdminResource> findAllResources(ResourceHandle resourceHandle);

    /**
     * 根据类型和资源名称获取资源
     * @param resourceName
     * @param type
     * @return
     */
    SysAdminResource findByNameAndType(String resourceName, String type);


    /**
     * 新增资源
     * @param resourceHandle
     */
    void addResource(ResourceHandle resourceHandle);

    /**
     * 删除资源
     * @param resourcesIds
     */
    void deleteResources(String resourcesIds);

    /**
     * 修改资源
     * @param resourceHandle
     */
    void updateResource(ResourceHandle resourceHandle);

    /**
     * 获取所有资源
     * @param p1
     * @return
     */
    @Cacheable(key = "'url_'+ #p0")
    Map<Object, Object> getAllUrl(String p1);

}
