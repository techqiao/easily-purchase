package com.epc.user.service.mapper.purchaser;

import com.epc.user.service.domain.purchaser.TPurchaserAttachment;
import com.epc.user.service.domain.purchaser.TPurchaserAttachmentCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface TPurchaserAttachmentMapper {

    int countByExample(TPurchaserAttachmentCriteria example);

    int deleteByExample(TPurchaserAttachmentCriteria example);

    int deleteByPrimaryKey(Long id);

    int insert(TPurchaserAttachment record);

    int insertSelective(TPurchaserAttachment record);

    List<TPurchaserAttachment> selectByExampleWithRowbounds(TPurchaserAttachmentCriteria example, RowBounds rowBounds);

    List<TPurchaserAttachment> selectByExample(TPurchaserAttachmentCriteria example);

    TPurchaserAttachment selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TPurchaserAttachment record, @Param("example") TPurchaserAttachmentCriteria example);

    int updateByExample(@Param("record") TPurchaserAttachment record, @Param("example") TPurchaserAttachmentCriteria example);

    int updateByPrimaryKeySelective(TPurchaserAttachment record);

    int updateByPrimaryKey(TPurchaserAttachment record);
}