package com.epc.web.client.controller.terdering.preview;

import com.epc.common.PagerParam;
import com.epc.common.Result;
import com.epc.web.client.controller.common.BaseController;
import com.epc.web.client.remoteApi.terdering.preview.ProJectPermissionClient;
import com.epc.web.facade.terdering.preview.handle.ProJectPermissionHandle;
import com.epc.web.facade.terdering.preview.vo.ProJectPermissionVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-21 10:34
 * <p>@Author : luozhixin
 * <p>ProJectPermissionController
 */
@Api(value = "项目审核列表",tags = {"项目审核列表"})
@RestController
@RequestMapping(value = "/projectpermission", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class ProJectPermissionController extends BaseController {

    @Autowired
    private ProJectPermissionClient proJectPermissionClient;

    @ApiOperation(value = "根据登入者 审核 批复权限查询对应项目的详情")
    @PostMapping(value = "/getProJectListByPermission")
    public Result<List<ProJectPermissionVO>> getProJectListByPermission(@RequestBody PagerParam pagerParam){
        ProJectPermissionHandle proJectPermissionHandle = new ProJectPermissionHandle();
        BeanUtils.copyProperties(pagerParam,proJectPermissionHandle);
//        proJectPermissionHandle.setUserId(getLoginUser().getUserId());
        return proJectPermissionClient.getProJectListByPermission(proJectPermissionHandle);

    }
}
