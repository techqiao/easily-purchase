package com.epc.platform.service.mapper.reviewexpert;

import com.epc.platform.service.domain.expert.TExpertAttachment;
import com.epc.platform.service.domain.expert.TExpertAttachmentCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface TExpertAttachmentMapper {
    int countByExample(TExpertAttachmentCriteria example);

    int deleteByExample(TExpertAttachmentCriteria example);

    int deleteByPrimaryKey(Long id);

    int insert(TExpertAttachment record);

    int insertSelective(TExpertAttachment record);

    List<TExpertAttachment> selectByExampleWithRowbounds(TExpertAttachmentCriteria example, RowBounds rowBounds);

    List<TExpertAttachment> selectByExample(TExpertAttachmentCriteria example);

    TExpertAttachment selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TExpertAttachment record, @Param("example") TExpertAttachmentCriteria example);

    int updateByExample(@Param("record") TExpertAttachment record, @Param("example") TExpertAttachmentCriteria example);

    int updateByPrimaryKeySelective(TExpertAttachment record);

    int updateByPrimaryKey(TExpertAttachment record);
}