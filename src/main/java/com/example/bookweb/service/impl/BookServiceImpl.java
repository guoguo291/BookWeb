package com.example.bookweb.service.impl;

import com.example.bookweb.dao.BookMapper;
import com.example.bookweb.entity.Book;
import com.example.bookweb.entity.Borrow;
import com.example.bookweb.service.BookService;
import com.example.bookweb.utils.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * @Author:guoj
 * @Time:2022/6/29
 * @Description:
 */
public class BookServiceImpl implements BookService {

    @Override
    public List<Borrow> getBorrowList() {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSession()) {
            BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);
            return bookMapper.getBorrowList();
        }
    }

    @Override
    public List<Book> getEnableBookList() {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSession()) {
            BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);
            return bookMapper.getEnableBookList();
        }
    }

    @Override
    public List<Book> getBookList() {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSession()) {
            BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);
            return bookMapper.getBookList();
        }
    }

    @Override
    public boolean updateBookStatus(String enable, String bid) {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSession()) {
            BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);
            return bookMapper.updateBookStatus(enable,bid);
        }
    }

    @Override
    public int countBooks() {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSession()) {
            BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);
            return bookMapper.countBooks();
        }
    }

    @Override
    public int addBook(int bid, String title, String desc, double price) {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSession()) {
            BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);
            return bookMapper.addBook(bid, title, desc, price);
        }
    }
}
