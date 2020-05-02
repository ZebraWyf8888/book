package com.atguigu.springboot.mapper;

import com.atguigu.springboot.entities.Book;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface BookMapper {
    @Select("select * from book where bid=#{bid}")
    public Book getBookById(Integer bid);

    @Select("select * from book where store=#{store}")
    public List<Book> getBookByStore(Integer store);

    @Delete("delete from book where id = #{bid}")
    public int deleteBookById(Integer bid);

    @Options(useGeneratedKeys = true,keyProperty = "bid")
    @Insert("INSERT INTO `bookstore`.`book`(`bName`, `publish`, `store`, `author`, `num`, `money`) VALUES " +
            "( #{bName}, #{publish}, #{store}, #{author}, #{num}, #{money} )")
    public int insertBook(Book book);

   // @Update("update book set departmentName=(#{departmentName}) where id=#{bid}")
    @Update("UPDATE book SET bName = (#{bName}), publish = (#{publish}), author = (#{author}), num = (#{num}), `money` =  (#{money}) WHERE `bid` = (#{bid})")
    public int updateBook(Book book);

    @Update("delete from book where bid=(#{bid})")
    public int deleteBook(Integer bid);

    @Select("select * from book where store=#{store} and bName LIKE  #{bName}")
    public List<Book> getBookByName(@Param("store") Integer store, @Param("bName") String bName);

    @Select("select *from book  limit #{startIndex},#{pageSize}")
    public List<Book> Books(Map<String,Integer> map);

    @Select("select count(*) from book")
    public int  BookSize();
}
