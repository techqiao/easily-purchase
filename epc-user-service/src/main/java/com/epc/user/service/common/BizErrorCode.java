/*
 * Copyright 2015 linglingqi Group Holding Ltd.
 *
 * 
 */
package com.epc.user.service.common;

import org.apache.commons.lang.enums.ValuedEnum;

public class BizErrorCode extends ValuedEnum {

    public static final BizErrorCode NULL = create("NULL", -9999999);

    public static final BizErrorCode SUCCESS = create("成功", 0);

    public static final BizErrorCode RECORD_NOT_EXISTED = create("记录不存在,或状态已变更", 0);

    //通用失败
    public static final BizErrorCode COMMON_ERROR = create("通用失败", -1);

    public static final BizErrorCode PARAM_ERROR = create("参数不正确", 100);

    public static final BizErrorCode DB_ERROR = create("数据库异常", 501);

    public static final BizErrorCode BASIC_INFO_ERROR = create("用户基本信息不正常", 601);

    public static final BizErrorCode PRODUCT_LIMIT_ERROR = create("商品限时购买,亲，请到点再来.", 602);

    public static final BizErrorCode OLD_PASSWORD_WRONG = create("旧密码输入错误.", 603);
    public static final BizErrorCode PASSWORD_FORMAT_WRONG = create("密码格式错误.", 605);
    public static final BizErrorCode HAS_JOINED_US = create("已经加入我们.不需要重新加入", 604);
    public static final BizErrorCode JOIN_ON_GOING = create("已经申请加入我们，等待审核中.", 606);
    public static final BizErrorCode REGISTER_BEGIN_TIME_NOT_ALLOW = create("注册入校时间不能大于当前时间.", 607);
    public static final BizErrorCode USER_ID_NO_EMPTY_ERROR = create("用户身份证信息为空,不能购买", 608);

    public static final BizErrorCode CANNOT_JOIN_WAITHOUT_AGING = create("无法申请加入我们，需进行分期购买后才能加入我们.", 609);

    public static final BizErrorCode USER_NOT_IN_WHITE_LIST = create("手机号码不在白名单中", 610);
    public static final BizErrorCode USER_PASSED_MODIFY_FORBID = create("用户已经通过审核，不允许修改信息", 612);

    public static final BizErrorCode USER_UN_CERTIFICATION = create("亲,你还没有认证哦", 613);
    public static final BizErrorCode BINDING_INFOR_NOT_EXISTS = create("用户未绑定银行卡", 615);
    public static final BizErrorCode PAY_ONGOING = create("正在支付中", 616);
    public static final BizErrorCode NO_FRONT_USER_REGISTER = create("用户还没有注册零零期帐号,请先去注册", 620);

    public static final BizErrorCode USER_ALREADY_CENSORED = create("用户已经被审核过,不能重复提交审核", 621);
    public static final BizErrorCode CASHAPPLY_CANNOT_PAY = create("订单状态已经关闭或者改变，与实际可打款条目数不一致", 622);
    public static final BizErrorCode ACCOUNT_ERROR = create("用户账户信息异常", 623);

    public static final BizErrorCode STAFF_EXISTS = create("该员工已经存在，不需要再添加", 1001);

    public static final BizErrorCode ORDER_STATUS_INVALID = create("当前订单状态不允许进行该操作", 1002);

    public static final BizErrorCode PINGAN_ONLY_SUPORT_BANK_CARD = create("平安支付只能选择银行卡绑卡通道", 1003);

    public static final BizErrorCode ALIPAY_ONLY_SUPORT_ALI_ACCOUNT = create("支付宝支付只能选择支付宝或众想通道", 1004);

