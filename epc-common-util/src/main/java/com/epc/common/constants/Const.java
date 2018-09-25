package com.epc.common.constants;


/**
 * <p>Description : 常量
 * <p>Date : 2018-09-09 00:03
 * <p>@Author : wjq
 */
public class Const {

    public interface RedisCacheExtime {
        int REDIS_SESSION_EXTIME = 60 * 30;//30分钟
    }

    public interface Role {
        int ROLE_CORPORATION = 0;// 法人
        int ROLE_ADMIN = 1;//管理员
        int ROLE_CUSTOMER = 2; //普通用户
    }

    public interface REDIS_LOCK {
        String CLOSE_ORDER_TASK_LOCK = "CLOSE_ORDER_TASK_LOCK";//关闭订单的分布式锁
    }

    public interface IS_DELETED {
        int IS_DELETED = 1;
        int NOT_DELETED = 0;
    }

    public interface STATE {
        int REGISTERED = 0;
        int PERFECTING = 1;
        int COMMITTED = 2;
        int AUDIT_SUCCESS = 3;
        int AUDIT_FAILD = 4;
    }

    public interface RESOURCE_TYPE {
        String PAGE = "page";
        String ACTION = "action";
    }

    public interface IS_OTHER_AGENCY {
        //不全权委托代理结构
        int NOT_OTHER_AGENCY = 0;
        int IS_OTHER_AGENCY = 1;
    }

    public interface WIN_SORT {
        String FIRST = "first";
        String SECOND = "second";
        String THREE = "three";
    }

    public interface IS_UNDER_LINE{
        int DOWN = 0;//线下
        int UP = 1;//线上
        int UP_DOWN = 3;//线上线下
    }
}
