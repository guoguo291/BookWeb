package com.example.bookweb.servlet;

import com.example.bookweb.entity.User;
import com.example.bookweb.service.impl.BookServiceImpl;
import com.example.bookweb.service.impl.StudentServiceImpl;
import com.example.bookweb.utils.ThymeleafUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.thymeleaf.context.Context;

import java.io.IOException;

/**
 * @Author:guoj
 * @Time:2022/6/28
 * @Description:
 */
@WebServlet("/index")
public class IndexServlet extends HttpServlet {
    BookServiceImpl bookService;
    StudentServiceImpl studentService;
    @Override
    public void init() throws ServletException {
        bookService=new BookServiceImpl();
        studentService=new StudentServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("IndexServlet:"+"=====doGet");
        Context context = new Context();
        User user = (User) req.getSession().getAttribute("user");
        context.setVariable("nickname", user.getNickname());
        context.setVariable("borrow_list", bookService.getBorrowList());
        context.setVariable("student_count", studentService.countStudents());
        context.setVariable("book_count", bookService.countBooks());
        System.out.println("borrow_list:"+bookService.getBorrowList());
        ThymeleafUtil.process("index.html", context, resp.getWriter());
    }

}
