package com.epc.bidding.mapper.bidding;

import com.epc.bidding.domain.bidding.BIssueDocuments;
import com.epc.bidding.domain.bidding.BIssueDocumentsCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface BIssueDocumentsMapper {
    int countByExample(BIssueDocumentsCriteria example);

    int deleteByExample(BIssueDocumentsCriteria example);

    int deleteByPrimaryKey(Long id);

    int insert(BIssueDocuments record);

    int insertSelective(BIssueDocuments record);

    List<BIssueDocuments> selectByExampleWithBLOBsWithRowbounds(BIssueDocumentsCriteria example, RowBounds rowBounds);

    List<BIssueDocuments> selectByExampleWithBLOBs(BIssueDocumentsCriteria example);

    List<BIssueDocuments> selectByExampleWithRowbounds(BIssueDocumentsCriteria example, RowBounds rowBounds);

    List<BIssueDocuments> selectByExample(BIssueDocumentsCriteria example);

    BIssueDocuments selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BIssueDocuments record, @Param("example") BIssueDocumentsCriteria example);

    int updateByExampleWithBLOBs(@Param("record") BIssueDocuments record, @Param("example") BIssueDocumentsCriteria example);

    int updateByExample(@Param("record") BIssueDocuments record, @Param("example") BIssueDocumentsCriteria example);

    int updateByPrimaryKeySelective(BIssueDocuments record);

    int updateByPrimaryKeyWithBLOBs(BIssueDocuments record);

    int updateByPrimaryKey(BIssueDocuments record);
}