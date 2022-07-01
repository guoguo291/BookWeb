package com.example.bookweb.servlet.merchant;

import com.example.bookweb.entity.User;
import com.example.bookweb.service.MerchantService;
import com.example.bookweb.service.TerminalService;
import com.example.bookweb.service.impl.BookServiceImpl;
import com.example.bookweb.service.impl.MerchantServiceImpl;
import com.example.bookweb.service.impl.StudentServiceImpl;
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
 * @Time: 2022/6/28
 * @Description:
 */
@WebServlet("/home")
public class HomeServlet extends HttpServlet {
    TerminalService terminalService;
    MerchantService merchantService;
    @Override
    public void init() throws ServletException {
        terminalService=new TerminalServiceImpl();
        merchantService=new MerchantServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("HomeServlet:"+"=====doGet");
        Context context = new Context();
        User user = (User) req.getSession().getAttribute("user");
        context.setVariable("nickname", user.getNickname());
        context.setVariable("bind_list", terminalService.getBindList());
        context.setVariable("merchant_count", merchantService.countMerchants());
        context.setVariable("terminal_count", terminalService.countTerminals());
        System.out.println("getBindList:"+terminalService.getBindList());
        ThymeleafUtil.process("home.html", context, resp.getWriter());
    }

}
