package com.epc.user.service.service.impl.purchaser;

import com.epc.common.constants.Const;
import com.epc.user.service.domain.purchaser.TPurchaserBasicInfo;
import com.epc.user.service.domain.purchaser.TPurchaserUser;
import com.epc.user.service.mapper.purchaser.TPurchaserBasicInfoMapper;
import com.epc.user.service.mapper.purchaser.TPurchaserDetailInfoMapper;
import com.epc.user.service.mapper.purchaser.TPurchaserUserMapper;
import com.epc.user.service.service.purchaser.PurchaserService;
import com.epc.web.facade.purchaser.handle.HandlePurchaser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
@Transactional
public class PurchaserServiceImpl implements PurchaserService {
    @Autowired
    TPurchaserBasicInfoMapper  tPurchaserBasicInfoMapper;
    @Autowired
    TPurchaserUserMapper tPurchaserUserMapper;
    @Autowired
    TPurchaserDetailInfoMapper tPurchaserDetailInfoMapper;

    /**
     * @Description 新增 采购人员登陆信息
     * @Author lzx
     * @param handleOperator
     * @return
     */
    public void createPurchaserUserInfo(HandlePurchaser handleOperator) {
        TPurchaserBasicInfo pojo=new TPurchaserBasicInfo();
        Date date = new Date();
        pojo.setCellphone(handleOperator.getCellPhone());
        pojo.setPassword(handleOperator.getPassword());
        pojo.setIsDeleted(Const.IS_DELETED.IS_DELETED);
        pojo.setState(Const.STATE.AUDIT_SUCCESS);
        pojo.setRole((long)Const.Role.ROLE_CORPORATION);
        pojo.setCreateAt(date);
        pojo.setUpdateAt(date);
        tPurchaserBasicInfoMapper.insertSelective(pojo);
        createPurchaserUser(handleOperator,pojo.getId());
    }


    /**
     * @Description 新增 采购人员--法人关系 记录
     * @Author lzx
     * @param handleOperator
     * @param userId 采购人ID
     */

    public void createPurchaserUser(HandlePurchaser handleOperator,Long userId) {
        TPurchaserUser pojo = new TPurchaserUser();
        Date date = new Date();
        pojo.setCreateAt(date);
        pojo.setUpdateAt(date);
        pojo.setIsDeleted(Const.IS_DELETED.IS_DELETED);
        pojo.setPurchaserId(userId);
        tPurchaserUserMapper.insertSelective(pojo);
    }

}