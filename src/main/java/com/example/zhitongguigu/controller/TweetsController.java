package com.example.zhitongguigu.controller;

import com.example.zhitongguigu.domain.TweetPost;
import com.example.zhitongguigu.domain.Tweets;
import com.example.zhitongguigu.request.CreateTweetRequest;
import com.example.zhitongguigu.request.TweetRequest;
import com.example.zhitongguigu.response.CommonResponse;
import com.example.zhitongguigu.response.PageResponse;
import com.example.zhitongguigu.response.TweetResponse;
import com.example.zhitongguigu.service.TweetsService;
import com.example.zhitongguigu.util.CopyUtil;
import com.example.zhitongguigu.util.SnowFlake;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/tweets")
public class TweetsController {

    @Resource
    private TweetsService tweetsService;

    @Resource
    private SnowFlake snowFlake;

    @RequestMapping(value = "/getTweetsByAuthorId", method = RequestMethod.POST)
    public CommonResponse getTweetsByAuthorId(@Valid @RequestBody TweetRequest tweetRequest){
        CommonResponse<PageResponse<TweetResponse>> commonResponse = new CommonResponse<>();
        PageResponse<TweetResponse> tweetResponses = tweetsService.getTweetsByAuthorId(tweetRequest);

        if (tweetResponses == null){
            commonResponse.setSuccess(false);
            commonResponse.setMessage("No Tweet Found");
        }else{
            commonResponse.setSuccess(true);
            commonResponse.setResponseData(tweetResponses);
            commonResponse.setMessage("Tweets have been fetched successfully");
        }
        return commonResponse;
    }

    @DeleteMapping("/deleteTweet/{tweetId}")
    public CommonResponse deleteTweetId(@PathVariable Long tweetId){
        CommonResponse response = new CommonResponse<>();
        tweetsService.deleteTweetId(tweetId);
        response.setMessage("Delete Operation Has Been Executed");
        return response;
    }

    @PutMapping("/updateTweet")
    public CommonResponse updateTweet(@Valid @RequestBody Tweets tweetRequest){
        CommonResponse response = new CommonResponse<>();
        /*Tweets tweetsToUpdate = CopyUtil.copy(tweetRequest, Tweets.class);*/
        tweetsService.updateTweet(tweetRequest);
        response.setMessage("Tweet has been updated");
        return response;
    }

    @PostMapping("/createTweet")
    public CommonResponse createTweet(@Valid @RequestBody CreateTweetRequest tweetRequest){
        CommonResponse response = new CommonResponse<>();
        Tweets tweetsToCreate = CopyUtil.copy(tweetRequest, Tweets.class);
        tweetsToCreate.setCreatetime(new Date());
        //tweetsToCreate.setId(snowFlake.nextId());
        tweetsToCreate.setLikes(0);
        tweetsService.createTweet(tweetsToCreate);
        response.setMessage("Tweet has been created");
        return response;
    }

    @PutMapping("/likeTweet/{tweetId}")
    public CommonResponse likeTweetById(@PathVariable int tweetId){
        CommonResponse response = new CommonResponse<>();
        tweetsService.likeTweetById(tweetId);
        return response;
    }

}
