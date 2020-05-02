package com.atguigu.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.Map;

@Controller
public class HelloController {

//    @RequestMapping("/hello")
//    public String hello(){
//        return "Hello world";
//    }

    //jsp的
    @RequestMapping("/jumpjsp")
    public String jsphello(Model model){
        model.addAttribute("msg", "成功了");
        return "redirect:/success.jsp";
    }

    //模板引擎的
    @RequestMapping("/jumpthy")
    public String success(Map<String,Object> map){
        map.put("hello", "<h1>你好<h1>");
        map.put("users", Arrays.asList("zhangsan","lisi","wangwu"));
        //去templates下找success.html
        return "success";
    }

    //模板引擎的
    @RequestMapping("/bookuser")
    public String loginuser(Map<String,Object> map){
//        map.put("hello", "<h1>你好<h1>");
//        map.put("users", Arrays.asList("zhangsan","lisi","wangwu"));
        //去templates下找success.html
        return "userlogin";
    }

    @RequestMapping("/aaa")
    public String index(){
                 return "aaa";
            }
//    @RequestMapping({"/","/index"})
//    public String index(){
//        return "index";
//    }
}
