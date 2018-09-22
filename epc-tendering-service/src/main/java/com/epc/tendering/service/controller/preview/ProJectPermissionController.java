package com.epc.tendering.service.controller.preview;

import com.epc.common.Result;
import com.epc.tendering.service.service.preview.ProJectByPermissionService;
import com.epc.web.facade.terdering.preview.ProJectPermissionService;
import com.epc.web.facade.terdering.preview.handle.ProJectPermissionHandle;
import com.epc.web.facade.terdering.preview.vo.ProJectPermissionVO;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-21 10:41
 * <p>@Author : luozhixin
 * <p>p
 * ClientProJectPermissionController
 */
public class ProJectPermissionController  implements ProJectPermissionService {

    @Autowired
    private ProJectByPermissionService proJectByPermissionService;

    @Override
    public Result<List<ProJectPermissionVO>> getProJectListByPermission(ProJectPermissionHandle proJectPermissionHandle) {
        return proJectByPermissionService.getProJectListByPermission(proJectPermissionHandle);
    }

}
