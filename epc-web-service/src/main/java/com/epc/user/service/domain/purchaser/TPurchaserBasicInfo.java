package com.epc.user.service.domain.purchaser;

import java.io.Serializable;
import java.util.Date;
/**
* @Description:    TPurchaserBasicInfo 采购人基本信息类
* @Author:         linzhixiang
* @CreateDate:     2018/9/13 11:05
* @UpdateUser:     linzhixiang
* @UpdateDate:     2018/9/13 11:05
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
public class TPurchaserBasicInfo implements Serializable {

    private Long id;

    private String name;//采购人员工姓名

    private String cellphone;//手机号

    private String password;//登录密码

    private Long purchaserId;//采购人(法人)ID

    private Integer state;//审核状态:0-已注册,1-完善中,2-已提交,3-审核通过,4-审核失败

    private Integer role;//用户角色:0-法人,1-管理员,2-普通员工

    private Date createAt;

    private Date updateAt;

    private Integer isDeleted;//是否删除: 0-存在,1-删除

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

    public Long getPurchaserId() {
        return purchaserId;
    }

    public void setPurchaserId(Long purchaserId) {
        this.purchaserId = purchaserId;
    }

    public Integer getState() {
        return state;
    }


    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
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
        sb.append(", purchaserId=").append(purchaserId);
        sb.append(", state=").append(state);
        sb.append(", role=").append(role);
        sb.append(", createAt=").append(createAt);
        sb.append(", updateAt=").append(updateAt);
        sb.append(", isDeleted=").append(isDeleted);
        sb.append("]");
        return sb.toString();
    }
}