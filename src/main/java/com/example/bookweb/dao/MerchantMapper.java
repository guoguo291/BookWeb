package com.example.bookweb.dao;

import com.example.bookweb.entity.Merchant;
import com.example.bookweb.entity.Student;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author:guoj
 * @Time:2022/6/30
 * @Description:
 */
public interface MerchantMapper {
    @Results({
            @Result(column = "mid",property = "mid"),
            @Result(column = "name",property = "name"),
            @Result(column = "type",property = "type"),
            @Result(column = "level",property = "level"),
            @Result(column = "phone",property = "phone"),
    })
    @Select("select * from merchant")
    List<Merchant> getMerchantList();

    @Select("select count(*) from merchant")
    int countMerchants();
}
