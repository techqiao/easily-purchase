package com.epc.web.facade.bidding.query.monitor.file;

import com.epc.common.PagerParam;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description: 文件监控 模糊查询
 * @Author: linzhixiang
 * @Date: 2018/9/30
 */ 
@Data
public class QueryMonitoringFileDTO extends PagerParam implements Serializable {

    private static final long serialVersionUID = 5073558120339217414L;

    private Long projectId;

}
