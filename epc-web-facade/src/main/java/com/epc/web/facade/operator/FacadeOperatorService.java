package com.epc.web.facade.operator;

import com.epc.web.facade.operator.handle.*;
import com.epc.web.facade.operator.query.HandleOperatorCellphone;
import com.epc.web.facade.operator.query.HandleOperatorFindAllByName;
import com.epc.web.facade.operator.query.HandleOperatorId;
import com.epc.web.facade.operator.vo.OperatorBasicInfoVO;
import com.epc.web.facade.supplier.handle.RoleDetailInfo;
import org.springframework.web.bind.annotation.PostMapping;
import com.epc.common.Result;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * @Description:    运营商服务
 * @Author:         linzhixiang
 * @CreateDate:     2018/9/13 9:50
 * @UpdateUser:     linzhixiang
 * @UpdateDate:     2018/9/13 9:50
 * @UpdateRemark:   修改内容
 * @Version:        1.0
 */

/**运营商注册(没有通过任何人拉取的，自己找到平台来注册的)
 * @PostMapping(value = "registerOperator",consumes = "application/json; charset=UTF-8")
 *     Result<Boolean> registerOperator(@RequestBody HandleOperator handleOperator);
 */

public interface FacadeOperatorService {

    /**0
     *  运营商注册(没有通过任何人拉取的，自己找到平台来注册的)
     */
    @PostMapping(value = "registerOperator",consumes = "application/json; charset=UTF-8")
    Result<Boolean> registerOperator(@RequestBody HandleOperator handleOperator);

    /**1
     *  运营商注册,(有人拉的，手机与名字都有,只需要输入电话，姓名就可以登陆)
     *          (有单独的页面登陆，只需要输入姓名，电话就可以进行登陆，进去直接设置密码，然后完善个人信息，然后下次登陆，就查询这个电话下的这条数据的密码状态是否为空，
     *           不为空，就电话，密码登陆；如果为空，就到相应的姓名电话登陆页面登陆。一旦设置完密码就只能用电话与密码进行登陆【其中每个登陆都要验证码，否则不安全】
     *           )
     */
    @PostMapping(value = "addPasswordOperator",consumes = "application/json; charset=UTF-8")
    Result<Boolean> addPasswordOperator(@RequestBody HandleOperator handleOperator);

    /**2
     * 完善运营商信息
     */
    @PostMapping(value = "insertCompleteOperatorInfo",consumes = "application/json; charset=UTF-8")
    Result<Boolean> insertCompleteOperatorInfo(@RequestBody RoleDetailInfo roleDetailInfo);


    //--------------------------平台审核通过之后----------------------------------


    /**3
     * 运营商增加一个员工
     */
    @PostMapping(value = "createOperatorEmployee",consumes = "application/json; charset=UTF-8")
    Result<Boolean> createOperatorEmployee(@RequestBody HandleOperatorAddEmployee handleOperatorAddEmployee);

    /**4
     * 依据id查询已经登陆的个人信息
     */
    @PostMapping(value = "findByNameOperator",consumes = "application/json; charset=UTF-8")
    Result<OperatorBasicInfoVO> findByName(@RequestBody HandleOperatorId handleOperatorId);

    /**5
     * 通过员工id来修改员工信息
     */
    @PostMapping(value = "updateOperatorEmployeeById",consumes = "application/json; charset=UTF-8")
    Result<Boolean> updateOperatorEmployeeById(@RequestBody HandleOperatorUpdateEmployeeById handleOperatorUpdateEmployeeById);

    /**6
     * 员工id来查询（公司法人supplier_id） 公司详情（包括附件）
     */

    /**7
     * 根据电话来查找一条记录,返回一个真假值
     */
    @PostMapping(value = "findOperatorRecordByCellphone",consumes = "application/json; charset=UTF-8")
    Result<Boolean> findOperatorRecordByCellphone(@RequestBody HandleOperatorCellphone handleOperatorCellphone);

    /**8
     * 依据电话来删除一个员工,只是改变is_deleted 为1
     */
    @PostMapping(value = "deleteOperatorEmployeeByCellphone",consumes = "application/json; charset=UTF-8")
    Result<Boolean> deleteOperatorEmployeeByCellphone(@RequestBody HandleOperatorCellphone handleOperatorCellphone);

    /**9
     * 通过员工id 只 修改员工 是否禁用
     */

    /**10
     * 依据id来删除一个员工,只是改变is_deleted 为1
     */
    @PostMapping(value = "deleteOperatorEmployeeById",consumes = "application/json; charset=UTF-8")
    Result<Boolean> deleteOperatorEmployeeById(@RequestBody HandleOperatorIdAndIsDeleted handleOperatorIdAndIsDeleted);

    /**11
     * 根据用户id来修改他的role 用户角色:0-法人,1-管理员,2-普通员工'
     */
    @PostMapping(value = "updateOperatorEmployeeRoleById",consumes = "application/json; charset=UTF-8")
    Result<Boolean> updateOperatorEmployeeRoleById(@RequestBody HandleOperatorRole handleOperatorRole);

    /**12
     *  通过id来改变员工是否禁用
     */
    @PostMapping(value = "updateOperatorEmployeeByisDeleted",consumes = "application/json; charset=UTF-8")
    Result<Boolean> updateOperatorEmployeeByisDeleted(@RequestBody HandleOperatorIdAndIsForbidden handleOperatorIdAndIsForbidden);

    /**13
     * 运营商忘记密码
     */
    @PostMapping(value = "forgetPasswordOperator",consumes = "application/json; charset=UTF-8")
    Result<Boolean> forgetPasswordOperator(@RequestBody HandleOperatorForgetPassword handleOperatorForgetPassword);

    /**14
     * 根据员工的名字,角色，是否禁用
     *     来匹配出符合条件的员工返回一个list：
     */
    @PostMapping(value = "queryOperatorEmployeeAll",consumes = "application/json; charset=UTF-8")
    Result<List<OperatorBasicInfoVO>> queryOperatorEmployeeAll(@RequestBody HandleOperatorFindAllByName handleOperatorFindAllByName);

    /**15
     *  运营商新增采购人（包括完善信息）
     */
    @PostMapping(value = "createPurchaseByOperator",consumes = "application/json; charset=UTF-8")
    Result<Boolean> createPurchaseByOperator(@RequestBody HandleCreatePurchaserByOperator handleCreatePurchaserByOperator);

    /**16
     *  运营商新增采购人（不包括完善信息，只填写姓名，电话）
     */
    @PostMapping(value = "createPurchaseByOperatorSimple",consumes = "application/json; charset=UTF-8")
    Result<Boolean> createPurchaseByOperatorSimple(@RequestBody HandleOperatorCreateSupplier handleOperatorCreateSupplier);


    /**17
     *  运营商新增供应商  (不包括完善信息,只填 姓名、电话)
     */
    @PostMapping(value = "operatorCreateSupplierSimple",consumes = "application/json; charset=UTF-8")
    Result<Boolean> operatorCreateSupplierSimple(@RequestBody HandleOperatorCreateSupplier handleOperatorCreateSupplier);


    /**18
     *  运营商新增供应商（包括完善信息）
     */
    @PostMapping(value = "operatorCreateSupplier",consumes = "application/json; charset=UTF-8")
    Result<Boolean> operatorCreateSupplier(@RequestBody HandleCreatePurchaserByOperator handleCreatePurchaserByOperator);




}
