package com.epc.ossfile.filter;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class AccessKeyInterceptor extends HandlerInterceptorAdapter {

    private static Log log = LogFactory.getLog(AccessKeyInterceptor.class);
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.addHeader("Access-Control-Allow-Headers", "origin, content-type, accept, authorization, referer, login-token,epc-token, X-Requested-With");
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD");
        response.setHeader("Access-Control-Max-Age", "3600");
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
        String host = request.getRemoteHost();
        log.debug("IP为---->>> " + host + " <<<-----访问成功");
    }

}
