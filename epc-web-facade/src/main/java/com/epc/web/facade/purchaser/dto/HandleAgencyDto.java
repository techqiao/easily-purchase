package com.epc.web.facade.purchaser.dto;

import com.epc.web.facade.agency.handle.Attachement;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class HandleAgencyDto  implements Serializable{
    private static final long serialVersionUID = 8175917442414344896L;
    /**
     * 采购人的id
     */
    private Long purchaseId;
    /**
     * 代理机构的id
     */
    private Long agencyId;
    /**
     * 手机号
     */
    private String cellphone;
    /**
     * 密码
     */
    private String password;
    /**
     * 状态
     */
    private Integer state;
    /**
     * 法人姓名
     */
    private String name;
    /**
     * 公司名称
     */
    private String companyName;
    /**
     * 统一的信用代码
     */
    private String uniformCreditCode;
    /**
     * 对公银行name
     */
    private String publicBankName;
    /**
     * 对公银行账号
     */
    private String publicBankCount;

    /**
     * 操作人id
     */
    private long OperatorId;
    /**
     * 操作人公司的id
     */
    private long companyId;
    /**
     * 附件list
     */
    protected List<Attachement> atts;
}
