package com.epc.web.client.controller.terdering.preview.query;

import lombok.Data;

import java.io.Serializable;

/**
 * <p>Description : easilys
 * <p>Date : 2018-09-23 10:21
 * <p>@Author : luozhixin
 * <p>ClientQueryPageDTO
 */
@Data
public class ClientQueryPageDTO implements Serializable {

    /**
     * 从第几页记录开始查询
     */
    private Integer page;

    /**
     * 限制返回记录数
     */
    private Integer rows;

}
