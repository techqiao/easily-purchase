package com.epc.platform.service.domain.admin;

import java.io.Serializable;
import java.util.Date;

/**
 * 描述:sys_admin_role_resource表的实体类
 * @version
 * @author:  01
 * @创建时间: 2018-09-29
 */
public class SysAdminRoleResource implements Serializable {
    /**
     * 主键ID
     */
    private Long id;

    /**
     * 用户角色ID
     */
    private Long amdinRoleId;

    /**
     * 用户资源ID
     */
    private Long adminResourceId;

    /**
     * 创建时间
     */
    private Date createAt;

    /**
     * 最后修改时间
     */
    private Date updateAt;

    /**
     * 是否删除: 0-存在,1-删除
     */
    private Integer isDeleted;

    /**
     * sys_admin_role_resource
     */
    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     * @return id 主键ID
     */
    public Long getId() {
        return id;
    }

    /**
     * 主键ID
     * @param id 主键ID
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 用户角色ID
     * @return amdin_role_id 用户角色ID
     */
    public Long getAmdinRoleId() {
        return amdinRoleId;
    }

    /**
     * 用户角色ID
     * @param amdinRoleId 用户角色ID
     */
    public void setAmdinRoleId(Long amdinRoleId) {
        this.amdinRoleId = amdinRoleId;
    }

    /**
     * 用户资源ID
     * @return admin_resource_id 用户资源ID
     */
    public Long getAdminResourceId() {
        return adminResourceId;
    }

    /**
     * 用户资源ID
     * @param adminResourceId 用户资源ID
     */
    public void setAdminResourceId(Long adminResourceId) {
        this.adminResourceId = adminResourceId;
    }

    /**
     * 创建时间
     * @return create_at 创建时间
     */
    public Date getCreateAt() {
        return createAt;
    }

    /**
     * 创建时间
     * @param createAt 创建时间
     */
    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    /**
     * 最后修改时间
     * @return update_at 最后修改时间
     */
    public Date getUpdateAt() {
        return updateAt;
    }

    /**
     * 最后修改时间
     * @param updateAt 最后修改时间
     */
    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }

    /**
     * 是否删除: 0-存在,1-删除
     * @return is_deleted 是否删除: 0-存在,1-删除
     */
    public Integer getIsDeleted() {
        return isDeleted;
    }

    /**
     * 是否删除: 0-存在,1-删除
     * @param isDeleted 是否删除: 0-存在,1-删除
     */
    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", amdinRoleId=").append(amdinRoleId);
        sb.append(", adminResourceId=").append(adminResourceId);
        sb.append(", createAt=").append(createAt);
        sb.append(", updateAt=").append(updateAt);
        sb.append(", isDeleted=").append(isDeleted);
        sb.append("]");
        return sb.toString();
    }
}