package com.epc.platform.service.mapper.purchaser;

import com.epc.platform.service.domain.purchaser.TPurchaserBasicInfo;
import com.epc.platform.service.domain.purchaser.TPurchaserBasicInfoCriteria;
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
}