package com.epc.web.facade.agency;

import com.epc.common.Result;
import com.epc.web.facade.agency.dto.*;
import com.epc.web.facade.agency.handle.HandleAgency;
import com.epc.web.facade.agency.handle.HandleEmployee;
import com.epc.web.facade.agency.handle.HandleExpert;
import com.epc.web.facade.agency.handle.HandleSupplier;
import com.epc.web.facade.agency.vo.AgencyEmployeeVo;
import com.epc.web.facade.agency.vo.AgencyExpertDetailVo;
import com.epc.web.facade.agency.vo.AgencyExpertVo;
import com.epc.web.facade.agency.vo.AgencySupplierVo;
import com.epc.web.facade.purchaser.dto.QueryDto;
import com.epc.web.facade.purchaser.handle.HandleTrustList;
import org.apache.el.parser.BooleanNode;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashMap;
import java.util.List;

/**
 * @Author :winlin
 * @Description :代理商服务
 * @Date:2018/9/15
 */
public interface FacadeAgencyService{
    /**
     * @Author :winlin
     * @Description :新增员工
     * @Date:2018/9/13
     */
    @PostMapping(value = "insertEmployee", consumes = "application/json; charset=UTF-8")
    public Result<Boolean> insertEmployee(HandleEmployee handleEmployee);

    /**
     *@author :winlin
     *@Description :启用或禁用员工,查询条件为员工id
     *@param:
     *@return:
     *@date:2018/9/30
     */
    @PostMapping(value = "enableOrDisableAgencyEmployee", consumes = "application/json; charset=UTF-8")
    public Result<Boolean> enableOrDisableAgencyEmployee(HandleTrustList trustList);
    /**
     *
     * @author :winlin
     * @Description :
     * @param:页面修该好的员工信息
     * @return:yes or no
     * @date:2018/9/18
     */
    @PostMapping(value = "updateEmployeeBy", consumes = "application/json; charset=UTF-8")
    public Result<Boolean> updateEmployeeBy(@RequestBody  HandleEmployee employee);
    /**
     *@author :winlin
     *@Description :依据id修改员工权限
     *@param:
     *@return:
     *@date:2018/9/30
     */
    @PostMapping(value = "updateAgencyEmployeeRoleById", consumes = "application/json; charset=UTF-8")
    public Result<Boolean> updateAgencyEmployeeRoleById(@RequestBody HandleTrustList trustList);
    /**
     * @author :winlin
     * @Description :查询员工信息
     * @param: emplyee 查询所需要的条件
     * @return: 员工的信息
     * @date:2018/9/18
     */
    @PostMapping(value = "queryEmployee", consumes = "application/json; charset=UTF-8")
    public Result<List<AgencyEmployeeVo>> queryEmployee(@RequestBody AgencyEmployeeDto employee);
    /**
     * @Author :winlin
     * @Description :新增专家
     * @Date:2018/9/13
     */
    @PostMapping(value = "insertExpert", consumes = "application/json; charset=UTF-8")
    public Result<Boolean> insertExpert(@RequestBody HandleExpert handleExpert);
    /**
     * @author :winlin
     * @Description :代理机构专家完善自己个人信息
     * @param:
     * @return:
     * @date:2018/9/21
     */
    @PostMapping(value = "completeAgencyExpertInfo", consumes = "application/json; charset=UTF-8")
    public Result<Boolean> completeAgencyExpertInfo(@RequestBody AgencyExpertDto expertDto);
    /**
     *@author :winlin
     *@Description :删除专家 修改is_delete的字段属性
     *@param:
     *@return:
     *@date:2018/9/30
     */
    @PostMapping(value = "deleteAgencyExpertById", consumes = "application/json; charset=UTF-8")
    public Result<Boolean> deleteAgencyExpertById(@RequestBody HandleTrustList trustList);
    /**
     *
     * @author :winlin
     * @Description :封装条件查询专家
     * @param:
     * @return:
     * @date:2018/9/20
     */
    @PostMapping(value = "queryExpertCriteria", consumes = "application/json; charset=UTF-8")
    public Result<List<AgencyExpertVo>> queryExpertCriteria(@RequestBody ExpertDto expertDto);

    /**
     *@author :winlin
     *@Description : id查询专家详情
     *@param:
     *@return:
     *@date:2018/10/2
     */
    @PostMapping(value = "queryExpertDeById", consumes = "application/json; charset=UTF-8")
    public Result<AgencyExpertDetailVo> queryExpertDetailById(@RequestBody QueryDto dto);

    /**
     * @Author :winlin
     * @Description :新增供应商
     * @Date:2018/9/13
     */
    @PostMapping(value = "insertSupplier", consumes = "application/json; charset=UTF-8")
    public Result<Boolean> insertSupplier(@RequestBody HandleSupplier handleSupplier);
    /**
     * @author :winlin
     * @Description :代理机构供应商完善自己的注册信息
     * @param:
     * @return:
     * @date:2018/9/21
     */
    @PostMapping(value = "completeAgencySupInfo", consumes = "application/json; charset=UTF-8")
    public Result<Boolean> completeAgencySupInfo(@RequestBody AgencySupplierDto supplierDto);

    /**
     * @author :winlin
     * @Description : 封装条件查供应商
     * @param:
     * @return:
     * @date:2018/9/20
     */
    @PostMapping(value = "querySupplierCriteria", consumes = "application/json; charset=UTF-8")
    public Result<List<AgencySupplierVo>> querySupplierCriteria(@RequestBody SupplierDto supplierDto);
    /**
     *@author :winlin
     *@Description :依据id查询供货商详情
     *@param:
     *@return:
     *@date:2018/10/1
     */
    @PostMapping(value = "queryAgencySupplierDetail", consumes = "application/json; charset=UTF-8")
    public Result<AgencySupplierVo> queryAgencySupplierDetail(@RequestBody QueryDto dto);

    /**
     * @author :winlin
     * @Description : 代理机构注册完善信息信息完善详细信息
     * @param:
     * @return: 数据库添加状态
     * @date:2018/9/18
     */
    @PostMapping(value = "completeInfo", consumes = "application/json; charset=UTF-8")
    public Result<Boolean> completeInfo(@RequestBody HandleAgency agency);


    /**
     * @author :winlin
     * @Description :根据id查询员工信息
     * @param:
     * @return:
     * @date:2018/9/19
     */
    @PostMapping(value = "queryEmployeeById", consumes = "application/json; charset=UTF-8")
    public Result<AgencyEmployeeVo> queryEmployeeById(@RequestBody QueryDto dto);



}
