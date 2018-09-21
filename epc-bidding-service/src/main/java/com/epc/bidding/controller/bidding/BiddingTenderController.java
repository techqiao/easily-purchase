package com.epc.bidding.controller.bidding;


import com.epc.bidding.service.tender.TenderService;
import com.epc.common.Result;
import com.epc.web.facade.bidding.FacadeTenderService;
import com.epc.web.facade.bidding.dto.PersonDTO;
import com.epc.web.facade.bidding.query.tender.QueryBidPayDTO;
import com.epc.web.facade.bidding.query.tender.QueryPersonDTO;
import com.epc.web.facade.bidding.query.tender.QueryTenderDTO;
import com.epc.web.facade.bidding.vo.QueryTenderMoneyRecordVO;
import com.epc.web.facade.bidding.vo.TenderVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BiddingTenderController implements FacadeTenderService {

    @Autowired
    TenderService tenderService;


    /**
     * 根据招标公告Id 获取标段列表及保证金支付情况
     * @param dto
     * @return
     */
    @Override
    public Result<List<QueryTenderMoneyRecordVO>> queryTenderMoneyRecordVO(QueryBidPayDTO dto){
        return  tenderService.queryTenderMoneyRecordVO(dto);
    }

    /**
     * 根据采购项目id获取标段列表
     * @param dto
     * @return
     */
    @Override
    public Result<List<TenderVO>> getTenderListByPurchaseProgramId(QueryTenderDTO dto){
        return  tenderService.getTenderListByPurchaseProgramId(dto);
     }

    /**
     * 获取机构下面的人员列表
     * @param dto
     * @return
     */
    @Override
    public Result<List<PersonDTO>> getPersonList(QueryPersonDTO dto){
        return  tenderService.getPersonList(dto);
    }



}
