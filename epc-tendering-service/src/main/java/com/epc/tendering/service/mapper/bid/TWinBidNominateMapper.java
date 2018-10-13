package com.epc.tendering.service.mapper.bid;

import com.epc.tendering.service.domain.bid.TWinBidNominate;
import com.epc.tendering.service.domain.bid.TWinBidNominateCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
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

    @Select("Select b.id from t_win_bid_nominate b where b.purchase_project_id =#{procurementProjectId} and b.process_status='released'")
    Long getId(Long procurementProjectId);
}