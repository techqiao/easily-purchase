package com.epc.web.facade.operator.vo;

import com.epc.web.facade.operator.handle.Attachment;
import lombok.Data;

import java.io.Serializable;
import java.util.List;


@Data
public class OperatorBasicVO implements Serializable {
    private static final long serialVersionUID = 2041338696895334089L;


    /**
     * 主键ID
     */
//    private Long id;

    /**
     * 手机号
     */
    private String cellphone;

    /**
     * 运营商员工姓名
     */
    private String name;


    /**
     * 用户角色:0-法人,1-管理员,2-普通员工
     */
    private Integer role;

    /**
     * 创建时间
     */
    private String createAt;

    /**
     * 最后修改时间
     */
    private String updateAt;


    private Long operatorId;

    private String companyName;

    private String uniformCreditCode;

    private String publicBankName;

    private String publicBanAccountNumber;

    private List<Attachment> atts;

}
