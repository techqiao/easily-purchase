package com.epc.tendering.service.mapper.winBid;

import com.epc.tendering.service.domain.winBid.TWinBid;
import com.epc.tendering.service.domain.winBid.TWinBidCriteria;
import java.util.List;

import com.epc.web.facade.terdering.answer.vo.WinBidVO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.session.RowBounds;

public interface TWinBidMapper {
    int countByExample(TWinBidCriteria example);

    int deleteByExample(TWinBidCriteria example);

    int deleteByPrimaryKey(Long id);

    int insert(TWinBid record);

    int insertSelective(TWinBid record);

    List<TWinBid> selectByExampleWithRowbounds(TWinBidCriteria example, RowBounds rowBounds);

    List<TWinBid> selectByExample(TWinBidCriteria example);

    TWinBid selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TWinBid record, @Param("example") TWinBidCriteria example);

    int updateByExample(@Param("record") TWinBid record, @Param("example") TWinBidCriteria example);

    int updateByPrimaryKeySelective(TWinBid record);

    int updateByPrimaryKey(TWinBid record);

    List<WinBidVO> selectPublicWinning();


    @Select("Select COUNT(b.id) from t_win_bid b where b.procurement_project_id =#{procurementProjectId} and b.process_status='released'")
    Integer getId(Long procurementProjectId);
}