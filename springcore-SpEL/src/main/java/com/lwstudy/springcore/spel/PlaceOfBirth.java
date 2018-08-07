package com.lwstudy.springcore.spel;

import lombok.Data;

/**
 * @Author: LiuWang
 * @Created: 2018/8/7 16:40
 */
@Data
public class PlaceOfBirth {

    /**
     * 国家
     */
    private final String nation;
    /**
     * 地区
     */
    private final String district;

    public PlaceOfBirth(String nation, String district) {
        this.nation = nation;
        this.district = district;
    }
}
