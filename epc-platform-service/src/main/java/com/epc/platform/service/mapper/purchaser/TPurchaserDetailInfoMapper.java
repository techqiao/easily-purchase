package com.epc.platform.service.mapper.purchaser;

import com.epc.administration.facade.purchaser.dto.QueryDetailIfo;
import com.epc.administration.facade.purchaser.vo.PurchaserVO;
import com.epc.platform.service.domain.purchaser.TPurchaserDetailInfo;
import com.epc.platform.service.domain.purchaser.TPurchaserDetailInfoCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface TPurchaserDetailInfoMapper {
    int countByExample(TPurchaserDetailInfoCriteria example);

    int deleteByExample(TPurchaserDetailInfoCriteria example);

    int deleteByPrimaryKey(Long id);

    int insert(TPurchaserDetailInfo record);

    int insertSelective(TPurchaserDetailInfo record);

    List<TPurchaserDetailInfo> selectByExampleWithRowbounds(TPurchaserDetailInfoCriteria example, RowBounds rowBounds);

    List<TPurchaserDetailInfo> selectByExample(TPurchaserDetailInfoCriteria example);

    TPurchaserDetailInfo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TPurchaserDetailInfo record, @Param("example") TPurchaserDetailInfoCriteria example);

    int updateByExample(@Param("record") TPurchaserDetailInfo record, @Param("example") TPurchaserDetailInfoCriteria example);

    int updateByPrimaryKeySelective(TPurchaserDetailInfo record);

    int updateByPrimaryKey(TPurchaserDetailInfo record);

    List<PurchaserVO> selectByPageWhereName(String name);

    /**
     * 分页查询
     * @return
     */
    List<PurchaserVO> selectByPage(QueryDetailIfo queryDetailIfo);

    /**
     * 根据状态
     * 分页查询
     * @param status
     * @return
     */
    List<PurchaserVO> selectByPageWithStatus(Integer status);
}