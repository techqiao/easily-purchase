package com.epc.web.facade.agency.handle;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;
import java.util.Date;

@Data
public class HandleExpert implements Serializable {

    private static final long serialVersionUID = 7406506628828438303L;
    private String name;

    private String cellphone;

    private String profession;

    private String positional;

    private String level;

    private Date circularDt;

    private String circularMethod;

    private Integer invitertype;

    private Long inviterid;

    private String password;

    private String invterCompanyId;

    private String source;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getPositional() {
        return positional;
    }

    public void setPositional(String positional) {
        this.positional = positional;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public Date getCircularDt() {
        return circularDt;
    }

    public void setCircularDt(Date circularDt) {
        this.circularDt = circularDt;
    }

    public String getCircularMethod() {
        return circularMethod;
    }

    public void setCircularMethod(String circularMethod) {
        this.circularMethod = circularMethod;
    }

    public Integer getInvitertype() {
        return invitertype;
    }

    public void setInvitertype(Integer invitertype) {
        this.invitertype = invitertype;
    }

    public Long getInviterid() {
        return inviterid;
    }

    public void setInviterid(Long inviterid) {
        this.inviterid = inviterid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getInvterCompanyId() {
        return invterCompanyId;
    }

    public void setInvterCompanyId(String invterCompanyId) {
        this.invterCompanyId = invterCompanyId;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }
}
