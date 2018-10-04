package com.epc.web.service.mapper.operator;

import com.epc.web.facade.loginuser.dto.LoginUser;
import com.epc.web.facade.loginuser.dto.ModifyUser;
import com.epc.web.service.domain.operator.TOperatorBasicInfo;
import com.epc.web.service.domain.operator.TOperatorBasicInfoCriteria;

import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface TOperatorBasicInfoMapper {
    int countByExample(TOperatorBasicInfoCriteria example);

    int deleteByExample(TOperatorBasicInfoCriteria example);

    int deleteByPrimaryKey(Long id);

    int insert(TOperatorBasicInfo record);

    int insertSelective(TOperatorBasicInfo record);

    List<TOperatorBasicInfo> selectByExampleWithRowbounds(TOperatorBasicInfoCriteria example, RowBounds rowBounds);

    List<TOperatorBasicInfo> selectByExample(TOperatorBasicInfoCriteria example);

    TOperatorBasicInfo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TOperatorBasicInfo record, @Param("example") TOperatorBasicInfoCriteria example);

    int updateByExample(@Param("record") TOperatorBasicInfo record, @Param("example") TOperatorBasicInfoCriteria example);

    int updateByPrimaryKeySelective(TOperatorBasicInfo record);

    int updateByPrimaryKey(TOperatorBasicInfo record);

    TOperatorBasicInfo login(@Param("cellphone") String cellphone, @Param("pwd") String pwd);

    int registerUser(@Param("cellphone") String cellphone, @Param("pwd") String pwd, @Param("name") String name, @Param("dates") Date date);

    TOperatorBasicInfo selectByNameAndCellphone(@Param("name") String name, @Param("cellphone") String cellphone);

    int updateOperatorPassword(ModifyUser modifyUser);

    TOperatorBasicInfo selectByCellphone(@Param("cell") String cell);

    TOperatorBasicInfo selectOperatorDetailByOperatorId(@Param("operatorId") Long operatorId, @Param("roleCorporation") int roleCorporation);

    boolean selectCountOperatorBasicByNameAndCellphone(@Param("name") String name, @Param("cellphone") String cellphone);
}