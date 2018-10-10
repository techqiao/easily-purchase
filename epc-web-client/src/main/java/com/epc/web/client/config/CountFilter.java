package com.epc.web.client.config;

import org.springframework.context.annotation.Configuration;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * <p> To describe how this class works </p>
 * @author junlee
 * @date {date}       // 创建时间
 */
//@Configuration
@WebFilter(filterName = "countFilter",urlPatterns = "/*")
public class CountFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }
    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletResponse httpResponse = (HttpServletResponse)res;
        httpResponse.addHeader("Access-Control-Allow-Origin", "*");
        httpResponse.addHeader("Access-Control-Allow-Headers", "Content-Type, Access-Control-Allow-Headers, Authorization,epc-token, X-Requested-With");
        httpResponse.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, PATCH, OPTIONS");
        httpResponse.setContentType("application/json:charset=UTF-8");
        chain.doFilter(req, res);
    }
    @Override
    public void destroy() {
    }
}