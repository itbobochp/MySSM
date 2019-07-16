package com.itheima.service;

import com.itheima.daomain.Role;

import java.util.List;

public interface RoleService {

    public List<Role> findAll();


    void save(Role role);
}
