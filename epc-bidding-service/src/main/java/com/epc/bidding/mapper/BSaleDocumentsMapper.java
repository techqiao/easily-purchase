package com.epc.bidding.mapper;

import com.epc.bidding.domain.BSaleDocuments;
import com.epc.bidding.domain.BSaleDocumentsCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface BSaleDocumentsMapper {
    int countByExample(BSaleDocumentsCriteria example);

    int deleteByExample(BSaleDocumentsCriteria example);

    int deleteByPrimaryKey(Long id);

    int insert(BSaleDocuments record);

    int insertSelective(BSaleDocuments record);

    List<BSaleDocuments> selectByExampleWithRowbounds(BSaleDocumentsCriteria example, RowBounds rowBounds);

    List<BSaleDocuments> selectByExample(BSaleDocumentsCriteria example);

    BSaleDocuments selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BSaleDocuments record, @Param("example") BSaleDocumentsCriteria example);

    int updateByExample(@Param("record") BSaleDocuments record, @Param("example") BSaleDocumentsCriteria example);

    int updateByPrimaryKeySelective(BSaleDocuments record);

    int updateByPrimaryKey(BSaleDocuments record);
}