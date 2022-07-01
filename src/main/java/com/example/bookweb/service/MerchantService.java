package com.example.bookweb.service;

import com.example.bookweb.entity.Merchant;
import com.example.bookweb.entity.Student;

import java.util.List;

/**
 * @Author:guoj
 * @Time:2022/6/30
 * @Description:
 */
public interface MerchantService {
    int countMerchants();
    List<Merchant> getMerchantList();
}
