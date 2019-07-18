package com.itheima.service;

import com.itheima.daomain.Permission;
import com.itheima.daomain.Role;

import java.util.List;

public interface RoleService {

    public List<Role> findAll();


    void save(Role role);


    Role findRoleById(String id);

    List<Permission> findAllPernission(String id);

    void addPermissionToRole(String roleId, String[] ids);
}
