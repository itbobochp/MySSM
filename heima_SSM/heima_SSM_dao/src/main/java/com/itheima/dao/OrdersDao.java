package com.itheima.dao;

import com.itheima.daomain.Orders;
import com.itheima.daomain.Product;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface OrdersDao {

    //查询订单
    @Select("select * from orders")
    @Results({
            @Result(column = "id",property = "id"),
            @Result(column = "orderNum",property = "orderNum"),
            @Result(column = "orderTime",property = "orderTime"),
            @Result(column = "orderStatus",property = "orderStatus"),
            @Result(column = "peopleCount",property = "peopleCount"),
            @Result(column = "payType",property = "payType"),
            @Result(column = "orderDesc",property = "orderDesc"),
            @Result(column = "productId",property = "product",
                    one = @One(select = "com.itheima.dao.ProductDao.findByProductId"))
    })
    public List<Orders> findAll();

    //查询订单详情
    @Select("select * from orders where id = #{id}")
    @Results({
            @Result(column = "id",property = "id"),
            @Result(column = "orderNum",property = "orderNum"),
            @Result(column = "orderTime",property = "orderTime"),
            @Result(column = "orderStatus",property = "orderStatus"),
            @Result(column = "peopleCount",property = "peopleCount"),
            @Result(column = "payType",property = "payType"),
            @Result(column = "orderDesc",property = "orderDesc"),
            @Result(column = "productId",property = "product", one = @One(select = "com.itheima.dao.ProductDao.findByProductId")),
            @Result(column = "memberId",property = "member", one = @One(select = "com.itheima.dao.MemberDao.findBymemberId")),
            @Result(column = "id",property ="travellers", many = @Many(select = "com.itheima.dao.TravellerDao.findByTravellerId"))
    })
    public Orders findById(String id);
}
