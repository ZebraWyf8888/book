package com.atguigu.springboot.service;

import com.atguigu.springboot.entities.Book;
import java.util.List;
import java.util.Map;

/**
 * 书本CRUD操作服务接口
 * @author WYF
 * @create 2019-11-21 21:08
 */
public interface BookService {

    /**
     * 根据id获取书本信息
     * @param bid：书本的id
     * @return Book：书本信息
     */
    Book getBookById(Integer bid);

    /**
     * 获取当前管理商店的书本信息
     *
     * @param store : 商店号
     * @return  List<Book> : 书本信息
     */
    List<Book> getBookByStore(Integer store);

    /**
     * 添加书本
     * @param book
     * @return
     */
    Integer insertBook(Book book);


    /**
     * 修改书本信息
     * @param book
     * @return
     */
    Integer updateBook(Book book);

    /**
     * 删除书本信息
     * @param bid
     * @return
     */
    Integer deleteBook(Integer bid);

    /**
     * 获取当前管理商店的书本信息
     * @param store
     * @return
     */
    List<Book>  getBookByName(Integer store,String bName);

    /**
     * 分页查询书本信息
     * @param map : 分页条件
     * @return List<Book> : 书本信息
     */
    List<Book> Books(Map<String,Integer> map);

    /**
     * 查看书本记录的总条数
     * @return 书本记录的总条数
     */
    Integer BookSize();
}
