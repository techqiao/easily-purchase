package com.epc.web.facade.supplier;

import com.epc.common.Result;
import com.epc.web.facade.loginuser.dto.LoginUser;
import com.epc.web.facade.operator.handle.HandleOperatorRole;
import com.epc.web.facade.operator.handle.HandleOperatorState;
import com.epc.web.facade.supplier.handle.*;
import com.epc.web.facade.supplier.query.HandleSupplierCellphone;
import com.epc.web.facade.supplier.query.HandleSupplierId;
import com.epc.web.facade.supplier.query.HandleSupplierIdAndName;
import com.epc.web.facade.supplier.query.QuerywithPageHandle;
import com.epc.web.facade.supplier.vo.SupplierAttachmentAndDetailVO;
import com.epc.web.facade.supplier.vo.SupplierBasicInfoVO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Map;


/**
 * @Description:    供应商服务
 * @Author:         donghuan
 */
public interface FacadeTSupplierBasicInfoService {

    /**0
     * 注册供应商
     *  {业务：    还需要要判断电话在数据库中有没有，（有无人拉。如无，就是自己注册；如有，就是添加密码登陆完善个人信息）
     *         1. 第一次只需要填写电话及密码就行，注册完成登陆成功后，可以做后续的完善信息工作
     *              所以目前，只操作一张基本信息表就行，等完善信息时，操作三张即可
     *         2.  由其他角色拉入平台网站 ，直接设置密码 ，登陆供应商账号
     *  }
     *  自己找到平台网站注册供应商
     */
    @PostMapping(value = "registerSupplier",consumes = "application/json;charset=UTF-8")
    Result<Boolean> registerSupplier(@RequestBody HandleSupplierDetail handleSupplierDetail);

    /**0.5
     * 已经被人拉取过的，校验电话与名字是否在数据库中有，并且密码为空的，才让其设置密码进行登陆
     */
    @PostMapping(value="public/addPasswordSupplierLogin",consumes = "application/json;charset=UTF-8")
    Result<Boolean> addPasswordSupplierLogin(@RequestBody HandleSupplierDetail handleSupplierDetail);
    /**1
     *    2.由其他角色拉入平台网站 ，直接设置密码 ，登陆供应商账号
     *      (有单独的页面登陆，只需要输入姓名，电话就可以进行登陆，进去直接设置密码，然后完善个人信息，然后下次登陆，就查询这个电话下的这条数据的密码状态是否为空，
     *      不为空，就电话，密码登陆；如果为空，就到相应的姓名电话登陆页面登陆。一旦设置完密码就只能用电话与密码进行登陆【其中每个登陆都要验证码，否则不安全】
     *      )
     */
    @PostMapping(value = "addPasswordSupplier",consumes = "application/json;charset=UTF-8")
    Result<Boolean> addPasswordSupplier(@RequestBody HandleSupplierDetail handleSupplierDetail);

    /**2
     *  完善供应商信息
     */
    @PostMapping(value = "insertCompleteSupplierInfo",consumes = "application/json;charset=UTF-8")
    Result<Boolean> insertCompleteSupplierInfo(@RequestBody RoleDetailInfo roleDetailInfo);

    //--------------------------平台审核通过之后----------------------------------

    /**3
     * 供应商增加一个员工(有可能增加的是一个管理员)
     */
    @PostMapping(value = "createSupplierEmployee",consumes = "application/json;charset=UTF-8")
    Result<Boolean> createSupplierEmployee(@RequestBody HandlerSupplierAddEmployee handlerSupplierAddEmployee);

    /**4
     * 根据员工的id来查询基本信息
     */
    @PostMapping(value = "findSupplierBasicById",consumes = "application/json;charset=UTF-8")
    Result<SupplierBasicInfoVO> findSupplierBasicById(@RequestBody HandleSupplierId handleSupplierId);

