package com.example.zhitongguigu.service;

import com.example.zhitongguigu.domain.Populartweetssnapshot;
import com.example.zhitongguigu.domain.Tweets;
import com.example.zhitongguigu.domain.TweetsExample;
import com.example.zhitongguigu.mapper.PopularTweetsMapper;
import com.example.zhitongguigu.mapper.PopulartweetssnapshotMapper;
import com.example.zhitongguigu.mapper.TweetsMapper;
import com.example.zhitongguigu.request.TweetRequest;
import com.example.zhitongguigu.response.PageResponse;
import com.example.zhitongguigu.response.TweetResponse;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TweetsService {

    @Resource
    private PopulartweetssnapshotMapper populartweetssnapshotMapper;
    @Resource
    private PopularTweetsMapper popularTweetsMapper;
    @Resource
    private TweetsMapper tweetsMapper;

    public List<Tweets> getAllTweets(){
        return tweetsMapper.selectByExample(null);
    }

    public PageResponse<TweetResponse> getTweetsByAuthorId(TweetRequest tweetRequest){

        PageHelper.startPage(tweetRequest.getPageIdx(), tweetRequest.getPageSize());

        TweetsExample tweetsExample = new TweetsExample();
        TweetsExample.Criteria tweetsCriteria = tweetsExample.createCriteria();
        tweetsCriteria.andAuthoridEqualTo(tweetRequest.getAuthorId());

        List<Tweets> tweetsList = tweetsMapper.selectByExample(tweetsExample);
        List<TweetResponse> tweetResponses = new ArrayList<>();

        for (Tweets tweet: tweetsList){
            TweetResponse tr = new TweetResponse();
            tr.setAuthorId(tweet.getAuthorid());
            tr.setContent(tweet.getCotent());
            tr.setTitle(tweet.getTitle());
            tr.setId(tweet.getId());
            tweetResponses.add(tr);
        }

        PageInfo<Tweets> pageInfo = new PageInfo<>(tweetsList);
        PageResponse<TweetResponse> pagedTweetsResponse = new PageResponse();
        pagedTweetsResponse.setTotalSize(pageInfo.getTotal());
        pagedTweetsResponse.setPageSize(pageInfo.getPageSize());
        pagedTweetsResponse.setList(tweetResponses);

        return pagedTweetsResponse;
    }

    public void deleteTweetId(Long tweetId){
        tweetsMapper.deleteByPrimaryKey(tweetId);
    }

    public void updateTweet(Tweets tweets){
        tweetsMapper.updateByPrimaryKey(tweets);
    }

    public Tweets createTweet(Tweets tweets){
        tweetsMapper.insert(tweets);
        return tweets;
    }

    public void likeTweetById(int id){
        Tweets tweets = tweetsMapper.selectByPrimaryKey(id);
        tweets.setLikes(tweets.getLikes()+1);
        updateTweet(tweets);
    }

    public void getPopularTweets(){
        List<Tweets> popularTweets = popularTweetsMapper.getPopularTweets();
        List<Long> ids = popularTweets.stream().map(Tweets::getId).collect(Collectors.toList());

        for(Long id : ids){
            Populartweetssnapshot populartweetssnapshot = new Populartweetssnapshot();
            populartweetssnapshot.setId(id);
            populartweetssnapshot.setTime(new Date());
            populartweetssnapshotMapper.insert(populartweetssnapshot);
        }
    }
}
