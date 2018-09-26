package com.epc.tendering.service.service.bid.impl;

import com.epc.common.Result;
import com.epc.common.constants.Const;
import com.epc.tendering.service.domain.bid.BExpertSign;
import com.epc.tendering.service.mapper.bid.BExpertSignMapper;
import com.epc.tendering.service.service.bid.ExpertSignService;
import com.epc.web.facade.terdering.bid.handle.HandleExpertSign;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-26 19:47
 * <p>@Author : wjq
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class ExpertSignServiceImpl implements ExpertSignService {
    @Autowired
    private BExpertSignMapper bExpertSignMapper;

    @Override
    public Result<Boolean> insertExpertSign(HandleExpertSign handleExpertSign) {
        //通过评标专家电话号 去判断是否是该标段的专家号 过滤
        BExpertSign bExpertSign = new BExpertSign();
        BeanUtils.copyProperties(handleExpertSign, bExpertSign);
        return Result.success(bExpertSignMapper.insertSelective(bExpertSign) > 0);
    }

    @Override
    public Result<Boolean> handleExpert(Long id) {
        BExpertSign bExpertSign = new BExpertSign();
        bExpertSign.setId(id);
        bExpertSign.setIsLeader(Const.IS_OK.IS_OK);
        return Result.success(bExpertSignMapper.updateByPrimaryKeySelective(bExpertSign) > 0);
    }
}
