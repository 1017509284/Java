package com.zhaomeng.bilibili.service;


import com.zhaomeng.bilibili.dao.UserFollowingDao;
import com.zhaomeng.bilibili.domain.FollowingGroup;
import com.zhaomeng.bilibili.domain.User;
import com.zhaomeng.bilibili.domain.UserFollowing;
import com.zhaomeng.bilibili.domain.constant.UserConstant;
import com.zhaomeng.bilibili.domain.exception.ConditionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class UserFollowingService {

    @Autowired
    private UserFollowingDao userFollowingDao;

    @Autowired
    private FollowingGroupService followingGroupService;

    @Autowired
    private UserService userService;

    // !新增关注
    @Transactional
    public void addUserFollowings(UserFollowing userFollowing) {

        // !获取要关注的组id
        Long groupId = userFollowing.getGroupId();

        // !若为空，代表添加到默认关注分组
        if (groupId == null) {
            FollowingGroup followingGroup = followingGroupService.getByType(UserConstant.USER_FOLLOWING_GROUP_TYPE_DEFAULT);
            userFollowing.setGroupId(followingGroup.getId());
        } else {
            // !否则添加到指定的组id
            FollowingGroup followingGroup = followingGroupService.getById(groupId);
            if (followingGroup == null) {
                throw new ConditionException("关注分组不存在");
            }
        }

        // !获取要关注的up Id
        Long followingId = userFollowing.getFollowingId();
        // !查询要关注的up信息
        User user = userService.getUserById(followingId);

        if (user == null) {
            throw new ConditionException("关注的用户不存在");
        }

        // !先删除此用户和要关注的up id的关联
        userFollowingDao.deleteUserFollowing(userFollowing.getId(), followingId);
        // !修改关注时间
        userFollowing.setCreateTime(new Date());
        // !重新建立关注关系
        userFollowingDao.addUserFollowing(userFollowing);
    }

    public List<FollowingGroup> getUserFollowings(Long userId) {

    }
}
