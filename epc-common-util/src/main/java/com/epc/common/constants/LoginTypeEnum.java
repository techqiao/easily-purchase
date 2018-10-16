package com.epc.common.constants;

public enum LoginTypeEnum {
    SUPPLIER("supplier","供应商"),
    PURCHASER("purchaser","采购人"),
    OPERATOR("operator","运营商"),
    AGENCY("agency","代理机构"),
    EXPERT("expert","专家");

    private String code;
    private String desc;
    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    LoginTypeEnum(String code,String desc){
       this.code = code;
        this.desc = desc;
    }

}
