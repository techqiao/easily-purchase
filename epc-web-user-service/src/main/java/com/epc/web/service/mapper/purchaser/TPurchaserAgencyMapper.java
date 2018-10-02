package com.epc.web.service.mapper.purchaser;

import com.epc.web.facade.purchaser.handle.HandleTrustList;
import com.epc.web.service.domain.purchaser.TPurchaserAgency;
import com.epc.web.service.domain.purchaser.TPurchaserAgencyCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface TPurchaserAgencyMapper {
    int countByExample(TPurchaserAgencyCriteria example);

    int deleteByExample(TPurchaserAgencyCriteria example);

    int deleteByPrimaryKey(Long id);

    int insert(TPurchaserAgency record);

    int insertSelective(TPurchaserAgency record);

    List<TPurchaserAgency> selectByExampleWithRowbounds(TPurchaserAgencyCriteria example, RowBounds rowBounds);

    List<TPurchaserAgency> selectByExample(TPurchaserAgencyCriteria example);

    TPurchaserAgency selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TPurchaserAgency record, @Param("example") TPurchaserAgencyCriteria example);

    int updateByExample(@Param("record") TPurchaserAgency record, @Param("example") TPurchaserAgencyCriteria example);

    int updateByPrimaryKeySelective(TPurchaserAgency record);

    int updateByPrimaryKey(TPurchaserAgency record);

    int updateTrustList(HandleTrustList trustList);

    TPurchaserAgency selectAgencyByAgencyId(Long agencyId);

}