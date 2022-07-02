package com.example.bookweb.servlet.merchant;

import com.example.bookweb.service.impl.BindTerminalServiceImpl;
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
@WebServlet("/unbind-terminal")
public class UnbindTerminalServlet extends HttpServlet {
    BindTerminalServiceImpl bindTerminalService;
    @Override
    public void init() throws ServletException {
        bindTerminalService = new BindTerminalServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String id = req.getParameter("id");
        String tid=req.getParameter("tid");
        bindTerminalService.unBindTerminal(id,tid);//解绑终端
        resp.sendRedirect("home");
    }
}
