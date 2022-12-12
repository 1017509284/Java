package com.zhaomeng.bilibili.dao;


import com.zhaomeng.bilibili.domain.UserFollowing;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserFollowingDao {
    Integer deleteUserFollowing(@Param("userId") Long id, @Param("followingId") Long followingId);

    void addUserFollowing(UserFollowing userFollowing);
}
