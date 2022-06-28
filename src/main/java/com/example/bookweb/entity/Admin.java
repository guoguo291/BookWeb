package com.example.bookweb.entity;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * @Author:guoj
 * @Time:2022/6/28
 * @Description:
 */
@Data
@RequiredArgsConstructor
public class Admin {
    int id;
    @NonNull
    String username;
    @NonNull
    String password;
}
