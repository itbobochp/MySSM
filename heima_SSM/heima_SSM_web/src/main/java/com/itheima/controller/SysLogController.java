package com.itheima.controller;

import com.itheima.daomain.Syslog;

import com.itheima.service.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/sysLog")
public class SysLogController {

    @Autowired
    private SysLogService sysLogService;

    @RequestMapping("/findAll")
    public String  findAll(Model model) throws Exception {

       List<Syslog> sysLogList= sysLogService.findAll();
       model.addAttribute("sysLogs",sysLogList);

        return "syslog-list";
    }
}
