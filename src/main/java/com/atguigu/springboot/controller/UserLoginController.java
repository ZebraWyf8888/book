package com.atguigu.springboot.controller;

import com.atguigu.springboot.entities.Bookuser;
import com.atguigu.springboot.service.BookuserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @author LB
 * @create 2019-04-21 14:15
 */
@Controller
public class UserLoginController {

    @Autowired
    private BookuserService bookuserService;

    @GetMapping("/userlogin")
    public String login(){
        return "login";
    }


    @PostMapping("/userlogin")
    public String login(@RequestParam("uname") String uname,
                        @RequestParam("upassword") String upassword,
                        @RequestParam("validateCode") String validateCode,
                        Map<String, Object> map,HttpSession session){
        Bookuser bookuser = bookuserService.login(uname, upassword);
        String rightCode = ((String) session.getAttribute("checkcode")).toUpperCase();
        validateCode = validateCode.toUpperCase();
        if(rightCode.equals(validateCode)){
            if(null == bookuser){
                map.put("msg","用户名或密码登录错误" );
                return "userlogin";
            }else{
                session.setAttribute("user",bookuser );
                session.setAttribute("loginUser", bookuser.getUname());
                //return "redirect:/page";
                return "redirect:/usermain.html";
            }
        }else{
            map.put("msg","验证码输入错误" );
            return "userlogin";
        }
    }
}
