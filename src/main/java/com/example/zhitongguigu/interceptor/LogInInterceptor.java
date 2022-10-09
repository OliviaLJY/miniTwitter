package com.example.zhitongguigu.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class LogInInterceptor implements HandlerInterceptor {

    private static final Logger LOG = LoggerFactory.getLogger(LogInInterceptor.class);
    @Resource
    private RedisTemplate redisTemplate;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
return true;
//        // OPTIONS
//        if(request.getMethod().toUpperCase().equals("OPTIONS")){
//            return true;
//        }
//
//        String token = request.getHeader("token");
//
//        if(token == null || token.isEmpty()){
//            response.setStatus(HttpStatus.UNAUTHORIZED.value());
//            return false;
//        }
//
//        Object object = redisTemplate.opsForValue().get(token);
//        if(object == null){
//            response.setStatus(HttpStatus.UNAUTHORIZED.value());
//            return false;
//        }else{
//            // successful login;
//            LOG.info("successful login");
//            return true;
//        }
    }


    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {


    }
}
