package com.example.bookweb.service.impl;

import com.example.bookweb.dao.BookMapper;
import com.example.bookweb.dao.BorrowMapper;
import com.example.bookweb.service.BorrowService;
import com.example.bookweb.utils.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

/**
 * @Author:guoj
 * @Time: 2022/7/1
 * @Description:
 */
public class BorrowServiceImpl implements BorrowService {

    @Override
    public void addBorrow(int sid, int bid) {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSession()) {
            BorrowMapper mapper = sqlSession.getMapper(BorrowMapper.class);
            mapper.addBorrow(sid, bid);
        }
    }

    @Override
    public void deleteBorrow(String id,String bid) {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSession(false)) {
            BorrowMapper borrowMapper = sqlSession.getMapper(BorrowMapper.class);
            BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);
            borrowMapper.deleteBorrow(id);
            bookMapper.updateBookStatus("是",bid);
            sqlSession.commit();
        }
    }
}
