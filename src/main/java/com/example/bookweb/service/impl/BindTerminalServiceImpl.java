package com.example.bookweb.service.impl;

import com.example.bookweb.dao.BindMapper;
import com.example.bookweb.dao.BookMapper;
import com.example.bookweb.dao.BorrowMapper;
import com.example.bookweb.dao.TerminalMapper;
import com.example.bookweb.service.BindTerminalService;
import com.example.bookweb.service.BorrowService;
import com.example.bookweb.utils.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

/**
 * @Author:guoj
 * @Time: 2022/7/1
 * @Description:
 */
public class BindTerminalServiceImpl implements BindTerminalService {

    @Override
    public void bindTerminal(int mid, int tid) {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSession()) {
            BindMapper mapper = sqlSession.getMapper(BindMapper.class);
            mapper.bindTerminal(mid, tid);
        }
    }

    @Override
    public void unBindTerminal(String id, String tid) {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSession(false)) {
            BindMapper bindTerminalMapper = sqlSession.getMapper(BindMapper.class);
            TerminalMapper terminalMapper = sqlSession.getMapper(TerminalMapper.class);
            bindTerminalMapper.unBindTerminal(id);
            terminalMapper.updateTerminalStatus(true,tid);
            sqlSession.commit();
        }
    }
}
