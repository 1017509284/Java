package com.zhaomeng.bilibili.service;


import com.zhaomeng.bilibili.dao.FollowingGroupDao;
import com.zhaomeng.bilibili.domain.FollowingGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FollowingGroupService {

    @Autowired
    private FollowingGroupDao followingGroupDao;

    // !根据关注类型查询关注的列表
    public FollowingGroup getByType(String type) {
        return followingGroupDao.getByType(type);
    }

    // !根据id查询关注的列表
    public FollowingGroup getById(Long id) {
        return followingGroupDao.getById(id);
    }
}
