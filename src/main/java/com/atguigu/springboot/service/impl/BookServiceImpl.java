package com.atguigu.springboot.service.impl;

import com.atguigu.springboot.entities.Book;
import com.atguigu.springboot.mapper.BookMapper;
import com.atguigu.springboot.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class BookServiceImpl implements BookService{
    @Autowired
    BookMapper bookMapper;

    @Override
    public Book getBookById(Integer bid) {
        return bookMapper.getBookById(bid);
    }

    @Override
    public List<Book> getBookByStore(Integer store) {
        return bookMapper.getBookByStore(store);
    }

    @Override
    public Integer insertBook(Book book) {
        return bookMapper.insertBook(book);
    }

    @Override
    public Integer updateBook(Book book) {
        return bookMapper.updateBook(book);
    }

    @Override
    public Integer deleteBook(Integer bid) {
        return bookMapper.deleteBook(bid);
    }

    @Override
    public List<Book> getBookByName(Integer store, String bName) {
        bName = "%"+bName+"%";
        return bookMapper.getBookByName(store,bName);
    }

    @Override
    public List<Book> Books(Map<String, Integer> map) {
        return bookMapper.Books(map);
    }

    @Override
    public Integer BookSize() {
        return bookMapper.BookSize();
    }


}
