package com.example.bookweb.servlet;

import com.example.bookweb.entity.User;
import com.example.bookweb.service.impl.BookServiceImpl;
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
 * @Time:2022/7/1
 * @Description:
 */
@WebServlet("/books")
public class BookServlet extends HttpServlet {
    private BookServiceImpl bookService;
    @Override
    public void init() throws ServletException {
        bookService = new BookServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Context context = new Context();
        User user = (User) req.getSession().getAttribute("user");
        context.setVariable("nickname", user.getNickname());
        context.setVariable("book_list",bookService.getBookList());
        ThymeleafUtil.process("books.html",context, resp.getWriter());
    }
}
