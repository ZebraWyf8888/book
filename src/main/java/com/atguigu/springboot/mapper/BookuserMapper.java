package com.atguigu.springboot.mapper;

import com.atguigu.springboot.entities.Bookuser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface BookuserMapper {
    @Select("select * from Bookuser where uname =  #{uname} AND upassword= #{upassword}")
    public Bookuser login(@Param("uname") String uname, @Param("upassword") String upassword);
}
