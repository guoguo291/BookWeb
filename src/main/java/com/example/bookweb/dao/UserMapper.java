package com.example.bookweb.dao;

import com.example.bookweb.entity.Admin;
import com.example.bookweb.entity.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @Author:guoj
 * @Time:2022/6/28
 * @Description:
 */
public interface UserMapper {
    @Select("select * from user where username = #{username} and password = #{password}")
    User getUser(@Param("username") String username, @Param("password") String password);
}
