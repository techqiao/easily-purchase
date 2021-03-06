package com.epc.tendering.service.domain.expert;

import java.io.Serializable;
import java.util.Date;

public class TExpertBasicInfo implements Serializable {
    private Long id;

    private String name;

    private String cellphone;

    private String password;

    private String profession;

    private String positional;

    private String level;

    private Integer workingYears;

    private Integer isIdle;

    private Date circularDt;

    private Date circularDtEnd;

    private String circularMethod;

    private String otherInformation;

    private Integer inviterType;

    private Long inviterId;

    private Long inviterCompanyId;

    private Integer state;

    private Date createAt;

    private Date updateAt;

    private Integer isForbidden;

    private Integer isDeleted;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone == null ? null : cellphone.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession == null ? null : profession.trim();
    }

    public String getPositional() {
        return positional;
    }

    public void setPositional(String positional) {
        this.positional = positional == null ? null : positional.trim();
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level == null ? null : level.trim();
    }

    public Integer getWorkingYears() {
        return workingYears;
    }

    public void setWorkingYears(Integer workingYears) {
        this.workingYears = workingYears;
    }

    public Integer getIsIdle() {
        return isIdle;
    }

    public void setIsIdle(Integer isIdle) {
        this.isIdle = isIdle;
    }

    public Date getCircularDt() {
        return circularDt;
    }

    public void setCircularDt(Date circularDt) {
        this.circularDt = circularDt;
    }

    public Date getCircularDtEnd() {
        return circularDtEnd;
    }

    public void setCircularDtEnd(Date circularDtEnd) {
        this.circularDtEnd = circularDtEnd;
    }

    public String getCircularMethod() {
        return circularMethod;
    }

    public void setCircularMethod(String circularMethod) {
        this.circularMethod = circularMethod == null ? null : circularMethod.trim();
    }

    public String getOtherInformation() {
        return otherInformation;
    }

    public void setOtherInformation(String otherInformation) {
        this.otherInformation = otherInformation == null ? null : otherInformation.trim();
    }

    public Integer getInviterType() {
        return inviterType;
    }

    public void setInviterType(Integer inviterType) {
        this.inviterType = inviterType;
    }

    public Long getInviterId() {
        return inviterId;
    }

    public void setInviterId(Long inviterId) {
        this.inviterId = inviterId;
    }

    public Long getInviterCompanyId() {
        return inviterCompanyId;
    }

    public void setInviterCompanyId(Long inviterCompanyId) {
        this.inviterCompanyId = inviterCompanyId;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }

    public Integer getIsForbidden() {
        return isForbidden;
    }

    public void setIsForbidden(Integer isForbidden) {
        this.isForbidden = isForbidden;
    }

    public Integer getIsDeleted() {
        return isDeleted;
    }

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
        sb.append(", workingYears=").append(workingYears);
        sb.append(", isIdle=").append(isIdle);
        sb.append(", circularDt=").append(circularDt);
        sb.append(", circularDtEnd=").append(circularDtEnd);
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