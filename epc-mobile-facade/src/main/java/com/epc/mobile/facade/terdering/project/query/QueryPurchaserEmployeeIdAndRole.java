package com.epc.mobile.facade.terdering.project.query;

import lombok.Data;

import java.io.Serializable;

@Data
public class QueryPurchaserEmployeeIdAndRole implements Serializable {
    private static final long serialVersionUID = -1647025101063884949L;

    //  传过来的数据 ,通过此数据去查询出相关的数据，组成列表


    /**
     * 当前登陆人的id
     */
    private Long id;

    /**
     * 当前 人必须 是采购人员工
     */
//    private int purchaser;

    /**
     * 当前登陆人的角色
     */
    private Integer role;

//    /**
//     * 项目还是采购项目
//     *  与前端 约定 0是项目，1是采购项目
//     */
//    private Integer pro;





}
