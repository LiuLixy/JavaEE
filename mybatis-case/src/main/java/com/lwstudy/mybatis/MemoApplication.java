package com.lwstudy.mybatis;

import com.lwstudy.mybatis.entity.MemoGroup;
import com.lwstudy.mybatis.mapper.MemoGroupMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;

/**
 * @author: LiuWang
 * @data: 2018/9/4 8:52
 */
public class MemoApplication {

    public static void main(String[] args) {

        try {
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(
                    Resources.getResourceAsReader("mybatis-config.xml")
            );

            SqlSession sqlSession = sqlSessionFactory.openSession();
//            // 自动提交
//            // SqlSession sqlSession = sqlSessionFactory.openSession(true);
//            MemoGroup memoGroup = sqlSession.selectOne(
//                    "com.lwstudy.mybatis.mapper.MemoGroupMapper.selectMemoGroup", 1);

            MemoGroupMapper memoGroupMapper = sqlSession.getMapper(MemoGroupMapper.class);
            MemoGroup memoGroup = memoGroupMapper.selectMemoGroup(1);
            System.out.println(memoGroup);
        } catch (IOException e) {
            e.printStackTrace();
        }




    }
}
