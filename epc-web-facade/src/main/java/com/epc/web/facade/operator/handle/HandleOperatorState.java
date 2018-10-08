package com.epc.web.facade.operator.handle;

import lombok.Data;

import java.io.Serializable;

@Data
public class HandleOperatorState implements Serializable {
    private static final long serialVersionUID = 2414642324210425302L;



    private Long id;

    //0-已注册, 1-完善中, 2-已提交, 3-审核通过, 4-审核失败
    private Integer state;



}
