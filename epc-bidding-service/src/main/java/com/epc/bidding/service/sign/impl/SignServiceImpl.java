package com.epc.bidding.service.sign.impl;

import com.epc.bidding.domain.TSupplierSign;
import com.epc.bidding.domain.TTenderMessage;
import com.epc.bidding.domain.TTenderMessageCriteria;
import com.epc.bidding.mapper.TSupplierSignMapper;
import com.epc.bidding.mapper.TTenderMessageMapper;
import com.epc.bidding.service.sign.SignService;
import com.epc.common.Result;
import com.epc.common.constants.Const;
import com.epc.web.facade.bidding.dto.SignBaseDTO;
import com.epc.web.facade.bidding.handle.HandleSign;
import com.epc.web.facade.bidding.query.sign.QuerySignerDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.Date;
import java.util.List;

/**
 * @author linzhixiang
 */
@Service
public class SignServiceImpl implements SignService {
    private static final Logger LOGGER = LoggerFactory.getLogger(SignServiceImpl.class);

    @Autowired
    TSupplierSignMapper tSupplierSignMapper;
    @Autowired
    TTenderMessageMapper tTenderMessageMapper;


    /**
     * 新增一条供应商签到记录
     * @param handleSign
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result<Boolean> insertSupplierSign(HandleSign handleSign) {
        TSupplierSign entity=new TSupplierSign();
        BeanUtils.copyProperties(handleSign,entity);
        entity.setCompanyId(handleSign.getSupplierId());
        entity.setPersonName(handleSign.getName());
        entity.setCreateAt(new Date());
        entity.setUpdateAt(new Date());
        entity.setIsDeleted(Const.IS_DELETED.NOT_DELETED);
        entity.setCellphone(handleSign.getCellPhone());

        try{
            tSupplierSignMapper.insertSelective(entity);
            return Result.success(true);
        }catch (Exception e){
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            LOGGER.error("insertSupplierSign_"+entity.toString()+"_"+e.getMessage(),e);
            return Result.error("插入失败");
        }
    }


    /**
     * 根据姓名 手机号查询 人员信息
     * @param name
     * @param cellPhone
     * @return
     */
    @Override
    public Result<SignBaseDTO> getSignBase(String name, String cellPhone) {
        SignBaseDTO dto;
        try{
             dto= tSupplierSignMapper.getSignPeronInfo(name,cellPhone);
        }catch (Exception e){
            LOGGER.error("找不到该用户");
            return Result.error();
        }

        return Result.success(dto);
    }


    /**
     * 查询签到人是否为授权委托人
     * @param dto
     * @return
     */
    @Override
    public Result<SignBaseDTO> getSignerInfo(QuerySignerDTO dto) {
        TTenderMessageCriteria criteria=new TTenderMessageCriteria();
        TTenderMessageCriteria.Criteria cubCriteria=criteria.createCriteria();
        cubCriteria.andBidsIdEqualTo(dto.getBidsId());
        cubCriteria.andDelegatorEqualTo(dto.getName());
        cubCriteria.andIdentitCardEqualTo(dto.getIdCard());
        cubCriteria.andIsDeletedEqualTo(Const.IS_DELETED.NOT_DELETED);
        //投标文件授权记录
        List<TTenderMessage> resultList=tTenderMessageMapper.selectByExample(criteria);
        SignBaseDTO signBaseDTO=new SignBaseDTO();
        if(resultList.size()>0){
            signBaseDTO.setCellphone(dto.getCellPhone());
            signBaseDTO.setCompanyName(resultList.get(0).getCompanyName());
            signBaseDTO.setName(dto.getName());
            signBaseDTO.setSupplierId(resultList.get(0).getCompanyId());
            signBaseDTO.setCompanyName(resultList.get(0).getCompanyName());
            signBaseDTO.setPurchaseProjectId(resultList.get(0).getPurchaseProjectId());
            return  Result.success(signBaseDTO);
        }else{
            return  Result.success(null);
        }
    }
}
