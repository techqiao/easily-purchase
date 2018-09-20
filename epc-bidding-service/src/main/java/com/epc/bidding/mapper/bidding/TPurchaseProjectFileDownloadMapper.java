package com.epc.bidding.mapper.bidding;

import com.epc.bidding.domain.bidding.TPurchaseProjectFileDownload;
import com.epc.bidding.domain.bidding.TPurchaseProjectFileDownloadCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface TPurchaseProjectFileDownloadMapper {
    int countByExample(TPurchaseProjectFileDownloadCriteria example);

    int deleteByExample(TPurchaseProjectFileDownloadCriteria example);

    int deleteByPrimaryKey(Long id);

    int insert(TPurchaseProjectFileDownload record);

    int insertSelective(TPurchaseProjectFileDownload record);

    List<TPurchaseProjectFileDownload> selectByExampleWithRowbounds(TPurchaseProjectFileDownloadCriteria example, RowBounds rowBounds);

    List<TPurchaseProjectFileDownload> selectByExample(TPurchaseProjectFileDownloadCriteria example);

    TPurchaseProjectFileDownload selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TPurchaseProjectFileDownload record, @Param("example") TPurchaseProjectFileDownloadCriteria example);

    int updateByExample(@Param("record") TPurchaseProjectFileDownload record, @Param("example") TPurchaseProjectFileDownloadCriteria example);

    int updateByPrimaryKeySelective(TPurchaseProjectFileDownload record);

    int updateByPrimaryKey(TPurchaseProjectFileDownload record);
}