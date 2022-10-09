package com.example.zhitongguigu.request;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class UserPostRequest {

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @NotNull(message = "Username can't be empty")
    private String username;

    @NotNull(message = "Profile name can't be empty")
    private String name;

    @NotNull(message = "password can't be null")
    @Pattern(regexp = "^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{10,20}$",
            message = "Password should contain digit and character, length should be 10-20")
    private String password;

    private Long id;
}
