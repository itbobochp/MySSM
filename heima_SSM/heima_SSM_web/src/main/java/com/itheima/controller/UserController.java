package com.itheima.controller;


import com.itheima.daomain.UserInfo;
import com.itheima.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {


    @Autowired
    private UserService userService;

    @RequestMapping("/findById")
    public String findById(Model model,@RequestParam(name = "id", required = true) String id){
       UserInfo userInfo = userService.findById(id);
       model.addAttribute("user",userInfo);
       return "user-show";
    }

    @RequestMapping("/save")
    public String save(UserInfo user){

        userService.save(user);

        return "redirect:findAll";
    }

    @RequestMapping("/findAll")
    public String  findAll(Model model){

        List<UserInfo> userInfoList = userService.findAll();

        model.addAttribute("userList",userInfoList);

        return "user-list";
    }
}
