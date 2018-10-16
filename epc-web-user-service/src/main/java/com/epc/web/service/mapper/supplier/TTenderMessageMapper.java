package com.epc.web.service.mapper.supplier;

import com.epc.web.service.domain.supplier.BSignUp;
import com.epc.web.service.domain.supplier.TTenderMessage;
import com.epc.web.service.domain.supplier.TTenderMessageCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface TTenderMessageMapper {
    int countByExample(TTenderMessageCriteria example);

    int deleteByExample(TTenderMessageCriteria example);

    int deleteByPrimaryKey(Long id);

    int insert(TTenderMessage record);

    int insertSelective(TTenderMessage record);

    List<TTenderMessage> selectByExampleWithRowbounds(TTenderMessageCriteria example, RowBounds rowBounds);

    List<TTenderMessage> selectByExample(TTenderMessageCriteria example);

    TTenderMessage selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TTenderMessage record, @Param("example") TTenderMessageCriteria example);

    int updateByExample(@Param("record") TTenderMessage record, @Param("example") TTenderMessageCriteria example);

    int updateByPrimaryKeySelective(TTenderMessage record);

    int updateByPrimaryKey(TTenderMessage record);

}