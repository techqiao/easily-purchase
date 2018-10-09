package com.epc.common.constants;


/**
 * <p>Description : 常量
 * <p>Date : 2018-09-09 00:03
 * <p>@Author : wjq
 */
public class Const {

    public interface RedisCacheExtime {
        int REDIS_SESSION_EXTIME = 60 * 30*30000;//30分钟
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

    public interface PASSWORD{
        String PASSWORD="epc1688";

    }
    public interface IS_OK {
        int IS_OK = 1;
        int NOT_OK = 0;
    }
    /**
     *@author :winlin
     *@Description : 默认密码
     *@param:
     *@return:
     *@date:2018/10/5
     */
    public interface DEFAULT_PASSWORD{
        String PASSWORD ="epc1688";
    }
    /**
     *@author :winlin
     *@Description : 启用或禁用
     *@param:
     *@return:
     *@date:2018/9/29
     */
    public interface ENABLE_OR_DISABLE{
        int ENABLE= 0;
        int DISABLE=1;
    }

    /**
     *@author :winlin
     *@Description : 来源
     *@param:
     *@return:
     *@date:2018/10/4
     */
    public interface SOURCE{
        String PUBLICS = "publics";
        String PRIVATES ="privates";
    }

    public interface STATE {
        int REGISTERED = 1;//拉取
        int PERFECTING = 2;//资料完善中
        int COMMITTED = 3;//审核中
        int FORBIDDEN =4;//禁用
        int AUDIT_SUCCESS = 5;//审核通过
        int AUDIT_FAILD = 6;//审核失败
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


    public interface IS_UNDER_LINE{
        int DOWN = 0;//线下
        int UP = 1;//线上
        int UP_DOWN = 3;//线上线下
    }


    /**
     * 邀请人类型,0-采购人, 1-运营商, 2-供应商, 3-代理机构,4-平台
     */
    public interface INVITER_TYPE{
        int PURCHASER=0;
        int OPERATOR=1;
        int SUPPLIER=2;
        int PROXY=3;
        int PLATFORM=4;
        int PLATFORM_ID =99999999;

    }

    public interface OPEN_STATUS {
        //开标记录状态
        int ABNORMA=0;
        int NORMA=1;
    }

    /**
     * loginUser,
     * 运营商1,
     * 代理商2,
     * 供货商3,
     * 采购商4
     * 评审专家5
     */
    public interface LOGIN_USER_TYPE{
        int OPERATOR=1;
        int PROXY=2;
        int SUPPLIER=3;
        int PURCHASER=4;
        int EXPERT=5;
    }



    public interface ACTION_STATE{
        //暂未到达此步
        int NOT_ARRIVING=0;
        //待办
        int NEED_DEAL=1;
        //完成
        int COMPLETE=2;
        //打回到此步
        int PURCHASER=-1;

    }


    public interface IS_IDLE_OR_NOT{
        int IS_IDLE=1;
        int NOT_IDLE=0;
    }
    /**
     *@author :winlin
     *@Description :
     *@param:
     *@return:
     *@date:2018/10/1
     */
    public interface TRUST_OR_NOT{
        String TRUST ="white_list";
        String NOT_TRUST="black_list";
    }

    public interface STATE_CODE{
        int  PULLING =1;//拉取
        int  COMPLETING_INFO =2;//完善信息
        int CHECKING =3;//审核中
        int FORBIDDEN =4;//禁用
        int AUDIT_SUCCESS=5;//审核通过
    }

}
