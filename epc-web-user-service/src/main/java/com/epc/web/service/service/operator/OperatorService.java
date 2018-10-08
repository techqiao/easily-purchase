package com.epc.web.service.service.operator;

import com.epc.common.Result;
import com.epc.web.facade.operator.handle.*;
import com.epc.web.facade.operator.query.HandleOperatorCellphone;
import com.epc.web.facade.operator.query.HandleOperatorFindAllByName;
import com.epc.web.facade.operator.query.HandleOperatorId;
import com.epc.web.facade.operator.vo.OperatorBasicInfoVO;
import com.epc.web.facade.operator.vo.OperatorBasicVO;
import com.epc.web.facade.operator.vo.TPurchaserBasicInfoVO;
import com.epc.web.facade.operator.vo.TSupplierBasicInfoVO;
import com.epc.web.facade.supplier.handle.RoleDetailInfo;

import java.util.List;

public interface OperatorService {



    /**0
     *  运营商注册(没有通过任何人拉取的，自己找到平台来注册的)
     */
    Result<Boolean> registerOperator(HandleOperator handleOperator);

    /**0.5
     * 已经被人拉取过的，校验电话与名字是否在数据库中有，并且密码为空的，才让其设置密码进行登陆
     */
//    Result<Boolean> addPasswordOperatorLogin(HandleOperator handleOperator);
    /**1
     *  运营商注册,(有人拉的，手机与名字都有,只需要输入电话，姓名就可以登陆)
     *          (有单独的页面登陆，只需要输入姓名，电话就可以进行登陆，进去直接设置密码，然后完善个人信息，然后下次登陆，就查询这个电话下的这条数据的密码状态是否为空，
     *           不为空，就电话，密码登陆；如果为空，就到相应的姓名电话登陆页面登陆。一旦设置完密码就只能用电话与密码进行登陆【其中每个登陆都要验证码，否则不安全】
     *           )
     */
//    Result<Boolean> addPasswordOperator(HandleOperator handleOperator);

    /**2
     * 完善运营商信息
     */
    Result<Boolean> insertCompleteOperatorInfo(RoleDetailInfo roleDetailInfo);


    //--------------------------平台审核通过之后----------------------------------


    /**3
     * 运营商增加一个员工
     */
    Result<Boolean> createOperatorEmployee(HandleOperatorAddEmployee handleOperatorAddEmployee);

    /**4
     * 依据id查询已经登陆的个人信息
     */
    Result<OperatorBasicVO> findByName(HandleOperatorId handleOperatorId);

    /**5
     * 通过员工id来修改员工信息
     */
    Result<Boolean> updateOperatorEmployeeById(HandleOperatorUpdateEmployeeById handleOperatorUpdateEmployeeById);

    /**6
     * 员工id来查询（公司法人supplier_id） 公司详情（包括附件）
     */

    /**7
     * 根据电话来查找一条记录,返回一个真假值
     */
    Result<Boolean> findOperatorRecordByCellphone(HandleOperatorCellphone handleOperatorCellphone);

    /**8
     * 依据电话来删除一个员工,只是改变is_deleted 为1
     */
    Result<Boolean> deleteOperatorEmployeeByCellphone(HandleOperatorCellphone handleOperatorCellphone);

    /**9
     * 通过员工id 只 修改员工 是否禁用
     */

    /**10
     * 依据id来删除一个员工,只是改变is_deleted 为1
     */
    Result<Boolean> deleteOperatorEmployeeById(HandleOperatorIdAndIsDeleted handleOperatorIdAndIsDeleted);

    /**11
     * 根据用户id来修改他的role 用户角色:0-法人,1-管理员,2-普通员工'
     */
    Result<Boolean> updateOperatorEmployeeRoleById(HandleOperatorRole handleOperatorRole);

    /**12
     *  通过id来改变员工是否禁用
     */
    Result<Boolean> updateOperatorEmployeeByisDeleted(HandleOperatorIdAndIsForbidden handleOperatorIdAndIsForbidden);

    /**13
     * 运营商忘记密码
     */
    Result<Boolean> forgetPassword(HandleOperatorForgetPassword handleOperatorForgetPassword);

    /**14
     * 根据员工的名字,角色，是否禁用
     *     来匹配出符合条件的员工返回一个list：
     */
    Result<List<OperatorBasicInfoVO>> queryOperatorEmployeeAll(HandleOperatorFindAllByName handleOperatorFindAllByName);

    /**15
     *  运营商新增采购人（包括完善信息）
     */
    Result<Boolean> createPurchaseByOperator(HandleCreatePurchaserByOperator handleCreatePurchaserByOperator);

    /**15.5
     *
     *  查看当前登陆人拉的采购人列表list
     *      参数:传入当前运营商的id,去采购basic表中去查，看有哪几个采购人是自己拉的
     */
    Result<List<TPurchaserBasicInfoVO>> lookPurchaserList(HandleOperatorLoginInfo handleOperatorLoginInfo);

    /**16
     *  运营商新增采购人（不包括完善信息，只填写姓名，电话）
     */
    Result<Boolean> createPurchaseByOperatorSimple(HandleOperatorCreateSupplier handleOperatorCreateSupplier);


    /**17
     *  运营商新增供应商  (不包括完善信息,只填 姓名、电话)
     */
    Result<Boolean> operatorCreateSupplierSimple(HandleOperatorCreateSupplier handleOperatorCreateSupplier);


    /**18
     *  运营商新增供应商（包括完善信息）
     */
    Result<Boolean> operatorCreateSupplier(HandleCreatePurchaserByOperator handleCreatePurchaserByOperator);

    /**
     * 19
     * 查看当前登陆者拉的供应商列表
     */
    Result<List<TSupplierBasicInfoVO>> lookSupplierList(HandleOperatorLoginInfo handleOperatorLoginInfo);


}
