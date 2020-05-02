package com.atguigu.springboot.service;

import com.atguigu.springboot.entities.Bookuser;

public interface BookuserService {
    /**
     * user登录
     *
     * @param uname, upassword
     * @return
     */
    Bookuser login(String uname,String upassword);
}
