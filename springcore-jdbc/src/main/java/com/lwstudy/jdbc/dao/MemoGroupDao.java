package com.lwstudy.jdbc.dao;

import com.lwstudy.jdbc.entity.MemoGroup;

import java.util.Date;
import java.util.List;

/**
 * @Author: LiuWang
 * @Created: 2018/8/7 15:07
 */
public interface MemoGroupDao {
    /**
     * 插入便签组
     *
     * @param memoGroup 便签组对象
     * @return 插入成功返回1否则0
     */
    int insertMemoGroup(MemoGroup memoGroup);

    int updateMemoGroup(int id, String name);

    List<MemoGroup> queryMemoGroupByCreatedTime(Date startTime, Date endTime);

    List<MemoGroup> queryMemoGroupById(int id);

    int deleteMemoGroupById(int id);
}
