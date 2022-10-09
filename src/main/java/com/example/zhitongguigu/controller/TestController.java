package com.example.zhitongguigu.controller;

import com.example.zhitongguigu.domain.TweetPost;
import com.example.zhitongguigu.request.TestRequest;
import com.example.zhitongguigu.response.TestResponse;
import com.example.zhitongguigu.service.TestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class TestController {
    @Resource
    private TestService testService;

    @RequestMapping(value = "/testHello", method = RequestMethod.GET)
    public TestResponse testHelloRequest(TestRequest testRequest){
        return testService.getTestHello(testRequest);
    }

    @DeleteMapping("/testDelete/{id}")
    public String testDelete(@PathVariable int id){
        return "delete id : " + id;
    }

    @RequestMapping(value = "/getAllTweets", method = RequestMethod.GET)
    public List<TweetPost> getListOfTweets(){
        return testService.getListOfTweets();
    }
}
