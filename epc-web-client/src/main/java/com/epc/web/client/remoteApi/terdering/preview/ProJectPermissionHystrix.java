package com.epc.web.client.remoteApi.terdering.preview;

import com.epc.common.Result;
import com.epc.web.facade.terdering.preview.ProJectPermissionService;
import com.epc.web.facade.terdering.preview.handle.ProJectPermissionHandle;
import com.epc.web.facade.terdering.preview.vo.ProJectPermissionVO;

import java.util.List;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-21 17:56
 * <p>@Author : luozhixin
 * <p>ProJectPermissionHystrix
 */
public class ProJectPermissionHystrix implements ProJectPermissionService {

    @Override
    public Result<List<ProJectPermissionVO>> getProJectListByPermission(ProJectPermissionHandle proJectPermissionHandle) {
        return Result.hystrixError();
    }
}
