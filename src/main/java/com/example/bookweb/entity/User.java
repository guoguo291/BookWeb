package com.example.bookweb.entity;

import lombok.Data;

@Data
public class User {
    int id;
    String username;
    String nickname;
    String password;
}
