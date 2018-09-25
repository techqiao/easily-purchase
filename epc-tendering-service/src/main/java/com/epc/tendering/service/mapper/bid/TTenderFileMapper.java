package com.epc.tendering.service.mapper.bid;

import com.epc.tendering.service.domain.bid.TTenderFile;
import com.epc.tendering.service.domain.bid.TTenderFileCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface TTenderFileMapper {
    int countByExample(TTenderFileCriteria example);

    int deleteByExample(TTenderFileCriteria example);

    int deleteByPrimaryKey(Long id);

    int insert(TTenderFile record);

    int insertSelective(TTenderFile record);

    List<TTenderFile> selectByExampleWithRowbounds(TTenderFileCriteria example, RowBounds rowBounds);

    List<TTenderFile> selectByExample(TTenderFileCriteria example);

    TTenderFile selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TTenderFile record, @Param("example") TTenderFileCriteria example);

    int updateByExample(@Param("record") TTenderFile record, @Param("example") TTenderFileCriteria example);

    int updateByPrimaryKeySelective(TTenderFile record);

    int updateByPrimaryKey(TTenderFile record);
}