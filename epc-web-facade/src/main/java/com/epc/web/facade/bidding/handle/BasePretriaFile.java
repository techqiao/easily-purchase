package com.epc.web.facade.bidding.handle;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
/** 
* @Description: 上传文件
* @Author: linzhixiang
* @Date: 2018/9/19 
*/
@Data
public class BasePretriaFile implements Serializable {
    private static final long serialVersionUID = -2062443423483279136L;
    private Long id;
    private String filePath;
    private String fileName;
    private String fileType;
    private int isDeleted;
}
