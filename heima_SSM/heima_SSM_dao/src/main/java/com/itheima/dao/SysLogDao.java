package com.itheima.dao;

import com.itheima.daomain.Syslog;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface SysLogDao {

    @Insert("insert into syslog(visitTime,username,ip,url,executionTime,method) values(#{visitTime},#{username},#{ip},#{url},#{executionTime},#{method})")
    public void save(Syslog sysLog) throws Exception;

    @Select("select * from sysLog")
    List<Syslog> findAll() throws Exception;
}
