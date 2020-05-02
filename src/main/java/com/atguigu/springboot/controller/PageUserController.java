package com.atguigu.springboot.controller;

import com.atguigu.springboot.entities.Bookuser;
import com.atguigu.springboot.entities.Page;
import com.atguigu.springboot.service.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * @author LB
 * @create 2019-03-30 17:33
 */
@Controller
public class PageUserController {

    @Autowired
    BookService bookService;

    @RequestMapping("/page")
    public String getPageUser(Model model, HttpServletRequest request, HttpSession session){
        Bookuser user = (Bookuser) session.getAttribute("user");

        String pageNum = request.getParameter("pageNum") == null?"1":request.getParameter("pageNum");
        int totalRecord = bookService.BookSize();

        Page page = new Page(Integer.parseInt(pageNum),7 ,totalRecord );
        int startIndex = page.getStartIndex();
        Map<String,Integer> map = new HashMap<>();
        map.put("startIndex",startIndex );
        map.put("pageSize",7 );
        page.setBooklist(bookService.Books(map));
        model.addAttribute("page",page );
        return "usermain";
    }
}
