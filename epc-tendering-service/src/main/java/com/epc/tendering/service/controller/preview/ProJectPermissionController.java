package com.epc.tendering.service.controller.preview;

import com.epc.common.Result;
import com.epc.tendering.service.service.preview.ProJectByPermissionService;
import com.epc.web.facade.terdering.preview.ProJectPermissionService;
import com.epc.web.facade.terdering.preview.handle.ProJectPermissionHandle;
import com.epc.web.facade.terdering.preview.vo.ProJectPermissionVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-21 10:41
 * <p>@Author : luozhixin
 * <p>p
 * ClientProJectPermissionController
 */
@RestController
public class ProJectPermissionController  implements ProJectPermissionService {

    @Autowired
    private ProJectByPermissionService proJectByPermissionService;

    @Override
    public Result<List<ProJectPermissionVO>> getProJectListByPermission(@RequestBody ProJectPermissionHandle proJectPermissionHandle) {
        return proJectByPermissionService.getProJectListByPermission(proJectPermissionHandle);
    }

}
