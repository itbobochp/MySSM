package com.itheima.service;

import com.itheima.daomain.Syslog;

import java.util.List;

public interface ISysLogService {

    public void save(Syslog sysLog) throws Exception;

    List<Syslog> findAll() throws Exception;
}
