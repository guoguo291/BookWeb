package com.example.bookweb.service.impl;

import com.example.bookweb.dao.StudentMapper;
import com.example.bookweb.entity.Student;
import com.example.bookweb.service.StudentService;
import com.example.bookweb.utils.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * @Author:guoj
 * @Time:2022/6/30
 * @Description:
 */
public class StudentServiceImpl implements StudentService {
    @Override
    public int countStudents() {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSession()){
            StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
            return mapper.countStudents();
        }
    }

    @Override
    public List<Student> getStudentList() {
        try(SqlSession sqlSession = MyBatisUtil.getSqlSession()){
            StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
            return mapper.getStudentList();
        }

    }
}
