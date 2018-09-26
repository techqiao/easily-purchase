package com.epc.tendering.service.controller.bid;

import com.epc.common.Result;
import com.epc.tendering.service.service.bid.OpeningRecordPublicityService;
import com.epc.web.facade.terdering.bid.FacadeOpeningRecordPublicityService;
import com.epc.web.facade.terdering.bid.handle.HandOpeningRecordPublicity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-26 17:51
 * <p>@Author : wjq
 */
@RestController
public class OpeningRecordPublicityController implements FacadeOpeningRecordPublicityService {
    @Autowired
    private OpeningRecordPublicityService openingRecordPublicityService;

    @Override
    public Result<Boolean> insertOpeningRecordPublicity(HandOpeningRecordPublicity handOpeningRecordPublicity) {
        return openingRecordPublicityService.insertOpeningRecordPublicity(handOpeningRecordPublicity);
    }
}
