package com.example.bookweb.entity;

import lombok.Data;

import java.util.Date;

/**
 * @Author:guoj
 * @Time:2022/7/1
 * @Description:
 */
@Data
public class BindTerminal {
    int id;
    int terminal_id;
    String terminal_name;
    Date time;
    String merchant_name;
    int merchant_id;
}
