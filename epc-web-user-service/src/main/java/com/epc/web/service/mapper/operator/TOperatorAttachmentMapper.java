package com.epc.web.service.mapper.operator;

import com.epc.web.service.domain.operator.TOperatorAttachment;
import com.epc.web.service.domain.operator.TOperatorAttachmentCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface TOperatorAttachmentMapper {
    int countByExample(TOperatorAttachmentCriteria example);

    int deleteByExample(TOperatorAttachmentCriteria example);

    int deleteByPrimaryKey(Long id);

    int insert(TOperatorAttachment record);

    int insertSelective(TOperatorAttachment record);

    List<TOperatorAttachment> selectByExampleWithRowbounds(TOperatorAttachmentCriteria example, RowBounds rowBounds);

    List<TOperatorAttachment> selectByExample(TOperatorAttachmentCriteria example);

    TOperatorAttachment selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TOperatorAttachment record, @Param("example") TOperatorAttachmentCriteria example);

    int updateByExample(@Param("record") TOperatorAttachment record, @Param("example") TOperatorAttachmentCriteria example);

    int updateByPrimaryKeySelective(TOperatorAttachment record);

    int updateByPrimaryKey(TOperatorAttachment record);
}