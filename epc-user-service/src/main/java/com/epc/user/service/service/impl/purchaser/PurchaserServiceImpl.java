package com.epc.user.service.service.impl.purchaser;

import com.epc.common.Const;
import com.epc.user.service.domain.handle.purchaser.HandlePurchaser;
import com.epc.user.service.domain.purchaser.TPurchaserBasicInfo;
import com.epc.user.service.domain.purchaser.TPurchaserDetailInfo;
import com.epc.user.service.domain.purchaser.TPurchaserUser;
import com.epc.user.service.mapper.purchaser.TPurchaserBasicInfoMapper;
import com.epc.user.service.mapper.purchaser.TPurchaserDetailInfoMapper;
import com.epc.user.service.mapper.purchaser.TPurchaserUserMapper;
import com.epc.user.service.service.purchaser.PurchaserService;
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
    public Boolean createPurchaserUserInfo(HandlePurchaser handleOperator) {
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
        createPurchaserCompanyDetail(handleOperator,pojo.getId());
        return true;
    }


    /**
     * @Description 新增 采购公司详情
     * @Author lzx
     * @param handleOperator
     * @param userId 采购人ID
     */
    private void createPurchaserCompanyDetail(HandlePurchaser handleOperator, Long userId) {
        TPurchaserDetailInfo pojo=new TPurchaserDetailInfo();
        Date date = new Date();
        pojo.setPurchaserId(userId);
        pojo.setCompanyName(pojo.getCompanyName());
        pojo.setUniformCreditCode(pojo.getUniformCreditCode());
        pojo.setPublicBankName(pojo.getPublicBankName());
        pojo.setPublicBanAccountNumber(pojo.getPublicBanAccountNumber());
        pojo.setQualificationCertificate(pojo.getQualificationCertificate());
        pojo.setBusinessLicense(pojo.getBusinessLicense());
        pojo.setLegalIdcardPositive(pojo.getLegalIdcardPositive());
        pojo.setLegalIdcardOther(pojo.getLegalIdcardOther());
        pojo.setCertificateOfAuthorization(pojo.getCertificateOfAuthorization());
        pojo.setOperatorIdCardFront(pojo.getOperatorIdCardFront());
        pojo.setExtendedField(pojo.getExtendedField());
        pojo.setCreateAt(date);
        pojo.setUpdateAt(date);
        pojo.setIsDeleted(Const.IS_DELETED.IS_DELETED);
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
        pojo.setName(handleOperator.getPurchaserName());
        pojo.setCreateAt(date);
        pojo.setUpdateAt(date);
        pojo.setIsDeleted(Const.IS_DELETED.IS_DELETED);
        pojo.setPurchaserId(userId);
        tPurchaserUserMapper.insertSelective(pojo);
    }

}