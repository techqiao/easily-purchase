package com.epc.bidding.mapper.bidding;

import com.epc.bidding.domain.bidding.TPurchaseProjectAgentCompanyInfo;
import com.epc.bidding.domain.bidding.TPurchaseProjectAgentCompanyInfoCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface TPurchaseProjectAgentCompanyInfoMapper {
    int countByExample(TPurchaseProjectAgentCompanyInfoCriteria example);

    int deleteByExample(TPurchaseProjectAgentCompanyInfoCriteria example);

    int deleteByPrimaryKey(Long id);

    int insert(TPurchaseProjectAgentCompanyInfo record);

    int insertSelective(TPurchaseProjectAgentCompanyInfo record);

    List<TPurchaseProjectAgentCompanyInfo> selectByExampleWithRowbounds(TPurchaseProjectAgentCompanyInfoCriteria example, RowBounds rowBounds);

    List<TPurchaseProjectAgentCompanyInfo> selectByExample(TPurchaseProjectAgentCompanyInfoCriteria example);

    TPurchaseProjectAgentCompanyInfo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TPurchaseProjectAgentCompanyInfo record, @Param("example") TPurchaseProjectAgentCompanyInfoCriteria example);

    int updateByExample(@Param("record") TPurchaseProjectAgentCompanyInfo record, @Param("example") TPurchaseProjectAgentCompanyInfoCriteria example);

    int updateByPrimaryKeySelective(TPurchaseProjectAgentCompanyInfo record);

    int updateByPrimaryKey(TPurchaseProjectAgentCompanyInfo record);
}