package com.example.zhitongguigu.controller;

import com.example.zhitongguigu.exception.ServiceException;
import com.example.zhitongguigu.response.CommonResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.rmi.ServerException;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(value = ServiceException.class)
    @ResponseBody
    public CommonResponse runtimeExceptionHandler(Exception e){
        //TODO: Log
        CommonResponse commonResponse = new CommonResponse();
        commonResponse.setSuccess(false);
        commonResponse.setMessage("Backend Server Err, please contact admin");
        return commonResponse;
    }
}
