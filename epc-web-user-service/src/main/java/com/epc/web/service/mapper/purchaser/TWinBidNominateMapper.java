package com.epc.web.service.mapper.purchaser;

import com.epc.web.service.domain.purchaser.TWinBidNominate;
import com.epc.web.service.domain.purchaser.TWinBidNominateCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface TWinBidNominateMapper {
    int countByExample(TWinBidNominateCriteria example);

    int deleteByExample(TWinBidNominateCriteria example);

    int deleteByPrimaryKey(Long id);

    int insert(TWinBidNominate record);

    int insertSelective(TWinBidNominate record);

    List<TWinBidNominate> selectByExampleWithRowbounds(TWinBidNominateCriteria example, RowBounds rowBounds);

    List<TWinBidNominate> selectByExample(TWinBidNominateCriteria example);

    TWinBidNominate selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TWinBidNominate record, @Param("example") TWinBidNominateCriteria example);

    int updateByExample(@Param("record") TWinBidNominate record, @Param("example") TWinBidNominateCriteria example);

    int updateByPrimaryKeySelective(TWinBidNominate record);

    int updateByPrimaryKey(TWinBidNominate record);

    List<TWinBidNominate> selectByIds(List<Long> list);

}