package com.epc.platform.service.domain.admin;

import java.io.Serializable;
import java.util.Date;

/**
 * 描述:sys_admin_resource表的实体类
 * @version
 * @author:  01
 * @创建时间: 2018-09-29
 */
public class SysAdminResource implements Serializable {
    /**
     * 主键ID
     */
    private Long id;

    /**
     * 父资源ID
     */
    private Long parentId;

    /**
     * 资源名称
     */
    private String name;

    /**
     * 标题
     */
    private String title;

    /**
     * 类型,page:页面，action:功能
     */
    private String type;

    /**
     * 资源路径
     */
    private String url;

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
     * sys_admin_resource
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
     * 父资源ID
     * @return parent_id 父资源ID
     */
    public Long getParentId() {
        return parentId;
    }

    /**
     * 父资源ID
     * @param parentId 父资源ID
     */
    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    /**
     * 资源名称
     * @return name 资源名称
     */
    public String getName() {
        return name;
    }

    /**
     * 资源名称
     * @param name 资源名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 标题
     * @return title 标题
     */
    public String getTitle() {
        return title;
    }

    /**
     * 标题
     * @param title 标题
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * 类型,page:页面，action:功能
     * @return type 类型,page:页面，action:功能
     */
    public String getType() {
        return type;
    }

    /**
     * 类型,page:页面，action:功能
     * @param type 类型,page:页面，action:功能
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    /**
     * 资源路径
     * @return url 资源路径
     */
    public String getUrl() {
        return url;
    }

    /**
     * 资源路径
     * @param url 资源路径
     */
    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
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
        sb.append(", name=").append(name);
        sb.append(", title=").append(title);
        sb.append(", type=").append(type);
        sb.append(", url=").append(url);
        sb.append(", createAt=").append(createAt);
        sb.append(", updateAt=").append(updateAt);
        sb.append(", isDeleted=").append(isDeleted);
        sb.append("]");
        return sb.toString();
    }
}