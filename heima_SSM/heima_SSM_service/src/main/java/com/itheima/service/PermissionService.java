package com.itheima.service;

import com.itheima.daomain.Permission;

import java.util.List;

public interface PermissionService {

    public List<Permission> findAll();

    void save(Permission permission);

    Permission findById(String id);
}
