package com.itheima.controller;

import com.itheima.daomain.Product;
import com.itheima.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    //添加商品信息
    @RequestMapping("/save")
    public String save(Product product){

        productService.save(product);

        return "redirect:findAll";
    }


    //查询所有商品信息
    @RequestMapping("/findAll")
    @RolesAllowed("ADMIN")
    public String findAll(Model model){

        List<Product> productList = productService.findAll();

        model.addAttribute("productList",productList);

        return "product-list";
    }
}
