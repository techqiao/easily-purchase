package com.epc.platform.service.service.supplier;

import com.epc.administration.facade.operator.dto.QueryDetailIfo;
import com.epc.administration.facade.operator.handle.UserBasicInfo;
import com.epc.administration.facade.supplier.handle.SupplierHandle;
import com.epc.common.Result;
import com.epc.platform.service.domain.operator.TOperatorDetailInfo;


/**
 * 供应商接口
 */
public interface SupplierUserService {

    /**
     * 供应商注册
     */
    Result<Boolean> insertSupplierUserInfo( UserBasicInfo handleOperator);
    /**
     * 供应商资料不全
     */
     Result<Boolean> insertSupplierDetailInfo( SupplierHandle supplierHandle);

    /**
     * 供应商资料删除
     */
    Result<Boolean> deleteSupplierDetailInfo( QueryDetailIfo queryDetailIfo);

    /**
     * 供应商资料查询
     */
    Result<TOperatorDetailInfo> queryOperatorDetailInfo( QueryDetailIfo queryDetailIfo);

    /**
     * 供应商资料模糊查询
     */
     Result selectSupplierDetailInfo( QueryDetailIfo queryDetailIfo);
}
