package com.epc.bidding.mapper;

import com.epc.bidding.domain.TPurchaserDetailInfo;
import com.epc.bidding.domain.TPurchaserDetailInfoCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
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

    @Select(value = "SELECT company_name from t_purchaser_detail_info where purchaser_id= #{purchaserId}")
    String selectName(Long purchaserId);
}