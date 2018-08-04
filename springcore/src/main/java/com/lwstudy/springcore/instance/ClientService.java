package com.lwstudy.springcore.instance;

import java.util.Date;

/**
 * @Author: LiuWang
 * @Created: 2018/7/31 17:15
 */
public class ClientService {

    public static ClientService getInstance() {
        return new ClientService();
    }

    public Date getServiceDate() {
        return new Date();
    }
}
