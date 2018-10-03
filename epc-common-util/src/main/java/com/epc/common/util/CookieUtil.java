package com.epc.common.util;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * <p>Description : CookieUtil
 * <p>Date : 2018-09-09 16:45
 * <p>@Author : wjq
 */
public class CookieUtil {
    private static final Logger log = LoggerFactory.getLogger(CookieUtil.class);

    private final static String COOKIE_DOMAIN = "epc.com";
    private final static String COOKIE_NAME = "epc_token";


    public static String readLoginToken(HttpServletRequest request){
        String header ="EPC_PRIVATE_"+ request.getHeader(COOKIE_NAME);
        if(header!=null){
            String jsonString = RedisShardedPoolUtil.get(header);
            return jsonString;
        }
        return null;
    }


    public static void writeLoginToken(HttpServletResponse response, String token){
        Cookie ck = new Cookie(COOKIE_NAME,token);
        ck.setDomain(COOKIE_DOMAIN);
        ck.setPath("/");//代表设置在根目录
        ck.setHttpOnly(true);
        //单位是秒。
        //如果这个maxage不设置的话，cookie就不会写入硬盘，而是写在内存。只在当前页面有效。
        ck.setMaxAge(60 * 60 );//如果是-1，代表永久
        log.info("write cookieName:{},cookieValue:{}",ck.getName(),ck.getValue());
        response.setHeader(COOKIE_NAME,token);
    }


    public static void delLoginToken(HttpServletRequest request,HttpServletResponse response){
        Cookie[] cks = request.getCookies();
        if(cks != null){
            for(Cookie ck : cks){
                if(StringUtils.equals(ck.getName(),COOKIE_NAME)){
                    ck.setDomain(COOKIE_DOMAIN);
                    ck.setPath("/");
                    ck.setMaxAge(0);//设置成0，代表删除此cookie。
                    log.info("del cookieName:{},cookieValue:{}",ck.getName(),ck.getValue());
                    response.addCookie(ck);
                    return;
                }
            }
        }
    }







}
