package com.itheima.dao;


import com.itheima.daomain.Role;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Service;

import java.util.List;

public interface RoleDao {

    @Select("select * from role where id in (select roleId from users_role where userId = #{id} ) ")
    public List<Role> findById(String id);

    @Select("select * from role where id in (select roleId from users_role where userId = #{id})")
    @Results({
            @Result(column = "id",property = "id"),
            @Result(column = "roleName",property = "roleName"),
            @Result(column = "roleDesc",property = "roleDesc"),
            @Result(column = "id",property = "permissions",many = @Many(select = "com.itheima.dao.PermissionsDao.findByPermissionId"))
    })
    public List<Role> findByUserId(String id);


    @Select("select * from role")
    public List<Role> findAll();

    @Insert("insert into role (roleName,roleDesc) values (#{roleName},#{roleDesc})")
    void save(Role role);
}
