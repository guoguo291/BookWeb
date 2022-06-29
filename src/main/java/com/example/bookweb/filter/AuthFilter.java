package com.example.bookweb.filter;

import com.example.bookweb.entity.Admin;
import com.example.bookweb.entity.User;
import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * @Author:guoj
 * @Time:2022/6/28
 * @Description:
 */
@WebFilter("/*")
public class AuthFilter extends HttpFilter {
    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        String url = req.getRequestURL().toString();
        if(!url.contains("/static/") && !url.endsWith("login")){
            HttpSession session = req.getSession();
            User user  = (User) session.getAttribute("user");
            if(user == null) {
                res.sendRedirect("login");
                return;
            }
        }
        chain.doFilter(req, res);
    }

}
