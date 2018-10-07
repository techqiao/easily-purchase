package com.epc.web.facade.operator.vo;

import com.epc.web.facade.operator.handle.Attachment;
import lombok.Data;

import java.io.Serializable;
import java.util.List;


@Data
public class HandleFindOperatorAllByIdVO implements Serializable {
    private static final long serialVersionUID = 5316402763450711469L;


    /**
     * operator_basic表
     */
//    private Long id;
    private String cellphone;
//    private String password;
    private String name;
    private Long operatorId;
    private Integer state;
    private Integer role;
    private String createAt;
    private String updateAt;
    private Integer isForbidden;
//    private Integer isDeleted;


    /**
     * operator_detail表
     */
    private String companyName;
    private String uniformCreditCode;
    private String publicBankName;
    private String publicBanAccountNumber;


    /**
     * operator_attachment表
     */
    private List<Attachment> atts;




}
