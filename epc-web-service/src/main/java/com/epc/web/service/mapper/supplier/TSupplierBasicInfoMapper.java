package com.epc.web.service.mapper.supplier;

import com.epc.web.service.domain.supplier.TSupplierBasicInfo;
import com.epc.web.service.domain.supplier.TSupplierBasicInfoCriteria;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface TSupplierBasicInfoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_supplier_basic_info
     *
     * @mbggenerated Fri Sep 14 19:54:40 CST 2018
     */
    int countByExample(TSupplierBasicInfoCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_supplier_basic_info
     *
     * @mbggenerated Fri Sep 14 19:54:40 CST 2018
     */
    int deleteByExample(TSupplierBasicInfoCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_supplier_basic_info
     *
     * @mbggenerated Fri Sep 14 19:54:40 CST 2018
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_supplier_basic_info
     *
     * @mbggenerated Fri Sep 14 19:54:40 CST 2018
     */
    int insert(TSupplierBasicInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_supplier_basic_info
     *
     * @mbggenerated Fri Sep 14 19:54:40 CST 2018
     */
    int insertSelective(TSupplierBasicInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_supplier_basic_info
     *
     * @mbggenerated Fri Sep 14 19:54:40 CST 2018
     */
    List<TSupplierBasicInfo> selectByExampleWithRowbounds(TSupplierBasicInfoCriteria example, RowBounds rowBounds);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_supplier_basic_info
     *
     * @mbggenerated Fri Sep 14 19:54:40 CST 2018
     */
    List<TSupplierBasicInfo> selectByExample(TSupplierBasicInfoCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_supplier_basic_info
     *
     * @mbggenerated Fri Sep 14 19:54:40 CST 2018
     */
    TSupplierBasicInfo selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_supplier_basic_info
     *
     * @mbggenerated Fri Sep 14 19:54:40 CST 2018
     */
    int updateByExampleSelective(@Param("record") TSupplierBasicInfo record, @Param("example") TSupplierBasicInfoCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_supplier_basic_info
     *
     * @mbggenerated Fri Sep 14 19:54:40 CST 2018
     */
    int updateByExample(@Param("record") TSupplierBasicInfo record, @Param("example") TSupplierBasicInfoCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_supplier_basic_info
     *
     * @mbggenerated Fri Sep 14 19:54:40 CST 2018
     */
    int updateByPrimaryKeySelective(TSupplierBasicInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_supplier_basic_info
     *
     * @mbggenerated Fri Sep 14 19:54:40 CST 2018
     */
    int updateByPrimaryKey(TSupplierBasicInfo record);
}