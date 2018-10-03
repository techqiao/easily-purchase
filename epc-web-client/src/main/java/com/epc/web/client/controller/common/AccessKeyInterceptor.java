package com.epc.web.client.controller.common;

import com.epc.common.util.RedisShardedPoolUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class AccessKeyInterceptor extends HandlerInterceptorAdapter {

    /**
     * preHandle方法是进行处理器拦截用的，顾名思义，该方法将在Controller处理之前进行调用，
     * SpringMVC中的Interceptor拦截器是链式的，可以同时存在多个Interceptor，
     * 然后SpringMVC会根据声明的前后顺序一个接一个的执行，
     * 而且所有的Interceptor中的preHandle方法都会在Controller方法调用之前调用。
     * SpringMVC的这种Interceptor链式结构也是可以进行中断的，
     * 这种中断方式是令preHandle的返回值为false，当preHandle的返回值为false的时候整个请求就结束了。
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.addHeader("Access-Control-Allow-Headers", "origin, content-type, accept, authorization, referer, login-token, X-Requested-With");
        response.setHeader("Access-Control-Allow-Origin", "http://localhost:8010");
        response.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD");
        response.setHeader("Access-Control-Max-Age", "3600");
//        String header = request.getHeader("epc-token");
//        if (null != handler) {
//            String s = RedisShardedPoolUtil.get("EPC_PRIVATE_" + header);
//            if (null != s) {
//                return true;
//            }
//        }
//        response.setContentType(";charset=UTF-8");
//        response.setHeader("Pragma", "No-cache");
//        response.setHeader("Cache-Control", "no-cache");
//        response.setDateHeader("Expires", 0);
//        PrintWriter writer = null;
//        try {
//            writer = response.getWriter();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        writer.write("to Login please");
//        writer.flush();
        return true;
    }

    /**
     * 这个方法只会在当前这个Interceptor的preHandle方法返回值为true的时候才会执行。
     * postHandle是进行处理器拦截用的，它的执行时间是在处理器进行处理之 后， 也就是在Controller的方法调用之后执行，
     * 然后要在Interceptor之前调用的内容都写在调用invoke之前，要在Interceptor之后调用的内容都写在调用invoke方法之后。
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
    }

    /**
     * 该方法也是需要当前对应的Interceptor的preHandle方法的返回值为true时才会执行
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
                                Exception ex) {
    }
}
