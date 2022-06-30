package com.example.bookweb.dao;

import com.example.bookweb.entity.Book;
import com.example.bookweb.entity.Borrow;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author:guoj
 * @Time:2022/6/29
 * @Description:
 */
public interface BookMapper {
    @Results({
            @Result(column = "id",property = "id"),
            @Result(column = "sid",property = "student_id"),
            @Result(column = "bid",property = "book_id"),
            @Result(column = "title",property = "book_name"),
            @Result(column = "name",property = "student_name"),
            @Result(column = "time",property = "time")
    })
    @Select("select * from borrow,student,book where borrow.bid = book.bid and student.sid = borrow.sid")
    List<Borrow> getBorrowList();

    @Results({
            @Result(column = "bid",property = "bid"),
            @Result(column = "price",property = "price"),
            @Result(column = "title",property = "title"),
            @Result(column = "desc",property = "desc"),
            @Result(column = "enable",property = "enable")
    })
    @Select("select * from book where enable = '是'")
    List<Book> getEnableBookList();
}
