package com.itheima.service;

import com.itheima.daomain.Product;

import java.util.List;

public interface ProductService {

    public List<Product> findAll();

    void save(Product product);
}
