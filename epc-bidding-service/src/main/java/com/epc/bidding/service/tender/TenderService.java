package com.epc.bidding.service.tender;

import com.epc.common.Result;
import com.epc.web.facade.bidding.dto.PersonDTO;
import com.epc.web.facade.bidding.query.tender.QueryPersonDTO;
import com.epc.web.facade.bidding.query.tender.QueryTenderDTO;
import com.epc.web.facade.bidding.vo.TenderVO;

import java.util.List;

public interface TenderService {


        public List<PersonDTO> getPersonList(QueryPersonDTO dto);

        public Result<List<TenderVO>> getTenderListByPurchaseProgramId(QueryTenderDTO dto);

    }
