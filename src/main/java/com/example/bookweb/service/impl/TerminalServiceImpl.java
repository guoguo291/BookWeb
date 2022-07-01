package com.example.bookweb.service.impl;

import com.example.bookweb.dao.BookMapper;
import com.example.bookweb.dao.TerminalMapper;
import com.example.bookweb.entity.BindTerminal;
import com.example.bookweb.entity.Book;
import com.example.bookweb.entity.Borrow;
import com.example.bookweb.entity.Terminal;
import com.example.bookweb.service.BookService;
import com.example.bookweb.service.TerminalService;
import com.example.bookweb.utils.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * @Author:guoj
 * @Time:2022/6/29
 * @Description:
 */
public class TerminalServiceImpl implements TerminalService {
    @Override
    public List<BindTerminal> getBindList() {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSession()) {
            TerminalMapper terminalMapper = sqlSession.getMapper(TerminalMapper.class);
            return terminalMapper.getBindList();
        }
    }

    @Override
    public List<Terminal> getEnableTerminalList() {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSession()) {
            TerminalMapper terminalMapper = sqlSession.getMapper(TerminalMapper.class);
            return terminalMapper.getEnableTerminalList();
        }
    }

    @Override
    public List<Terminal> getTerminalList() {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSession()) {
            TerminalMapper terminalMapper = sqlSession.getMapper(TerminalMapper.class);
            return terminalMapper.getTerminalList();
        }
    }

    @Override
    public boolean updateTerminalStatus(boolean enable, String tid) {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSession()) {
            TerminalMapper terminalMapper = sqlSession.getMapper(TerminalMapper.class);
            return terminalMapper.updateTerminalStatus(enable,tid);
        }
    }

    @Override
    public int countTerminals() {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSession()) {
            TerminalMapper terminalMapper = sqlSession.getMapper(TerminalMapper.class);
            return terminalMapper.countTerminals();
        }
    }

    @Override
    public int addTerminal(int tid, String name, String desc, double price) {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSession()) {
            TerminalMapper terminalMapper = sqlSession.getMapper(TerminalMapper.class);
            return terminalMapper.addTerminal(tid, name, desc, price);
        }
    }
}
