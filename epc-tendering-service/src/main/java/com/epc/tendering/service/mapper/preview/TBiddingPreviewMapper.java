package com.epc.tendering.service.mapper.preview;

import com.epc.tendering.service.domain.preview.TBiddingPreview;
import com.epc.tendering.service.domain.preview.TBiddingPreviewCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface TBiddingPreviewMapper {
    int countByExample(TBiddingPreviewCriteria example);

    int deleteByExample(TBiddingPreviewCriteria example);

    int deleteByPrimaryKey(Long id);

    int insert(TBiddingPreview record);

    int insertSelective(TBiddingPreview record);

    List<TBiddingPreview> selectByExampleWithRowbounds(TBiddingPreviewCriteria example, RowBounds rowBounds);

    List<TBiddingPreview> selectByExample(TBiddingPreviewCriteria example);

    TBiddingPreview selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TBiddingPreview record, @Param("example") TBiddingPreviewCriteria example);

    int updateByExample(@Param("record") TBiddingPreview record, @Param("example") TBiddingPreviewCriteria example);

    int updateByPrimaryKeySelective(TBiddingPreview record);

    int updateByPrimaryKey(TBiddingPreview record);
}