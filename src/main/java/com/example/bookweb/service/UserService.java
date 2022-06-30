package com.example.bookweb.service;

import jakarta.servlet.http.HttpSession;

/**
 * @Author:guoj
 * @Time:2022/6/28
 * @Description:
 */
public interface UserService {
    boolean auth(String username, String password, HttpSession session);
}
