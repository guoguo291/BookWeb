package com.example.bookweb.entity;

import lombok.Data;

/**
 * @Author:guoj
 * @Time:2022/6/29
 * @Description:
 */
@Data
public class Book {
    int bid;
    String title;
    String desc;
    double price;
    String enable;//是否可借
}
