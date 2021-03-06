package com.itheima.service;

import com.itheima.daomain.Role;
import com.itheima.daomain.UserInfo;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {


    List<UserInfo> findAll();

    void save(UserInfo user);

    UserInfo findById(String id);

    List<Role> findAllRole(String id);

    void addRoleToUser(String userId, String[] ids);
}
