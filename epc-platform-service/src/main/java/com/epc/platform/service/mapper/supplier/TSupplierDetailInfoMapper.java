package com.epc.platform.service.mapper.supplier;

import com.epc.platform.service.domain.supplier.TSupplierDetailInfo;
import com.epc.platform.service.domain.supplier.TSupplierDetailInfoCriteria;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface TSupplierDetailInfoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_supplier_detail_info
     *
     * @mbggenerated Fri Sep 14 15:15:25 CST 2018
     */
    int countByExample(TSupplierDetailInfoCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_supplier_detail_info
     *
     * @mbggenerated Fri Sep 14 15:15:25 CST 2018
     */
    int deleteByExample(TSupplierDetailInfoCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_supplier_detail_info
     *
     * @mbggenerated Fri Sep 14 15:15:25 CST 2018
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_supplier_detail_info
     *
     * @mbggenerated Fri Sep 14 15:15:25 CST 2018
     */
    int insert(TSupplierDetailInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_supplier_detail_info
     *
     * @mbggenerated Fri Sep 14 15:15:25 CST 2018
     */
    int insertSelective(TSupplierDetailInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_supplier_detail_info
     *
     * @mbggenerated Fri Sep 14 15:15:25 CST 2018
     */
    List<TSupplierDetailInfo> selectByExampleWithRowbounds(TSupplierDetailInfoCriteria example, RowBounds rowBounds);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_supplier_detail_info
     *
     * @mbggenerated Fri Sep 14 15:15:25 CST 2018
     */
    List<TSupplierDetailInfo> selectByExample(TSupplierDetailInfoCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_supplier_detail_info
     *
     * @mbggenerated Fri Sep 14 15:15:25 CST 2018
     */
    TSupplierDetailInfo selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_supplier_detail_info
     *
     * @mbggenerated Fri Sep 14 15:15:25 CST 2018
     */
    int updateByExampleSelective(@Param("record") TSupplierDetailInfo record, @Param("example") TSupplierDetailInfoCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_supplier_detail_info
     *
     * @mbggenerated Fri Sep 14 15:15:25 CST 2018
     */
    int updateByExample(@Param("record") TSupplierDetailInfo record, @Param("example") TSupplierDetailInfoCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_supplier_detail_info
     *
     * @mbggenerated Fri Sep 14 15:15:25 CST 2018
     */
    int updateByPrimaryKeySelective(TSupplierDetailInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_supplier_detail_info
     *
     * @mbggenerated Fri Sep 14 15:15:25 CST 2018
     */
    int updateByPrimaryKey(TSupplierDetailInfo record);

    /**
     * 根据名称查询
     * @param companyName
     * @return
     */
    List<TSupplierDetailInfo> selectByName(String companyName);
}