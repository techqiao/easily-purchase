package com.epc.bidding.service.tender;

import com.epc.common.Result;
import com.epc.web.facade.bidding.dto.PersonDTO;
import com.epc.web.facade.bidding.query.tender.QueryBackTenderMoneyRecordDTO;
import com.epc.web.facade.bidding.query.tender.QueryBidPayDTO;
import com.epc.web.facade.bidding.query.tender.QueryPersonDTO;
import com.epc.web.facade.bidding.query.tender.QueryTenderDTO;
import com.epc.web.facade.bidding.vo.IsBackTenderMoneyRecordVO;
import com.epc.web.facade.bidding.vo.QueryTenderMoneyRecordVO;
import com.epc.web.facade.bidding.vo.TenderVO;

import java.util.List;

public interface TenderService {

    /**
     * 获取机构下面的人员列表
     * @param dto
     * @return
     */
         Result<List<PersonDTO>> getPersonList(QueryPersonDTO dto);
    /**
     * 根据采购项目id获取标段列表
     * @param dto
     * @return
     */
         Result<List<TenderVO>> getTenderListByPurchaseProgramId(QueryTenderDTO dto);

    /**
     * 根据招标公告Id 获取标段列表及保证金支付情况
     * @param dto
     * @return
     */
         Result<List<QueryTenderMoneyRecordVO>> queryTenderMoneyRecordVO(QueryBidPayDTO dto);


         Result<List<IsBackTenderMoneyRecordVO>>
         isBackTenderMoneyRecordList(QueryBackTenderMoneyRecordDTO dto);

}
