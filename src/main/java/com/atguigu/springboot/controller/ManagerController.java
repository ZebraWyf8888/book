package com.atguigu.springboot.controller;

import com.atguigu.springboot.entities.Manager;
import com.atguigu.springboot.service.ManagerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Collection;

@Controller
public class ManagerController {
    @Resource
    ManagerService managerService;

    @RequestMapping("/toUpdateManagerPage")
    public String toUpdatePage(Model model, HttpSession session) {
        String loginUser = (String) session.getAttribute("loginUser");
        Manager manager = managerService.getManagerBymName(loginUser);
        model.addAttribute("manager", manager);
        return "manager/update";
    }

    @PutMapping("/updateManager")
    public String updateManager(Manager manager,HttpSession session){
        managerService.updateManager(manager);
        session.setAttribute("mName", manager.getmName());
        return "redirect:/main.html";
    }
}
