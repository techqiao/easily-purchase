package com.epc.tendering.service.service.bid;

import com.epc.common.Result;
import com.epc.web.facade.bidding.handle.HandleWinBidding;
import com.epc.web.facade.bidding.vo.NominateVO;

import java.util.List;

/**
* @Description:  中标公示
* @Author: linzhixiang
* @Date: 2018/9/27
*/
public interface WinBidRecordService {

    /**
     * 获取采购项目下各标段的中标公示记录
     * @param procurementProjectId
     * @return
     */
     Result<List<NominateVO>> getTWinBidNominated(Long procurementProjectId) ;
    /**
     * 确认中标人和上传中标通知书
     * @param dtoList
     * @return
     */
     Result<Boolean> updateTWinBidNominated(List<HandleWinBidding> dtoList);

    }
