package com.epc.web.facade.agency;

import com.epc.common.Result;
import com.epc.web.facade.agency.dto.AgencySubjectDto;
import com.epc.web.facade.agency.handle.HandleAgency;
import com.epc.web.facade.agency.handle.HandleEmployee;
import com.epc.web.facade.agency.handle.HandleExpert;
import com.epc.web.facade.agency.handle.HandleSupplier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;

/**
 * @Author :winlin
 * @Description :代理商服务
 * @Date:2018/9/15
 */
public interface FacadeAgencyService {
    /**
     * 代理商新增员工
     *
     * @param employee
     * @return
     */
    @PostMapping(value = "insertEmployee", consumes = "application/json; charset=UTF-8")
    Result insertEmployee(@RequestBody HandleEmployee employee);

    /**
     * 代理商新增专家
     *
     * @param handleExpert
     * @return
     */
    @PostMapping(value = "insertExpert", consumes = "application/json; charset=UTF-8")
    public Result insertExpert( @RequestBody HandleExpert handleExpert);

    /**
     * 代理商新增供货商
     *
     * @param handleSupplier
     * @return
     */
    @PostMapping(value = "insertSupplier", consumes = "application/json; charset=UTF-8")
    public Result insertSupplier( @RequestBody HandleSupplier handleSupplier);

    /**
     * @param agency 页面传入的信息
     * @return 注册是否成功
     * @author :winlin
     * @Description :代理机构注册
     * @date:2018/9/18
     */
    @PostMapping(value = "regesityAgency", consumes = "application/json; charset=UTF-8")
    public Result regesityAgency(@RequestBody HandleAgency agency);

    /**
     * @author :winlin
     * @Description :代理机构查询
     * @param: agency 查询条件
     * @date:2018/9/18
     * @return 返回按条件查询的所有信息
     */
    @PostMapping(value = "queryAgencies", consumes = "application/json; charset=UTF-8")
    public Result queryAgencies(@RequestBody HandleAgency agency);


    /**
     *@author :winlin
     *@Description : 代理机构忘记密码状态
     *@param: agency 验证通过的用户信息
     *@return: 数据库信息修改状态
     *@date:2018/9/18
     */
    @PostMapping(value = "modifypassword", consumes = "application/json; charset=UTF-8")
    public Result modifypassword( @RequestBody HandleAgency agency);
    /**
     *@author :winlin
     *@Description : 信息完善详细信息
     *@param:
     *@return: 数据库添加状态
     *@date:2018/9/18
     */
    @PostMapping(value = "completeInfo", consumes = "application/json; charset=UTF-8")
    public Result completeInfo( @RequestBody HandleAgency agency);

    /**
     *@author :winlin
     *@Description :代理机构代理的所有项目
     *@param: 需要项目名称,项目编号,采购人id
     *@return: 序号,项目名称,项目编号,项目区域,招标信息条数,采购人,创建时间,项目状态
     *@date:2018/9/18
     */
    @PostMapping(value = "proxySubjects", consumes = "application/json; charset=UTF-8")
    public Result proxySubjects(AgencySubjectDto subjectDto);

    /**
     *@author :winlin
     *@Description :查询员工信息
     *@param: emplyee 查询所需要的条件
     *@return: 员工的信息
     *@date:2018/9/18
     */
    @PostMapping(value = "queryAgencyEmployee", consumes = "application/json; charset=UTF-8")
    public Result queryEmployee( @RequestBody HandleEmployee employee);

    /**
     *@author :winlin
     *@Description : 根据cellphone查询员工信息
     *@param:
     *@return:
     *@date:2018/9/18
     */

    @PostMapping(value = "queryEmployeeByCellphone")
    public Result queryEmployeeByCellphone(@RequestBody HashMap<String,String> map);

    /**
     *@author :winlin
     *@Description :根据id查询员工信息
     *@param:
     *@return:
     *@date:2018/9/19
     */
    @PostMapping(value = "queryEmployeeById", consumes = "application/json; charset=UTF-8")
    public Result queryEmployeeById(@RequestBody HashMap<String,Long> map);

     /**
     *@author :winlin
     *@Description :
     *@param:页面修该好的员工信息
     *@return:yes or no
     *@date:2018/9/18
     */
    @PostMapping(value = "updateEmployeeBy", consumes = "application/json; charset=UTF-8")
    public Result updateEmployeeBy( @RequestBody HandleEmployee employee);
}
