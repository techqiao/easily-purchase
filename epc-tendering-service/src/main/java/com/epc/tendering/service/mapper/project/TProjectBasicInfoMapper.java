package com.epc.tendering.service.mapper.project;

import com.epc.tendering.service.domain.project.TProjectBasicInfo;
import com.epc.tendering.service.domain.project.TProjectBasicInfoCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.session.RowBounds;

public interface TProjectBasicInfoMapper {
    int countByExample(TProjectBasicInfoCriteria example);

    int deleteByExample(TProjectBasicInfoCriteria example);

    int deleteByPrimaryKey(Long id);

    int insert(TProjectBasicInfo record);

    int insertSelective(TProjectBasicInfo record);

    List<TProjectBasicInfo> selectByExampleWithBLOBsWithRowbounds(TProjectBasicInfoCriteria example, RowBounds rowBounds);

    List<TProjectBasicInfo> selectByExampleWithBLOBs(TProjectBasicInfoCriteria example);

    List<TProjectBasicInfo> selectByExampleWithRowbounds(TProjectBasicInfoCriteria example, RowBounds rowBounds);

    List<TProjectBasicInfo> selectByExample(TProjectBasicInfoCriteria example);

    TProjectBasicInfo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TProjectBasicInfo record, @Param("example") TProjectBasicInfoCriteria example);

    int updateByExampleWithBLOBs(@Param("record") TProjectBasicInfo record, @Param("example") TProjectBasicInfoCriteria example);

    int updateByExample(@Param("record") TProjectBasicInfo record, @Param("example") TProjectBasicInfoCriteria example);

    int updateByPrimaryKeySelective(TProjectBasicInfo record);

    int updateByPrimaryKeyWithBLOBs(TProjectBasicInfo record);

    int updateByPrimaryKey(TProjectBasicInfo record);

    @Select("SELECT t.project_address FROM t_project_basic_info t where t.id =#{id}")
    String getProjectAddress(Long id);
}