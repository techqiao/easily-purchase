package com.epc.administration.client.remoteapi.admin;

import com.epc.administration.facade.admin.AdminResourceService;
import com.epc.administration.facade.admin.handle.ResourceHandle;
import com.epc.common.Result;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-15 10:20
 * <p>@Author : luozhixin
 */
public class adminResourceHystrix implements AdminResourceService {

    @Override
    public Result getResource(String phone) {
        return Result.hystrixError();
    }
    @Override
    public Result getResource(Long resourceId) {
        return Result.hystrixError();
    }

    @Override
    public Result getResourceButtonTree() {
        return Result.hystrixError();
    }

    @Override
    public Result getResourceTree() {
        return Result.hystrixError();
    }

    @Override
    public Result resourceList(ResourceHandle sysAdminResource) {
        return Result.hystrixError();
    }

    @Override
    public Result checkResourceName(String resourceName, String type, String oldResourceName) {
        return Result.hystrixError();
    }

    @Override
    public Result addResource(ResourceHandle sysAdminResource) {
        return Result.hystrixError();
    }

    @Override
    public Result deleteMenus(String ids) {
        return Result.hystrixError();
}

    @Override
    public Result updateMenu(ResourceHandle resource) {
        return Result.hystrixError();
    }

    @Override
    public Result getAllUrl() {
        return Result.hystrixError();
    }
}
