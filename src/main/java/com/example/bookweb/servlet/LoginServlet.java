package com.example.bookweb.servlet;

import com.example.bookweb.service.impl.UserServiceImpl;
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
@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    UserServiceImpl userService;

    @Override
    public void init() throws ServletException {
        userService = new UserServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Context context = new Context();
        if(req.getSession().getAttribute("login-failure") != null){
            context.setVariable("failure", true);
            req.getSession().removeAttribute("login-failure");
        }
        if(req.getSession().getAttribute("user") != null) {
            resp.sendRedirect("index");
            return;
        }
        ThymeleafUtil.process("login.html", context, resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String remember = req.getParameter("remember-me");
        System.out.println("remember:"+remember);
        if (remember!=null?userService.auth(username, password, req.getSession()):userService.auth(username, password)){
            System.out.println("LoginServlet:"+"auth success!!!");
            resp.sendRedirect("index");
        }else {
            System.out.println("LoginServlet:"+"auth fail!!!");
            req.getSession().setAttribute("login-failure",new Object());
            this.doGet(req, resp);
        }

    }
}
