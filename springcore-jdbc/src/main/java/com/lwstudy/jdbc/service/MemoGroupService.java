package com.lwstudy.jdbc.service;

import com.lwstudy.jdbc.dao.MemoGroupDao;
import com.lwstudy.jdbc.entity.MemoGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: LiuWang
 * @Created: 2018/8/7 15:39
 */
@Service
public class MemoGroupService {
    
    @Autowired
    private MemoGroupDao memoGroupDao;
    
    public List<MemoGroup> queryMemoGroup(int id) {
        return memoGroupDao.queryMemoGroupById(id);
    }
    
}