    /**5
     *  供应商通过id修改员工
     *     通过id查询这个用户信息，得到用户提交的数据，并且设置到对应的实体类中
     */
    @PostMapping(value = "updateSupplierEmployeeById",consumes = "application/json;charset=UTF-8")
    Result<Boolean> updateSupplierEmployeeById(@RequestBody HandlerUpdateSupplierEmployeeById handlerUpdateSupplierEmployeeById);

    /**6
     * 员工id来查询（公司法人supplier_id） 公司详情（包括附件）
     */
    @PostMapping(value = "findSupplierDetailByEmployee",consumes = "application/json;charset=UTF-8")
    Result<SupplierAttachmentAndDetailVO> findSupplierDetailByEmployee(@RequestBody HandleSupplierId handleSupplierId);

    /**7
     * 根据电话来查找一条记录,返回一个真假值
     */
    @PostMapping(value = "findSupplierRecordByCellphone",consumes = "application/json;charset=UTF-8")
    Result<Boolean> findSupplierRecordByCellphone(@RequestBody HandleSupplierCellphone handleSupplierCellphone);

    /**8
     * 根据电话来查找一条记录,返回一个基本信息
     */
    @PostMapping(value = "findSupplierByCellphone",consumes = "application/json;charset=UTF-8")
    Result<SupplierBasicInfoVO> findSupplierByCellphone(@RequestBody HandleSupplierCellphone handleSupplierCellphone);

    /**9
     * 通过员工id 只 修改员工 是否禁用
     */
    @PostMapping(value = "updateSupplierEmployeeByisDeleted",consumes = "application/json;charset=UTF-8")
    Result<Boolean> updateSupplierEmployeeByisDeleted(@RequestBody HandleSupplierIdAndIsForbidden handleSupplierIdAndIsForbidden);

    /**10
     * 根据员工id来删除一个员工,只是将 is_deleted 改为1，
     */
    @PostMapping(value = "deleteSupplierEmployeeById",consumes = "application/json;charset=UTF-8")
    Result<Boolean> deleteSupplierEmployeeById(@RequestBody HandleSupplieIsDeleted handleSupplieIsDeleted);

    /**11
     * 根据用户id来修改他的role 用户角色:0-法人,1-管理员,2-普通员工
     * @author donghuan
     */
    @PostMapping(value = "updateSupplierEmployeeRoleById",consumes = "application/json;charset=UTF-8")
    Result<Boolean> updateSupplierEmployeeRoleById(@RequestBody HandleOperatorRole handleOperatorRole);

    /**12
     * 通过id来修改对应的state  0-已注册, 1-完善中, 2-已提交, 3-审核通过, 4-审核失败
     * @author donghuan
     */
    @PostMapping(value = "updateSupplierEmployeeStateById",consumes = "application/json;charset=UTF-8")
    Result<Boolean> updateSupplierEmployeeStateById(@RequestBody HandleOperatorState handleOperatorState);

    /**13
     *  忘记密码
     */
    @PostMapping(value = "forgetPasswordSupplier",consumes = "application/json;charset=UTF-8")
    Result<Boolean> forgetPasswordSupplier(@RequestBody HandleSupplierForgetPassword handleSupplierForgetPassword);


    /**14
     * 根据员工的名字,角色，是否禁用
     * 来匹配出符合条件的员工返回一个list：
     */
    @PostMapping(value = "querySupplierEmployeeAll",consumes = "application/json;charset=UTF-8")
    Result<List<SupplierBasicInfoVO>> querySupplierEmployeeAll(@RequestBody HandleSupplierIdAndName handleSupplierIdAndName);


    /**
     * 根据登录者id查询他需要看到的投标项目
     * @param querywithPageHandle
     * @return
     */
    @PostMapping(value = "querySupplierProject" ,consumes = "application/json;charset=UTF-8")
    Result<Map<String, Object>> querySupplierProject(@RequestBody QuerywithPageHandle querywithPageHandle);

}
