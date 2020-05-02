package com.atguigu.springboot.controller;


import com.atguigu.springboot.verification.DrawImage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author LB
 * @create 2019-04-22 12:00
 */
@Controller
public class ImageController {

    @RequestMapping("/img")
  public void getImage(HttpServletRequest request, HttpServletResponse response){
      DrawImage drawImage = new DrawImage();
      drawImage.image(request,response );
  }
}
