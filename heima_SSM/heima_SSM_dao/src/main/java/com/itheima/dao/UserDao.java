package com.itheima.dao;

import com.itheima.daomain.Role;
import com.itheima.daomain.UserInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserDao {


    @Select("select * from users where username = #{username}")
    @Results({
            @Result(column = "id",property = "id"),
            @Result(column = "username",property = "username"),
            @Result(column = "email",property = "email"),
            @Result(column = "password",property = "password"),
            @Result(column = "phoneNum",property = "phoneNum"),
            @Result(column = "status",property = "status"),
            @Result(column = "id",property = "roles",many = @Many(select ="com.itheima.dao.RoleDao.findById"))
    })
    public UserInfo findByUsername(String username);


    @Select("select * from users")
    List<UserInfo> findAll();

    @Insert("insert into users (email,username,password,phoneNum,status) values(#{email},#{username},#{password},#{phoneNum},#{status})")
    void save(UserInfo user);

    @Select("select * from users where id = #{id}")
    @Results({
            @Result(column = "id",property = "id"),
            @Result(column = "username",property = "username"),
            @Result(column = "email",property = "email"),
            @Result(column = "password",property = "password"),
            @Result(column = "phoneNum",property = "phoneNum"),
            @Result(column = "status",property = "status"),
            @Result(column = "id",property = "roles",many = @Many(select ="com.itheima.dao.RoleDao.findByUserId"))
    })
    UserInfo findById(String id);

    @Select("select * from role where id not in (select roleId from users_role where userId = #{id})")
    List<Role> findAllRole(String id);


    @Insert("insert into users_role (userId,roleId) values (#{userId},#{roleId})")
    void addRoleToUser(@Param("userId") String userId, @Param("roleId") String roleId);
}
