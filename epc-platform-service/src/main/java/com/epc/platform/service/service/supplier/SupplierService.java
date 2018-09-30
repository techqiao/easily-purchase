package com.epc.platform.service.service.supplier;

import com.epc.administration.facade.supplier.dto.QueryDetailIfo;
import com.epc.administration.facade.supplier.handle.ExamineSupplierHandle;
import com.epc.administration.facade.supplier.handle.SupplierHandle;
import com.epc.administration.facade.supplier.handle.UserBasicInfo;
import com.epc.administration.facade.supplier.vo.SupplierUserVO;
import com.epc.common.Result;

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
     * @param whereId
     * @return
     */
    Result<Boolean> deleteSupplierDetailInfo( Long whereId);

    /**
     * 供应商资料查询
     * @param id
     * @return
     */
    Result querySupplierDetailInfo(Long id);

    /**
     * 查询所有供应商 分页展示
     * @param queryDetailIfo
     * @return
     */
    List<SupplierUserVO> selectAllSupplierByPage(QueryDetailIfo queryDetailIfo);

    /**
     * 审核供应商
     * @param examineSupplierHandle
     * @return
     */
    Result<Boolean> examineSupplier(ExamineSupplierHandle examineSupplierHandle);
}
