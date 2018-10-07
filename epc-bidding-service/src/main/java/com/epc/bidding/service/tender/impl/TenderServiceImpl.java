package com.epc.bidding.service.tender.impl;

import com.epc.bidding.domain.*;
import com.epc.bidding.mapper.*;
import com.epc.bidding.service.tender.TenderService;
import com.epc.common.Result;
import com.epc.common.constants.Const;
import com.epc.web.facade.bidding.dto.PersonDTO;
import com.epc.web.facade.bidding.query.tender.QueryBackTenderMoneyRecordDTO;
import com.epc.web.facade.bidding.query.tender.QueryBidPayDTO;
import com.epc.web.facade.bidding.query.tender.QueryPersonDTO;
import com.epc.web.facade.bidding.query.tender.QueryTenderDTO;
import com.epc.web.facade.bidding.vo.IsBackTenderMoneyRecordVO;
import com.epc.web.facade.bidding.vo.QueryTenderMoneyRecordVO;
import com.epc.web.facade.bidding.vo.TenderVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * 标段相关业务
 * @author linzhixiang
 */
@Service
public class TenderServiceImpl implements TenderService {

    @Autowired
    TSupplierBasicInfoMapper tSupplierBasicInfoMapper;
    @Autowired
    TPurchaseProjectBidsMapper tPurchaseProjectBidsMapper;
    @Autowired
    BBidOpeningPayMapper bBidOpeningPayMapper;
    @Autowired
    TProjectBasicInfoMapper tProjectBasicInfoMapper;
    @Autowired
    BBidsGuaranteeAmountMapper bBidsGuaranteeAmountMapper;

    /**
     * 获取机构下面的人员列表
     * @param dto
     * @return
     */
    @Override
    public Result<List<PersonDTO>> getPersonList(QueryPersonDTO dto){
        List<PersonDTO>  list=tSupplierBasicInfoMapper.selectCompanyPerson(dto.getSupplierId());
      return Result.success(list);
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


    /**
     * 根据招标公告Id 获取标段列表及保证金支付情况
     * @param dto
     * @return
     */

    @Override
    public Result<List<QueryTenderMoneyRecordVO>> queryTenderMoneyRecordVO(QueryBidPayDTO dto){
        List<QueryTenderMoneyRecordVO> vo=bBidOpeningPayMapper.selectBidPayRecord(dto.getId());
        return Result.success(vo);
    }


    /**
     * 查看保证金归还情况
     * @param dto
     * @return
     */
    @Override
    public Result<List<IsBackTenderMoneyRecordVO>> isBackTenderMoneyRecordList(QueryBackTenderMoneyRecordDTO dto) {
        BBidOpeningPayCriteria criteria=new BBidOpeningPayCriteria();
        BBidOpeningPayCriteria.Criteria cubCriteria=criteria.createCriteria();
        cubCriteria.andProcurementProjectIdEqualTo(dto.getProcurementProjectId());
        cubCriteria.andTendererCompanyIdEqualTo(dto.getTendererCompanyId());
        cubCriteria.andIsDeletedEqualTo(Const.IS_DELETED.NOT_DELETED);
        //获取供应商 标段保证金支付列表
        List<BBidOpeningPay> result=bBidOpeningPayMapper.selectByExample(criteria);
        if(result.size()==0){
            return Result.success("未找到支付记录");
        }
        List<IsBackTenderMoneyRecordVO> voList=new ArrayList<>();
        for(BBidOpeningPay entity:result){
            IsBackTenderMoneyRecordVO vo=new IsBackTenderMoneyRecordVO();
            //项目信息
            TProjectBasicInfo projectBasicInfo= tProjectBasicInfoMapper.selectByPrimaryKey(entity.getProjectId());
            //标段信息
            TPurchaseProjectBids purchaseProjectBids=tPurchaseProjectBidsMapper.selectByPrimaryKey(entity.getBidId());
            BigDecimal money=purchaseProjectBids.getGuaranteePayment();
            vo.setProjectCode(projectBasicInfo.getProjectCode());
            vo.setProjectName(projectBasicInfo.getProjectName());
            vo.setBidsCode(purchaseProjectBids.getBidCode());
            vo.setBidsName(purchaseProjectBids.getBidName());
            //实付金额 和 需付金额比较
            if(entity.getAmountMoney().compareTo(money)>-1){
                vo.setIsBack(true);
            }else{
                vo.setIsBack(false);
            }
            voList.add(vo);
        }
        return Result.success(voList);
    }
}
