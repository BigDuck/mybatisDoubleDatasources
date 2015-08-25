/*
 * Copyright (c) 2015 / 8 / 10 0 :31 :0
 * BY:wupeiji
 * QQ:757671834
 *
 */

package w.p.j.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import w.p.j.dao.one.JobMapper;
import w.p.j.daomain.one.Job;
import w.p.j.service.StudentService;


/**
 * -------------------------------------
 * Created by wupeji on 2015-08-10 00:31
 * ----------------------------------------
 **/
@Service(value = "studentServiceImpl")
public class StudentServiceImpl implements StudentService {
    @Autowired
    private JobMapper jobMapper;
    public StudentServiceImpl() {
        System.out.println("-----------------studentServiceImpl----------------");
    }

    public boolean deleteStudentById() {
     Job j= jobMapper.selectByPrimaryKey(1);
        System.out.println(j);
        return false;
    }
}
