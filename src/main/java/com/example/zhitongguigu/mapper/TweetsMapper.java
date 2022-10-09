package com.example.zhitongguigu.mapper;


import com.example.zhitongguigu.domain.Tweets;
import com.example.zhitongguigu.domain.TweetsExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface TweetsMapper {
    long countByExample(TweetsExample example);

    int deleteByExample(TweetsExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Tweets row);

    int insertSelective(Tweets row);

    List<Tweets> selectByExample(TweetsExample example);

    Tweets selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("row") Tweets row, @Param("example") TweetsExample example);

    int updateByExample(@Param("row") Tweets row, @Param("example") TweetsExample example);

    int updateByPrimaryKeySelective(Tweets row);

    int updateByPrimaryKey(Tweets row);
}