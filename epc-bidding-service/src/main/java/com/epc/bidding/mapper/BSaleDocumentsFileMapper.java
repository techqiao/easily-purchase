package com.epc.bidding.mapper;

import com.epc.bidding.domain.BSaleDocumentsFile;
import com.epc.bidding.domain.BSaleDocumentsFileCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface BSaleDocumentsFileMapper {
    int countByExample(BSaleDocumentsFileCriteria example);

    int deleteByExample(BSaleDocumentsFileCriteria example);

    int deleteByPrimaryKey(Long id);

    int insert(BSaleDocumentsFile record);

    int insertSelective(BSaleDocumentsFile record);

    List<BSaleDocumentsFile> selectByExampleWithRowbounds(BSaleDocumentsFileCriteria example, RowBounds rowBounds);

    List<BSaleDocumentsFile> selectByExample(BSaleDocumentsFileCriteria example);

    BSaleDocumentsFile selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BSaleDocumentsFile record, @Param("example") BSaleDocumentsFileCriteria example);

    int updateByExample(@Param("record") BSaleDocumentsFile record, @Param("example") BSaleDocumentsFileCriteria example);

    int updateByPrimaryKeySelective(BSaleDocumentsFile record);

    int updateByPrimaryKey(BSaleDocumentsFile record);
}