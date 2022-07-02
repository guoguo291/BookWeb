package com.example.bookweb.servlet.merchant;

import com.example.bookweb.service.impl.TerminalServiceImpl;
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
 * @Time: 2022/7/1
 * @Description:
 */
@WebServlet("/add-terminal")
public class AddTerminalServlet extends HttpServlet {
    TerminalServiceImpl terminalService;
    @Override
    public void init() throws ServletException {
        terminalService = new TerminalServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Context context = new Context();
        ThymeleafUtil.process("add-terminal.html",context, resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String tid = req.getParameter("tid");
        String name = req.getParameter("name");
        String desc=req.getParameter("desc");
        String price = req.getParameter("price");
        terminalService.addTerminal(Integer.parseInt(tid),name,desc,Double.parseDouble(price));
        resp.sendRedirect("terminals");
    }
}
