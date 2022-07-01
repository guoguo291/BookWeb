package com.example.bookweb.entity;

import lombok.Data;

/**
 * @Author:guoj
 * @Time: 2022/7/1
 * @Description:
 */
@Data
public class Merchant {
    int mid;
    String name;
    String type;
    int level;
    String phone;
}
