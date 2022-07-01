package com.example.bookweb.service.impl;

import com.example.bookweb.dao.MerchantMapper;
import com.example.bookweb.dao.StudentMapper;
import com.example.bookweb.entity.Merchant;
import com.example.bookweb.entity.Student;
import com.example.bookweb.service.MerchantService;
import com.example.bookweb.service.StudentService;
import com.example.bookweb.utils.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * @Author:guoj
 * @Time:2022/6/30
 * @Description:
 */
public class MerchantServiceImpl implements MerchantService {
    @Override
    public int countMerchants() {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSession()){
            MerchantMapper mapper = sqlSession.getMapper(MerchantMapper.class);
            return mapper.countMerchants();
        }
    }

    @Override
    public List<Merchant> getMerchantList() {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSession()){
            MerchantMapper mapper = sqlSession.getMapper(MerchantMapper.class);
            return mapper.getMerchantList();
        }
    }
}
