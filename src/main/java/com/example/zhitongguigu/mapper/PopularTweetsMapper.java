package com.example.zhitongguigu.mapper;

import com.example.zhitongguigu.domain.Tweets;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PopularTweetsMapper {
    public List<Tweets> getPopularTweets();
}
