package com.example.bookweb.servlet.merchant;

import com.example.bookweb.entity.Merchant;
import com.example.bookweb.entity.Student;
import com.example.bookweb.service.impl.MerchantServiceImpl;
import com.example.bookweb.service.impl.StudentServiceImpl;
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
 * @Time:2022/6/30
 * @Description:
 */
@WebServlet("/merchants")
public class MerchantsServlet extends HttpServlet {
    private MerchantServiceImpl merchantService;
    @Override
    public void init() throws ServletException {
        merchantService=new MerchantServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Merchant> merchantList = merchantService.getMerchantList();
        Context context=new Context();
        context.setVariable("merchant_list",merchantService.getMerchantList());
        ThymeleafUtil.process("merchants.html",context,resp.getWriter());
    }
}
