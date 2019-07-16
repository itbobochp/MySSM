package com.itheima.controller;

import com.github.pagehelper.PageInfo;
import com.itheima.daomain.Orders;
import com.itheima.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrdersController {

    @Autowired
    private OrdersService ordersService;

    @RequestMapping("/findAll")
    public String findAll(Model model,@RequestParam(name = "page", required = true, defaultValue = "1") Integer page,
                          @RequestParam(name = "pageSize", required = true, defaultValue = "4") Integer pageSize){
        List<Orders> orders = ordersService.findAll(page,pageSize);
        PageInfo pageInfo = new PageInfo(orders);
        model.addAttribute("pageInfo",pageInfo);
        return "orders-list";
    }

    @RequestMapping("/findById")
    public String findById(Model model,String id){
       Orders orders = ordersService.findById(id);
        model.addAttribute("orders",orders);
        return "orders-show";
    }
}
