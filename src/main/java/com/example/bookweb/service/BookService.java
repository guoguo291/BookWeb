package com.example.bookweb.service;

import com.example.bookweb.entity.Borrow;

import java.util.List;

/**
 * @Author:guoj
 * @Time:2022/6/29
 * @Description:
 */
public interface BookService {
    List<Borrow> getBorrowList();
}
