package com.epc.platform.service.domain.tagency;

import java.io.Serializable;
import java.util.Date;

/**
 * 描述:t_agency_basic_info表的实体类
 * @version
 * @author:  01
 * @创建时间: 2018-09-30
 */
public class TAgencyBasicInfo implements Serializable {
    /**
     * 主键ID
     */
    private Long id;

    /**
     * 招标代理机构员工姓名
     */
    private String name;

    /**
     * 招标(采购)代理机构 ID
     */
    private Long agencyId;

    /**
     * 手机号
     */
    private String cellphone;

    /**
     * 登录密码
     */
    private String password;

    /**
     * 邀请人类型,0-采购人, 1-运营商, 2-供应商, 3-代理机构,4-平台
     */
    private Integer inviterType;

    /**
     * 邀请人Id
     */
    private Long inviterId;

    /**
     * 邀请人机构ID
     */
    private Long inviterCompanyId;

    /**
     * 审核状态:0-已注册,1-完善中,2-已提交,3-审核通过,4-审核失败
     */
    private Integer state;

    /**
     * 用户角色:0-法人,1-管理员,2-普通员工
     */
    private Integer role;

    /**
     * 创建时间
     */
    private Date createAt;

    /**
     * 最后修改时间
     */
    private Date updateAt;

    /**
     * 是否禁用: 0-启用,1-禁用
     */
    private Integer isForbidden;

    /**
     * 是否删除: 0-存在,1-删除
     */
    private Integer isDeleted;

    /**
     * t_agency_basic_info
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
     * 招标代理机构员工姓名
     * @return name 招标代理机构员工姓名
     */
    public String getName() {
        return name;
    }

    /**
     * 招标代理机构员工姓名
     * @param name 招标代理机构员工姓名
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 招标(采购)代理机构 ID
     * @return agency_id 招标(采购)代理机构 ID
     */
    public Long getAgencyId() {
        return agencyId;
    }

    /**
     * 招标(采购)代理机构 ID
     * @param agencyId 招标(采购)代理机构 ID
     */
    public void setAgencyId(Long agencyId) {
        this.agencyId = agencyId;
    }

    /**
     * 手机号
     * @return cellphone 手机号
     */
    public String getCellphone() {
        return cellphone;
    }

    /**
     * 手机号
     * @param cellphone 手机号
     */
    public void setCellphone(String cellphone) {
        this.cellphone = cellphone == null ? null : cellphone.trim();
    }

    /**
     * 登录密码
     * @return password 登录密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 登录密码
     * @param password 登录密码
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * 邀请人类型,0-采购人, 1-运营商, 2-供应商, 3-代理机构,4-平台
     * @return inviter_type 邀请人类型,0-采购人, 1-运营商, 2-供应商, 3-代理机构,4-平台
     */
    public Integer getInviterType() {
        return inviterType;
    }

    /**
     * 邀请人类型,0-采购人, 1-运营商, 2-供应商, 3-代理机构,4-平台
     * @param inviterType 邀请人类型,0-采购人, 1-运营商, 2-供应商, 3-代理机构,4-平台
     */
    public void setInviterType(Integer inviterType) {
        this.inviterType = inviterType;
    }

    /**
     * 邀请人Id
     * @return inviter_id 邀请人Id
     */
    public Long getInviterId() {
        return inviterId;
    }

    /**
     * 邀请人Id
     * @param inviterId 邀请人Id
     */
    public void setInviterId(Long inviterId) {
        this.inviterId = inviterId;
    }

    /**
     * 邀请人机构ID
     * @return inviter_company_id 邀请人机构ID
     */
    public Long getInviterCompanyId() {
        return inviterCompanyId;
    }

    /**
     * 邀请人机构ID
     * @param inviterCompanyId 邀请人机构ID
     */
    public void setInviterCompanyId(Long inviterCompanyId) {
        this.inviterCompanyId = inviterCompanyId;
    }

    /**
     * 审核状态:0-已注册,1-完善中,2-已提交,3-审核通过,4-审核失败
     * @return state 审核状态:0-已注册,1-完善中,2-已提交,3-审核通过,4-审核失败
     */
    public Integer getState() {
        return state;
    }

    /**
     * 审核状态:0-已注册,1-完善中,2-已提交,3-审核通过,4-审核失败
     * @param state 审核状态:0-已注册,1-完善中,2-已提交,3-审核通过,4-审核失败
     */
    public void setState(Integer state) {
        this.state = state;
    }

    /**
     * 用户角色:0-法人,1-管理员,2-普通员工
     * @return role 用户角色:0-法人,1-管理员,2-普通员工
     */
    public Integer getRole() {
        return role;
    }

    /**
     * 用户角色:0-法人,1-管理员,2-普通员工
     * @param role 用户角色:0-法人,1-管理员,2-普通员工
     */
    public void setRole(Integer role) {
        this.role = role;
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
     * 是否禁用: 0-启用,1-禁用
     * @return is_forbidden 是否禁用: 0-启用,1-禁用
     */
    public Integer getIsForbidden() {
        return isForbidden;
    }

    /**
     * 是否禁用: 0-启用,1-禁用
     * @param isForbidden 是否禁用: 0-启用,1-禁用
     */
    public void setIsForbidden(Integer isForbidden) {
        this.isForbidden = isForbidden;
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
        sb.append(", name=").append(name);
        sb.append(", agencyId=").append(agencyId);
        sb.append(", cellphone=").append(cellphone);
        sb.append(", password=").append(password);
        sb.append(", inviterType=").append(inviterType);
        sb.append(", inviterId=").append(inviterId);
        sb.append(", inviterCompanyId=").append(inviterCompanyId);
        sb.append(", state=").append(state);
        sb.append(", role=").append(role);
        sb.append(", createAt=").append(createAt);
        sb.append(", updateAt=").append(updateAt);
        sb.append(", isForbidden=").append(isForbidden);
        sb.append(", isDeleted=").append(isDeleted);
        sb.append("]");
        return sb.toString();
    }
}