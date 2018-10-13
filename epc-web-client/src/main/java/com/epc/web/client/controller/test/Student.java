package com.epc.web.client.controller.test;


import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

public class Student implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 学生姓名
     */
    private String name;

    /**
     * 学生姓名
     */
    private String account;

    /**
     * 学生姓名
     */
    private String password;

    /**
     * 图片
     */
    private String image;

    /**
     * 是否已经毕业（0：没有毕业 1：已经毕业）
     */
    @Column(name = "is_graduated")
    private String isGraduated;

    /**
     * 微信OPENID
     */
    private String openid;

    /**
     * 微信昵称
     */
    @Column(name = "wx_nickname")
    private String wxNickname;

    /**
     * 微信账号
     */
    @Column(name = "wx_account")
    private String wxAccount;

    /**
     * 微信头像
     */
    @Column(name = "wx_headimage")
    private String wxHeadimage;

    /**
     * 是否删除（0：未删除 1：已删除）
     */
    @Column(name = "is_delete")
    private Integer isDelete;

    /**
     * 创建时间
     */
    private Date createtime;

    /**
     * 更新时间
     */
    private Date updatetime;

    /**
     * 获取主键
     *
     * @return id - 主键
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置主键
     *
     * @param id
     *            主键
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取学生姓名
     *
     * @return name - 学生姓名
     */
    public String getName() {
        return name;
    }

    /**
     * 设置学生姓名
     *
     * @param name
     *            学生姓名
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取图片
     *
     * @return image - 图片
     */
    public String getImage() {
        return image;
    }

    /**
     * 设置图片
     *
     * @param image
     *            图片
     */
    public void setImage(String image) {
        this.image = image;
    }

    /**
     * 获取是否已经毕业（0：没有毕业 1：已经毕业）
     *
     * @return is_graduated - 是否已经毕业（0：没有毕业 1：已经毕业）
     */
    public String getIsGraduated() {
        return isGraduated;
    }

    /**
     * 设置是否已经毕业（0：没有毕业 1：已经毕业）
     *
     * @param isGraduated
     *            是否已经毕业（0：没有毕业 1：已经毕业）
     */
    public void setIsGraduated(String isGraduated) {
        this.isGraduated = isGraduated;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    /**
     * 获取微信昵称
     *
     * @return wx_nickname - 微信昵称
     */
    public String getWxNickname() {
        return wxNickname;
    }

    /**
     * 设置微信昵称
     *
     * @param wxNickname
     *            微信昵称
     */
    public void setWxNickname(String wxNickname) {
        this.wxNickname = wxNickname;
    }

    /**
     * 获取微信账号
     *
     * @return wx_account - 微信账号
     */
    public String getWxAccount() {
        return wxAccount;
    }

    /**
     * 设置微信账号
     *
     * @param wxAccount
     *            微信账号
     */
    public void setWxAccount(String wxAccount) {
        this.wxAccount = wxAccount;
    }

    /**
     * 获取微信头像
     *
     * @return wx_headimage - 微信头像
     */
    public String getWxHeadimage() {
        return wxHeadimage;
    }

    /**
     * 设置微信头像
     *
     * @param wxHeadimage
     *            微信头像
     */
    public void setWxHeadimage(String wxHeadimage) {
        this.wxHeadimage = wxHeadimage;
    }

    /**
     * 获取是否删除（0：未删除 1：已删除）
     *
     * @return is_delete - 是否删除（0：未删除 1：已删除）
     */
    public Integer getIsDelete() {
        return isDelete;
    }

    /**
     * 设置是否删除（0：未删除 1：已删除）
     *
     * @param isDelete
     *            是否删除（0：未删除 1：已删除）
     */
    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    /**
     * 获取创建时间
     *
     * @return createtime - 创建时间
     */
    public Date getCreatetime() {
        return createtime;
    }

    /**
     * 设置创建时间
     *
     * @param createtime
     *            创建时间
     */
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    /**
     * 获取更新时间
     *
     * @return updatetime - 更新时间
     */
    public Date getUpdatetime() {
        return updatetime;
    }

    /**
     * 设置更新时间
     *
     * @param updatetime
     *            更新时间
     */
    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Student [id=" + id + ", name=" + name + ", account=" + account + ", password=" + password + ", image="
                + image + ", isGraduated=" + isGraduated + ", openid=" + openid + ", wxNickname=" + wxNickname
                + ", wxAccount=" + wxAccount + ", wxHeadimage=" + wxHeadimage + ", isDelete=" + isDelete
                + ", createtime=" + createtime + ", updatetime=" + updatetime + "]";
    }

}
