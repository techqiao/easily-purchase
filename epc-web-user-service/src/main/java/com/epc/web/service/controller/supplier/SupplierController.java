package com.epc.web.service.controller.supplier;

import com.epc.common.Result;
import com.epc.web.facade.operator.handle.HandleOperatorRole;
import com.epc.web.facade.operator.handle.HandleOperatorState;
import com.epc.web.facade.supplier.FacadeTSupplierBasicInfoService;
import com.epc.web.facade.supplier.handle.*;
import com.epc.web.facade.supplier.query.HandleSupplierCellphone;
import com.epc.web.facade.supplier.query.HandleSupplierId;
import com.epc.web.facade.supplier.query.HandleSupplierIdAndName;
import com.epc.web.facade.supplier.vo.SupplierAttachmentAndDetailVO;
import com.epc.web.facade.supplier.vo.SupplierBasicInfoVO;
import com.epc.web.service.service.supplier.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 供应商服务
 * @author donghuan
 */
@RestController
public class SupplierController implements FacadeTSupplierBasicInfoService {

    @Autowired
    private SupplierService supplierService;

    /**0
     * 注册供应商
     *  {业务：    还需要要判断电话在数据库中有没有，（有无人拉。如无，就是自己注册；如有，就是添加密码登陆完善个人信息）
     *         1. 第一次只需要填写电话及密码就行，注册完成登陆成功后，可以做后续的完善信息工作
     *              所以目前，只操作一张基本信息表就行，等完善信息时，操作三张即可
     *         2.  由其他角色拉入平台网站 ，直接设置密码 ，登陆供应商账号
     *  }
     *  自己找到平台网站注册供应商
     */
    @Override
    public Result<Boolean> registerSupplier(@RequestBody HandleSupplierDetail handleSupplierDetail){
        return supplierService.registerSupplier(handleSupplierDetail);
    }

    /**1
     *    2.由其他角色拉入平台网站 ，直接设置密码 ，登陆供应商账号
     *      (有单独的页面登陆，只需要输入姓名，电话就可以进行登陆，进去直接设置密码，然后完善个人信息，然后下次登陆，就查询这个电话下的这条数据的密码状态是否为空，
     *      不为空，就电话，密码登陆；如果为空，就到相应的姓名电话登陆页面登陆。一旦设置完密码就只能用电话与密码进行登陆【其中每个登陆都要验证码，否则不安全】
     *      )
     */
    @Override
    public Result<Boolean> addPasswordSupplier(@RequestBody HandleSupplierDetail handleSupplierDetail){
        return supplierService.addPasswordSupplier(handleSupplierDetail);
    }

    /**2
     *  完善供应商信息
     */
    @Override
    public Result<Boolean> insertCompleteSupplierInfo(@RequestBody RoleDetailInfo roleDetailInfo){
        return supplierService.insertCompleteSupplierInfo(roleDetailInfo);
    }

    //--------------------------平台审核通过之后----------------------------------

    /**3
     * 供应商增加一个员工(有可能增加的是一个管理员)
     */
    @Override
    public Result<Boolean> createSupplierEmployee(@RequestBody HandlerSupplierAddEmployee handlerSupplierAddEmployee){
        return supplierService.createSupplierEmployee(handlerSupplierAddEmployee);
    }

    /**4
     * 根据员工的id来查询基本信息
     */
    @Override
    public Result<SupplierBasicInfoVO> findSupplierBasicById(@RequestBody HandleSupplierId handleSupplierId){
        return supplierService.findSupplierBasicById(handleSupplierId);
    }

    /**5
     *  供应商通过id修改员工
     *     通过id查询这个用户信息，得到用户提交的数据，并且设置到对应的实体类中
     */
    @Override
    public Result<Boolean> updateSupplierEmployeeById(@RequestBody HandlerUpdateSupplierEmployeeById handlerUpdateSupplierEmployeeById){
        return supplierService.updateSupplierEmployeeById(handlerUpdateSupplierEmployeeById);
    }

    /**6
     * 员工id来查询（公司法人supplier_id） 公司详情（包括附件）
     */
    @Override
    public Result<SupplierAttachmentAndDetailVO> findSupplierDetailByEmployee(@RequestBody HandleSupplierId handleSupplierId) {
        return supplierService.findSupplierDetailByEmployee(handleSupplierId);
    }

    /**7
     * 根据电话来查找一条记录,返回一个真假值
     */
    @Override
    public Result<Boolean> findSupplierRecordByCellphone(@RequestBody HandleSupplierCellphone handleSupplierCellphone){
        return supplierService.findSupplierRecordByCellphone(handleSupplierCellphone);
    }

    /**8
     * 根据电话来查找一条记录,返回一个基本信息
     */
    @Override
    public Result<SupplierBasicInfoVO> findSupplierByCellphone(@RequestBody HandleSupplierCellphone handleSupplierCellphone){
        return supplierService.findSupplierByCellphone(handleSupplierCellphone);
    }

    /**9
     * 通过员工id 只 修改员工 是否禁用
     */
    @Override
    public Result<Boolean> updateSupplierEmployeeByisDeleted(@RequestBody HandleSupplierIdAndIsForbidden handleSupplierIdAndIsForbidden){
        return supplierService.updateSupplierEmployeeByisDeleted(handleSupplierIdAndIsForbidden);
    }

    /**10
     * 根据员工id来删除一个员工,只是将 is_deleted 改为1，
     */
    @Override
    public Result<Boolean> deleteSupplierEmployeeById(@RequestBody HandleSupplieIsDeleted handleSupplieIsDeleted){
        return supplierService.deleteSupplierEmployeeById(handleSupplieIsDeleted);
    }

    /**11
     * 根据用户id来修改他的role 用户角色:0-法人,1-管理员,2-普通员工
     * @author donghuan
     */
    @Override
    public Result<Boolean> updateSupplierEmployeeRoleById(@RequestBody HandleOperatorRole handleOperatorRole){
        return supplierService.updateSupplierEmployeeRoleById(handleOperatorRole);
    }

    /**12
     * 通过id来修改对应的state  0-已注册, 1-完善中, 2-已提交, 3-审核通过, 4-审核失败
     * @author donghuan
     */
    @Override
    public Result<Boolean> updateSupplierEmployeeStateById(@RequestBody HandleOperatorState handleOperatorState){
        return supplierService.updateSupplierEmployeeStateById(handleOperatorState);
    }

    /**13
     *  忘记密码
     */
    @Override
    public Result<Boolean> forgetPassword(@RequestBody HandleSupplierForgetPassword handleSupplierForgetPassword) {
        return supplierService.forgetPassword(handleSupplierForgetPassword);
    }


    /**14
     * 根据员工的名字,角色，是否禁用
     * 来匹配出符合条件的员工返回一个list：
     */
    @Override
    public Result<List<SupplierBasicInfoVO>> querySupplierEmployeeAll(@RequestBody HandleSupplierIdAndName handleSupplierIdAndName){
        return supplierService.querySupplierEmployeeAll(handleSupplierIdAndName);
    }





}
