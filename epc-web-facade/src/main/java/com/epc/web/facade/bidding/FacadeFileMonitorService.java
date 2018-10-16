package com.epc.web.facade.bidding;

import com.epc.common.Result;
import com.epc.web.facade.bidding.handle.HandleMonitoringFile;
import com.epc.web.facade.bidding.query.monitor.file.QueryMonitoringFileDTO;
import com.epc.web.facade.bidding.query.monitor.list.QueryListMonitor;
import com.epc.web.facade.bidding.vo.MonitorFileVO;
import com.epc.web.facade.bidding.vo.listMonitorVO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Map;

public interface FacadeFileMonitorService {

    /**
     * 查看文件监控列表
     * @param dto
     * @return
     */
    @PostMapping(value = "ListBMonitoringFile", consumes = "application/json; charset=UTF-8")
     Result<List<MonitorFileVO>> ListBMonitoringFile(@RequestBody  QueryMonitoringFileDTO dto);

    /**
     * 新增文件监控记录
     * @param handle
     * @return
     */
    @PostMapping(value = "createMonitoringFile", consumes = "application/json; charset=UTF-8")
    Result<Boolean> createMonitoringFile(@RequestBody HandleMonitoringFile handle);

    /**
     * 负责人查询监控项目列表
     * @param queryListMonitor
     * @return
     */
    @PostMapping(value = "listMonitor", consumes = "application/json; charset=UTF-8")
    Result<Map<String, Object>> listMonitor(@RequestBody QueryListMonitor queryListMonitor);
}
