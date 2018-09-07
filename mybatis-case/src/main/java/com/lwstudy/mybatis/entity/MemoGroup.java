package com.lwstudy.mybatis.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author: LiuWang
 * @data: 2018/9/4 14:06
 */
@Data
public class MemoGroup {

    private Integer id;

    private String name;

    private Date createdTime;

    private Date modifyTime;

}
