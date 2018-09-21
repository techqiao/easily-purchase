package com.epc.bidding.mapper.bidding;

import com.epc.bidding.domain.bidding.TPretrialFile;
import com.epc.bidding.domain.bidding.TPretrialFileCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface TPretrialFileMapper {
    int countByExample(TPretrialFileCriteria example);

    int deleteByExample(TPretrialFileCriteria example);

    int deleteByPrimaryKey(Long id);

    int insert(TPretrialFile record);

    int insertSelective(TPretrialFile record);

    List<TPretrialFile> selectByExampleWithRowbounds(TPretrialFileCriteria example, RowBounds rowBounds);

    List<TPretrialFile> selectByExample(TPretrialFileCriteria example);

    TPretrialFile selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TPretrialFile record, @Param("example") TPretrialFileCriteria example);

    int updateByExample(@Param("record") TPretrialFile record, @Param("example") TPretrialFileCriteria example);

    int updateByPrimaryKeySelective(TPretrialFile record);

    int updateByPrimaryKey(TPretrialFile record);
}