package com.example.bookweb.service;

import org.apache.ibatis.annotations.Param;

/**
 * @Author:guoj
 * @Time:2022/7/1
 * @Description:
 */
public interface BorrowService {
    void addBorrow(int sid,int bid);
    void deleteBorrow(String id,String bid);
}
