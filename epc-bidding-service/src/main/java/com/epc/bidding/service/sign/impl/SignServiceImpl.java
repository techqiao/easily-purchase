package com.epc.bidding.service.sign.impl;

import com.epc.bidding.domain.bidding.TSupplierSign;
import com.epc.bidding.mapper.bidding.TSupplierSignMapper;
import com.epc.bidding.service.sign.SignService;
import com.epc.common.Result;
import com.epc.common.util.CookieUtil;
import com.epc.web.facade.bidding.dto.SignBaseDTO;
import com.epc.web.facade.bidding.handle.HandleSign;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author linzhixiang
 */
@Service
public class SignServiceImpl implements SignService {
    private static final Logger LOGGER = LoggerFactory.getLogger(SignServiceImpl.class);

    @Autowired
    TSupplierSignMapper tSupplierSignMapper;


    /**
     * 新增一条供应商签到记录
     * @param handleSign
     * @return
     */
    @Override
    public Result<Boolean> insertSupplierSign(HandleSign handleSign) {
        TSupplierSign entity=new TSupplierSign();
        BeanUtils.copyProperties(handleSign,entity);
        entity.setCreateAt(new Date());
        entity.setUpdateAt(new Date());
        try{
            tSupplierSignMapper.insertSelective(entity);
            return Result.success();
        }catch (Exception e){
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
        SignBaseDTO dto=new SignBaseDTO();
        try{
             dto= tSupplierSignMapper.getSignPeronInfo(name,cellPhone);

        }catch (Exception e){
            LOGGER.error("找不到该用户");
            return Result.error();
        }

        return Result.success(dto);
    }

}
