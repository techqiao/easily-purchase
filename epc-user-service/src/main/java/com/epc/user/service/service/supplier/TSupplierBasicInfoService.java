package com.epc.user.service.service.supplier;


import com.epc.common.Result;
import com.epc.web.facade.supplier.handle.HandleSupplierDetail;
import com.epc.web.facade.supplier.handle.HandlerSupplierUser;


public interface TSupplierBasicInfoService {

    /**
     * @Description:    供应商添加员工
     * @param handlerSupplierUser
     * @return
     */
    public abstract Result<Boolean> createSupplierUser(HandlerSupplierUser handlerSupplierUser);

    public abstract Result<Boolean> createSupplierBasicInfo(HandleSupplierDetail handlerSupplierUser);



//    /**
//     * 供应商注册信息插入到数据库中
//     * @param handlerRegisterSupplier
//     * @return
//     */
//    public abstract boolean createSupplier(HandlerRegisterSupplier handlerRegisterSupplier);



//    /**
//     * 供应商通过员工id来修改名字和手机号
//     * @param handlerUpdateSupplierUser
//     * @return
//     */
//    public abstract boolean updateSupplierUser(HandlerUpdateSupplierUser handlerUpdateSupplierUser);
//
//    /**
//     *  查询所有的员工列表
//     * @return
//     */
//    public abstract List<T> querySupplierAll();

}
