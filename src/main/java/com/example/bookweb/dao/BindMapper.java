package com.example.bookweb.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

/**
 * @Author:guoj
 * @Time:2022/6/30
 * @Description:
 */
public interface BindMapper {
    @Insert("insert into bind_terminal (mid,tid,time) values(#{mid},#{tid},NOW())")
    void bindTerminal(@Param("mid") int mid,@Param("tid") int tid);
    @Delete("delete from bind_terminal where id = #{id}")
    void unBindTerminal(@Param("id")String id);
}
