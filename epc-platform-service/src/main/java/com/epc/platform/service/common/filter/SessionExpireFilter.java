package com.epc.platform.service.common.filter;


import com.alibaba.fastjson.JSONObject;
import com.epc.common.constants.Const;
import com.epc.common.util.CookieUtil;
import com.epc.common.util.RedisShardedPoolUtil;
import com.epc.platform.service.domain.admin.SysAdminUser;
import org.apache.commons.lang.StringUtils;
import org.springframework.context.annotation.Configuration;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * <p>Description : 过滤器判断用户是否已登录
 * <p>Date : 2018-09-14 09:40
 * <p>@Author : wjq
 */
@Configuration
public class SessionExpireFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest)servletRequest;

        String loginToken = CookieUtil.readLoginToken(httpServletRequest);

        if(StringUtils.isNotEmpty(loginToken)){
            //判断logintoken是否为空或者""；
            //如果不为空的话，符合条件，继续拿user信息

            String userJsonStr = RedisShardedPoolUtil.get(loginToken);
            SysAdminUser user = JSONObject.parseObject(userJsonStr, SysAdminUser.class);
            if(user != null){
                //如果user不为空，则重置session的时间，即调用expire命令
                RedisShardedPoolUtil.expire(loginToken, Const.RedisCacheExtime.REDIS_SESSION_EXTIME);
            }
        }
        filterChain.doFilter(servletRequest,servletResponse);
    }


    @Override
    public void destroy() {

    }
}
