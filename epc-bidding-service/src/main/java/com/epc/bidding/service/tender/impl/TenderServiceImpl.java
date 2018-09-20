package com.epc.bidding.service.tender.impl;

import com.epc.bidding.domain.bidding.TPurchaseProjectBids;
import com.epc.bidding.domain.bidding.TPurchaseProjectBidsCriteria;
import com.epc.bidding.mapper.bidding.TPurchaseProjectBidsMapper;
import com.epc.bidding.mapper.bidding.TSupplierBasicInfoMapper;
import com.epc.bidding.service.bidding.impl.BiddingServiceimpl;
import com.epc.bidding.service.tender.TenderService;
import com.epc.common.Result;
import com.epc.web.facade.bidding.dto.PersonDTO;
import com.epc.web.facade.bidding.query.tender.QueryPersonDTO;
import com.epc.web.facade.bidding.query.tender.QueryTenderDTO;
import com.epc.web.facade.bidding.vo.TenderVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 标段相关业务
 * @author linzhixiang
 */
@Service
public class TenderServiceImpl implements TenderService {
    private static final Logger LOGGER = LoggerFactory.getLogger(BiddingServiceimpl.class);


    @Autowired
    TSupplierBasicInfoMapper tSupplierBasicInfoMapper;
    @Autowired
    TPurchaseProjectBidsMapper tPurchaseProjectBidsMapper;

    /**
     * 获取机构下面的人员列表
     * @param dto
     * @return
     */
    @Override
    public List<PersonDTO> getPersonList(QueryPersonDTO dto){
        List<PersonDTO>  list=tSupplierBasicInfoMapper.selectCompanyPerson(dto.getSupplierId());
      return list;
    }


    /**
     * 根据采购项目id获取标段列表
     * @param dto
     * @return
     */
    @Override
    public Result<List<TenderVO>> getTenderListByPurchaseProgramId(QueryTenderDTO dto){
        TPurchaseProjectBidsCriteria criteria=new TPurchaseProjectBidsCriteria();
        TPurchaseProjectBidsCriteria.Criteria cubCriteria =criteria.createCriteria();
        cubCriteria.andPurchaseProjectIdEqualTo(dto.getPurchasProgramId());
        List<TPurchaseProjectBids> list=tPurchaseProjectBidsMapper.selectByExampleWithRowbounds(criteria,dto.getRowBounds());
        List<TenderVO> newList=new ArrayList<>();
        for(TPurchaseProjectBids entity:list){
            TenderVO newDto=new TenderVO();
            BeanUtils.copyProperties(entity,newDto);
            newList.add(newDto);
        }
        return Result.success(newList);
    }

}
