package com.example.bookweb.servlet;

import com.example.bookweb.entity.Book;
import com.example.bookweb.entity.Student;
import com.example.bookweb.service.impl.BookServiceImpl;
import com.example.bookweb.service.impl.BorrowServiceImpl;
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
 * @Time: 2022/6/30
 * @Description:
 */
@WebServlet("/add-borrow")
public class AddBorrowServlet extends HttpServlet {
    private BookServiceImpl bookService;
    private BorrowServiceImpl borrowService;
    private StudentServiceImpl studentService;

    @Override
    public void init() throws ServletException {
        bookService = new BookServiceImpl();
        studentService = new StudentServiceImpl();
        borrowService=new BorrowServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Context context = new Context();
        List<Book> enableBookList = bookService.getEnableBookList();
        List<Student> studentList = studentService.getStudentList();
        context.setVariable("book_list", enableBookList);
        context.setVariable("student_list", studentList);
        ThymeleafUtil.process("add-borrow.html", context, resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String sid = req.getParameter("student");
        String bid = req.getParameter("book");
        log("========sid:"+sid);
        log("========bid:"+bid);
        if (sid!=null&&bid!=null){
            borrowService.addBorrow(Integer.parseInt(sid),Integer.parseInt(bid));
            boolean updateBookStatus = bookService.updateBookStatus("否", bid);
            log("========bookService.updateBookStatus:"+updateBookStatus);
            resp.sendRedirect("index");
        }
    }
}
