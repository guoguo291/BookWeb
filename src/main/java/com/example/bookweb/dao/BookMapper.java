package com.example.bookweb.dao;

import com.example.bookweb.entity.Book;
import com.example.bookweb.entity.Borrow;
import org.apache.ibatis.annotations.*;

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

    @Results({
            @Result(column = "bid",property = "bid"),
            @Result(column = "price",property = "price"),
            @Result(column = "title",property = "title"),
            @Result(column = "desc",property = "desc"),
            @Result(column = "enable",property = "enable")
    })
    @Select("select * from book")
    List<Book> getBookList();

    @Update("update book set enable = #{enable} where bid =#{bid}")
    boolean updateBookStatus(@Param("enable") String enable,@Param("bid") String bid);

    @Select("select count(*) from book")
    int countBooks();
    @Insert("insert into book(bid, title, `desc`, price) values (#{bid}, #{title}, #{desc}, #{price})")
    int addBook(@Param("bid")int bid,@Param("title")String title,@Param("desc")String desc,@Param("price")double price);
}
