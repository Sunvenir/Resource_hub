package com.example.demo.mapper;

import com.example.demo.entity.User;
import org.apache.ibatis.annotations.*;

public interface UserMapper {
    @Insert({"insert into User(UID,password,status) values(#{UID},#{password},#{status})"})
    int insert(User user);

    @Select("select * from User where UID=#{UID}")
    User getByUId(String UID);
}
