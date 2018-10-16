package com.epc.web.client.controller.bidding;


import com.epc.common.Result;
import com.epc.common.constants.Const;
import com.epc.web.client.controller.bidding.query.monitor.ClientListMonitor;
import com.epc.web.client.controller.bidding.query.monitor.ClientMonitoringFileDTO;
import com.epc.web.client.controller.common.BaseController;
import com.epc.web.client.remoteApi.bidding.monitoring.MonitorFileClient;
import com.epc.web.facade.bidding.handle.HandleMonitoringFile;
import com.epc.web.facade.bidding.query.monitor.file.QueryMonitoringFileDTO;
import com.epc.web.facade.bidding.query.monitor.list.QueryListMonitor;
import com.epc.web.facade.bidding.vo.MonitorFileVO;
import com.epc.web.facade.bidding.vo.listMonitorVO;
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

    @ApiOperation(value = "监控项目列表")
    @PostMapping(value = "listMonitor", consumes = "application/json; charset=UTF-8")
    public Result<List<listMonitorVO>> listMonitor(@RequestBody ClientListMonitor clientListMonitor){
        QueryListMonitor queryListMonitor=new QueryListMonitor();
        BeanUtils.copyProperties(clientListMonitor,queryListMonitor);
        queryListMonitor.setBossId(getLoginUser().getBossId());
        queryListMonitor.setSupplier(getLoginUser().getUserId());
        return  monitorFileClient.listMonitor(queryListMonitor);

    }

    @ApiOperation(value = "文件监控列表")
    @PostMapping(value = "ListBMonitoringFile", consumes = "application/json; charset=UTF-8")
    public  Result<List<MonitorFileVO>> listBMonitoringFile(@RequestBody ClientMonitoringFileDTO dto){
        QueryMonitoringFileDTO queryMonitoringFileDTO=new QueryMonitoringFileDTO();
        BeanUtils.copyProperties(dto,queryMonitoringFileDTO);
        return  monitorFileClient.ListBMonitoringFile(queryMonitoringFileDTO);
    }

    @ApiOperation(value = "新增文件监控记录")
    @PostMapping(value = "createMonitoringFile", consumes = "application/json; charset=UTF-8")
    public Result<Boolean> createMonitoringFile(@RequestBody HandleMonitoringFile dto){
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
