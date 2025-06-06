package com.example.mytwitter.controller;

import com.example.mytwitter.domain.TweetPost;
import com.example.mytwitter.request.TestRequest;
import com.example.mytwitter.response.TestResponse;
import com.example.mytwitter.service.TestService;
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
