package com.example.bookweb.servlet.merchant;

import com.example.bookweb.entity.User;
import com.example.bookweb.service.impl.BookServiceImpl;
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
 * @Time:2022/7/1
 * @Description:
 */
@WebServlet("/terminals")
public class TerminalServlet extends HttpServlet {
    private TerminalServiceImpl terminalService;
    @Override
    public void init() throws ServletException {
        terminalService = new TerminalServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Context context = new Context();
        User user = (User) req.getSession().getAttribute("user");
        context.setVariable("nickname", user.getNickname());
        context.setVariable("terminal_list",terminalService.getTerminalList());
        ThymeleafUtil.process("terminals.html",context, resp.getWriter());
    }
}
