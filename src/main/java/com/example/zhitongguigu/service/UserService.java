package com.example.zhitongguigu.service;

import com.example.zhitongguigu.domain.User;
import com.example.zhitongguigu.domain.UserExample;
import com.example.zhitongguigu.exception.ServiceException;
import com.example.zhitongguigu.exception.ServiceExceptionCode;
import com.example.zhitongguigu.mapper.UserMapper;
import com.example.zhitongguigu.request.UserLoginRequest;
import com.example.zhitongguigu.request.UserPostRequest;
import com.example.zhitongguigu.response.UserLoginResponse;
import com.example.zhitongguigu.util.CopyUtil;
import com.example.zhitongguigu.util.SnowFlake;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.List;
import java.util.Random;

@Service
public class UserService {

    @Resource
    private UserMapper userMapper;

    @Resource
    private SnowFlake snowFlake;

    public void createUserAccount(UserPostRequest userPostRequest){
        User storedUser = selectByLogInName(userPostRequest.getUsername());
        User userToAdd = CopyUtil.copy(userPostRequest, User.class);

        if(storedUser == null){
            // create a new user
            userToAdd.setId(snowFlake.nextId());
            userMapper.insert(userToAdd);
        }else{
            // username already exists
            throw new ServiceException(ServiceExceptionCode.USERNAME_ALREADY_EXISTS);
        }
    }

    public void resetPassword(UserPostRequest userPostRequest){
        User userToUpdate = CopyUtil.copy(userPostRequest, User.class);
        userMapper.updateByPrimaryKey(userToUpdate);
    }

    public User selectByLogInName(String loginName){
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andUsernameEqualTo(loginName);

        List<User> userList = userMapper.selectByExample(userExample);

        if(userList.isEmpty()){
            return null;
        }else{
            return userList.get(0);
        }
    }

    public UserLoginResponse userLogin(UserLoginRequest userLoginRequest){
        User storedUser = selectByLogInName(userLoginRequest.getUsername());

        if(ObjectUtils.isEmpty(storedUser)){
            throw new ServiceException(ServiceExceptionCode.LOGIN_ERROR);
        } else {
            if(storedUser.getPassword().equals(userLoginRequest.getPassword())){
                // Successful login
                UserLoginResponse userLoginResponse = CopyUtil.copy(storedUser, UserLoginResponse.class);
                return userLoginResponse;
            } else {
                // Incorrect Password
                throw new ServiceException(ServiceExceptionCode.INVALID_PASSWORD);
            }
        }
    }
}
