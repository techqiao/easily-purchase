package com.epc.tendering.service.service.bid.impl;

import com.epc.common.Result;
import com.epc.tendering.service.mapper.bid.TPurchaseProjectBidsMapper;
import com.epc.tendering.service.service.bid.TPurchaseProjectBidsService;
import com.epc.web.facade.terdering.bid.handle.HandleBidsBasicInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-19 11:30
 * <p>@Author : wjq
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class TPurchaseProjectBidsServiceImpl implements TPurchaseProjectBidsService {
    @Autowired
    private TPurchaseProjectBidsMapper tPurchaseProjectBidsMapper;


    @Override
    public Result<Boolean> handleBidsBasicInfo(HandleBidsBasicInfo handleBidsBasicInfo) {
        //TODO
        return null;
    }
}
