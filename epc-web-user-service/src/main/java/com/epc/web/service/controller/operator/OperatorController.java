package com.epc.web.service.controller.operator;


import com.epc.common.Result;
import com.epc.web.facade.operator.FacadeOperatorService;
import com.epc.web.facade.operator.handle.*;
import com.epc.web.facade.operator.query.HandleOperatorCellphone;
import com.epc.web.facade.operator.query.HandleOperatorFindAllByName;
import com.epc.web.facade.operator.query.HandleOperatorId;
import com.epc.web.facade.operator.vo.OperatorBasicInfoVO;
import com.epc.web.facade.operator.vo.OperatorBasicVO;
import com.epc.web.facade.operator.vo.TPurchaserBasicInfoVO;
import com.epc.web.facade.operator.vo.TSupplierBasicInfoVO;
import com.epc.web.facade.supplier.handle.RoleDetailInfo;
import com.epc.web.service.service.operator.OperatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * <p>Description : 运营商服务
 * <p>Date : 2018-09-10  18:08
 */
@RestController
public class OperatorController implements FacadeOperatorService {

    @Autowired
    private OperatorService operatorService;


    /**0
     *  运营商注册(没有通过任何人拉取的，自己找到平台来注册的)
     */
    @Override
    public Result<Boolean> registerOperator(@RequestBody HandleOperator handleOperator){
        return operatorService.registerOperator(handleOperator);
    }

    /**0.5
     * 已经被人拉取过的，校验电话与名字是否在数据库中有，并且密码为空的，才让其设置密码进行登陆
     */
//    @Override
//    public Result<Boolean> addPasswordOperatorLogin(@RequestBody HandleOperator handleOperator){
//        return operatorService.addPasswordOperatorLogin(handleOperator);
//    }
    /**1
     *  运营商注册,(有人拉的，手机与名字都有,只需要输入电话，姓名就可以登陆)
     *          (有单独的页面登陆，只需要输入姓名，电话就可以进行登陆，进去直接设置密码，然后完善个人信息，然后下次登陆，就查询这个电话下的这条数据的密码状态是否为空，
     *           不为空，就电话，密码登陆；如果为空，就到相应的姓名电话登陆页面登陆。一旦设置完密码就只能用电话与密码进行登陆【其中每个登陆都要验证码，否则不安全】
     *           )
     */
//    @Override
//    public Result<Boolean> addPasswordOperator(@RequestBody HandleOperator handleOperator){
//        return operatorService.addPasswordOperator(handleOperator);
//    }

    /**2
     * 完善运营商信息
     */
    @Override
    public Result<Boolean> insertCompleteOperatorInfo(@RequestBody RoleDetailInfo roleDetailInfo){
        return operatorService.insertCompleteOperatorInfo(roleDetailInfo);
    }


    //--------------------------平台审核通过之后----------------------------------


    /**3
     * 运营商增加一个员工
     */
    @Override
    public Result<Boolean> createOperatorEmployee(@RequestBody HandleOperatorAddEmployee handleOperatorAddEmployee){
        return operatorService.createOperatorEmployee(handleOperatorAddEmployee);
    }

    /**4
     * 依据id查询已经登陆的个人信息
     */
    @Override
    public Result<OperatorBasicVO> findByName(@RequestBody  HandleOperatorId handleOperatorId){
        return operatorService.findByName(handleOperatorId);
    }

    /**5
     * 通过员工id来修改员工信息
     */
    @Override
    public Result<Boolean> updateOperatorEmployeeById(@RequestBody HandleOperatorUpdateEmployeeById handleOperatorUpdateEmployeeById){
        return operatorService.updateOperatorEmployeeById(handleOperatorUpdateEmployeeById);
    }

    /**6
     * 员工id来查询（公司法人supplier_id） 公司详情（包括附件）
     */

    /**7
     * 根据电话来查找一条记录,返回一个真假值
     */
    @Override
    public Result<Boolean> findOperatorRecordByCellphone(@RequestBody HandleOperatorCellphone handleOperatorCellphone){
        return operatorService.findOperatorRecordByCellphone(handleOperatorCellphone);
    }

    /**8
     * 依据电话来删除一个员工,只是改变is_deleted 为1
     */
    @Override
    public Result<Boolean> deleteOperatorEmployeeByCellphone(@RequestBody HandleOperatorCellphone handleOperatorCellphone){
        return operatorService.deleteOperatorEmployeeByCellphone(handleOperatorCellphone);
    }

    /**9
     * 通过员工id 只 修改员工 是否禁用
     */

