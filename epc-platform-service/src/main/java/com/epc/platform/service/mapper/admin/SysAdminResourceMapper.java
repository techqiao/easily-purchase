package com.epc.platform.service.mapper.admin;

import com.epc.platform.service.domain.admin.SysAdminResource;
import com.epc.platform.service.domain.admin.SysAdminResourceCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface SysAdminResourceMapper {
    int countByExample(SysAdminResourceCriteria example);

    int deleteByExample(SysAdminResourceCriteria example);

    int deleteByPrimaryKey(Long id);

    int insert(SysAdminResource record);

    int insertSelective(SysAdminResource record);

    List<SysAdminResource> selectByExampleWithRowbounds(SysAdminResourceCriteria example, RowBounds rowBounds);

    List<SysAdminResource> selectByExample(SysAdminResourceCriteria example);

    SysAdminResource selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SysAdminResource record, @Param("example") SysAdminResourceCriteria example);

    int updateByExample(@Param("record") SysAdminResource record, @Param("example") SysAdminResourceCriteria example);

    int updateByPrimaryKeySelective(SysAdminResource record);

    int updateByPrimaryKey(SysAdminResource record);

    /**根据手机号查看资源
     * @param phone
     * @return
     */
    List<SysAdminResource> findResource(String phone);


    /** 删除父节点，子节点变成顶级节点（根据实际业务调整）
     * @param resourceIds
     */
    void changeToTop(List<Long> resourceIds);

    /**
     * 查询User Permissions
     * @param userName
     * @return
     */
    List<SysAdminResource> findUserPermissions(String userName);

    List<SysAdminResource> selectUrl();
}