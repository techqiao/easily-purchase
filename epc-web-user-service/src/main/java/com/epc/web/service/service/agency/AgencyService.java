package com.epc.web.service.service.agency;

import com.epc.common.Result;
import com.epc.web.facade.agency.dto.AgencyEmployeeDto;
import com.epc.web.facade.agency.dto.AgencyExpertDto;
import com.epc.web.facade.agency.dto.AgencySupplierDto;
import com.epc.web.facade.agency.handle.HandleAgency;
import com.epc.web.facade.agency.handle.HandleEmployee;
import com.epc.web.facade.agency.handle.HandleExpert;
import com.epc.web.facade.agency.handle.HandleSupplier;
import com.epc.web.facade.agency.vo.AgencyEmployeeVo;
import com.epc.web.facade.agency.vo.AgencyExpertVo;
import com.epc.web.facade.agency.vo.AgencySupplierVo;
import com.epc.web.facade.loginuser.dto.RegisterDto;
import com.epc.web.facade.purchaser.handle.HandleTrustList;

import java.util.List;

/**
 * @Author :winlin
 * @Description : 代理机构接口
 * @Date:2018/9/13
 */
public interface AgencyService {

    /**
     * @Author :winlin
     * @Description :新增员工
     * @Date:2018/9/13
     */
    public Result<Integer> insertEmployee(HandleEmployee handleEmployee);
    
    /**
     *@author :winlin
     *@Description :启用或禁用员工,查询条件为员工id
     *@param:
     *@return:
     *@date:2018/9/30
     */
    public Result<Boolean> enableOrDisableAgencyEmployee(HandleTrustList trustList);
    /**
     *
     * @author :winlin
     * @Description :
     * @param:页面修该好的员工信息
     * @return:yes or no
     * @date:2018/9/18
     */
    public Result<Boolean> updateEmployeeBy(HandleEmployee employee);
    /**
     *@author :winlin
     *@Description :依据id修改员工权限
     *@param:
     *@return:
     *@date:2018/9/30
     */
    public Result<Boolean> updateAgencyEmployeeRoleById(HandleTrustList trustList);
    /**
     * @author :winlin
     * @Description :查询员工信息
     * @param: emplyee 查询所需要的条件
     * @return: 员工的信息
     * @date:2018/9/18
     */
    public Result<List<AgencyEmployeeVo>> queryEmployee(AgencyEmployeeDto employee);
    /**
     * @Author :winlin
     * @Description :新增专家
     * @Date:2018/9/13
     */
    public Result<Integer> insertExpert(HandleExpert handleExpert);
    /**
     * @author :winlin
     * @Description :代理机构专家完善自己个人信息
     * @param:
     * @return:
     * @date:2018/9/21
     */
    public Result<Boolean> completeAgencyExpertInfo(AgencyExpertDto expertDto);
    /**
     *@author :winlin
     *@Description :删除专家 修改is_delete的字段属性
     *@param:
     *@return:
     *@date:2018/9/30
     */
    public Result<Boolean> deleteAgencyExpertById(HandleTrustList trustList);
    /**
     *
     * @author :winlin
     * @Description :封装条件查询专家
     * @param:
     * @return:
     * @date:2018/9/20
     */

    public Result<List<AgencyExpertVo>> queryExpertCriteria(AgencyExpertDto expertDto);

    /**
     * @Author :winlin
     * @Description :新增供应商
     * @Date:2018/9/13
     */
    public Result<Integer> insertSupplier(HandleSupplier handleSupplier);
    /**
     * @author :winlin
     * @Description :代理机构供应商完善自己的注册信息
     * @param:
     * @return:
     * @date:2018/9/21
     */
    public Result<Boolean> completeAgencySupInfo(AgencySupplierDto supplierDto);

    /**
     * @author :winlin
     * @Description : 封装条件查供应商
     * @param:
     * @return:
     * @date:2018/9/20
     */
    public Result<List<AgencySupplierVo>> querySupplierCriteria(AgencySupplierDto supplierDto);
    /**
     *@author :winlin
     *@Description :依据id查询供货商详情
     *@param:
     *@return:
     *@date:2018/10/1
     */
    public Result<AgencySupplierVo> queryAgencySupplierDetail(Long supplierId);

    /**
     * @param agency 页面传入的信息
     * @return 注册是否成功, 成功返回注册信息
     * @author :winlin
     * @Description :代理机构注册
     * @date:2018/9/18
     */
    public Result<HandleAgency> regesityAgency(HandleAgency agency);
    /**
     * @author :winlin
     * @Description : 代理机构注册完善信息信息完善详细信息
     * @param:
     * @return: 数据库添加状态
     * @date:2018/9/18
     */
    public Result<Boolean> completeInfo(HandleAgency agency);

    /**
     * @return 返回按条件查询的所有信息
     * @author :winlin
     * @Description :代理机构查询
     * @param: agency 查询条件
     * @date:2018/9/18
     */
    public Result<List<HandleAgency>> queryAgencies(HandleAgency agency);


    /**
     * @author :winlin
     * @Description : 代理机构忘记密码状态
     * @param: agency 验证通过的用户信息
     * @return: 数据库信息修改状态
     * @date:2018/9/18
     */
    public Result<Boolean> modifypassword(HandleAgency agency);



    /**
     * @author :winlin
     * @Description :查询机构下所有员工的信息
     * @param:
     * @return:
     * @date:2018/9/20
     */
    public Result<List<AgencyEmployeeVo>> queryAllEmployee(Long agencyId);
    /**
     * @author :winlin
     * @Description : 根据cellphone查询员工信息
     * @param:
     * @return:
     * @date:2018/9/18
     */
    public Result<AgencyEmployeeVo> queryEmployeeByCellphone(String cellphone);

    /**
     * @author :winlin
     * @Description :根据id查询员工信息
     * @param:
     * @return:
     * @date:2018/9/19
     */
    public Result<AgencyEmployeeVo> queryEmployeeById(Long id);












}
