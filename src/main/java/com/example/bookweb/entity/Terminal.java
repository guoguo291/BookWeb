package com.example.bookweb.entity;

import lombok.Data;

/**
 * @Author:guoj
 * @Time: 2022/7/1
 * @Description:
 */
@Data
public class Terminal {
    int tid;
    String name;
    String desc;
    double price;
    boolean enable;//是否可用
}
