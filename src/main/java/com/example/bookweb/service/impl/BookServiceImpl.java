package com.example.bookweb.service.impl;

import com.example.bookweb.dao.BookMapper;
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
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);
        return bookMapper.getBorrowList();
    }
}
