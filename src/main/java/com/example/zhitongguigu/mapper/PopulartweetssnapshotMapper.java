package com.example.zhitongguigu.mapper;

import com.example.zhitongguigu.domain.Populartweetssnapshot;
import com.example.zhitongguigu.domain.PopulartweetssnapshotExample;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PopulartweetssnapshotMapper {
    long countByExample(PopulartweetssnapshotExample example);

    int deleteByExample(PopulartweetssnapshotExample example);

    int deleteByPrimaryKey(@Param("id") Integer id, @Param("time") Date time);

    int insert(Populartweetssnapshot row);

    int insertSelective(Populartweetssnapshot row);

    List<Populartweetssnapshot> selectByExample(PopulartweetssnapshotExample example);

    int updateByExampleSelective(@Param("row") Populartweetssnapshot row, @Param("example") PopulartweetssnapshotExample example);

    int updateByExample(@Param("row") Populartweetssnapshot row, @Param("example") PopulartweetssnapshotExample example);
}