package com.example.bookweb.servlet;

import com.example.bookweb.service.impl.UserServiceImpl;
import com.example.bookweb.utils.ThymeleafUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.java.Log;
import org.thymeleaf.context.Context;

import java.io.IOException;

/**
 * @Author:guoj
 * @Time:2022/6/28
 * @Description:
 */
@Log
@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    UserServiceImpl userService;

    @Override
    public void init() throws ServletException {
        userService = new UserServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //这里校验cookie，如果有就直接进入主页
        Cookie[] cookies = req.getCookies();
        if (cookies!=null){
            String username = null;
            String password = null;
            for (Cookie cookie:cookies) {
                if ("username".equals(cookie.getName()))username=cookie.getValue();
                if ("password".equals(cookie.getName()))password=cookie.getValue();
            }
            if (username!=null&&password!=null){
                if (userService.auth(username,password, req.getSession())) {
                    resp.sendRedirect("home");
                    return;
                }
            }
        }
        Context context = new Context();
        if(req.getSession().getAttribute("login-failure") != null){
            context.setVariable("failure", true);
            req.getSession().removeAttribute("login-failure");
        }
        if(req.getSession().getAttribute("user") != null) {
            resp.sendRedirect("home");
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
        if (userService.auth(username, password, req.getSession())){
            if (remember!=null){
                Cookie cookie_username = new Cookie("username", username);
                Cookie cookie_password = new Cookie("password", password);
                cookie_username.setMaxAge(60*2);
                cookie_password.setMaxAge(60*2);
                resp.addCookie(cookie_username);
                resp.addCookie(cookie_password);
            }
            log.info("LoginServlet:"+"auth success!!!");
            resp.sendRedirect("home");
        }else {
            log.info("LoginServlet:\"+\"auth fail!!!");
            req.getSession().setAttribute("login-failure",new Object());
            this.doGet(req, resp);
        }

    }
}
