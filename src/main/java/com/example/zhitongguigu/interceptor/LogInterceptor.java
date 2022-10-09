package com.example.zhitongguigu.interceptor;

//import com.example.zhitongguigu.filter.LogFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class LogInterceptor implements HandlerInterceptor {

    private static final Logger LOG = LoggerFactory.getLogger("test Logger Name");
    private static final String REQUEST_START_TIME = "requestStartTime";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        LOG.info("------------ LOG Interceptor ------------");
        LOG.info("request url: {}, request method {}", request.getRequestURL().toString(), request.getMethod());
//        LOG.info("request address {}", request.getRemoteAddr());

        long startTime = System.currentTimeMillis();
        request.setAttribute(REQUEST_START_TIME, startTime);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
        long startTime = (Long)request.getAttribute(REQUEST_START_TIME);
        LOG.info("Log Interceptor -- API duration {} ms", System.currentTimeMillis() - startTime);
    }

}
