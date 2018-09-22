package com.epc.web.facade.bidding;

import com.epc.common.Result;
import com.epc.web.facade.bidding.dto.PersonDTO;
import com.epc.web.facade.bidding.query.tender.QueryBidPayDTO;
import com.epc.web.facade.bidding.query.tender.QueryPersonDTO;
import com.epc.web.facade.bidding.query.tender.QueryTenderDTO;
import com.epc.web.facade.bidding.vo.QueryTenderMoneyRecordVO;
import com.epc.web.facade.bidding.vo.TenderVO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * 投标-标段业务
 * @author linzhixiang
 */
public interface FacadeTenderService {

    /**
     * 根据招标公告Id 获取标段列表及保证金支付情况
     * @param dto
     * @return
     */
    @PostMapping(value = "queryTenderMoneyRecordVO", consumes = "application/json; charset=UTF-8")
     Result<List<QueryTenderMoneyRecordVO>> queryTenderMoneyRecordVO(@RequestBody  QueryBidPayDTO dto);


    /**
     * 根据采购项目id获取标段列表
     * @param dto
     * @return
     */

    @PostMapping(value = "getTenderListByPurchaseProgramId", consumes = "application/json; charset=UTF-8")
     Result<List<TenderVO>> getTenderListByPurchaseProgramId(@RequestBody QueryTenderDTO dto);


    /**
     * 获取机构下面的人员列表
     * @param dto
     * @return
     */
    @PostMapping(value = "getPersonList", consumes = "application/json; charset=UTF-8")
     Result<List<PersonDTO>> getPersonList(@RequestBody QueryPersonDTO dto);

}
