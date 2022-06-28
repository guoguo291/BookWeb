package com.example.bookweb.service.impl;

import com.example.bookweb.dao.UserMapper;
import com.example.bookweb.entity.Admin;
import com.example.bookweb.service.UserService;
import com.example.bookweb.utils.MyBatisUtil;
import jakarta.servlet.http.HttpSession;
import org.apache.ibatis.session.SqlSession;

/**
 * @Author:guoj
 * @Time:2022/6/28
 * @Description:
 */
public class UserServiceImpl implements UserService {
    @Override
    public boolean auth(String username, String password, HttpSession session) {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        Admin admin = mapper.getAdmin(username, password);
        if (admin!=null){
            session.setAttribute("admin",admin);
            return true;
        }
        return false;
    }

    @Override
    public boolean auth(String username, String password) {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        Admin admin = mapper.getAdmin(username, password);
        return admin != null;
    }
}
