package com.example.mytwitter.mapper;

import com.example.mytwitter.domain.Tweets;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PopularTweetsMapper {
    public List<Tweets> getPopularTweets();
}
