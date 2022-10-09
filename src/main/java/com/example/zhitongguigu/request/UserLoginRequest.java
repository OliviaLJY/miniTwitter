package com.example.zhitongguigu.request;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class UserLoginRequest {

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @NotNull(message = "password can't be null")
    @Pattern(regexp = "^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{10,20}$",
            message = "Password should contain digit and character, length should be 10-20")
    private String password;

    @NotNull(message = "Username can't be empty")
    private String username;

}
