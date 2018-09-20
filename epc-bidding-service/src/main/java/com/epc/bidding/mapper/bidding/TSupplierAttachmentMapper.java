package com.epc.bidding.mapper.bidding;

import com.epc.bidding.domain.bidding.TSupplierAttachment;
import com.epc.bidding.domain.bidding.TSupplierAttachmentCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface TSupplierAttachmentMapper {
    int countByExample(TSupplierAttachmentCriteria example);

    int deleteByExample(TSupplierAttachmentCriteria example);

    int deleteByPrimaryKey(Long id);

    int insert(TSupplierAttachment record);

    int insertSelective(TSupplierAttachment record);

    List<TSupplierAttachment> selectByExampleWithRowbounds(TSupplierAttachmentCriteria example, RowBounds rowBounds);

    List<TSupplierAttachment> selectByExample(TSupplierAttachmentCriteria example);

    TSupplierAttachment selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TSupplierAttachment record, @Param("example") TSupplierAttachmentCriteria example);

    int updateByExample(@Param("record") TSupplierAttachment record, @Param("example") TSupplierAttachmentCriteria example);

    int updateByPrimaryKeySelective(TSupplierAttachment record);

    int updateByPrimaryKey(TSupplierAttachment record);
}