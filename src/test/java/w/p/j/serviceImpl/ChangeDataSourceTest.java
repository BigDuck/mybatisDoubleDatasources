/*
 * Copyright (c) 2015 / 8 / 24 10 :36 :0
 * BY:wupeiji
 * QQ:757671834
 *
 */

package w.p.j.serviceImpl;

import com.github.pagehelper.PageHelper;
import org.junit.Test;
import tk.mybatis.mapper.entity.Example;
import w.p.j.dao.one.JobMapper;
import w.p.j.dao.two.NewsMapper;
import w.p.j.daomain.one.Job;
import w.p.j.daomain.two.News;

import javax.annotation.Resource;
import java.util.List;

/**
 * -------------------------------------
 * Created by wupeji on 2015-08-24 22:35
 * https://github.com/BigDuck/mybatisDoubleDatasources.git
 * ----------------------------------------
 **/
public class ChangeDataSourceTest  extends TestFather{
    @Resource
    private JobMapper jobMapper;
    @Resource
    private NewsMapper newsMapper;
    @Test
    public void TestinsertSelective(){
        Job job=new Job();
        job.setJobAddress("泉州");
        job.setJobName("程序员");
        job.setJobSalary(2000l);
        int res= jobMapper.insertSelective(job);
        System.out.println("结果：" + res);
    }
    @Test
    public void TestSelect(){
    PageHelper.startPage(1, 5);
        Example e=new Example(News.class);
        e.createCriteria().andGreaterThan("newsId",3);
        //PageHelper.startPage(1,4,true);
        List<News> list=newsMapper.selectByExample(e);
                //newsMapper.select(null);
        list.forEach(o->{
            System.out.println(
                    "动漫："+o.toString());
        });
    }

}
