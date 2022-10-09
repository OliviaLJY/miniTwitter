package com.example.zhitongguigu.exception;

public enum ServiceExceptionCode {
    INVALID_REQUEST("Invalid Request"),
    LOGIN_ERROR("Invalid Login Credential"),
    INVALID_AUTHOR_ID("Invalid Author Id"),
    USERNAME_ALREADY_EXISTS("Username already exists"),
    INVALID_PASSWORD("Invalid User Password");

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    private String description;

    ServiceExceptionCode(String exceptionDescription){
        this.description = exceptionDescription;
    }

}
