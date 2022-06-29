package com.example.bookweb.entity;

import lombok.Data;

import java.util.Date;

/**
 * @Author:guoj
 * @Time:2022/6/29
 * @Description:
 */
@Data
public class Borrow {
    int id;
    int book_id;
    String book_name;
    Date time;
    String student_name;
    int student_id;
}
