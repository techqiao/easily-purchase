package com.epc.platform.service.domain.admin;

import java.io.Serializable;
import java.util.Date;

/**
 * 描述:sys_admin_dept表的实体类
 * @version
 * @author:  01
 * @创建时间: 2018-09-29
 */
public class SysAdminDept implements Serializable {
    /**
     * 部门ID
     */
    private Long id;

    /**
     * 上级部门ID
     */
    private Long parentId;

    /**
     * 部门名称
     */
    private String deptName;

    /**
     * 排序
     */
    private Long orderNum;

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
     * sys_admin_dept
     */
    private static final long serialVersionUID = 1L;

    /**
     * 部门ID
     * @return id 部门ID
     */
    public Long getId() {
        return id;
    }

    /**
     * 部门ID
     * @param id 部门ID
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 上级部门ID
     * @return parent_id 上级部门ID
     */
    public Long getParentId() {
        return parentId;
    }

    /**
     * 上级部门ID
     * @param parentId 上级部门ID
     */
    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    /**
     * 部门名称
     * @return dept_name 部门名称
     */
    public String getDeptName() {
        return deptName;
    }

    /**
     * 部门名称
     * @param deptName 部门名称
     */
    public void setDeptName(String deptName) {
        this.deptName = deptName == null ? null : deptName.trim();
    }

    /**
     * 排序
     * @return order_num 排序
     */
    public Long getOrderNum() {
        return orderNum;
    }

    /**
     * 排序
     * @param orderNum 排序
     */
    public void setOrderNum(Long orderNum) {
        this.orderNum = orderNum;
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
        sb.append(", parentId=").append(parentId);
        sb.append(", deptName=").append(deptName);
        sb.append(", orderNum=").append(orderNum);
        sb.append(", createAt=").append(createAt);
        sb.append(", updateAt=").append(updateAt);
        sb.append(", isDeleted=").append(isDeleted);
        sb.append("]");
        return sb.toString();
    }
}