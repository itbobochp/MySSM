package com.itheima.service.impl;

import com.itheima.dao.ISysLogDao;
import com.itheima.daomain.Syslog;
import com.itheima.service.ISysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SysLogServiceImpl implements ISysLogService{

    @Autowired
    private ISysLogDao sysLogDao;

    @Override
    public List<Syslog> findAll() throws Exception {
        return sysLogDao.findAll();
    }

    @Override
    public void save(Syslog sysLog) throws Exception {
        sysLogDao.save(sysLog);
    }
}
