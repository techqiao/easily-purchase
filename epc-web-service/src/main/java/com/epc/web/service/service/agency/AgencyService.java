package com.epc.web.service.service.agency;

import com.epc.common.Result;
import com.epc.web.facade.agency.handle.HandleAgency;
import com.epc.web.facade.agency.handle.HandleEmployee;
import com.epc.web.facade.agency.handle.HandleExpert;
import com.epc.web.facade.agency.handle.HandleSupplier;
import org.springframework.stereotype.Service;

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
    public Result insertEmployee(HandleEmployee handleEmployee);

    /**
     * @Author :winlin
     * @Description :新增专家
     * @Date:2018/9/13
     */
    public Result insertExpert(HandleExpert handleExpert);

    /**
     * @Author :winlin
     * @Description :新增供应商
     * @Date:2018/9/13
     */
    public Result insertSupplier(HandleSupplier handleSupplier);

    /**
     * @param agency 页面传入的信息
     * @return 注册是否成功
     * @author :winlin
     * @Description :代理机构注册
     * @date:2018/9/18
     */
    public Result regesityAgency(HandleAgency agency);

    /**
     * @author :winlin
     * @Description :代理机构查询
     * @param: agency 查询条件
     * @date:2018/9/18
     * @return 返回按条件查询的所有信息
     */
    public Result queryAgencies(HandleAgency agency);


    /**
     *@author :winlin
     *@Description : 代理机构忘记密码状态
     *@param: agency 验证通过的用户信息
     *@return: 数据库信息修改状态
     *@date:2018/9/18
     */
    public Result modifypassword(HandleAgency agency);
    /**
     *@author :winlin
     *@Description : 信息完善详细信息
     *@param:
     *@return: 数据库添加状态
     *@date:2018/9/18
     */
    public Result completeInfo(HandleAgency agency);

    /**
     *@author :winlin
     *@Description :代理机构代理的所有项目
     *@param: 需要项目名称,项目编号,采购人id
     *@return: 序号,项目名称,项目编号,项目区域,招标信息条数,采购人,创建时间,项目状态
     *@date:2018/9/18
     */
    public Result proxySubjects();

    /**
     *@author :winlin
     *@Description :查询员工信息
     *@param: emplyee 查询所需要的条件
     *@return: 员工的信息
     *@date:2018/9/18
     */
    public Result queryEmployee(HandleEmployee employee);

    /**
     *@author :winlin
     *@Description : 根据cellphone查询员工信息
     *@param:
     *@return:
     *@date:2018/9/18
     */
    public Result queryEmployeeByCellphone(String cellphone);
    /**
     *@author :winlin
     *@Description :根据id查询员工信息
     *@param:
     *@return:
     *@date:2018/9/19
     */
    public Result queryEmployeeById(Long id);
    /**
    /**
     *@author :winlin
     *@Description :
     *@param:页面修该好的员工信息
     *@return:yes or no
     *@date:2018/9/18
     */
    public Result updateEmployeeBy(HandleEmployee employee);

}
