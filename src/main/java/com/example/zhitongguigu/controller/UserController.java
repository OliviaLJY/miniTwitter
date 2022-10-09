package com.example.zhitongguigu.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.zhitongguigu.request.UserLoginRequest;
import com.example.zhitongguigu.request.UserPostRequest;
import com.example.zhitongguigu.response.CommonResponse;
import com.example.zhitongguigu.response.UserLoginResponse;
import com.example.zhitongguigu.service.UserService;
import com.example.zhitongguigu.util.SnowFlake;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.Random;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @Resource
    private RedisTemplate redisTemplate;

    @Resource
    private SnowFlake snowFlake;

    @PostMapping("/createUser")
    public CommonResponse postNewUser(@Valid @RequestBody UserPostRequest userPostRequest){
        userPostRequest.setPassword(DigestUtils.md5DigestAsHex(userPostRequest.getPassword().getBytes()));
        CommonResponse response = new CommonResponse<>();
        userService.createUserAccount(userPostRequest);
        return response;
    }


    @PutMapping("/resetPassword")
    public CommonResponse resetPassword(@Valid @RequestBody UserPostRequest userPostRequest){
        userPostRequest.setPassword(DigestUtils.md5DigestAsHex(userPostRequest.getPassword().getBytes()));
        CommonResponse response = new CommonResponse<>();
        userService.resetPassword(userPostRequest);
        return response;
    }

    @PostMapping("/login")
    public CommonResponse login(@Valid @RequestBody UserLoginRequest userLoginRequest){
        userLoginRequest.setPassword(DigestUtils.md5DigestAsHex(userLoginRequest.getPassword().getBytes()));
        CommonResponse<UserLoginResponse> response = new CommonResponse<>();

        UserLoginResponse userLoginResponse = userService.userLogin(userLoginRequest);

        Long token = snowFlake.nextId();
        // Snowflake  64 bits   1 bit signed int, 41 bits timestamp,
        // 10bits machines ids , 12 sequence number
        redisTemplate.opsForValue().set(token.toString(), JSONObject.toJSONString(userLoginResponse), 3600  * 24, TimeUnit.SECONDS);
        userLoginResponse.setToken(token);
        response.setResponseData(userLoginResponse);

        return response;
    }

    @GetMapping("/logout/{token}")
    public CommonResponse logout(@PathVariable String token){
        CommonResponse response = new CommonResponse<>();
        redisTemplate.delete(token);

        return response;
    }
}
