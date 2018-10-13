package com.epc.web.facade.bidding.dto;

import com.epc.web.facade.bidding.vo.BankAccountVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
/**
 * @Description: 支付情况
 * @Author: linzhixiang
 * @Date: 2018/10/13
 */ 
@Data
@ApiModel("支付情况")
public class IsPayDTO implements Serializable {
    private static final long serialVersionUID = 6965372380199209329L;
    @ApiModelProperty("是否支付成功")
    private  Boolean isPay;
    @ApiModelProperty("需要支付金额")
    private BigDecimal money;
    @ApiModelProperty("招标文件路径")
    private String filePath;
    @ApiModelProperty("对公银行账户")
    private BankAccountVO bankAccountVO;
}
