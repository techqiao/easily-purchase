package com.epc.web.service.mapper.supplier;

import com.epc.web.service.domain.supplier.TSupplierAttachment;
import com.epc.web.service.domain.supplier.TSupplierAttachmentCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface TSupplierAttachmentMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_supplier_attachment
     *
     * @mbggenerated Tue Sep 18 11:36:59 CST 2018
     */
    int countByExample(TSupplierAttachmentCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_supplier_attachment
     *
     * @mbggenerated Tue Sep 18 11:36:59 CST 2018
     */
    int deleteByExample(TSupplierAttachmentCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_supplier_attachment
     *
     * @mbggenerated Tue Sep 18 11:36:59 CST 2018
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_supplier_attachment
     *
     * @mbggenerated Tue Sep 18 11:36:59 CST 2018
     */
    int insert(TSupplierAttachment record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_supplier_attachment
     *
     * @mbggenerated Tue Sep 18 11:36:59 CST 2018
     */
    int insertSelective(TSupplierAttachment record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_supplier_attachment
     *
     * @mbggenerated Tue Sep 18 11:36:59 CST 2018
     */
    List<TSupplierAttachment> selectByExampleWithRowbounds(TSupplierAttachmentCriteria example, RowBounds rowBounds);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_supplier_attachment
     *
     * @mbggenerated Tue Sep 18 11:36:59 CST 2018
     */
    List<TSupplierAttachment> selectByExample(TSupplierAttachmentCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_supplier_attachment
     *
     * @mbggenerated Tue Sep 18 11:36:59 CST 2018
     */
    TSupplierAttachment selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_supplier_attachment
     *
     * @mbggenerated Tue Sep 18 11:36:59 CST 2018
     */
    int updateByExampleSelective(@Param("record") TSupplierAttachment record, @Param("example") TSupplierAttachmentCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_supplier_attachment
     *
     * @mbggenerated Tue Sep 18 11:36:59 CST 2018
     */
    int updateByExample(@Param("record") TSupplierAttachment record, @Param("example") TSupplierAttachmentCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_supplier_attachment
     *
     * @mbggenerated Tue Sep 18 11:36:59 CST 2018
     */
    int updateByPrimaryKeySelective(TSupplierAttachment record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_supplier_attachment
     *
     * @mbggenerated Tue Sep 18 11:36:59 CST 2018
     */
    int updateByPrimaryKey(TSupplierAttachment record);
}