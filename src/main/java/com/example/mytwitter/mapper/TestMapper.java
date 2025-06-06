package com.example.mytwitter.mapper;

import com.example.mytwitter.domain.TweetPost;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TestMapper {

    public List<TweetPost> getListOfTweets();

}
