package com.epc.tendering.service.mapper.pretrial;

import com.epc.tendering.service.domain.pretrial.TPretrialMessage;
import com.epc.tendering.service.domain.pretrial.TPretrialMessageCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface TPretrialMessageMapper {
    int countByExample(TPretrialMessageCriteria example);

    int deleteByExample(TPretrialMessageCriteria example);

    int deleteByPrimaryKey(Long id);

    int insert(TPretrialMessage record);

    int insertSelective(TPretrialMessage record);

    List<TPretrialMessage> selectByExampleWithRowbounds(TPretrialMessageCriteria example, RowBounds rowBounds);

    List<TPretrialMessage> selectByExample(TPretrialMessageCriteria example);

    TPretrialMessage selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TPretrialMessage record, @Param("example") TPretrialMessageCriteria example);

    int updateByExample(@Param("record") TPretrialMessage record, @Param("example") TPretrialMessageCriteria example);

    int updateByPrimaryKeySelective(TPretrialMessage record);

    int updateByPrimaryKey(TPretrialMessage record);
}