package com.epc.web.facade.terdering.preview;

import com.epc.common.Result;
import com.epc.web.facade.terdering.preview.handle.ProJectPermissionHandle;
import com.epc.web.facade.terdering.preview.vo.ProJectPermissionVO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface ProJectPermissionService {
    /**
     * 根据登入者 审核 批复权限查询对应项目的详情
     * @param proJectPermissionHandle
     * @return
     */
    @PostMapping(value = "getProJectListByPermission" ,consumes ="application/json; charset=UTF-8" )
    Result<List<ProJectPermissionVO>> getProJectListByPermission(@RequestBody ProJectPermissionHandle proJectPermissionHandle);
}
