package com.epc.web.client.controller.supplier;

import com.epc.common.Result;
import com.epc.web.client.controller.operator.handle.ClientHandleOperatorRole;
import com.epc.web.client.controller.operator.handle.ClientHandleOperatorState;
import com.epc.web.client.controller.supplier.handle.*;
import com.epc.web.client.controller.supplier.query.ClientHandleSupplierCellphone;
import com.epc.web.client.controller.supplier.query.ClientHandleSupplierId;
import com.epc.web.client.controller.supplier.query.ClientHandleSupplierIdAndName;
import com.epc.web.client.remoteApi.supplier.SupplierClient;
import com.epc.web.facade.operator.handle.HandleOperatorRole;
import com.epc.web.facade.operator.handle.HandleOperatorState;
import com.epc.web.facade.supplier.handle.*;
import com.epc.web.facade.supplier.query.HandleSupplierCellphone;
import com.epc.web.facade.supplier.query.HandleSupplierId;
import com.epc.web.facade.supplier.query.HandleSupplierIdAndName;
import com.epc.web.facade.supplier.vo.SupplierAttachmentAndDetailVO;
import com.epc.web.facade.supplier.vo.SupplierBasicInfoVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Api(value = "供应商服务"/*,tags = "供应商服务"*/)
@RestController
@RequestMapping(value = "/supplier",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_UTF8_VALUE,consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class TSupplierBasicInfoController /*extends BaseController*/ {

    @Autowired
    private SupplierClient supplierClient;

    /**0
     * 注册供应商
     *  {业务：    还需要要判断电话在数据库中有没有，（有无人拉。如无，就是自己注册；如有，就是添加密码登陆完善个人信息）
     *         1. 第一次只需要填写电话及密码就行，注册完成登陆成功后，可以做后续的完善信息工作
     *              所以目前，只操作一张基本信息表就行，等完善信息时，操作三张即可
     *         2.  由其他角色拉入平台网站 ，直接设置密码 ，登陆供应商账号
     *  }
     *  自己找到平台网站注册供应商
     */
    @ApiOperation(value = "0:自己找到平台网站注册供应商",notes = "donghuan")
    @PostMapping(value = "public/registerSupplier")
    public Result<Boolean> registerSupplier(@RequestBody ClientHandleSupplierDetail clientHandleSupplierDetail){
        HandleSupplierDetail handleSupplierDetail=new HandleSupplierDetail();
        BeanUtils.copyProperties(clientHandleSupplierDetail,handleSupplierDetail);
        return supplierClient.registerSupplier(handleSupplierDetail);
    }


    @ApiOperation(value = "1:由其他角色拉入平台网站 ，直接设置密码 ，登陆供应商账号",notes = "donghuan")
    @PostMapping(value="public/addPasswordSupplierLogin")
    public Result<Boolean> addPasswordSupplierLogin(@RequestBody ClientHandleSupplierDetail clientHandleSupplierDetail){
        HandleSupplierDetail handleSupplierDetail=new HandleSupplierDetail();
        BeanUtils.copyProperties(clientHandleSupplierDetail,handleSupplierDetail);
        return supplierClient.addPasswordSupplierLogin(handleSupplierDetail);
    }

    /**1
     *    2.由其他角色拉入平台网站 ，直接设置密码 ，登陆供应商账号
     *      (有单独的页面登陆，只需要输入姓名，电话就可以进行登陆，进去直接设置密码，然后完善个人信息，然后下次登陆，就查询这个电话下的这条数据的密码状态是否为空，
     *      不为空，就电话，密码登陆；如果为空，就到相应的姓名电话登陆页面登陆。一旦设置完密码就只能用电话与密码进行登陆【其中每个登陆都要验证码，否则不安全】
     *      )
     */
    @ApiOperation(value = "1:由其他角色拉入平台网站 ，直接设置密码 ，登陆供应商账号",notes = "donghuan")
    @PostMapping(value="public/addPasswordSupplier")
    public Result<Boolean> addPasswordSupplier(@RequestBody ClientHandleSupplierDetail clientHandleSupplierDetail){
        HandleSupplierDetail handleSupplierDetail=new HandleSupplierDetail();
        BeanUtils.copyProperties(clientHandleSupplierDetail,handleSupplierDetail);
        return supplierClient.addPasswordSupplier(handleSupplierDetail);
    }

    /**2
     *  完善供应商信息
     */
    @ApiOperation(value = "2:完善供应商信息",notes = "donghuan")
    @PostMapping(value = "/insertCompleteSupplierInfo")
    public Result<Boolean> insertCompleteSupplierInfo(@RequestBody ClientRoleDetailInfo clientRoleDetailInfo){
        RoleDetailInfo roleDetailInfo=new RoleDetailInfo();
        BeanUtils.copyProperties(clientRoleDetailInfo,roleDetailInfo);
        return supplierClient.insertCompleteSupplierInfo(roleDetailInfo);
    }

    //--------------------------平台审核通过之后----------------------------------

    /**3
     * 供应商增加一个员工(有可能增加的是一个管理员)
     */
    @ApiOperation(value = "3:供应商增加一个员工(有可能增加的是一个管理员)",notes = "donghuan")
    @PostMapping(value = "/createSupplierEmployee")
    public Result<Boolean> createSupplierEmployee(@RequestBody ClientHandlerSupplierAddEmployee clientHandlerSupplierAddEmployee){
        HandlerSupplierAddEmployee handlerSupplierAddEmployee=new HandlerSupplierAddEmployee();
        BeanUtils.copyProperties(clientHandlerSupplierAddEmployee,handlerSupplierAddEmployee);
        return supplierClient.createSupplierEmployee(handlerSupplierAddEmployee);
    }

    /**4
     * 根据员工的id来查询基本信息
     */
    @ApiOperation(value = "4:根据员工的id来查询基本信息",notes = "donghuan")
    @PostMapping(value = "/findSupplierBasicById")
    public Result<SupplierBasicInfoVO> findSupplierBasicById(@RequestBody ClientHandleSupplierId clientHandleSupplierId){
        HandleSupplierId handleSupplierId=new HandleSupplierId();
        BeanUtils.copyProperties(clientHandleSupplierId,handleSupplierId);
        return supplierClient.findSupplierBasicById(handleSupplierId);
    }

    /**5
     *  供应商通过id修改员工
     *     通过id查询这个用户信息，得到用户提交的数据，并且设置到对应的实体类中
     */
    @ApiOperation(value = "5:供应商通过id修改员工",notes = "donghuan")
    @PostMapping(value = "/updateSupplierEmployeeById")
    public Result<Boolean> updateSupplierEmployeeById(@RequestBody ClientHandlerUpdateSupplierEmployeeById clientHandlerUpdateSupplierEmployeeById){
        HandlerUpdateSupplierEmployeeById handlerUpdateSupplierEmployeeById=new HandlerUpdateSupplierEmployeeById();
        BeanUtils.copyProperties(clientHandlerUpdateSupplierEmployeeById,handlerUpdateSupplierEmployeeById);
        return supplierClient.updateSupplierEmployeeById(handlerUpdateSupplierEmployeeById);
    }

    /**6
     * 员工id来查询（公司法人supplier_id） 公司详情（包括附件）
     */
    @ApiOperation(value = "6:员工id来查询（公司法人supplier_id）公司详情（包括附件）",notes = "donghuan")
    @PostMapping(value = "/findSupplierDetailByEmployee")
    public Result<SupplierAttachmentAndDetailVO> findSupplierDetailByEmployee(@RequestBody ClientHandleSupplierId clientHandleSupplierId) {
        HandleSupplierId handleSupplierId=new HandleSupplierId();
        BeanUtils.copyProperties(clientHandleSupplierId,handleSupplierId);
        return supplierClient.findSupplierDetailByEmployee(handleSupplierId);
    }

    /**7
     * 根据电话来查找一条记录,返回一个真假值
     */
    @ApiOperation(value = "7:根据电话来查找一条记录,返回一个真假值",notes = "donghuan")
    @PostMapping(value = "/findSupplierRecordByCellphone")
    public Result<Boolean> findSupplierRecordByCellphone(@RequestBody ClientHandleSupplierCellphone clientHandleSupplierCellphone){
        HandleSupplierCellphone handleSupplierCellphone=new HandleSupplierCellphone();
        BeanUtils.copyProperties(clientHandleSupplierCellphone,handleSupplierCellphone);
        return supplierClient.findSupplierRecordByCellphone(handleSupplierCellphone);
    }

    /**8
     * 根据电话来查找一条记录,返回一个基本信息
     */
    @ApiOperation(value = "8:根据电话来查找一条记录,返回一个基本信息",notes = "donghuan")
    @PostMapping(value = "/findSupplierByCellphone")
    public Result<SupplierBasicInfoVO> findSupplierByCellphone(@RequestBody ClientHandleSupplierCellphone clientHandleSupplierCellphone){
        HandleSupplierCellphone handleSupplierCellphone=new HandleSupplierCellphone();
        BeanUtils.copyProperties(clientHandleSupplierCellphone,handleSupplierCellphone);
        return supplierClient.findSupplierByCellphone(handleSupplierCellphone);
    }

    /**9
     * 通过员工id 只 修改员工 是否禁用
     */
    @ApiOperation(value = "9:通过员工id只修改员工是否禁用",notes = "donghuan")
    @PostMapping(value = "/updateSupplierEmployeeByisDeleted")
    public Result<Boolean> updateSupplierEmployeeByisDeleted(@RequestBody ClientHandleSupplierIdAndIsForbidden clientHandleSupplierIdAndIsForbidden){
        HandleSupplierIdAndIsForbidden handleSupplierIdAndIsForbidden=new HandleSupplierIdAndIsForbidden();
        BeanUtils.copyProperties(clientHandleSupplierIdAndIsForbidden,handleSupplierIdAndIsForbidden);
        return supplierClient.updateSupplierEmployeeByisDeleted(handleSupplierIdAndIsForbidden);
    }

    /**10
     * 根据员工id来删除一个员工,只是将 is_deleted 改为1，
     */
    @ApiOperation(value = "10:根据员工id来删除一个员工,只是将 is_deleted 改为1，",notes = "donghuan")
    @PostMapping(value = "/clientHandleSupplierIdAndIsForbidden")
    public Result<Boolean> clientHandleSupplierIdAndIsForbidden(@RequestBody ClientHandleSupplieIsDeleted clientHandleSupplieIsDeleted){
        HandleSupplieIsDeleted handleSupplieIsDeleted=new HandleSupplieIsDeleted();
        BeanUtils.copyProperties(clientHandleSupplieIsDeleted,handleSupplieIsDeleted);
        return supplierClient.deleteSupplierEmployeeById(handleSupplieIsDeleted);
    }

    /**11
     * 根据用户id来修改他的role 用户角色:0-法人,1-管理员,2-普通员工
     * @author donghuan
     */
    @ApiOperation(value = "11:根据用户id来修改他的role 用户角色:0-法人,1-管理员,2-普通员工",notes = "donghuan")
    @PostMapping(value = "/updateSupplierEmployeeRoleById")
    public Result<Boolean> updateSupplierEmployeeRoleById(@RequestBody ClientHandleOperatorRole clientHandleOperatorRole){
        HandleOperatorRole handleOperatorRole=new HandleOperatorRole();
        BeanUtils.copyProperties(clientHandleOperatorRole,handleOperatorRole);
        return supplierClient.updateSupplierEmployeeRoleById(handleOperatorRole);
    }

    /**12
     * 通过id来修改对应的state  0-已注册, 1-完善中, 2-已提交, 3-审核通过, 4-审核失败
     * @author donghuan
     */
    @ApiOperation(value = "12:通过id来修改对应的state  0-已注册, 1-完善中, 2-已提交, 3-审核通过, 4-审核失败",notes = "donghuan")
    @PostMapping(value = "/updateSupplierEmployeeStateById")
    public Result<Boolean> updateSupplierEmployeeStateById(@RequestBody ClientHandleOperatorState clientHandleOperatorState){
        HandleOperatorState handleOperatorState=new HandleOperatorState();
        BeanUtils.copyProperties(clientHandleOperatorState,handleOperatorState);
        return supplierClient.updateSupplierEmployeeStateById(handleOperatorState);
    }

    /**13
     *  忘记密码
     */
    @ApiOperation(value = "13:忘记密码",notes = "donghuan")
    @PostMapping(value = "public/forgetPasswordSupplier")
    public Result<Boolean> forgetPasswordSupplier(@RequestBody ClientHandleSupplierForgetPassword clientHandleSupplierForgetPassword) {
        HandleSupplierForgetPassword handleSupplierForgetPassword=new HandleSupplierForgetPassword();
        BeanUtils.copyProperties(clientHandleSupplierForgetPassword,handleSupplierForgetPassword);
        return supplierClient.forgetPasswordSupplier(handleSupplierForgetPassword);
    }


    /**14
     * 根据员工的名字,角色，是否禁用 来匹配出符合条件的员工返回一个list：
     */
    @ApiOperation(value = "14:根据员工的名字,角色，是否禁用 来匹配出符合条件的员工返回一个list",notes = "donghuan")
    @PostMapping(value = "/querySupplierEmployeeAll")
    public Result<List<SupplierBasicInfoVO>> querySupplierEmployeeAll(@RequestBody ClientHandleSupplierIdAndName clientHandleSupplierIdAndName){
        HandleSupplierIdAndName handleSupplierIdAndName=new HandleSupplierIdAndName();
        BeanUtils.copyProperties(clientHandleSupplierIdAndName,handleSupplierIdAndName);
        return supplierClient.querySupplierEmployeeAll(handleSupplierIdAndName);
    }




}
