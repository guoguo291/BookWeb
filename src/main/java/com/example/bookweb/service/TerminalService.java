package com.example.bookweb.service;

import com.example.bookweb.entity.BindTerminal;
import com.example.bookweb.entity.Book;
import com.example.bookweb.entity.Borrow;
import com.example.bookweb.entity.Terminal;

import java.util.List;

/**
 * @Author:guoj
 * @Time:2022/6/29
 * @Description:
 */
public interface TerminalService {
    List<BindTerminal> getBindList();
    List<Terminal> getEnableTerminalList();
    List<Terminal> getTerminalList();
    boolean updateTerminalStatus(boolean enable,String id);
    int countTerminals();
    int addTerminal(int tid,String name,String desc,double price);
}
