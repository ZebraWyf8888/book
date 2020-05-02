package com.atguigu.springboot;

import com.atguigu.springboot.entities.Book;
import com.atguigu.springboot.entities.Bookuser;
import com.atguigu.springboot.mapper.BookMapper;
import com.atguigu.springboot.mapper.BookuserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBoot04WebRestfulcrudApplicationTests {

	@Autowired
	BookuserMapper mapper;
	@Test
	public void contextLoads() {
		Bookuser user1 = mapper.login("user1", "123");
		System.out.println(user1);
	}

}