    //优惠券错误码,从801-840
    public static final BizErrorCode NOT_LOGIN = create("NOT_LOGIN", "未登录", 801);
    public static final BizErrorCode NO_PHONE = create("NO_PHONE", "手机号为空", 802);
    public static final BizErrorCode NO_COUPON = create("NO_COUPON", "没有选择优惠券", 803);
    public static final BizErrorCode PHONES_OVER_LIMIT = create("PHONES_OVER_LIMIT", "手机号码数量超过限制",
            804);
    public static final BizErrorCode COUPON_OVER_LIMIT = create("COUPON_OVER_LIMIT", "优惠券数量超过限制",
            805);
    public static final BizErrorCode PHONE_IS_ERROR = create("PHONE_IS_ERROR", "手机号不正确", 806);
    public static final BizErrorCode NO_VALID_RED_ENVELOPE = create("NO_VALID_RED_ENVELOPE", "没有有效的红包",
            807);
    public static final BizErrorCode NO_VALID_SERVICE_FEE_DISCOUNT = create("NO_VALID_SERVICE_FEE_DISCOUNT",
            "没有有效的还款券", 808);
    public static final BizErrorCode NO_VALID_SHOP_COUPON = create("NO_VALID_SHOP_COUPON",
            "没有有效的店铺优惠券", 809);
    public static final BizErrorCode REMAIN_NOT_ENOUGH = create("REMAIN_NOT_ENOUGH", "余量不足", 810);
    public static final BizErrorCode RULE_HAS_ERROR = create("RULE_HAS_ERROR", "规则有误", 811);
    public static final BizErrorCode RECEIVE_LIMIT_OVER = create("RECEIVE_LIMIT_OVER", "超过领取限制",
            812);
    public static final BizErrorCode USER_RED_ENVELOPE_INSERT_FAIL = create("USER_RED_ENVELOPE_INSERT_FAIL",
            "用户红包插入失败", 813);
    public static final BizErrorCode USER_SERVICE_FEE_DISCOUNT_INSERT_FAIL = create(
            "USER_SERVICE_FEE_DISCOUNT_INSERT_FAIL", "用户还款券插入失败", 814);

    public static final BizErrorCode USER_SHOP_COUPON_INSERT_FAIL = create("USER_SHOP_COUPON_INSERT_FAIL",
            "用户店铺优惠券插入失败", 815);
    public static final BizErrorCode GRANT_FAIL = create("GRANT_FAIL", "发放失败", 816);
    public static final BizErrorCode REMAIN_UPDATE_FAIL = create("REMAIN_UPDATE_FAIL", "余量更新失败", 817);

    public static final BizErrorCode NO_MESSAGE_CONTENT = create("NO_MESSAGE_CONTENT", "没有短信内容", 818);
    public static final BizErrorCode MESSAGE_CONTENT_TOO_LONG = create("MESSAGE_CONTENT_TOO_LONG", "短信内容过长", 819);
    public static final BizErrorCode WAS_LOANED = create("WAS_LOANED", "已有贷款记录", 820);
    public static final BizErrorCode USER_ID_IS_ERROR = create("USER_ID_IS_ERROR", "用户id不正确", 821);
    public static final BizErrorCode NO_USER_ID = create("NO_USER_ID", "用户id为空", 822);
    public static final BizErrorCode SKU_IS_EXISTED = create("SKU_IS_EXISTED", "不能重复关联sku", 823);
    public static final BizErrorCode ORDER_IS_NOT_EXISTED = create("ORDER_IS_NOT_EXISTED", "订单不存在", 824);
    public static final BizErrorCode ORDER_NOT_PAY = create("ORDER_NOT_PAY", "订单未支付", 825);
    public static final BizErrorCode PRODUCT_IS_NOT_NORMAL = create("PRODUCT_IS_NOT_NORMAL", "商品异常", 826);
    public static final BizErrorCode CHARGE_PRODUCT_TYPE_ERROR = create("CHARGE_PRODUCT_TYPE_ERROR", "充值类型错误", 827);
    public static final BizErrorCode CHARGE_FAIL = create("CHARGE_FAIL", "充值失败", 828);

    public static final BizErrorCode REMOTE_INVOKER_FAILD = create("REMOTE_INVOKER_FAILD", "远程调用失败", 900);

    public static final BizErrorCode JD_INVOKER_FAILD = create("JD_INVOKER_FAILD", "京东接口异常", 910);

    public static final BizErrorCode EXPORT_DATA_TOO_LARGE = create("EXPORT_DATA_TOO_LARGE", "数据导出量太大了，请选择好条件", 911);

    public static final BizErrorCode JD_ORDER_CREATE_FAILD = create("JD_ORDER_CREATE_FAILD", "客户填写地址信息有误,京东订单未创建.", 912);

