package com.epc.platform.service.mapper.supplier;

import com.epc.administration.facade.supplier.vo.SupplierUserVO;
import com.epc.platform.service.domain.supplier.TSupplierDetailInfo;
import com.epc.platform.service.domain.supplier.TSupplierDetailInfoCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface TSupplierDetailInfoMapper {
    int countByExample(TSupplierDetailInfoCriteria example);

    int deleteByExample(TSupplierDetailInfoCriteria example);

    int deleteByPrimaryKey(Long id);

    int insert(TSupplierDetailInfo record);

    int insertSelective(TSupplierDetailInfo record);

    List<TSupplierDetailInfo> selectByExampleWithRowbounds(TSupplierDetailInfoCriteria example, RowBounds rowBounds);

    List<TSupplierDetailInfo> selectByExample(TSupplierDetailInfoCriteria example);

    TSupplierDetailInfo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TSupplierDetailInfo record, @Param("example") TSupplierDetailInfoCriteria example);

    int updateByExample(@Param("record") TSupplierDetailInfo record, @Param("example") TSupplierDetailInfoCriteria example);

    int updateByPrimaryKeySelective(TSupplierDetailInfo record);

    int updateByPrimaryKey(TSupplierDetailInfo record);

    /**
     * 分页查询所有带公司名称
     * @param name
     * @return
     */
    List<SupplierUserVO> selectByPageWhereName(String name);

    /**
     * 分页查询
     * @return
     */
    List<SupplierUserVO> selectByPage();

    /**
     * 根据状态
     * 分页查询
     * @param status
     * @return
     */
    List<SupplierUserVO> selectByPageWithStatus(Integer status);
}