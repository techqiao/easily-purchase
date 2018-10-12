package com.epc.web.service.mapper.purchaser;

import com.epc.web.facade.loginuser.dto.LoginUser;
import com.epc.web.facade.loginuser.dto.ModifyUser;
import com.epc.web.facade.purchaser.dto.HandleEmployeeDto;
import com.epc.web.facade.purchaser.dto.HandleExpertDto;
import com.epc.web.facade.purchaser.vo.PurchaserEmplyeeVo;
import com.epc.web.facade.purchaser.vo.PurchaserExpertVo;
import com.epc.web.facade.purchaser.vo.PurchaserSupplierVo;
import com.epc.web.service.domain.purchaser.TPurchaserBasicInfo;
import com.epc.web.service.domain.purchaser.TPurchaserBasicInfoCriteria;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.Date;
import java.util.List;
@Mapper
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

    TPurchaserBasicInfo login(@Param("cellphone") String cellphone, @Param("pwd") String pwd);

    List<PurchaserEmplyeeVo> queryEmplyees(Long supplierId);

    List<PurchaserEmplyeeVo> findEmployeeByName(@Param("fuzzyName") String fuzzyName, @Param("purchaseId") Long purchaseId);

    int updateEmployeeStateByCellphone(@Param("cellphone") String cellphone, @Param("state") Integer state);

    int updateEmployeeStateById(@Param("id") Long id, @Param("state") Integer state);

    PurchaserEmplyeeVo queryEmplyeeByCellphone(String cellphone);

    PurchaserEmplyeeVo queryEmplyeeById(Long id);

    List<PurchaserEmplyeeVo> queryEmplyeeByCriteria(HandleEmployeeDto employeeDto);

    int updateEmployeeRoleById(@Param("id") Long id, @Param("role") Integer role);

    List<PurchaserSupplierVo> queryAllSuppliers(Long purchaseId);

    List<PurchaserSupplierVo> querySuppliersByName(@Param("fuzzyName") String fuzzyName, @Param("purchaseId") Long purchaseId);

    PurchaserSupplierVo querySuppliersById(Long id);

    List<PurchaserExpertVo> queryExpertsByCriteria(HandleExpertDto dto);

    int updateExpertStateById(@Param("id") Long id, @Param("state") Integer state);

    int updatePurchaserEmployeeRole(@Param("id")Long id, @Param("role")Integer role);

    //int updatePurchaserEmployeeDetail(TPurchaserBasicInfo info);


    int enableOrDisablePurchaserEmployee(@Param("id")Long id, @Param("forbidden")Integer forbidden);

    int registerUser(@Param("cellphone") String cellphone, @Param("pwd") String pwd, @Param("name") String name, @Param("dates")Date date);

    List<TPurchaserBasicInfo> selectBasicInfoCriteria(HandleEmployeeDto employeeDto);

    TPurchaserBasicInfo selectBossBasicInfoByPurchaserIdAndRole(@Param("purchaseId") Long purchaseId, @Param("role") Integer role);

    TPurchaserBasicInfo selectBasicInfoByNameAndPhone(@Param("name") String name, @Param("phone") String phone);

    int updatePurchaserEmployeeDetail(TPurchaserBasicInfo info);

    int updatePurchaserPassword(ModifyUser modifyUser);

    TPurchaserBasicInfo selectPurchaserBasicInfoByCell(@Param("cell") String cell);

    int updateDeleteStateById(Long id);

}