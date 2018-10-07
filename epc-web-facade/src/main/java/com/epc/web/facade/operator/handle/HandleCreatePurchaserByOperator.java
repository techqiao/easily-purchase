package com.epc.web.facade.operator.handle;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
* @Description:    运营商录入采购人
* @Author:          linzhixiang
* @CreateDate:     2018/9/13 10:00
* @UpdateUser:     linzhixiang
* @UpdateDate:     2018/9/13 10:00
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
@Data
public class HandleCreatePurchaserByOperator implements Serializable {
    private static final long serialVersionUID = 5221353786072352076L;


    //运营商员工id
//    private Long id;
    /**
     *  是什么角色
     */
    private Integer systemRole;

    // 登陆时的用户角色
//    private Integer loginRole;

    // 当前 登陆人的法人 id
//    private Long bossId;



    //当前添加的采购人id
    private Long id;

    //采购人姓名
    private String name;

    //手机号
    private String cellphone;

    //公司名称
    private String companyName;

    //统一信用代码
    private String uniformCreditCode;

    //对公银行名称
    private String publicBankName;

    //对公银行账号
    private String publicBanAccountNumber;


    //附件表字段
    private List<Attachment> atts;




}
