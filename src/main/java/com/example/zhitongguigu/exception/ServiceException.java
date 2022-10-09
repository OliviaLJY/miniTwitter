package com.example.zhitongguigu.exception;

public class ServiceException extends RuntimeException{
    public ServiceExceptionCode getExceptionCode() {
        return exceptionCode;
    }

    public void setExceptionCode(ServiceExceptionCode exceptionCode) {
        this.exceptionCode = exceptionCode;
    }

    private ServiceExceptionCode exceptionCode;

    public ServiceException(ServiceExceptionCode code){
        super(code.getDescription());
        this.exceptionCode = code;
    }
}
