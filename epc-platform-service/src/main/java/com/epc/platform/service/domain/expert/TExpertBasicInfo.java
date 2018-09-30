package com.epc.platform.service.domain.expert;

import java.io.Serializable;
import java.util.Date;

/**
 * 描述:t_expert_basic_info表的实体类
 * @version
 * @author:  01
 * @创建时间: 2018-09-30
 */
public class TExpertBasicInfo implements Serializable {
    /**
     * 主键ID
     */
    private Long id;

    /**
     * 评标专家姓名
     */
    private String name;

    /**
     * 手机号(登录账号)
     */
    private String cellphone;

    /**
     * 登录密码
     */
    private String password;

    /**
     * 专业
     */
    private String profession;

    /**
     * 职称
     */
    private String positional;

    /**
     * 级别
     */
    private String level;

    /**
     * 0-繁忙, 1-空闲
     */
    private Integer isIdle;

    /**
     * 通知时间
     */
    private Date circularDt;

    /**
     * 通知方式
     */
    private String circularMethod;

    /**
     * 其他信息
     */
    private String otherInformation;

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
     * 0-已注册, 1-完善中, 2-已提交, 3-审核通过, 4-审核失败
     */
    private Integer state;

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
     * t_expert_basic_info
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
     * 评标专家姓名
     * @return name 评标专家姓名
     */
    public String getName() {
        return name;
    }

    /**
     * 评标专家姓名
     * @param name 评标专家姓名
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 手机号(登录账号)
     * @return cellphone 手机号(登录账号)
     */
    public String getCellphone() {
        return cellphone;
    }

    /**
     * 手机号(登录账号)
     * @param cellphone 手机号(登录账号)
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
     * 专业
     * @return profession 专业
     */
    public String getProfession() {
        return profession;
    }

    /**
     * 专业
     * @param profession 专业
     */
    public void setProfession(String profession) {
        this.profession = profession == null ? null : profession.trim();
    }

    /**
     * 职称
     * @return positional 职称
     */
    public String getPositional() {
        return positional;
    }

    /**
     * 职称
     * @param positional 职称
     */
    public void setPositional(String positional) {
        this.positional = positional == null ? null : positional.trim();
    }

    /**
     * 级别
     * @return level 级别
     */
    public String getLevel() {
        return level;
    }

    /**
     * 级别
     * @param level 级别
     */
    public void setLevel(String level) {
        this.level = level == null ? null : level.trim();
    }

    /**
     * 0-繁忙, 1-空闲
     * @return is_idle 0-繁忙, 1-空闲
     */
    public Integer getIsIdle() {
        return isIdle;
    }

    /**
     * 0-繁忙, 1-空闲
     * @param isIdle 0-繁忙, 1-空闲
     */
    public void setIsIdle(Integer isIdle) {
        this.isIdle = isIdle;
    }

    /**
     * 通知时间
     * @return circular_dt 通知时间
     */
    public Date getCircularDt() {
        return circularDt;
    }

    /**
     * 通知时间
     * @param circularDt 通知时间
     */
    public void setCircularDt(Date circularDt) {
        this.circularDt = circularDt;
    }

    /**
     * 通知方式
     * @return circular_method 通知方式
     */
    public String getCircularMethod() {
        return circularMethod;
    }

    /**
     * 通知方式
     * @param circularMethod 通知方式
     */
    public void setCircularMethod(String circularMethod) {
        this.circularMethod = circularMethod == null ? null : circularMethod.trim();
    }

    /**
     * 其他信息
     * @return other_information 其他信息
     */
    public String getOtherInformation() {
        return otherInformation;
    }

    /**
     * 其他信息
     * @param otherInformation 其他信息
     */
    public void setOtherInformation(String otherInformation) {
        this.otherInformation = otherInformation == null ? null : otherInformation.trim();
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
     * 0-已注册, 1-完善中, 2-已提交, 3-审核通过, 4-审核失败
     * @return state 0-已注册, 1-完善中, 2-已提交, 3-审核通过, 4-审核失败
     */
    public Integer getState() {
        return state;
    }

    /**
     * 0-已注册, 1-完善中, 2-已提交, 3-审核通过, 4-审核失败
     * @param state 0-已注册, 1-完善中, 2-已提交, 3-审核通过, 4-审核失败
     */
    public void setState(Integer state) {
        this.state = state;
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
        sb.append(", cellphone=").append(cellphone);
        sb.append(", password=").append(password);
        sb.append(", profession=").append(profession);
        sb.append(", positional=").append(positional);
        sb.append(", level=").append(level);
        sb.append(", isIdle=").append(isIdle);
        sb.append(", circularDt=").append(circularDt);
        sb.append(", circularMethod=").append(circularMethod);
        sb.append(", otherInformation=").append(otherInformation);
        sb.append(", inviterType=").append(inviterType);
        sb.append(", inviterId=").append(inviterId);
        sb.append(", inviterCompanyId=").append(inviterCompanyId);
        sb.append(", state=").append(state);
        sb.append(", createAt=").append(createAt);
        sb.append(", updateAt=").append(updateAt);
        sb.append(", isForbidden=").append(isForbidden);
        sb.append(", isDeleted=").append(isDeleted);
        sb.append("]");
        return sb.toString();
    }
}