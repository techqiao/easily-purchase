package com.epc.web.service.mapper.purchaser;

import com.epc.web.facade.loginuser.dto.LoginUser;
import com.epc.web.facade.purchaser.dto.HandleExpertDto;
import com.epc.web.facade.purchaser.vo.PurchaserEmplyeeVo;
import com.epc.web.facade.purchaser.vo.PurchaserExpertVo;
import com.epc.web.facade.purchaser.vo.PurchaserSupplierVo;
import com.epc.web.service.domain.purchaser.TPurchaserBasicInfo;
import com.epc.web.service.domain.purchaser.TPurchaserBasicInfoCriteria;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface TPurchaserBasicInfoMapper {

    int countByExample(TPurchaserBasicInfoCriteria example);

    int deleteByExample(TPurchaserBasicInfoCriteria example);

    int deleteByPrimaryKey(Long id);

    int insert(TPurchaserBasicInfo record);

    int insertSelective(TPurchaserBasicInfo record);

    List<TPurchaserBasicInfo> selectByExampleWithRowbounds(TPurchaserBasicInfoCriteria example, RowBounds rowBounds);

    List<TPurchaserBasicInfo> selectByExample(TPurchaserBasicInfoCriteria example);

    TPurchaserBasicInfo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TPurchaserBasicInfo record, @Param("example") TPurchaserBasicInfoCriteria example);

    int updateByExample(@Param("record") TPurchaserBasicInfo record, @Param("example") TPurchaserBasicInfoCriteria example);

    int updateByPrimaryKeySelective(TPurchaserBasicInfo record);

    int updateByPrimaryKey(TPurchaserBasicInfo record);

    LoginUser login(@Param("cellphone") String cellphone, @Param("pwd") String pwd);

    List<PurchaserEmplyeeVo>queryEmplyees(Long supplierId);

    List<PurchaserEmplyeeVo> findEmployeeByName(String fuzzyName);

    int updateEmployeeStateByCellphone(@Param("cellphone") String cellphone,@Param("state") Integer state);

    int updateEmployeeStateById(@Param("id")Long id, @Param("state")Integer state);

    PurchaserEmplyeeVo queryEmplyeeByCellphone(String cellphone);

    PurchaserEmplyeeVo queryEmplyeeById(Long id);

    List<PurchaserEmplyeeVo> queryEmplyeeByCriteria(TPurchaserBasicInfo basicInfo);

    int updateEmployeeRoleById(@Param("id")Long id, @Param("role")Integer role);

    List<PurchaserSupplierVo> queryAllSuppliers(Long purchaseId);

    List<PurchaserSupplierVo> querySuppliersByName(String fuzzyName);

    PurchaserSupplierVo querySuppliersById(Long id);

    List<PurchaserExpertVo> queryExpertsByCriteria(HandleExpertDto dto);

    int updateExpertStateById(@Param("id")Long id, @Param("state")Integer state);
}