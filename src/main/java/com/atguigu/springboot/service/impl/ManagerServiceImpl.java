package com.atguigu.springboot.service.impl;



import com.atguigu.springboot.entities.Manager;
import com.atguigu.springboot.mapper.ManagerMapper;
import com.atguigu.springboot.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManagerServiceImpl implements ManagerService{
    @Autowired
    ManagerMapper managerMapper;

    @Override
    public Manager login(String mUsername, String mPassword) {
        return managerMapper.login(mUsername, mPassword);
    }

    @Override
    public Manager getManagerBymName(String mUsername) {
        return managerMapper.getManagerBymName(mUsername);
    }

    @Override
    public Integer updateManager(Manager manager) {
        return managerMapper.updateManager(manager);
    }


//    @Override
//    public  getBookById(Integer bid) {
//        return bookMapper.getBookById(bid);
//    }
}
