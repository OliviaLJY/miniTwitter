package com.example.zhitongguigu.mapper;

import com.example.zhitongguigu.domain.TweetPost;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TestMapper {

    public List<TweetPost> getListOfTweets();

}
