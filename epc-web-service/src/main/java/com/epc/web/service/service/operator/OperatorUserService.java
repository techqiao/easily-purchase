package com.epc.web.service.service.operator;

import com.epc.common.Result;
import com.epc.web.facade.operator.handle.HandleOperatorDetail;
import com.epc.web.facade.operator.handle.HandleOperatorForgetPassword;
import com.epc.web.facade.operator.vo.OperatorBasicInfoVO;
import com.epc.web.facade.supplier.handle.HandleSupplierDetail;
import com.epc.web.facade.supplier.handle.HandleSupplierForgetPassword;
import com.epc.web.service.domain.operator.TOperatorBasicInfo;
import com.epc.web.service.domain.operator.TOperatorDetailInfo;
import com.epc.web.service.domain.supplier.TSupplierBasicInfo;

/**
 * @author donghuan
 */
public interface OperatorUserService {

    /**
     * 注册运营商
     * @param HandleOperatorDetail
     * @return
     */
    Result<Boolean> registerOperator(HandleOperatorDetail HandleOperatorDetail);


    /**
     * 查询运营商用户信息
     * @param name
     * @param cellphone
     * @return
     */
    Result<OperatorBasicInfoVO> findByName(String name, String cellphone);

    /**
     * 忘记密码
     * @param handleOperatorForgetPassword
     */
    Result<Boolean> forgetPassword(HandleOperatorForgetPassword handleOperatorForgetPassword);

}
