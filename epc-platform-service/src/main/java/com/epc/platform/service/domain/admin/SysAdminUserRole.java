package com.epc.platform.service.domain.admin;

import java.io.Serializable;

/**
 * 描述:sys_admin_user_role表的实体类
 * @version
 * @author:  01
 * @创建时间: 2018-09-29
 */
public class SysAdminUserRole implements Serializable {
    /**
     * 
     */
    private Long id;

    /**
     * 
     */
    private Long adminUserId;

    /**
     * 
     */
    private Long adminRoleId;

    /**
     * 是否删除: 0-存在,1-删除
     */
    private Integer isDeleted;

    /**
     * sys_admin_user_role
     */
    private static final long serialVersionUID = 1L;

    /**
     * 
     * @return id 
     */
    public Long getId() {
        return id;
    }

    /**
     * 
     * @param id 
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 
     * @return admin_user_id 
     */
    public Long getAdminUserId() {
        return adminUserId;
    }

    /**
     * 
     * @param adminUserId 
     */
    public void setAdminUserId(Long adminUserId) {
        this.adminUserId = adminUserId;
    }

    /**
     * 
     * @return admin_role_id 
     */
    public Long getAdminRoleId() {
        return adminRoleId;
    }

    /**
     * 
     * @param adminRoleId 
     */
    public void setAdminRoleId(Long adminRoleId) {
        this.adminRoleId = adminRoleId;
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
        sb.append(", adminUserId=").append(adminUserId);
        sb.append(", adminRoleId=").append(adminRoleId);
        sb.append(", isDeleted=").append(isDeleted);
        sb.append("]");
        return sb.toString();
    }
}