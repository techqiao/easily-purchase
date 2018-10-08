package com.epc.web.facade.bidding.handle;

import lombok.Data;

import java.io.Serializable;

@Data
public class HandleQuestion implements Serializable {

    private static final long serialVersionUID = 2633674461364958202L;

    private Long procurementProjectId;
    /**
     * 问题类型
     */
    private String questionType;
    /**
     * 记录Id
     */
    private Long typeId;
    /**
     * 提问人Id
     */
    private Long questionerId;
    /**
     * 提问人姓名
     */
    private String questionerName;

    private String problem;

    private String title;

}
