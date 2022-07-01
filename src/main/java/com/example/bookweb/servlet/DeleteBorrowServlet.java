package com.example.bookweb.servlet;

import com.example.bookweb.service.impl.BorrowServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * @Author:guoj
 * @Time:2022/7/1
 * @Description:
 */
@WebServlet("/return-book")
public class DeleteBorrowServlet extends HttpServlet {
    BorrowServiceImpl borrowService;
    @Override
    public void init() throws ServletException {
        borrowService = new BorrowServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String id = req.getParameter("id");
        String bid=req.getParameter("bid");
        borrowService.deleteBorrow(id,bid);//还书
        resp.sendRedirect("index");
    }
}
