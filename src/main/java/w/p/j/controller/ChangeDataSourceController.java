/*
 * Copyright (c) 2015 / 8 / 24 10 :16 :59
 * BY:wupeiji
 * QQ:757671834
 *
 */

package w.p.j.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import w.p.j.dao.one.JobMapper;
import w.p.j.dao.two.NewsMapper;
import w.p.j.daomain.one.Job;
import w.p.j.daomain.two.News;

import javax.annotation.Resource;
import java.util.Map;

/**
 * -------------------------------------
 * Created by wupeji on 2015-08-24 10:16
 * ----------------------------------------
 **/
@Controller
@RequestMapping("/data")
public class ChangeDataSourceController {
    @Resource
    private   JobMapper jobMapper;
    @Resource
    private NewsMapper newsMapper;
    @RequestMapping("/source")
    public String testChange(){
        /**
         * 主数据库
         */
        Job job=new Job();
        job.setJobAddress("泉州");
        job.setJobName("程序员");
        job.setJobSalary(2000l);
        int res= jobMapper.insertSelective(job);
        System.out.println("结果：" + res);
        /**
         * 从数据库
         */

        News news= newsMapper.selectByPrimaryKey(1);
        System.out.println(news.toString());
        return "test";
    }
}
