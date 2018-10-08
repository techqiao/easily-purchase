package com.epc.platform.service.domain.dictionary;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * 描述：系统字典类，用于管理某些类型
 * @auth SongXing
 * @创建时间 2018-10-6 13:05:16
 */

@Data
public class SysDictionary implements Serializable {
    private static final long serialVersionUID = -6894086716507147158L;
    /*
    * 字典Id
    * */
    private Long dictId;

    /*
    * 文本(显示)
    * */
    private String text;

    /*
    * 值（关联）
    * */
    private String value;

    /*
    * 全路径（查询）
    * */
    private String path;

    /*
    * 顺序（排序）
    * */
    private Float seq;

    /*
    * 类型
    * */
    private String type;

    /*
    * 创建时间
    * */
    private Date createAt;

    /*
    * 更新时间
    * */
    private Date updateAt;

    /*
    * 是否删除
    * */
    private Integer isDeleted;
}