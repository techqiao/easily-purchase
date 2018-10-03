package com.epc.platform.service.mapper.tagency;

import com.epc.administration.facade.biddingagency.dto.QueryDetailIfo;
import com.epc.administration.facade.biddingagency.vo.BiddingAgencyVO;
import com.epc.platform.service.domain.tagency.TAgencyDetailInfo;
import com.epc.platform.service.domain.tagency.TAgencyDetailInfoCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface TAgencyDetailInfoMapper {
    int countByExample(TAgencyDetailInfoCriteria example);

    int deleteByExample(TAgencyDetailInfoCriteria example);

    int deleteByPrimaryKey(Long id);

    int insert(TAgencyDetailInfo record);

    int insertSelective(TAgencyDetailInfo record);

    List<TAgencyDetailInfo> selectByExampleWithRowbounds(TAgencyDetailInfoCriteria example, RowBounds rowBounds);

    List<TAgencyDetailInfo> selectByExample(TAgencyDetailInfoCriteria example);

    TAgencyDetailInfo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TAgencyDetailInfo record, @Param("example") TAgencyDetailInfoCriteria example);

    int updateByExample(@Param("record") TAgencyDetailInfo record, @Param("example") TAgencyDetailInfoCriteria example);

    int updateByPrimaryKeySelective(TAgencyDetailInfo record);

    int updateByPrimaryKey(TAgencyDetailInfo record);

    /**
     * 根据名称查询
     * @param companyName
     * @return
     */
    List<TAgencyDetailInfo> selectByName(String companyName);


    /**
     * 分页查询
     * @return
     */
    List<BiddingAgencyVO> selectByPage(QueryDetailIfo queryDetailIfo);

}