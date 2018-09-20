package com.epc.tendering.service.mapper.purchase;

import com.epc.tendering.service.domain.purchase.TPurchaseProjectBasicInfo;
import com.epc.tendering.service.domain.purchase.TPurchaseProjectBasicInfoCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.session.RowBounds;

public interface TPurchaseProjectBasicInfoMapper {
    int countByExample(TPurchaseProjectBasicInfoCriteria example);

    int deleteByExample(TPurchaseProjectBasicInfoCriteria example);

    int deleteByPrimaryKey(Long id);

    int insert(TPurchaseProjectBasicInfo record);

    int insertSelective(TPurchaseProjectBasicInfo record);

    List<TPurchaseProjectBasicInfo> selectByExampleWithRowbounds(TPurchaseProjectBasicInfoCriteria example, RowBounds rowBounds);

    List<TPurchaseProjectBasicInfo> selectByExample(TPurchaseProjectBasicInfoCriteria example);

    TPurchaseProjectBasicInfo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TPurchaseProjectBasicInfo record, @Param("example") TPurchaseProjectBasicInfoCriteria example);

    int updateByExample(@Param("record") TPurchaseProjectBasicInfo record, @Param("example") TPurchaseProjectBasicInfoCriteria example);

    int updateByPrimaryKeySelective(TPurchaseProjectBasicInfo record);

    int updateByPrimaryKey(TPurchaseProjectBasicInfo record);

    @Select("select t.purchase_project_status from t_purchase_project_basic_info where id=#{id}")
    @ResultType(String.class)
    String getPurchaseProjectStatusById(Long id);
}