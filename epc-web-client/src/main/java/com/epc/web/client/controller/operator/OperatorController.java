package com.epc.web.client.controller.operator;

import com.epc.common.Result;
import com.epc.web.client.controller.common.BaseController;
import com.epc.web.client.controller.operator.handle.*;
import com.epc.web.client.controller.operator.query.ClientHandleOperatorCellphone;
import com.epc.web.client.controller.operator.query.ClientHandleOperatorFindAllByName;
import com.epc.web.client.controller.supplier.handle.ClientRoleDetailInfo;
import com.epc.web.client.remoteApi.operator.OperatorClient;
import com.epc.web.facade.operator.handle.*;
import com.epc.web.facade.operator.query.HandleOperatorCellphone;
import com.epc.web.facade.operator.query.HandleOperatorFindAllByName;
import com.epc.web.facade.operator.query.HandleOperatorId;
import com.epc.web.facade.operator.vo.OperatorBasicInfoVO;
import com.epc.web.facade.operator.vo.OperatorBasicVO;
import com.epc.web.facade.operator.vo.TPurchaserBasicInfoVO;
import com.epc.web.facade.operator.vo.TSupplierBasicInfoVO;
import com.epc.web.facade.supplier.handle.RoleDetailInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "运营商服务",tags = "运营商服务")
@RestController
@RequestMapping(value = "/operator", method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_UTF8_VALUE,consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class OperatorController extends BaseController {

    @Autowired
    private OperatorClient operatorClient;

    /**0
     *  运营商注册(没有通过任何人拉取的，自己找到平台来注册的)
     */
    @ApiOperation(value = "0:运营商注册(没有通过任何人拉取的，自己找到平台来注册的)",notes = "donghuan")
    @PostMapping(value = "public/registerOperator")
    public Result<Boolean> registerOperator(@RequestBody ClientHandleOperator clientHandleOperator){
        HandleOperator handleOperator=new HandleOperator();
        BeanUtils.copyProperties(clientHandleOperator,handleOperator);
        return operatorClient.registerOperator(handleOperator);
    }


    /**0.5
     *  已经被人拉取过的，校验电话与名字是否在数据库中有，并且密码为空的，才让其设置密码进行登陆
     */
//    @ApiOperation(value = "0.5:已经被人拉取过的，校验电话与名字是否在数据库中有，并且密码为空的，才让其设置密码进行登陆",notes = "donghuan")
//    @PostMapping(value = "public/addPasswordOperatorLogin")
//    public Result<Boolean> addPasswordOperatorLogin(@RequestBody ClientHandleOperator clientHandleOperator){
//        HandleOperator  handleOperator=new HandleOperator();
//        BeanUtils.copyProperties(clientHandleOperator,handleOperator);
//        return operatorClient.addPasswordOperatorLogin(handleOperator);
//    }

    /**1
     *
     * version 2:业务修改，被拉取的设置其默认密码为epc1688，并状态为1（拉取状态），直接从电话号码 与 密码框进行登陆,进去就设置密码，将状态改成2（完善信息中）
     *
     *  运营商注册,(有人拉的，手机与名字都有,只需要输入电话，姓名就可以登陆)
     *          (有单独的页面登陆，只需要输入姓名，电话就可以进行登陆，进去直接设置密码，然后完善个人信息，然后下次登陆，就查询这个电话下的这条数据的密码状态是否为空，
     *           不为空，就电话，密码登陆；如果为空，就到相应的姓名电话登陆页面登陆。一旦设置完密码就只能用电话与密码进行登陆【其中每个登陆都要验证码，否则不安全】
     *           )
     */
//    @ApiOperation(value = "1:运营商注册,(有人拉的，手机与名字都有,只需要输入电话，姓名就可以登陆)",notes = "donghuan")
//    @PostMapping(value = "public/addPasswordOperator")
//    public Result<Boolean> addPasswordOperator(@RequestBody ClientHandleOperator clientHandleOperator){
//        HandleOperator handleOperator=new HandleOperator();
//        BeanUtils.copyProperties(clientHandleOperator,handleOperator);
//        return operatorClient.addPasswordOperator(handleOperator);
//    }

    /**2
     * 完善运营商信息
     */
    @ApiOperation(value = "2:完善运营商信息)",notes = "donghuan")
    @PostMapping(value = "public/insertCompleteOperatorInfo")
    public Result<Boolean> insertCompleteOperatorInfo(@RequestBody ClientRoleDetailInfo clientRoleDetailInfo){
        RoleDetailInfo roleDetailInfo=new RoleDetailInfo();
        BeanUtils.copyProperties(clientRoleDetailInfo,roleDetailInfo);
        return operatorClient.insertCompleteOperatorInfo(roleDetailInfo);
    }


    //--------------------------平台审核通过之后----------------------------------


    /**3
     * 运营商增加一个员工
     */
    @ApiOperation(value = "3:运营商增加一个员工",notes = "donghuan")
    @PostMapping(value = "/createOperatorEmployee")
    public Result<Boolean> createOperatorEmployee(@RequestBody ClientHandleOperatorAddEmployee clientHandleOperatorAddEmployee){
        HandleOperatorAddEmployee handleOperatorAddEmployee=new HandleOperatorAddEmployee();
        BeanUtils.copyProperties(clientHandleOperatorAddEmployee,handleOperatorAddEmployee);
        Integer loginRole = getLoginUser().getLoginRole();
        Long bossId = getLoginUser().getBossId();
        if(loginRole==null || bossId==null){
            return Result.error("从redis中获取当前登陆用户信息 异常");
        }
        handleOperatorAddEmployee.setLoginRole(loginRole);
        handleOperatorAddEmployee.setBossId(bossId);
        return operatorClient.createOperatorEmployee(handleOperatorAddEmployee);
    }

//    /**4
//     * 依据id查询已经登陆的个人信息(如果是法人，管理员，员工)
//     */
//    @ApiOperation(value = "4:依据id查询已经登陆的个人信息",notes = "donghuan")
//    @PostMapping(value = "/findByNameOperator")
//    public Result<OperatorBasicInfoVO> findByName(@RequestBody ClientHandleOperatorId clientHandleOperatorId){
//        HandleOperatorId handleOperatorId=new HandleOperatorId();
//        BeanUtils.copyProperties(clientHandleOperatorId,handleOperatorId);
//        Long userId = getLoginUser().getUserId();
//        Long bossId = getLoginUser().getBossId();
//        Integer type = getLoginUser().getType();
//        Integer loginRole = getLoginUser().getLoginRole();
//        if(userId==null || type==null || loginRole==null || bossId==null){
//            return Result.success("从redis中获取当前登陆用户信息 异常");
//        }
//        handleOperatorId.s
//        handleOperatorId
//
//        return operatorClient.findByName(handleOperatorId);
//    }
    /**4
     * 查询 登陆者个人详情
     */
    @ApiOperation(value = "4:查询 登陆者个人详情",notes = "donghuan")
    @PostMapping(value = "/findByNameOperator")
    public Result<OperatorBasicVO> findByName(){
        HandleOperatorId handleOperatorId=new HandleOperatorId();
        Long userId = getLoginUser().getUserId();
        Integer loginRole = getLoginUser().getLoginRole();
        if(userId==null || loginRole==null){
            return Result.error("从redis中获取当前登陆用户信息 异常");
        }
        System.out.println(" loginRole="+loginRole+" userId="+userId);
        handleOperatorId.setLoginId(userId);
        handleOperatorId.setLoginRole(loginRole);
        return operatorClient.findByName(handleOperatorId);
    }

    /**5
     * 通过员工id来修改员工信息
     */
    @ApiOperation(value = "5:通过员工id来修改员工信息",notes = "donghuan")
    @PostMapping(value = "/updateOperatorEmployeeById")
    public Result<Boolean> updateOperatorEmployeeById(@RequestBody ClientHandleOperatorUpdateEmployeeById clientHandleOperatorUpdateEmployeeById){
        HandleOperatorUpdateEmployeeById handleOperatorUpdateEmployeeById=new HandleOperatorUpdateEmployeeById();
        BeanUtils.copyProperties(clientHandleOperatorUpdateEmployeeById,handleOperatorUpdateEmployeeById);
        Integer loginRole = getLoginUser().getLoginRole();
        if(loginRole==null){
            return Result.error("从redis中获取当前登陆用户信息 异常");
        }
        handleOperatorUpdateEmployeeById.setLoginRole(loginRole);
        return operatorClient.updateOperatorEmployeeById(handleOperatorUpdateEmployeeById);
    }

    /**6
     * 员工id来查询（公司法人supplier_id） 公司详情（包括附件）
     */

    /**7
     * 根据电话来查找一条记录,返回一个真假值
     */
    @ApiOperation(value = "7:根据电话来查找一条记录,返回一个真假值",notes = "donghuan")
    @PostMapping(value = "/findOperatorRecordByCellphone")
    public Result<Boolean> findOperatorRecordByCellphone(@RequestBody ClientHandleOperatorCellphone clientHandleOperatorCellphone){
        HandleOperatorCellphone handleOperatorCellphone=new HandleOperatorCellphone();
        BeanUtils.copyProperties(clientHandleOperatorCellphone,handleOperatorCellphone);
        Integer loginRole = getLoginUser().getLoginRole();
        if(loginRole==null){
            return Result.error("从redis中获取当前登陆用户信息 异常");
        }
        handleOperatorCellphone.setLoginRole(loginRole);
        return operatorClient.findOperatorRecordByCellphone(handleOperatorCellphone);
    }

    /**8
     * 依据电话来删除一个员工,只是改变is_deleted 为1
     */
    @ApiOperation(value = "8:依据电话来删除一个员工,只是改变is_deleted 为1",notes = "donghuan")
    @PostMapping(value = "/deleteOperatorEmployeeByCellphone")
    public Result<Boolean> deleteOperatorEmployeeByCellphone(@RequestBody ClientHandleOperatorCellphone clientHandleOperatorCellphone){
        HandleOperatorCellphone handleOperatorCellphone=new HandleOperatorCellphone();
        BeanUtils.copyProperties(clientHandleOperatorCellphone,handleOperatorCellphone);
        Integer loginRole = getLoginUser().getLoginRole();
        if(loginRole==null){
            return Result.error("从redis中获取当前登陆用户信息 异常");
        }
        handleOperatorCellphone.setLoginRole(loginRole);
        return operatorClient.deleteOperatorEmployeeByCellphone(handleOperatorCellphone);
    }

    /**9
     * 通过员工id 只 修改员工 是否禁用
     */

    /**10
     * 依据id来删除一个员工,只是改变is_deleted 为1
     */
    @ApiOperation(value = "10:依据id来删除一个员工,只是改变is_deleted 为1",notes = "donghuan")
    @PostMapping(value = "/deleteOperatorEmployeeById")
    public Result<Boolean> deleteOperatorEmployeeById(@RequestBody ClientHandleOperatorIdAndIsDeleted clientHandleOperatorIdAndIsDeleted){
        HandleOperatorIdAndIsDeleted handleOperatorIdAndIsDeleted=new HandleOperatorIdAndIsDeleted();
        BeanUtils.copyProperties(clientHandleOperatorIdAndIsDeleted,handleOperatorIdAndIsDeleted);
        Integer loginRole = getLoginUser().getLoginRole();
        if(loginRole==null){
            return Result.error("从redis中获取当前登陆用户信息 异常");
        }
        handleOperatorIdAndIsDeleted.setLoginRole(loginRole);
        return operatorClient.deleteOperatorEmployeeById(handleOperatorIdAndIsDeleted);
    }

    /**11
     * 根据用户id来修改他的role 用户角色:0-法人,1-管理员,2-普通员工'
     */
    @ApiOperation(value = "11:根据用户id来修改他的role 用户角色:0-法人,1-管理员,2-普通员工",notes = "donghuan")
    @PostMapping(value = "/updateOperatorEmployeeRoleById")
    public Result<Boolean> updateOperatorEmployeeRoleById(@RequestBody ClientHandleOperatorRole clientHandleOperatorRole){
        HandleOperatorRole handleOperatorRole=new HandleOperatorRole();
        BeanUtils.copyProperties(clientHandleOperatorRole,handleOperatorRole);
        Integer loginRole = getLoginUser().getLoginRole();
        if(loginRole==null){
            return  Result.error("从redis中获取当前登陆用户信息 异常");
        }
        handleOperatorRole.setLoginRole(loginRole);
        return operatorClient.updateOperatorEmployeeRoleById(handleOperatorRole);
    }

    /**12
     *  通过id来改变员工是否禁用
     */
    @ApiOperation(value = "12:通过id来改变员工是否禁用",notes = "donghuan")
    @PostMapping(value = "/updateOperatorEmployeeByisDeleted")
    public Result<Boolean> updateOperatorEmployeeByisDeleted(@RequestBody ClientHandleOperatorIdAndIsForbidden clientHandleOperatorIdAndIsForbidden){
        HandleOperatorIdAndIsForbidden handleOperatorIdAndIsForbidden=new HandleOperatorIdAndIsForbidden();
        BeanUtils.copyProperties(clientHandleOperatorIdAndIsForbidden,handleOperatorIdAndIsForbidden);
        Integer loginRole = getLoginUser().getLoginRole();
        if(loginRole==null){
            return  Result.error("从redis中获取当前登陆用户信息 异常");
        }
        handleOperatorIdAndIsForbidden.setLoginRole(loginRole);
        return operatorClient.updateOperatorEmployeeByisDeleted(handleOperatorIdAndIsForbidden);
    }

    /**13
     * 运营商忘记密码
     */
    @ApiOperation(value = "13:修改密码",notes = "donghuan")
    @PostMapping(value = "public/forgetPasswordOperator")
    public Result<Boolean> forgetPassword(@RequestBody ClientHandleOperatorForgetPassword clientHandleOperatorForgetPassword){
        HandleOperatorForgetPassword handleOperatorForgetPassword=new HandleOperatorForgetPassword();
        BeanUtils.copyProperties(clientHandleOperatorForgetPassword,handleOperatorForgetPassword);
        return operatorClient.forgetPassword(handleOperatorForgetPassword);
    }

    /**14
     * 根据员工的名字,角色，是否禁用,来匹配出符合条件的员工返回一个list：
     */
    @ApiOperation(value = "14:根据员工的名字,角色，是否禁用,来匹配出符合条件的员工返回一个list",notes = "donghuan")
    @PostMapping(value = "/queryOperatorEmployeeAll")
    public Result<List<OperatorBasicInfoVO>> queryOperatorEmployeeAll(@RequestBody ClientHandleOperatorFindAllByName clientHandleOperatorFindAllByName){
        HandleOperatorFindAllByName handleOperatorFindAllByName=new HandleOperatorFindAllByName();
        BeanUtils.copyProperties(clientHandleOperatorFindAllByName,handleOperatorFindAllByName);
        Long bossId = getLoginUser().getBossId();
        Integer loginRole = getLoginUser().getLoginRole();
        if(bossId==null || loginRole==null){
            return  Result.error("从redis中获取当前登陆用户信息 异常");
        }
        handleOperatorFindAllByName.setBossId(bossId);
        handleOperatorFindAllByName.setLoginRole(loginRole);
        return operatorClient.queryOperatorEmployeeAll(handleOperatorFindAllByName);
    }

    /**15
     *  运营商新增采购人（第2步：完善信息）
     */
    @ApiOperation(value = "运营商新增采购人（第2步：完善信息）-15",notes = "donghuan")
    @PostMapping(value = "/createPurchaseByOperator")
    public Result<Boolean> createPurchaseByOperator(@RequestBody ClientRoleDetailInfo clientRoleDetailInfo){
        HandleCreatePurchaserByOperator handleCreatePurchaserByOperator=new HandleCreatePurchaserByOperator();
        BeanUtils.copyProperties(clientRoleDetailInfo,handleCreatePurchaserByOperator);
        return operatorClient.createPurchaseByOperator(handleCreatePurchaserByOperator);
    }

    /**15.5
     *
     *  查看当前登陆人拉的采购人列表list
     *      参数:传入当前运营商的id,去采购basic表中去查，看有哪几个采购人是自己拉的
     */
    @ApiOperation(value = "查看当前登陆人拉的采购人列表list--15.5",notes = "donghuan")
    @PostMapping(value = "/lookPurchaserList")
    public Result<List<TPurchaserBasicInfoVO>> lookPurchaserList(){
        HandleOperatorLoginInfo handleOperatorLoginInfo=new HandleOperatorLoginInfo();
        Long userId = getLoginUser().getUserId();
        Long bossId = getLoginUser().getBossId();
        Integer type = getLoginUser().getType();
        if(userId==null || bossId==null || type==null){
            return Result.error("从redis中获取当前登陆用户信息 异常");
        }
        handleOperatorLoginInfo.setBossId(bossId);
        handleOperatorLoginInfo.setId(userId);
        handleOperatorLoginInfo.setSystemRole(type);
        return operatorClient.lookPurchaserList(handleOperatorLoginInfo);
    }
    /**15.6
     *通过手机号或者姓名来搜索自己拉的采购人
     */
    @ApiOperation(value = "通过手机号或者姓名来搜索自己拉的采购人",notes = "donghuan")
    @PostMapping(value = "/searchPurchaserSingle")
    public Result<List<TPurchaserBasicInfoVO>> searchPurchaserSingle(@RequestBody ClientHandleOperatorCreateSupplier clientHandleOperatorCreateSupplier){
        HandleOperatorCreateSupplier handleOperatorCreateSupplier=new HandleOperatorCreateSupplier();
        BeanUtils.copyProperties(clientHandleOperatorCreateSupplier,handleOperatorCreateSupplier);
        Long bossId = getLoginUser().getBossId();
        Long userId = getLoginUser().getUserId();
        Integer type = getLoginUser().getType();
        if(type==null || bossId==null || userId==null){
            return Result.error("从redis中获取当前登陆用户信息 异常");
        }
        handleOperatorCreateSupplier.setSystemRole(type);
        handleOperatorCreateSupplier.setId(userId);
        handleOperatorCreateSupplier.setBossId(bossId);
        return operatorClient.searchPurchaserSingle(handleOperatorCreateSupplier);
    }




        /**16
         *  运营商新增采购人（第1步：不包括完善信息，只填写姓名，电话，及默认密码epc1688）
         */
    @ApiOperation(value = "运营商新增采购人（第1步：不包括完善信息，只填写姓名，电话，及默认密码epc1688--16）",notes = "donghuan")
    @PostMapping(value = "/createPurchaseByOperatorSimple")
    public Result<Boolean> createPurchaseByOperatorSimple(@RequestBody ClientHandleOperatorCreateSupplier clientHandleOperatorCreateSupplier){
        HandleOperatorCreateSupplier handleOperatorCreateSupplier=new HandleOperatorCreateSupplier();
        BeanUtils.copyProperties(clientHandleOperatorCreateSupplier,handleOperatorCreateSupplier);
        Long userId = getLoginUser().getUserId();
        Long bossId = getLoginUser().getBossId();
        Integer type = getLoginUser().getType();
        Integer loginRole = getLoginUser().getLoginRole();
        if(userId==null || bossId==null || type==null || loginRole==null){
            return Result.error("从redis中获取当前登陆用户信息 异常");
        }
        handleOperatorCreateSupplier.setSystemRole(type);
        handleOperatorCreateSupplier.setLoginRole(loginRole);
        handleOperatorCreateSupplier.setId(userId);
        handleOperatorCreateSupplier.setBossId(bossId);
        return operatorClient.createPurchaseByOperatorSimple(handleOperatorCreateSupplier);
    }


    /**17
     *  运营商新增供应商  (第1步：不包括完善信息，只填写姓名，电话，及默认密码epc1688)
     */
    @ApiOperation(value = "17:运营商新增供应商 (第1步：不包括完善信息，只填写姓名，电话，及默认密码epc1688)",notes = "donghuan")
    @PostMapping(value = "/operatorCreateSupplierSimple")
    public Result<Boolean> operatorCreateSupplierSimple(@RequestBody ClientHandleOperatorCreateSupplier clientHandleOperatorCreateSupplier){
        HandleOperatorCreateSupplier handleOperatorCreateSupplier=new HandleOperatorCreateSupplier();
        BeanUtils.copyProperties(clientHandleOperatorCreateSupplier,handleOperatorCreateSupplier);
        Long userId = getLoginUser().getUserId();
        Long bossId = getLoginUser().getBossId();
        Integer type = getLoginUser().getType();
        Integer loginRole = getLoginUser().getLoginRole();
        if(userId==null || bossId==null || type==null || loginRole==null){
            return Result.error("从redis中获取当前登陆用户信息 异常");
        }
        handleOperatorCreateSupplier.setId(userId);
        handleOperatorCreateSupplier.setBossId(bossId);
        handleOperatorCreateSupplier.setSystemRole(type);
        handleOperatorCreateSupplier.setLoginRole(loginRole);
        return operatorClient.operatorCreateSupplierSimple(handleOperatorCreateSupplier);
    }


    /**18
     *  运营商新增供应商（包括完善信息）
     */
    @ApiOperation(value = "18:运营商新增供应商（包括完善信息）",notes = "donghuan")
    @PostMapping(value = "/operatorCreateSupplier")
    public Result<Boolean> operatorCreateSupplier(@RequestBody ClientRoleDetailInfo clientRoleDetailInfo){
        HandleCreatePurchaserByOperator handleCreatePurchaserByOperator=new HandleCreatePurchaserByOperator();
        BeanUtils.copyProperties(clientRoleDetailInfo,handleCreatePurchaserByOperator);
        return operatorClient.operatorCreateSupplier(handleCreatePurchaserByOperator);
    }

    /**19
     *    查看当前登陆者拉的供应商列表
     */
    @ApiOperation(value = "查看当前登陆者拉的供应商列表--19",notes = "donghuan")
    @PostMapping(value = "/lookSupplierList")
    public Result<List<TSupplierBasicInfoVO>> lookSupplierList(){
        HandleOperatorLoginInfo handleOperatorLoginInfo=new HandleOperatorLoginInfo();
        Long userId = getLoginUser().getUserId();
        Long bossId = getLoginUser().getBossId();
        Integer type = getLoginUser().getType();
        if(userId==null || bossId==null || type==null){
            return Result.error("从redis中获取当前登陆用户信息 异常");
        }
        handleOperatorLoginInfo.setSystemRole(type);
        handleOperatorLoginInfo.setId(userId);
        handleOperatorLoginInfo.setBossId(bossId);
        return operatorClient.lookSupplierList(handleOperatorLoginInfo);
    }

    /**20
     *通过手机号或者姓名来搜索自己拉的供应商
     */
    @ApiOperation(value = "20 通过手机号或者姓名来搜索自己拉的供应商",notes = "donghuan")
    @PostMapping(value = "/searchSupplierSingle")
    public Result<List<TSupplierBasicInfoVO>> searchSupplierSingle(@RequestBody ClientHandleOperatorCreateSupplier clientHandleOperatorCreateSupplier){
        HandleOperatorCreateSupplier handleOperatorCreateSupplier=new HandleOperatorCreateSupplier();
        BeanUtils.copyProperties(clientHandleOperatorCreateSupplier,handleOperatorCreateSupplier);
        Integer type = getLoginUser().getType();
        Long bossId = getLoginUser().getBossId();
        Long userId = getLoginUser().getUserId();
        if(type==null || bossId==null || userId==null){
            return Result.error("从redis中获取当前登陆用户信息 异常");
        }
        handleOperatorCreateSupplier.setSystemRole(type);
        handleOperatorCreateSupplier.setBossId(bossId);
        handleOperatorCreateSupplier.setId(userId);
        return operatorClient.searchSupplierSingle(handleOperatorCreateSupplier);
    }





    }
