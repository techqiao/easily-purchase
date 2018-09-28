package com.epc.web.facade.supplier;

import com.epc.common.Result;
import com.epc.web.facade.operator.handle.HandleOperatorCellphone;
import com.epc.web.facade.operator.handle.HandleOperatorRole;
import com.epc.web.facade.operator.handle.HandleOperatorState;
import com.epc.web.facade.supplier.handle.*;
import com.epc.web.facade.supplier.query.HandleFindSupplierByInfo;
import com.epc.web.facade.supplier.vo.SupplierAttachmentAndDetailVO;
import com.epc.web.facade.supplier.vo.SupplierBasicInfoVO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;


/**
 * @Description:    供应商添加员工
 * @Author:         donghuan
 */
public interface FacadeTSupplierBasicInfoService {

    /**
     *  自己找到平台注册供应商
     * @author donghuan
     */
    @PostMapping(value = "registerSupplier",consumes = "application/json;charset=UTF-8")
    Result<Boolean> registerSupplier(@RequestBody  HandleSupplierDetail handleSupplierDetail);

    /**
     *  由其他角色拉入平台网站 ，直接设置密码 ，登陆供应商账号
     *  @author donghuan
     */
    @PostMapping(value = "addPasswordSupplier",consumes = "application/json;charset=UTF-8")
    Result<Boolean> addPasswordSupplier(@RequestBody HandleSupplierDetail handleSupplierDetail);

    /**
     * 根据员工的id来删除员工
     * @author  donghuan
     */
    @PostMapping(value = "deleteSupplierEmployeeById",consumes = "application/json;charset=UTF-8")
    Result<Boolean> deleteSupplierEmployeeById(@RequestBody HandleFindSupplierByInfo handleFindSupplierByInfo);

//    /**
//     * 依据电话来删除一个员工
//     *  @author donghuan
//     */
//    @PostMapping(value = "deleteOperatorEmployeeByCellphone",consumes = "application/json;charset=UTF-8")
//    Result<Boolean> deleteOperatorEmployeeByCellphone(@RequestBody HandleOperatorCellphone handleOperatorCellphone);

    /**
     * 根据员工的id来查询基本信息
     * @author  donghuan
     */
    @PostMapping(value = "findSupplierBasicById",consumes = "application/json;charset=UTF-8")
    Result<SupplierBasicInfoVO> findSupplierBasicById(@RequestBody HandleFindSupplierByInfo handleFindSupplierByInfo);

    /**
     * 通过员工id 只 修改员工的状态
     * @author  donghuan
     */
    @PostMapping(value = "updateSupplierEmployeeByisDeleted" ,consumes = "application/json;charset=UTF-8")
    Result<Boolean> updateSupplierEmployeeByisDeleted(@RequestBody HandleSupplierEmployeeByisDeleted handleSupplierEmployeeByisDeleted);

    /**
     * 根据用户id来修改他的role 用户角色:0-法人,1-管理员,2-普通员工'
     * @author donghuan
     */
    @PostMapping(value = "updateSupplierEmployeeRoleById",consumes = "application/json;charset=UTF-8")
    Result<Boolean> updateSupplierEmployeeRoleById(@RequestBody HandleOperatorRole handleOperatorRole);

    /**
     * 通过id来修改对应的state  0-已注册, 1-完善中, 2-已提交, 3-审核通过, 4-审核失败
     * @author donghuan
     */
    @PostMapping(value = "updateSupplierEmployeeStateById",consumes = "application/json;charset=UTF-8")
    Result<Boolean> updateSupplierEmployeeStateById(@RequestBody HandleOperatorState handleOperatorState);

    /**
     * 员工查看 公司详情
     * @author  donghuan
     */
    @PostMapping(value = "findSupplierDetailByEmployee",consumes = "application/json;charset=UTF-8")
    Result<SupplierAttachmentAndDetailVO> findSupplierDetailByEmployee(@RequestBody HandleFindSupplierByInfo handleFindSupplierByInfo);

    /**
     * 根据电话来查找一条记录,返回一个真假值
     * @author  donghuan
     */
    @PostMapping(value = "findSupplierRecordByCellphone",consumes = "application/json;charset=UTF-8")
    Result<Boolean> findSupplierRecordByCellphone(@RequestBody HandleSupplierRecordByCellphone handleSupplierByCellphone);

    /**
     * 根据电话来查找一条记录,返回一个记录
     * @author  donghuan
     */
    @PostMapping(value = "findSupplierByCellphone",consumes = "application/json;charset=UTF-8")
    Result<SupplierBasicInfoVO> findSupplierByCellphone(@RequestBody HandleFindSupplierByInfo handleFindSupplierByInfo);

    /**
     * 忘记密码
     * @author  donghuan
     */
    @PostMapping(value = "forgetPasswordSupplier",consumes = "application/json;charset=UTF-8")
    Result<Boolean> forgetPassword(@RequestBody HandleSupplierForgetPassword handleSupplierForgetPassword);

    /**
     * 供应商添加员工
     * @author  donghuan
     */
    @PostMapping(value = "createSupplierEmployee", consumes = "application/json;charset=UTF-8")
    Result<Boolean> createSupplierEmployee(@RequestBody HandlerSupplierAddEmployee handlerSupplierAddEmployee);

    /**
     * 供应商通过员工id来修改名字和手机号及状态是否可用
     * @author  donghuan
     */
    @PostMapping(value = "updateSupplierEmployeeById", consumes ="application/json;charset=UTF-8" )
    Result<Boolean> updateSupplierEmployeeById(@RequestBody HandlerUpdateSupplierEmployeeById handlerUpdateSupplierEmployeeById);

    /**
     *  模糊查询
     *  传入员工的姓名查询所有的员工列表
     *  @author  donghuan
     */
    @PostMapping(value = "querySupplierEmployeeAll", consumes = "application/json;charset=UTF-8")
    Result<List<SupplierBasicInfoVO>> querySupplierEmployeeAll(@RequestBody HandleFindSupplierByInfo handleFindSupplierByInfo);

    /**
     * 由员工状态来查询出员工的列表:(你给我你的id, 我找出这个角色当中符合这个状态的所有员工)
     */
    @PostMapping(value = "querySupplierEmployeeByisDeleted",consumes = "application/json;charset=UTF-8")
    Result<List<SupplierBasicInfoVO>> querySupplierEmployeeByisDeleted(@RequestBody HandleFindSupplierByInfo handleFindSupplierByInfo);

    /**
     * 完善供应商信息
     *
     */
    @PostMapping(value = "insertCompleteSupplierInfo",consumes ="application/json;charset=UTF-8" )
    Result<Boolean> insertCompleteSupplierInfo(@RequestBody RoleDetailInfo roleDetailInfo);


}
