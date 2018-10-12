package com.epc.web.service.mapper.supplier;

import com.epc.web.service.domain.supplier.TProjectProcedure;
import com.epc.web.service.domain.supplier.TProjectProcedureCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface TProjectProcedureMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_project_procedure
     *
     * @mbggenerated Fri Oct 12 11:54:17 CST 2018
     */
    int countByExample(TProjectProcedureCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_project_procedure
     *
     * @mbggenerated Fri Oct 12 11:54:17 CST 2018
     */
    int deleteByExample(TProjectProcedureCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_project_procedure
     *
     * @mbggenerated Fri Oct 12 11:54:17 CST 2018
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_project_procedure
     *
     * @mbggenerated Fri Oct 12 11:54:17 CST 2018
     */
    int insert(TProjectProcedure record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_project_procedure
     *
     * @mbggenerated Fri Oct 12 11:54:17 CST 2018
     */
    int insertSelective(TProjectProcedure record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_project_procedure
     *
     * @mbggenerated Fri Oct 12 11:54:17 CST 2018
     */
    List<TProjectProcedure> selectByExampleWithRowbounds(TProjectProcedureCriteria example, RowBounds rowBounds);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_project_procedure
     *
     * @mbggenerated Fri Oct 12 11:54:17 CST 2018
     */
    List<TProjectProcedure> selectByExample(TProjectProcedureCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_project_procedure
     *
     * @mbggenerated Fri Oct 12 11:54:17 CST 2018
     */
    TProjectProcedure selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_project_procedure
     *
     * @mbggenerated Fri Oct 12 11:54:17 CST 2018
     */
    int updateByExampleSelective(@Param("record") TProjectProcedure record, @Param("example") TProjectProcedureCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_project_procedure
     *
     * @mbggenerated Fri Oct 12 11:54:17 CST 2018
     */
    int updateByExample(@Param("record") TProjectProcedure record, @Param("example") TProjectProcedureCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_project_procedure
     *
     * @mbggenerated Fri Oct 12 11:54:17 CST 2018
     */
    int updateByPrimaryKeySelective(TProjectProcedure record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_project_procedure
     *
     * @mbggenerated Fri Oct 12 11:54:17 CST 2018
     */
    int updateByPrimaryKey(TProjectProcedure record);
}