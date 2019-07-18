package com.itheima.controller;

import com.itheima.daomain.Permission;
import com.itheima.daomain.Role;
import com.itheima.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @RequestMapping("/addPermissionToRole")
    public String addPermissionToRole(@RequestParam(name = "roleId", required = true) String roleId,String[] ids){

        roleService.addPermissionToRole(roleId,ids);
        return "redirect:findAll";
    }

    @RequestMapping("/findRoleByIdAndAllPermission")
    public String findRoleByIdAndAllPermission(Model model,@RequestParam(name = "id", required = true) String id){

        Role role = roleService.findRoleById(id);
        List<Permission> permissionList = roleService.findAllPernission(id);
        model.addAttribute("role",role);
        model.addAttribute("permissionList",permissionList);
        return "role-permission-add";
    }

    @RequestMapping("/save")
    public String save(Role role){
        roleService.save(role);
        return "redirect:findAll";
    }

    @RequestMapping("/findAll")
    public String findAll(Model model){
        List<Role> roleList = roleService.findAll();
        model.addAttribute("roleList",roleList);
        return "role-list";
    }
}
