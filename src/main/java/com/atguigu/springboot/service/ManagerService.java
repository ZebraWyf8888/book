package com.atguigu.springboot.service;

import com.atguigu.springboot.entities.Manager;

public interface ManagerService {
    /**
     * manager登录
     *
     * @param mUsername, mPassword
     * @return
     */
    Manager login(String mUsername, String mPassword);

    /**
     * 根据姓名获取用户信息
     *
     * @param mUsername
     * @return
     */
    Manager getManagerBymName(String mUsername);

    /**
     * 修改当前登录用户的信息
     *
     * @param manager
     * @return
     */
    Integer updateManager(Manager manager);

}
