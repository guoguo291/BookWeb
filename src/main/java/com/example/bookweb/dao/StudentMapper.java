package com.example.bookweb.dao;

import com.example.bookweb.entity.Student;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author:guoj
 * @Time:2022/6/30
 * @Description:
 */
public interface StudentMapper {
    @Results({
            @Result(column = "sid",property = "sid"),
            @Result(column = "name",property = "name"),
            @Result(column = "sex",property = "sex"),
            @Result(column = "grade",property = "grade"),
    })
    @Select("select * from student")
    List<Student> getStudentList();

    @Select("select count(*) from student")
    int countStudents();
}
