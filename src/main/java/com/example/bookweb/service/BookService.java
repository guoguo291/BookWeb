package com.example.bookweb.service;

import com.example.bookweb.entity.Book;
import com.example.bookweb.entity.Borrow;

import java.util.List;

/**
 * @Author:guoj
 * @Time:2022/6/29
 * @Description:
 */
public interface BookService {
    List<Borrow> getBorrowList();
    List<Book> getEnableBookList();
    List<Book> getBookList();
    boolean updateBookStatus(String enable,String bid);
    int countBooks();
    int addBook(int bid,String title,String desc,double price);
}
