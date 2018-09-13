package com.epc.user.service.mapper.purchaser;

import com.epc.user.service.domain.purchaser.TPurchaserDetailInfo;
import com.epc.user.service.domain.purchaser.TPurchaserDetailInfoCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface TPurchaserDetailInfoMapper {

    int countByExample(TPurchaserDetailInfoCriteria example);

    int deleteByExample(TPurchaserDetailInfoCriteria example);

    int deleteByPrimaryKey(Long id);

    int insert(TPurchaserDetailInfo record);

     int insertSelective(TPurchaserDetailInfo record);

    List<TPurchaserDetailInfo> selectByExampleWithRowbounds(TPurchaserDetailInfoCriteria example, RowBounds rowBounds);

    List<TPurchaserDetailInfo> selectByExample(TPurchaserDetailInfoCriteria example);

    TPurchaserDetailInfo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TPurchaserDetailInfo record, @Param("example") TPurchaserDetailInfoCriteria example);

    int updateByExample(@Param("record") TPurchaserDetailInfo record, @Param("example") TPurchaserDetailInfoCriteria example);

    int updateByPrimaryKeySelective(TPurchaserDetailInfo record);

    int updateByPrimaryKey(TPurchaserDetailInfo record);
}