package com.epc.web.service.mapper.expert;

import com.epc.web.facade.expert.dto.ProjectDto;
import com.epc.web.service.domain.expert.TPurchaseProjectBasicInfo;
import com.epc.web.service.domain.expert.TPurchaseProjectBasicInfoCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
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

    List<TPurchaseProjectBasicInfo> selectBasicInfosByProjectIds(List<Long> purchaserProjectIds);

    List<TPurchaseProjectBasicInfo> selectBasicInfosByProjectIdsAndCriteria(ProjectDto projecctDto);

}