package com.epc.ossfile.domain;

import lombok.Getter;
@Getter
public enum BusinessModelEnum {
    // 模块
    USER_INFO_FILE("user_info","user-info-file","用户证件信息"),
    BIDDING_FILE("bidding","bidding-file","投标文件"),
    TENDERING_FILE("tendering","tendering_file","招标文件"),
    PRE_QUALIFICATION("pre_qualification","pre_qualification_file","资格预审文件");
    private String modelCode;
    private String modelValue;
    private String modelDescription;

    BusinessModelEnum(String modelCode,String modeValue,String modelDescription){
        this.modelCode = modelCode;
        this.modelValue = modeValue;
        this.modelDescription = modelDescription;
    }

    public static String getModelValueByCode(String modelCode){
        for(BusinessModelEnum businessModel :BusinessModelEnum.values()){
            if(businessModel.getModelCode().equalsIgnoreCase(modelCode)){
                return businessModel.getModelValue();
            }
        }
        return null;
    }
}
