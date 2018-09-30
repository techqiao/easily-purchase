package com.epc.web.facade.terdering.bid;

import com.epc.common.Result;
import com.epc.web.facade.bidding.handle.HandleWinBidding;
import com.epc.web.facade.bidding.vo.NominateVO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * @Description: 中标服务
 * @Author: linzhixiang
 * @Date: 2018/9/28
 */ 
public interface FacadeWinBidRecordService {


    /**
     * 获取采购项目下各标段的中标公示记录
     * @param procurementProjectId
     * @return
     */
    @PostMapping(value = "getTWinBidNominated", consumes = "application/json; charset=UTF-8")
    Result<List<NominateVO>> getTWinBidNominated(@RequestBody Long procurementProjectId) ;


    /**
     * 确认中标人和上传中标通知书
     * @param dtoList
     * @return
     */
    @PostMapping(value = "updateTWinBidNominated", consumes = "application/json; charset=UTF-8")
    Result<Boolean> updateTWinBidNominated(@RequestBody List<HandleWinBidding> dtoList);


    }
