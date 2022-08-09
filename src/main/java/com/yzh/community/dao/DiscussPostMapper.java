package com.yzh.community.dao;

import com.yzh.community.entity.DiscussPost;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DiscussPostMapper {

    //查询首页数据 userId用于以后查询自己发帖考虑设计，
    public List<DiscussPost> selectDiscussPosts(int userId,int offset,int limit);

    // @Param注解用于给参数取别名,
    // 如果只有一个参数,并且在<if>里使用,则必须加别名.
    public int selectDiscussPostRows(@Param("userId") int userId);

}
