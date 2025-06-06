package com.example.mytwitter.controller;

import com.example.mytwitter.exception.ServiceException;
import com.example.mytwitter.response.CommonResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

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
