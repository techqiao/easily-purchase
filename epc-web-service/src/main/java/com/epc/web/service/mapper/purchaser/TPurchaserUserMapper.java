package com.epc.web.service.mapper.purchaser;

import com.epc.web.service.domain.purchaser.TPurchaserUser;
import com.epc.web.service.domain.purchaser.TPurchaserUserCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface TPurchaserUserMapper {

    int countByExample(TPurchaserUserCriteria example);

    int deleteByExample(TPurchaserUserCriteria example);

    int deleteByPrimaryKey(Long id);

    int insert(TPurchaserUser record);

    int insertSelective(TPurchaserUser record);

    List<TPurchaserUser> selectByExampleWithRowbounds(TPurchaserUserCriteria example, RowBounds rowBounds);

    List<TPurchaserUser> selectByExample(TPurchaserUserCriteria example);

    TPurchaserUser selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TPurchaserUser record, @Param("example") TPurchaserUserCriteria example);

    int updateByExample(@Param("record") TPurchaserUser record, @Param("example") TPurchaserUserCriteria example);

    int updateByPrimaryKeySelective(TPurchaserUser record);

    int updateByPrimaryKey(TPurchaserUser record);
}