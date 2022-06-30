package com.example.bookweb.servlet;

import com.example.bookweb.entity.Student;
import com.example.bookweb.service.impl.StudentServiceImpl;
import com.example.bookweb.utils.ThymeleafUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.thymeleaf.context.Context;
import org.thymeleaf.context.IContext;

import java.io.IOException;
import java.util.List;

/**
 * @Author:guoj
 * @Time:2022/6/30
 * @Description:
 */
@WebServlet("/students")
public class StudentsServlet extends HttpServlet {
    private StudentServiceImpl studentService;
    @Override
    public void init() throws ServletException {
        studentService=new StudentServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Student> studentList = studentService.getStudentList();
        Context context=new Context();
        context.setVariable("student_list",studentService.getStudentList());
        ThymeleafUtil.process("students.html",context,resp.getWriter());
    }
}
