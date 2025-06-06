package com.example.mytwitter.service;

import com.example.mytwitter.domain.TweetPost;
import com.example.mytwitter.mapper.TestMapper;
import com.example.mytwitter.request.TestRequest;
import com.example.mytwitter.response.TestResponse;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TestService {

    @Resource
    private TestMapper testMapper;

    public TestResponse getTestHello(TestRequest testRequest){
        TestResponse testResponse = new TestResponse();
        String responseResult = "testHello";

        if(testRequest.getKey2() != null && !testRequest.getKey2().isEmpty()){
            responseResult += testRequest.getKey2();
        }
        testResponse.setResponseString(responseResult);
        testResponse.setResponseInt(testRequest.getKey1());

        return testResponse;
    }

    public List<TweetPost> getListOfTweets(){
        return testMapper.getListOfTweets();
    }

}