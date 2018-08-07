package com.lwstudy.springcore.spel;

import lombok.Data;

import java.util.Date;

/**
 * @Author: LiuWang
 * @Created: 2018/8/7 16:38
 */

@Data
public class User {
    /**
     * 用户名
     */
    private String userName;
    /**
     * 最近访问时间
     */
    private Date lastDate;
    /**
     * 用户积分
     */
    private Integer credits;
    /**
     * 出生地
     */
    private PlaceOfBirth placeOfBirth;
}
