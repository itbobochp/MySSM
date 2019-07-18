package com.itheima.service.impl;

import com.itheima.dao.RoleDao;
import com.itheima.daomain.Permission;
import com.itheima.daomain.Role;
import com.itheima.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;

    @Override
    public List<Role> findAll() {
        return roleDao.findAll();
    }

    @Override
    public void save(Role role) {
         roleDao.save(role);
    }

    @Override
    public Role findRoleById(String id) {
        return roleDao.findRoleById(id);
    }

    @Override
    public List<Permission> findAllPernission(String id) {
        return roleDao.findAllPernission(id);
    }

    @Override
    public void addPermissionToRole(String roleId, String[] ids) {
        for (String permissionId : ids) {
            roleDao.addPermissionToRole(roleId,permissionId);
        }
    }


}
