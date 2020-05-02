package com.atguigu.springboot.mapper;

import com.atguigu.springboot.entities.Manager;
import org.apache.ibatis.annotations.*;

@Mapper
public interface ManagerMapper {
    @Select("select * from Manager where mid=#{mid}")
    public Manager getManagerById(Integer mid);

    @Delete("delete from Manager where id = #{mid}")
    public Integer deleteManagerById(Integer mid);

    @Options(useGeneratedKeys = true,keyProperty = "mid")
    @Insert("INSERT INTO manager ( mName, mUsername, mPassword, is_deleted, store )VALUES ( #{mName}, #{mUsername}, #{mPassword}, #{is_deleted}, #{store} )")
    public Integer insertManager(Manager manager);

    @Select("select * from manager where mUsername =  #{mUsername} AND mPassword= #{mPassword}")
    public Manager login(@Param("mUsername") String mUsername, @Param("mPassword") String mPassword);

   //未改
    @Update("UPDATE manager SET mName = (#{mName}), email= (#{email})," +
            " gender = (#{gender}), phone = (#{phone}) WHERE `mid` = (#{mid})")
    public int updateManager(Manager manager);

    @Select("select * from Manager where mUsername=#{mName}")
    Manager getManagerBymName(String mName);
}
