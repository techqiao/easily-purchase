package com.epc.tendering.service.controller.bid;

import com.epc.common.Result;
import com.epc.tendering.service.service.bid.WinBidRecordService;
import com.epc.web.facade.bidding.handle.HandleWinBidding;
import com.epc.web.facade.bidding.vo.NominateVO;
import com.epc.web.facade.terdering.bid.FacadeWinBidRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;


/**
 * @Description: 中标公示
 * @Author: linzhixiang
 * @Date: 2018/9/28
 */
@RestController
public class WinBidRecordController implements FacadeWinBidRecordService {

    @Autowired
    WinBidRecordService winBidRecordService;


    /**
     * 获取采购项目下各标段的中标公示记录
     * @param procurementProjectId
     * @return
     */
    @Override
    public Result<List<NominateVO>> getTWinBidNominated(@RequestBody Long procurementProjectId) {
        return winBidRecordService.getTWinBidNominated(procurementProjectId);
    }

    /**
     * 确认中标人和上传中标通知书
     * @param dtoList
     * @return
     */
    @Override
    public Result<Boolean> updateTWinBidNominated(@RequestBody List<HandleWinBidding> dtoList){
        return winBidRecordService.updateTWinBidNominated(dtoList);
    }



}
