package com.epc.web.client.controller.bidding;


import com.epc.common.Result;
import com.epc.common.constants.Const;
import com.epc.web.client.controller.bidding.query.monitor.ClientMonitoringFileDTO;
import com.epc.web.client.controller.common.BaseController;
import com.epc.web.client.remoteApi.bidding.monitoring.MonitorFileClient;
import com.epc.web.facade.bidding.handle.HandleMonitoringFile;
import com.epc.web.facade.bidding.query.monitor.file.QueryMonitoringFileDTO;
import com.epc.web.facade.bidding.vo.MonitorFileVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Description: 监控业务
 * @Author: linzhixiang
 * @Date: 2018/9/30
 */

@Api(value = "监控业务",tags = "监控业务")
@RestController
@RequestMapping(value = "/monitoring", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class MonitoringFileController extends BaseController {
    @Autowired
    MonitorFileClient monitorFileClient;

    @ApiOperation(value = "文件监控列表")
    @PostMapping(value = "ListBMonitoringFile", consumes = "application/json; charset=UTF-8")
    public  Result<List<MonitorFileVO>> ListBMonitoringFile(ClientMonitoringFileDTO dto){
        QueryMonitoringFileDTO queryMonitoringFileDTO=new QueryMonitoringFileDTO();
        BeanUtils.copyProperties(dto,queryMonitoringFileDTO);
        return  monitorFileClient.ListBMonitoringFile(queryMonitoringFileDTO);
    }

    @ApiOperation(value = "新增文件监控记录")
    @PostMapping(value = "createMonitoringFile", consumes = "application/json; charset=UTF-8")
    public Result<Boolean> createMonitoringFile(HandleMonitoringFile dto){
        HandleMonitoringFile handleMonitoringFile=new HandleMonitoringFile();
        BeanUtils.copyProperties(handleMonitoringFile,dto);
        dto.setOperateId(getLoginUser().getUserId());
        dto.setOperator(getLoginUser().getName());
        String personType=null;
        //运营商1,代理商2,供货商3,采购商4
        switch (getLoginUser().getType()){
            case Const.LOGIN_USER_TYPE.OPERATOR:
                personType="operator";
                break;
            case Const.LOGIN_USER_TYPE.PROXY:
                personType="proxy";
                break;
            case Const.LOGIN_USER_TYPE.SUPPLIER:
                personType="supplier";
                break;
            case Const.LOGIN_USER_TYPE.PURCHASER:
                personType="purchaser";
                break;
            default:
        }
        dto.setOperateType(personType);
        return monitorFileClient.createMonitoringFile(dto);
    }

}
