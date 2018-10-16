package com.epc.mobile.client.controller.common;

import com.alibaba.fastjson.JSONObject;
import com.epc.common.util.CookieUtil;
import com.epc.mobile.client.controller.loginuser.vo.ClientLoginUser;
import com.github.pagehelper.PageInfo;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-18 15:46
 * <p>@Author : wjq
 */
public class BaseController {

    protected Map<String, Object> getDataTable(PageInfo<?> pageInfo) {
        Map<String, Object> rspData = new HashMap<>();
        rspData.put("rows", pageInfo.getList());
        rspData.put("total", pageInfo.getTotal());
        return rspData;
    }

    public ClientLoginUser getLoginUser() {
        ClientLoginUser loginHandle = null;

        boolean isLoginFinished = true;
        // 登陆用户模块暂未完成
        Integer fakeUserType = 4;
        //moniji "机构类型: 运营商1,代理商2,供货商3,采购商4,专家5")

        if (isLoginFinished) {
            RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
            HttpServletRequest request = ((ServletRequestAttributes) requestAttributes).getRequest();
            String userJsonStr = CookieUtil.readLoginToken(request);
            loginHandle = JSONObject.parseObject(userJsonStr, ClientLoginUser.class);
        } else {
            // region   模拟登陆用户
            loginHandle = new ClientLoginUser();
            loginHandle.setType(fakeUserType);
            switch (fakeUserType) {
                case 1:
                    loginHandle.setUserId(4L);
                    loginHandle.setBossId(4L);
                    loginHandle.setName("模拟用户win");
                    loginHandle.setBossName("模拟boss");
                    loginHandle.setCompanyName("模拟公司1");
                    loginHandle.setCellphone("13333333333");
                    loginHandle.setPassword("E10ADC3949BA59ABBE56E057F20F883E");
                    break;
                case 2:
                    loginHandle.setUserId(2L);
                    loginHandle.setBossId(2L);
                    loginHandle.setName("fjkld");
                    loginHandle.setBossName("模拟boss");
                    loginHandle.setCompanyName("模拟公司2");
                    loginHandle.setCellphone("15554955555");
                    loginHandle.setPassword("123");
                    break;
                case 3:
                    loginHandle.setUserId(9L);
                    loginHandle.setBossId(9L);
                    loginHandle.setName("模拟用户9");
                    loginHandle.setBossName("模拟boss");
                    loginHandle.setCompanyName("模拟公司3");
                    loginHandle.setCellphone("13583084444");
                    loginHandle.setPassword("123");
                    break;
                case 4:
                    loginHandle.setUserId(9L);
                    loginHandle.setBossId(9L);
                    loginHandle.setName("模拟用户9");
                    loginHandle.setBossName("模拟boss");
                    loginHandle.setCompanyName("模拟公司4");
                    loginHandle.setCellphone("13583084444");
                    loginHandle.setPassword("123");
                    break;
                default:
                    System.err.println("模拟获取登陆用户错误！");

            }
            //endregion
        }
        return loginHandle;
    }

}
