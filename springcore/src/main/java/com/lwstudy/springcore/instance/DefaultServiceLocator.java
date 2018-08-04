package com.lwstudy.springcore.instance;

/**
 * @Author: LiuWang
 * @Created: 2018/7/31 17:29
 */
public class DefaultServiceLocator {

    private static ClientService clientService = new ClientService();

    public ClientService createClientServiceInstance() {
        return clientService;
    }

}
