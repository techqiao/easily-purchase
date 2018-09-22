package com.epc.web.facade.supplier.handle;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class HandleSupplierAll implements Serializable {
    private static final long serialVersionUID = -4686240317454177900L;

    //主键id
    private Long id;

   //员工姓名
    private String name;

    //手机号(登录账号)
    private String cellphone;

    //登录密码
    private String password;

    //0-已注册, 1-完善中, 2-已提交, 3-审核通过, 4-审核失败
    private Integer state;

    //供应商ID
    private Long supplierId;

    //供应商姓名
    private String supplierName;

    //统一信用代码
    private String uniformCreditCode;

    //对公银行名称
    private String publicBankName;

    //对公银行账号
    private String publicBanAccountNumber;

    //来源(public,private)
    private String source;

    //操作人ID
    private String operatorId;

    // 创建时间
    private Date createAt;

    // 最后修改时间
    private Date updateAt;

    //是否删除: 0-存在,1-删除
    private Integer isDeleted;

    //供应商的公司名字
    private String companyName;

}
