package com.zhaomeng.bilibili.dao;

import org.apache.ibatis.annotations.Mapper;

/**
 * @author: zhaomeng
 * @Date: 2022/11/26 00:41
 */

@Mapper
public interface DemoDao {
    public Long query(Long id);
}
