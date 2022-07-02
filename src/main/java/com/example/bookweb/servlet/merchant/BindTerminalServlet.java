package com.example.bookweb.servlet.merchant;

import com.example.bookweb.entity.Book;
import com.example.bookweb.entity.Merchant;
import com.example.bookweb.entity.Student;
import com.example.bookweb.entity.Terminal;
import com.example.bookweb.service.impl.*;
import com.example.bookweb.utils.ThymeleafUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.thymeleaf.context.Context;

import java.io.IOException;
import java.util.List;

/**
 * @Author:guoj
 * @Time: 2022/6/30
 * @Description:
 */
@WebServlet("/bind-terminal")
public class BindTerminalServlet extends HttpServlet {
    private TerminalServiceImpl terminalService;
    private BindTerminalServiceImpl bindTerminalService;
    private MerchantServiceImpl merchantService;

    @Override
    public void init() throws ServletException {
        terminalService = new TerminalServiceImpl();
        merchantService = new MerchantServiceImpl();
        bindTerminalService=new BindTerminalServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Context context = new Context();
        List<Terminal> enableTerminalList = terminalService.getEnableTerminalList();
        List<Merchant> merchantList = merchantService.getMerchantList();
        context.setVariable("terminal_list", enableTerminalList);
        context.setVariable("merchant_list", merchantList);
        ThymeleafUtil.process("bind-terminal.html", context, resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String mid = req.getParameter("merchant");
        String tid = req.getParameter("terminal");

        if (mid!=null&&tid!=null){
            bindTerminalService.bindTerminal(Integer.parseInt(mid),Integer.parseInt(tid));
            boolean updateBookStatus = terminalService.updateTerminalStatus(false, tid);
            resp.sendRedirect("home");
        }
    }
}