    public static final BizErrorCode CHARGE_TYPE_ERROR = create("CHARGE_TYPE_ERROR", "只支持充值福禄商品", 913);
    public static final BizErrorCode PRODUCT_SKU_IS_EMPTY = create("PRODUCT_SKU_IS_EMPTY", "没有可用的商品sku", 914);
    public static final BizErrorCode DEAL_SAME_PRODUCT_ONCE = create("DEAL_SAME_PRODUCT_ONCE", "只能处理相同的商品", 915);
    public static final BizErrorCode TEMPLATE_IS_REPEAT = create("TEMPLATE_IS_REPEAT", "同一商品的模板不能重复", 916);
    public static final BizErrorCode CHANNEL_IS_UNDEFINED = create("CHANNEL_IS_UNDEFINED", "不存在该渠道的商品", 917);
    public static final BizErrorCode VALUE_TYPE_IS_NULL = create("VALUE_TYPE_IS_NULL", "值类型不能为空", 918);
    public static final BizErrorCode VALUE_TYPE_IS_NOT_SUPPORT = create("VALUE_TYPE_IS_NOT_SUPPORT", "值类型暂不支持", 919);
    public static final BizErrorCode VALUE_TYPE_IS_UNDEFINED = create("VALUE_TYPE_IS_UNDEFINED", "值类型未定义", 920);
    public static final BizErrorCode FETCH_A_SURE_VALUE = create("FETCH_A_SURE_VALUE", "请填写正确的值", 921);
    public static final BizErrorCode PRODUCT_WAS_NOT_EXISTED = create("PRODUCT_WAS_NOT_EXISTED", "商品不存在", 922);
    public static final BizErrorCode PRODUCT_CHANNEL_DIFF = create("PRODUCT_CHANNEL_DIFF", "商品渠道不一致", 923);
    public static final BizErrorCode SHOP_CANNOT_USED = create("SHOP_CANNOT_USED", "店铺不存在或被禁用", 924);
    public static final BizErrorCode SELLER_NOT_EXISTED = create("SELLER_NOT_EXISTED", "卖家不存在或状态异常", 925);

    public static final BizErrorCode BATCH_DELIVERY_SIZE_OVER = create("BATCH_DELIVERY_SIZE_OVER", "批量发货数量不能超过200个", 924);

    public static final BizErrorCode V2_PASS_FORIBD_NANTIAO = create("V2_PASS_FORIBD_NANTIAO", "该用户已经通过审核，不能改成该标签", 926);

    public static final BizErrorCode READ_NO_EXCEL_FROM_REQUEST = create("READ_NO_EXCEL_FROM_REQUEST", "请求参数中没有excel上传", 927);

    public static final BizErrorCode READ_NO_CONTENTS_FROM_EXCEL = create("READ_NO_CONTENTS_FROM_EXCEL", "未读取到表格内容", 928);

    public static final BizErrorCode COLLECTION_MODEL_NOT_EXISTED = create("COLLECTION_MODEL_NOT_EXISTED", "催收模板不存在", 929);

    public static final BizErrorCode COLLECTION_EXCEL_FILED_IS_UNDEFINED = create("COLLECTION_EXCEL_FILED_IS_UNDEFINED", "催收模板未定义", 930);

    public static final BizErrorCode NOTHING_TO_DO_FOR_UPDATE_COLLECTION_CONTENT = create("NOTHING_TO_DO_FOR_UPDATE_COLLECTION_CONTENT", "没有修改内容", 931);

    public static final BizErrorCode UPDATE_COLLECTION_CONTENT_IS_RUNNING = create("UPDATE_COLLECTION_CONTENT_IS_RUNNING", "上次修改尚未结束，稍后再试", 932);

    public static final BizErrorCode CERT_CENSOR_EXIT = create("USER_AUTHENTICATION_HAS_BEEN_SUBMITTED", "该用户认证产品已提交,不允许重置", 933);

    private String errorName;

    public BizErrorCode(String name, int value) {
        super(name, value);
    }

    /**
     * 中文提示没有初始化
     *
     * @param errorName 英文错误提示
     * @param name      中文错误提示
     * @param value     错误码
     */
    public BizErrorCode(String errorName, String name, int value) {
        super(name, value);
        this.errorName = errorName;

    }

    public static BizErrorCode create(String name, int value) {
        return new BizErrorCode(name, value);
    }

    public static BizErrorCode create(String errorName, String name, int value) {
        return new BizErrorCode(errorName, name, value);
    }

    /**
     * 获取错误码
     *
     * @return
     */
    public int getCode() {
        return this.getValue();
    }

    /**
     * 获取描述信息
     *
     * @return
     */
    public String getDesc() {
        return this.getName();
    }

    public String getErrorName() {
        return this.errorName;
    }
}
