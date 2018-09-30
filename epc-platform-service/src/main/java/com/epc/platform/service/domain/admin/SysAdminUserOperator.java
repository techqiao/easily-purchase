package com.epc.platform.service.domain.admin;

import java.io.Serializable;
import java.util.Date;

/**
 * 描述:sys_admin_user_operator表的实体类
 * @version
 * @author:  01
 * @创建时间: 2018-09-29
 */
public class SysAdminUserOperator implements Serializable {
    /**
     * 主键ID
     */
    private Long id;

    /**
     * 平台用户ID
     */
    private Long adminUserId;

    /**
     * 平台用户名称
     */
    private String adminUserName;

    /**
     * 运营商ID
     */
    private Long operatorId;

    /**
     * 运营商名称
     */
    private String comanyName;

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
     * sys_admin_user_operator
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
     * 平台用户ID
     * @return admin_user_id 平台用户ID
     */
    public Long getAdminUserId() {
        return adminUserId;
    }

    /**
     * 平台用户ID
     * @param adminUserId 平台用户ID
     */
    public void setAdminUserId(Long adminUserId) {
        this.adminUserId = adminUserId;
    }

    /**
     * 平台用户名称
     * @return admin_user_name 平台用户名称
     */
    public String getAdminUserName() {
        return adminUserName;
    }

    /**
     * 平台用户名称
     * @param adminUserName 平台用户名称
     */
    public void setAdminUserName(String adminUserName) {
        this.adminUserName = adminUserName == null ? null : adminUserName.trim();
    }

    /**
     * 运营商ID
     * @return operator_id 运营商ID
     */
    public Long getOperatorId() {
        return operatorId;
    }

    /**
     * 运营商ID
     * @param operatorId 运营商ID
     */
    public void setOperatorId(Long operatorId) {
        this.operatorId = operatorId;
    }

    /**
     * 运营商名称
     * @return comany_name 运营商名称
     */
    public String getComanyName() {
        return comanyName;
    }

    /**
     * 运营商名称
     * @param comanyName 运营商名称
     */
    public void setComanyName(String comanyName) {
        this.comanyName = comanyName == null ? null : comanyName.trim();
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
        sb.append(", adminUserId=").append(adminUserId);
        sb.append(", adminUserName=").append(adminUserName);
        sb.append(", operatorId=").append(operatorId);
        sb.append(", comanyName=").append(comanyName);
        sb.append(", createAt=").append(createAt);
        sb.append(", updateAt=").append(updateAt);
        sb.append(", isDeleted=").append(isDeleted);
        sb.append("]");
        return sb.toString();
    }
}