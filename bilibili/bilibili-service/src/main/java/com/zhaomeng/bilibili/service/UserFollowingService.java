package com.zhaomeng.bilibili.service;


import com.zhaomeng.bilibili.dao.UserFollowingDao;
import com.zhaomeng.bilibili.domain.FollowingGroup;
import com.zhaomeng.bilibili.domain.User;
import com.zhaomeng.bilibili.domain.UserFollowing;
import com.zhaomeng.bilibili.domain.UserInfo;
import com.zhaomeng.bilibili.domain.constant.UserConstant;
import com.zhaomeng.bilibili.domain.exception.ConditionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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

    // !获取这个用户的关注列表
    public List<FollowingGroup> getUserFollowings(Long userId) {
        // !查询这个用户的关注列表
        List<UserFollowing> userFollowingList = userFollowingDao.getUserFollowings(userId);
        // !获取入参userId的关注的id set
        Set<Long> followingSet = userFollowingList.stream().map(UserFollowing::getFollowingId).collect(Collectors.toSet());

        List<UserInfo> userInfoList = new ArrayList<>();
        if (followingSet.size() > 0) {
            // !查询入参userId关注的所有up的信息
            userInfoList = userService.getUserInfoByUserIds(followingSet);
        }

        for (UserFollowing userFollowing : userFollowingList) {
            for (UserInfo userInfo : userInfoList) {
                if (userFollowing.getFollowingId().equals(userInfo.getUserId())) {
                    userFollowing.setUserInfo(userInfo);
                }
            }
        }

        List<FollowingGroup> followingGroupList = followingGroupService.getByUserId(userId);

        FollowingGroup allGroup = new FollowingGroup();
        allGroup.setName(UserConstant.USER_FOLLOWING_GROUP_ALL_NAME);
        allGroup.setFollowingUserInfoList(userInfoList);

        List<FollowingGroup> result = new ArrayList<>();
        result.add(allGroup);

        for (FollowingGroup followingGroup : followingGroupList) {
            List<UserInfo> infoList = new ArrayList<>();
            for (UserFollowing userFollowing : userFollowingList) {
                if (followingGroup.getId().equals(userFollowing.getGroupId())) {
                    infoList.add(userFollowing.getUserInfo());
                }
            }
            followingGroup.setFollowingUserInfoList(infoList);
            result.add(followingGroup);
        }
        return result;
    }

    // !获取当前用户的粉丝列表
    public List<UserFollowing> getUserFans(Long userId) {
        // !获取用户的粉丝列表
        List<UserFollowing> fanList = userFollowingDao.getUserFans(userId);
        Set<Long> fanIdSet = fanList.stream().map(UserFollowing::getUserId).collect(Collectors.toSet());
        List<UserInfo> userInfoList = new ArrayList<>();

        if (fanIdSet.size() > 0) {
            userInfoList = userService.getUserInfoByUserIds(fanIdSet);
        }

        List<UserFollowing> followingList = userFollowingDao.getUserFollowings(userId);
        for (UserFollowing fan : fanList) {
            for (UserInfo userInfo : userInfoList) {
                if (fan.getUserId().equals(userInfo.getUserId())) {
                    userInfo.setFollowed(false);
                    fan.setUserInfo(userInfo);
                }
            }
            for (UserFollowing userFollowing : followingList) {
                if (userFollowing.getFollowingId().equals(fan.getUserId())) {
                    fan.getUserInfo().setFollowed(true);
                }
            }
        }
        return fanList;
    }

    public Long addUserFollowingGroups(FollowingGroup followingGroup) {
        followingGroup.setCreateTime(new Date());
        followingGroup.setType(UserConstant.USER_FOLLOWING_GROUP_TYPE_USER);

        followingGroupService.addFollowingGroup(followingGroup);
        return followingGroup.getId();
    }

    public List<FollowingGroup> getUserFollowingGroups(Long userId) {
        return followingGroupService.getUserFollowingGroups(userId);
    }

    public List<UserInfo> checkFollowingStatus(List<UserInfo> userInfoList, Long userId) {
        List<UserFollowing> userFollowingList = userFollowingDao.getUserFollowings(userId);
        for (UserInfo userInfo : userInfoList) {
            userInfo.setFollowed(false);
            for (UserFollowing userFollowing : userFollowingList) {
                if (userFollowing.getFollowingId().equals(userInfo.getUserId())) {
                    userInfo.setFollowed(true);
                }
            }
        }
        return userInfoList;
    }
}
