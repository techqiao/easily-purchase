package com.epc.tendering.service.service.bid.impl;

import com.epc.common.Result;
import com.epc.tendering.service.mapper.bid.BExpertScoreMapper;
import com.epc.tendering.service.service.bid.ExpertScoreService;
import com.epc.web.facade.terdering.bid.vo.BidderListVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-27 10:08
 * <p>@Author : wjq
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class ExpertScoreServiceImpl implements ExpertScoreService {
    @Autowired
    private BExpertScoreMapper bExpertScoreMapper;
    @Override
    public Result<List<BidderListVO>> getBidderList(Long procurementProjectId) {
        return null;
    }
}
