package com.epc.web.facade.terdering.bid.handle;

import lombok.Data;

import java.io.Serializable;
/**
* @Description:  创建唱标记录
* @Author: linzhixiang
* @Date: 2018/9/25
*/
@Data
public class HandleBidAnnouncement implements Serializable {

    private static final long serialVersionUID = -7767001037669780657L;

    private Long purchaseProjectId;

    private Long bidsId;

    private String filePath;

    private Long operateId;

    private String creator;

}