    /**10
     * 依据id来删除一个员工,只是改变is_deleted 为1
     */
    @Override
    public Result<Boolean> deleteOperatorEmployeeById(@RequestBody HandleOperatorIdAndIsDeleted handleOperatorIdAndIsDeleted){
        return operatorService.deleteOperatorEmployeeById(handleOperatorIdAndIsDeleted);
    }

    /**11
     * 根据用户id来修改他的role 用户角色:0-法人,1-管理员,2-普通员工'
     */
    @Override
    public Result<Boolean> updateOperatorEmployeeRoleById(@RequestBody HandleOperatorRole handleOperatorRole){
        return operatorService.updateOperatorEmployeeRoleById(handleOperatorRole);
    }

    /**12
     *  通过id来改变员工是否禁用
     */
    @Override
    public Result<Boolean> updateOperatorEmployeeByisDeleted(@RequestBody HandleOperatorIdAndIsForbidden handleOperatorIdAndIsForbidden){
        return operatorService.updateOperatorEmployeeByisDeleted(handleOperatorIdAndIsForbidden);
    }

    /**13
     * 运营商忘记密码
     */
    @Override
    public Result<Boolean> forgetPassword(@RequestBody HandleOperatorForgetPassword handleOperatorForgetPassword){
        return operatorService.forgetPassword(handleOperatorForgetPassword);
    }

    /**14
     * 根据员工的名字,角色，是否禁用
     *     来匹配出符合条件的员工返回一个list：
     */
    @Override
    public Result<List<OperatorBasicInfoVO>> queryOperatorEmployeeAll(@RequestBody HandleOperatorFindAllByName handleOperatorFindAllByName){
        return operatorService.queryOperatorEmployeeAll(handleOperatorFindAllByName);
    }

    /**15
     *  运营商新增采购人（包括完善信息）
     */
    @Override
    public Result<Boolean> createPurchaseByOperator(@RequestBody HandleCreatePurchaserByOperator handleCreatePurchaserByOperator){
        return operatorService.createPurchaseByOperator(handleCreatePurchaserByOperator);
    }

    /**15.5
     *
     *  查看当前登陆人拉的采购人列表list
     *      参数:传入当前运营商的id,去采购basic表中去查，看有哪几个采购人是自己拉的
     */
    @Override
    public Result<List<TPurchaserBasicInfoVO>> lookPurchaserList(@RequestBody HandleOperatorLoginInfo handleOperatorLoginInfo){
        return operatorService.lookPurchaserList(handleOperatorLoginInfo);
    }

    /**15.6
     *通过手机号或者姓名来搜索自己拉的采购人
     */
    @Override
    public Result<List<TPurchaserBasicInfoVO>> searchPurchaserSingle(@RequestBody HandleOperatorCreateSupplier handleOperatorCreateSupplier){
        return operatorService.searchPurchaserSingle(handleOperatorCreateSupplier);
    }

    /**16
     *  运营商新增采购人（不包括完善信息，只填写姓名，电话）
     */
    @Override
    public Result<Boolean> createPurchaseByOperatorSimple(@RequestBody HandleOperatorCreateSupplier handleOperatorCreateSupplier){
        return operatorService.createPurchaseByOperatorSimple(handleOperatorCreateSupplier);
    }


    /**17
     *  运营商新增供应商  (不包括完善信息,只填 姓名、电话)
     */
    @Override
    public Result<Boolean> operatorCreateSupplierSimple(@RequestBody HandleOperatorCreateSupplier handleOperatorCreateSupplier){
        return operatorService.operatorCreateSupplierSimple(handleOperatorCreateSupplier);
    }


    /**18
     *  运营商新增供应商（包括完善信息）
     */
    @Override
    public Result<Boolean> operatorCreateSupplier(@RequestBody HandleCreatePurchaserByOperator handleCreatePurchaserByOperator){
        return operatorService.operatorCreateSupplier(handleCreatePurchaserByOperator);
    }

    /**19
     *    查看当前登陆者拉的供应商列表
     */
    @Override
    public Result<List<TSupplierBasicInfoVO>> lookSupplierList(@RequestBody HandleOperatorLoginInfo handleOperatorLoginInfo){
        return operatorService.lookSupplierList(handleOperatorLoginInfo);
    }

    /**20
     *通过手机号或者姓名来搜索自己拉的供应商
     */
    @Override
    public Result<List<TSupplierBasicInfoVO>> searchSupplierSingle(@RequestBody HandleOperatorCreateSupplier handleOperatorCreateSupplier) {
        return operatorService.searchSupplierSingle(handleOperatorCreateSupplier);
    }

}
