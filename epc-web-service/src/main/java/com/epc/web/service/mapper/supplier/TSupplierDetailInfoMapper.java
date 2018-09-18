package com.epc.web.service.mapper.supplier;

import com.epc.web.service.domain.supplier.TSupplierDetailInfo;
import com.epc.web.service.domain.supplier.TSupplierDetailInfoCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface TSupplierDetailInfoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_supplier_detail_info
     *
     * @mbggenerated Tue Sep 18 10:15:14 CST 2018
     */
    int countByExample(TSupplierDetailInfoCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_supplier_detail_info
     *
     * @mbggenerated Tue Sep 18 10:15:14 CST 2018
     */
    int deleteByExample(TSupplierDetailInfoCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_supplier_detail_info
     *
     * @mbggenerated Tue Sep 18 10:15:14 CST 2018
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_supplier_detail_info
     *
     * @mbggenerated Tue Sep 18 10:15:14 CST 2018
     */
    int insert(TSupplierDetailInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_supplier_detail_info
     *
     * @mbggenerated Tue Sep 18 10:15:14 CST 2018
     */
    int insertSelective(TSupplierDetailInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_supplier_detail_info
     *
     * @mbggenerated Tue Sep 18 10:15:14 CST 2018
     */
    List<TSupplierDetailInfo> selectByExampleWithRowbounds(TSupplierDetailInfoCriteria example, RowBounds rowBounds);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_supplier_detail_info
     *
     * @mbggenerated Tue Sep 18 10:15:14 CST 2018
     */
    List<TSupplierDetailInfo> selectByExample(TSupplierDetailInfoCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_supplier_detail_info
     *
     * @mbggenerated Tue Sep 18 10:15:14 CST 2018
     */
    TSupplierDetailInfo selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_supplier_detail_info
     *
     * @mbggenerated Tue Sep 18 10:15:14 CST 2018
     */
    int updateByExampleSelective(@Param("record") TSupplierDetailInfo record, @Param("example") TSupplierDetailInfoCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_supplier_detail_info
     *
     * @mbggenerated Tue Sep 18 10:15:14 CST 2018
     */
    int updateByExample(@Param("record") TSupplierDetailInfo record, @Param("example") TSupplierDetailInfoCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_supplier_detail_info
     *
     * @mbggenerated Tue Sep 18 10:15:14 CST 2018
     */
    int updateByPrimaryKeySelective(TSupplierDetailInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_supplier_detail_info
     *
     * @mbggenerated Tue Sep 18 10:15:14 CST 2018
     */
    int updateByPrimaryKey(TSupplierDetailInfo record);
}