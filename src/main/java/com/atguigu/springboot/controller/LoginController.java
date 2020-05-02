package com.atguigu.springboot.controller;

import com.atguigu.springboot.entities.Manager;
import com.atguigu.springboot.service.ManagerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.util.StringUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class LoginController {
    //service
    @Resource
    private ManagerService managerService;

    @PostMapping(value = "/user/login")
    //@RequestMapping(value = "",method = "")
    public String login(@RequestParam("mUsername") String mUsername,
                        @RequestParam("mPassword") String mPassword,
                        Map<String,Object> map, HttpSession session){
        if (org.springframework.util.StringUtils.isEmpty(mUsername) || org.springframework.util.StringUtils.isEmpty(mPassword)) {
            //session.setAttribute("msg", "用户名或密码不能为空");
            map.put("msg", "用户名或密码不能为空");
            return "login";
        }
        Manager manager = managerService.login(mUsername, mPassword);
        if (manager != null){
            session.setAttribute("loginUser", manager.getmUsername());
            session.setAttribute("mName", manager.getmName());
            session.setAttribute("store", manager.getStore());
            return "redirect:/main.html";
        }else {
            map.put("msg", "用户名密码错误");
            return "login";
        }
    }
}
