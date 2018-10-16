package com.epc.bidding.controller.monitor;

import com.epc.bidding.service.monitoring.FileMonitoringService;
import com.epc.common.QueryRequest;
import com.epc.common.Result;
import com.epc.web.facade.bidding.FacadeFileMonitorService;
import com.epc.web.facade.bidding.handle.HandleMonitoringFile;
import com.epc.web.facade.bidding.query.monitor.file.QueryMonitoringFileDTO;
import com.epc.web.facade.bidding.query.monitor.list.QueryListMonitor;
import com.epc.web.facade.bidding.vo.MonitorFileVO;
import com.epc.web.facade.bidding.vo.NoticeDetailVO;
import com.epc.web.facade.bidding.vo.listMonitorVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @Description: 文件监控
 * @Author: linzhixiang
 * @Date: 2018/9/30
 */

@RestController
public class BiddingFileMonitorController extends QueryRequest implements FacadeFileMonitorService {
@Autowired
FileMonitoringService fileMonitoringService;

    @Override
    public Result<List<MonitorFileVO>> ListBMonitoringFile(@RequestBody  QueryMonitoringFileDTO dto){
        return  fileMonitoringService.ListBMonitoringFile(dto);
    }

    @Override
    public Result<Boolean> createMonitoringFile(@RequestBody HandleMonitoringFile handle){
        return fileMonitoringService.createMonitoringFile(handle);
    }

    @Override
    public Result<Map<String, Object>> listMonitor(@RequestBody QueryListMonitor queryListMonitor){
        PageHelper.startPage(queryListMonitor.getPageNum(),queryListMonitor.getPageSize());
        List<listMonitorVO> voList=fileMonitoringService.listMonitor(queryListMonitor);
        PageInfo<listMonitorVO> pageInfo = new PageInfo<>(voList);
        Map<String, Object> dataTable = getDataTable(pageInfo);
        return Result.success(dataTable);
    }
}


