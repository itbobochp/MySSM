package com.itheima.controller;


import com.itheima.daomain.Role;
import com.itheima.daomain.UserInfo;
import com.itheima.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {


    @Autowired
    private UserService userService;

    @RequestMapping("/addRoleToUser")
    public String addRoleToUser(@RequestParam(name = "userId", required = true) String userId,String[] ids){

        userService.addRoleToUser(userId,ids);
        return "redirect:findAll";
    }

    @RequestMapping("/findUserByIdAndAllRole")
    public String findUserByIdAndAllRole(Model model,@RequestParam(name = "id", required = true) String id){

        UserInfo userInfo = userService.findById(id);
        List<Role> roleList = userService.findAllRole(id);
        model.addAttribute("user",userInfo);
        model.addAttribute("roleList",roleList);
        return "user-role-add";
    }

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
