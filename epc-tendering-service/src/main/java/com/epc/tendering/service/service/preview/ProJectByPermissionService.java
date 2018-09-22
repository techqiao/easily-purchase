package com.epc.tendering.service.service.preview;

import com.epc.common.Result;
import com.epc.web.facade.terdering.preview.handle.ProJectPermissionHandle;
import com.epc.web.facade.terdering.preview.vo.ProJectPermissionVO;

import java.util.List;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-21 10:48
 * <p>@Author : luozhixin
 * <p>ProJectByPermissionService
 */
public interface ProJectByPermissionService {

    /**
     * 根据登入者 审核 批复权限查询对应项目的详情
     * @param proJectPermissionHandle
     * @return
     */
    Result<List<ProJectPermissionVO>> getProJectListByPermission(ProJectPermissionHandle proJectPermissionHandle);
}
