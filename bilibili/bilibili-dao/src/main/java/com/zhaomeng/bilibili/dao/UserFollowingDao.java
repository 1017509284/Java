package com.zhaomeng.bilibili.dao;


import com.zhaomeng.bilibili.domain.UserFollowing;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserFollowingDao {
    Integer deleteUserFollowing(@Param("userId") Long id, @Param("followingId") Long followingId);

    void addUserFollowing(UserFollowing userFollowing);

    List<UserFollowing> getUserFans(Long userId);

    List<UserFollowing> getUserFollowings(Long userId);
}
