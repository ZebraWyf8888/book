package com.atguigu.springboot.service.impl;



import com.atguigu.springboot.entities.Bookuser;
import com.atguigu.springboot.entities.Manager;
import com.atguigu.springboot.mapper.BookuserMapper;
import com.atguigu.springboot.mapper.ManagerMapper;
import com.atguigu.springboot.service.BookuserService;
import com.atguigu.springboot.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookuserServiceImpl implements BookuserService {
    @Autowired
    BookuserMapper bookuserMapper;

    @Override
    public Bookuser login(String uname,String upassword) {
        return bookuserMapper.login(uname, upassword);
    }

//    @Override
//    public Manager getManagerBymName(String mUsername) {
//        return managerMapper.getManagerBymName(mUsername);
//    }
//
//    @Override
//    public Integer updateManager(Manager manager) {
//        return managerMapper.updateManager(manager);
//    }


//    @Override
//    public  getBookById(Integer bid) {
//        return bookMapper.getBookById(bid);
//    }
}
