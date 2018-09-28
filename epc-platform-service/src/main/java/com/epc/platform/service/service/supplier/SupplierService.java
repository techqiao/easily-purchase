package com.epc.platform.service.service.supplier;

import com.epc.administration.facade.operator.dto.QueryDetailIfo;
import com.epc.administration.facade.operator.handle.UserBasicInfo;
import com.epc.administration.facade.supplier.handle.SupplierHandle;
import com.epc.common.Result;
import com.epc.platform.service.domain.supplier.TSupplierDetailInfo;

import java.util.List;


/**
 * 供应商接口
 */
public interface SupplierService {

    /**
     * 供应商注册
     * @param handleOperator
     * @return
     */
    Result insertSupplierUserInfo(UserBasicInfo handleOperator);
    /**
     * 供应商资料补全
     * @param supplierHandle
     * @return
     */
     Result<Boolean> insertSupplierDetailInfo(SupplierHandle supplierHandle);

    /**
     * 供应商资料删除
     * @param queryDetailIfo
     * @return
     */
    Result<Boolean> deleteSupplierDetailInfo(QueryDetailIfo queryDetailIfo);

    /**
     * 供应商资料查询
     * @param queryDetailIfo
     * @return
     */
    Result querySupplierDetailInfo(QueryDetailIfo queryDetailIfo);

    /**
     * 供应商资料模糊查询
     * @param queryDetailIfo
     * @return
     */
     Result selectSupplierDetailInfo(QueryDetailIfo queryDetailIfo);

    /**
     * 查询所有供应商 分页展示
     * @return
     */
    List<TSupplierDetailInfo> selectAllSupplierByPage();
}
