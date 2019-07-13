package com.itheima.service.impl;

import com.itheima.dao.ProductDao;
import com.itheima.daomain.Product;
import com.itheima.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    //查询所有商品信息
    @Override
    public List<Product> findAll() {

        return productDao.findAll();
    }

    //添加商品信息
    @Override
    public void save(Product product) {

        productDao.save(product);
    }
}
