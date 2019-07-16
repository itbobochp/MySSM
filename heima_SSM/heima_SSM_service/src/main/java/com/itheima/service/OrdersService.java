package com.itheima.service;

import com.itheima.daomain.Orders;

import java.util.List;

public interface OrdersService {

    public List<Orders> findAll(int page,int pageSize);

    Orders findById(String id);
}
