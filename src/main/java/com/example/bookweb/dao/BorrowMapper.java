package com.example.bookweb.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

/**
 * @Author:guoj
 * @Time:2022/6/30
 * @Description:
 */
public interface BorrowMapper {
    @Insert("insert into borrow(sid,bid,time) values(#{sid},#{bid},NOW())")
    void addBorrow(@Param("sid") int sid,@Param("bid") int bid);
    @Delete("delete from borrow where id = #{id}")
    void deleteBorrow(@Param("id")String id);
}
