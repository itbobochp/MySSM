package com.itheima.dao;

import com.itheima.daomain.Permission;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface PermissionsDao {

    @Select("select * from permission where id in (select permissionId from role_permission where roleId = #{id})")
    public List<Permission> findByPermissionId(String id);
}
