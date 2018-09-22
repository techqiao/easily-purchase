package com.epc.web.client.remoteApi.bidding.tender;

import com.epc.common.Result;
import com.epc.web.facade.bidding.FacadeTenderService;
import com.epc.web.facade.bidding.dto.PersonDTO;
import com.epc.web.facade.bidding.query.tender.QueryBidPayDTO;
import com.epc.web.facade.bidding.query.tender.QueryPersonDTO;
import com.epc.web.facade.bidding.query.tender.QueryTenderDTO;
import com.epc.web.facade.bidding.vo.QueryTenderMoneyRecordVO;
import com.epc.web.facade.bidding.vo.TenderVO;

import java.util.List;

public class TenderHystrix implements FacadeTenderService {
    
    @Override
    public Result<List<QueryTenderMoneyRecordVO>> queryTenderMoneyRecordVO(QueryBidPayDTO dto) {
        return Result.hystrixError();
    }

    @Override
    public Result<List<TenderVO>> getTenderListByPurchaseProgramId(QueryTenderDTO dto) {
        return Result.hystrixError();
    }

    @Override
    public Result<List<PersonDTO>> getPersonList(QueryPersonDTO dto) {
        return Result.hystrixError();
    }
}
