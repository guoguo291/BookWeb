package com.example.bookweb.dao;

import com.example.bookweb.entity.BindTerminal;
import com.example.bookweb.entity.Book;
import com.example.bookweb.entity.Borrow;
import com.example.bookweb.entity.Terminal;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @Author:guoj
 * @Time:2022/6/29
 * @Description:
 */
public interface TerminalMapper {
    @Results({
            @Result(column = "id",property = "id"),
            @Result(column = "mid",property = "merchant_id"),
            @Result(column = "tid",property = "terminal_id"),
            @Result(column = "device_name",property = "terminal_name"),
            @Result(column = "name",property = "merchant_name"),
            @Result(column = "time",property = "time")
    })
    @Select("select * from bind_terminal,merchant,terminal where bind_terminal.tid = terminal.tid and merchant.mid = bind_terminal.mid")
    List<BindTerminal> getBindList();

    @Results({
            @Result(column = "bid",property = "bid"),
            @Result(column = "price",property = "price"),
            @Result(column = "device_name",property = "name"),
            @Result(column = "desc",property = "desc"),
            @Result(column = "enable",property = "enable")
    })
    @Select("select * from terminal where enable = '1'")
    List<Terminal> getEnableTerminalList();

    @Results({
            @Result(column = "tid",property = "tid"),
            @Result(column = "price",property = "price"),
            @Result(column = "device_name",property = "name"),
            @Result(column = "desc",property = "desc"),
            @Result(column = "enable",property = "enable")
    })
    @Select("select * from terminal")
    List<Terminal> getTerminalList();

    @Update("update terminal set enable = #{enable} where tid =#{tid}")
    boolean updateTerminalStatus(@Param("enable") boolean enable,@Param("tid") String tid);

    @Select("select count(*) from terminal")
    int countTerminals();
    @Insert("insert into terminal(tid, device_name, `desc`, price,enable) values (#{tid}, #{device_name}, #{desc}, #{price},1)")
    int addTerminal(@Param("tid")int tid,@Param("device_name")String device_name,@Param("desc")String desc,@Param("price")double price);
}
