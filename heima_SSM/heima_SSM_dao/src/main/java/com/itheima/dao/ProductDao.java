package com.itheima.dao;

import com.itheima.daomain.Product;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ProductDao {

    //查询所有商品信息
    @Select("select * from product")
    public List<Product> findAll();

    //添加商品信息
    @Insert("insert into product(productNum,productName,cityName,departureTime,productPrice,productDesc,productStatus) values(#{productNum},#{productName},#{cityName},#{departureTime},#{productPrice},#{productDesc},#{productStatus})")
    void save(Product product);
}
