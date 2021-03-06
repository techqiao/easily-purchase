package com.epc.platform.service.domain.expert;

import java.io.Serializable;
import java.util.Date;

/**
 * 描述:t_expert_detail_info表的实体类
 * @version
 * @author:  01
 * @创建时间: 2018-10-10
 */
public class TExpertDetailInfo implements Serializable {
    /**
     * 主键ID
     */
    private Long id;

    /**
     * 专家基础信息表ID
     */
    private Long expertId;

    /**
     * 公司名称
     */
    private String companyName;

    /**
     * 省
     */
    private String province;

    /**
     * 市
     */
    private String city;

    /**
     * 区
     */
    private String area;

    /**
     * 公司地址
     */
    private String companyAddress;

    /**
     * 统一信用代码
     */
    private String uniformCreditCode;

    /**
     * 对公银行名称
     */
    private String publicBankName;

    /**
     * 对公银行账号
     */
    private String publicBanAccountNumber;

    /**
     * 扩展字段
     */
    private String extendedField;

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
     * t_expert_detail_info
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
     * 专家基础信息表ID
     * @return expert_id 专家基础信息表ID
     */
    public Long getExpertId() {
        return expertId;
    }

    /**
     * 专家基础信息表ID
     * @param expertId 专家基础信息表ID
     */
    public void setExpertId(Long expertId) {
        this.expertId = expertId;
    }

    /**
     * 公司名称
     * @return company_name 公司名称
     */
    public String getCompanyName() {
        return companyName;
    }

    /**
     * 公司名称
     * @param companyName 公司名称
     */
    public void setCompanyName(String companyName) {
        this.companyName = companyName == null ? null : companyName.trim();
    }

    /**
     * 省
     * @return province 省
     */
    public String getProvince() {
        return province;
    }

    /**
     * 省
     * @param province 省
     */
    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    /**
     * 市
     * @return city 市
     */
    public String getCity() {
        return city;
    }

    /**
     * 市
     * @param city 市
     */
    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    /**
     * 区
     * @return area 区
     */
    public String getArea() {
        return area;
    }

    /**
     * 区
     * @param area 区
     */
    public void setArea(String area) {
        this.area = area == null ? null : area.trim();
    }

    /**
     * 公司地址
     * @return company_address 公司地址
     */
    public String getCompanyAddress() {
        return companyAddress;
    }

    /**
     * 公司地址
     * @param companyAddress 公司地址
     */
    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress == null ? null : companyAddress.trim();
    }

    /**
     * 统一信用代码
     * @return uniform_credit_code 统一信用代码
     */
    public String getUniformCreditCode() {
        return uniformCreditCode;
    }

    /**
     * 统一信用代码
     * @param uniformCreditCode 统一信用代码
     */
    public void setUniformCreditCode(String uniformCreditCode) {
        this.uniformCreditCode = uniformCreditCode == null ? null : uniformCreditCode.trim();
    }

    /**
     * 对公银行名称
     * @return public_bank_name 对公银行名称
     */
    public String getPublicBankName() {
        return publicBankName;
    }

    /**
     * 对公银行名称
     * @param publicBankName 对公银行名称
     */
    public void setPublicBankName(String publicBankName) {
        this.publicBankName = publicBankName == null ? null : publicBankName.trim();
    }

    /**
     * 对公银行账号
     * @return public_ban_account_number 对公银行账号
     */
    public String getPublicBanAccountNumber() {
        return publicBanAccountNumber;
    }

    /**
     * 对公银行账号
     * @param publicBanAccountNumber 对公银行账号
     */
    public void setPublicBanAccountNumber(String publicBanAccountNumber) {
        this.publicBanAccountNumber = publicBanAccountNumber == null ? null : publicBanAccountNumber.trim();
    }

    /**
     * 扩展字段
     * @return extended_field 扩展字段
     */
    public String getExtendedField() {
        return extendedField;
    }

    /**
     * 扩展字段
     * @param extendedField 扩展字段
     */
    public void setExtendedField(String extendedField) {
        this.extendedField = extendedField == null ? null : extendedField.trim();
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
        sb.append(", expertId=").append(expertId);
        sb.append(", companyName=").append(companyName);
        sb.append(", province=").append(province);
        sb.append(", city=").append(city);
        sb.append(", area=").append(area);
        sb.append(", companyAddress=").append(companyAddress);
        sb.append(", uniformCreditCode=").append(uniformCreditCode);
        sb.append(", publicBankName=").append(publicBankName);
        sb.append(", publicBanAccountNumber=").append(publicBanAccountNumber);
        sb.append(", extendedField=").append(extendedField);
        sb.append(", createAt=").append(createAt);
        sb.append(", updateAt=").append(updateAt);
        sb.append(", isDeleted=").append(isDeleted);
        sb.append("]");
        return sb.toString();
    }
}