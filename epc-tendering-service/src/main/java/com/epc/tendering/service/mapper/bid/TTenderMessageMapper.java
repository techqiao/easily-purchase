package com.epc.tendering.service.mapper.bid;

import com.epc.tendering.service.domain.bid.TTenderMessage;
import com.epc.tendering.service.domain.bid.TTenderMessageCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
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

    /**
     * 供应商
     * @param id
     * @return
     */
    @Select("SELECT COUNT(b.id) FROM t_tender_message b where b.purchase_project_id=#{id}")
    Integer countSupplier(Long id);
}