package com.example.bookweb.service;

/**
 * @Author:guoj
 * @Time:2022/7/1
 * @Description:
 */
public interface BindTerminalService {
    void bindTerminal(int mid,int tid);
    void unBindTerminal(String id,String tid);
}
