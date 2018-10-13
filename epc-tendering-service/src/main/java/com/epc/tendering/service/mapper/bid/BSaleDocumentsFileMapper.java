package com.epc.tendering.service.mapper.bid;

import com.epc.tendering.service.domain.bid.BSaleDocumentsFile;
import com.epc.tendering.service.domain.bid.BSaleDocumentsFileCriteria;
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