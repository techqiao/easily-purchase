package com.epc.tendering.service.mapper.purchase;

import com.epc.tendering.service.domain.purchase.TPurchaseProjectBasicInfo;
import com.epc.tendering.service.domain.purchase.TPurchaseProjectBasicInfoCriteria;
import java.util.List;

import com.epc.web.facade.terdering.answer.vo.PublicityVO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
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

    @Select("select t.purchase_project_status from t_purchase_project_basic_info t where id=#{id}")
    @ResultType(String.class)
    String getPurchaseProjectStatusById(Long id);

    @Select("select t.project_name projectName,t.project_id projectId," +
            "t.purchase_project_name purchaseProjectName," +
            "t.purchase_project_code purchaseProjectCode," +
            "t.id as purchaseProjectId," +
            "from t_purchase_project_basic_info where id=#{id}")
    @ResultType(PublicityVO.class)
    PublicityVO getDetailInfoById(Long id);

    @Select("select t.is_other_agency from t_purchase_project_basic_info t left join b_release_announcement b" +
            " on b.procurement_project_id=t.id where b.id =#{id}")
    int getIsOtherAgency(Long id);

}