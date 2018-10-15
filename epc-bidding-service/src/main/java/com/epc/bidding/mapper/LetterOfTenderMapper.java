package com.epc.bidding.mapper;

import com.epc.bidding.domain.LetterOfTender;
import com.epc.bidding.domain.LetterOfTenderCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface LetterOfTenderMapper {
    int countByExample(LetterOfTenderCriteria example);

    int deleteByExample(LetterOfTenderCriteria example);

    int deleteByPrimaryKey(Long id);

    int insert(LetterOfTender record);

    int insertSelective(LetterOfTender record);

    List<LetterOfTender> selectByExampleWithRowbounds(LetterOfTenderCriteria example, RowBounds rowBounds);

    List<LetterOfTender> selectByExample(LetterOfTenderCriteria example);

    LetterOfTender selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") LetterOfTender record, @Param("example") LetterOfTenderCriteria example);

    int updateByExample(@Param("record") LetterOfTender record, @Param("example") LetterOfTenderCriteria example);

    int updateByPrimaryKeySelective(LetterOfTender record);

    int updateByPrimaryKey(LetterOfTender record);
}