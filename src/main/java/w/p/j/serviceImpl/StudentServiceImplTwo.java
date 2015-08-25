/*
 * Copyright (c) 2015 / 8 / 10 0 :31 :18
 * BY:wupeiji
 * QQ:757671834
 *
 */

package w.p.j.serviceImpl;

import org.springframework.stereotype.Service;
import w.p.j.service.StudentService;

import javax.annotation.Resource;

/**
 * -------------------------------------
 * Created by wupeji on 2015-08-10 00:31
 * ----------------------------------------
 **/
@Service(value = "studentServiceImplTwo")
public class StudentServiceImplTwo implements StudentService {
    public boolean deleteStudentById() {
        return true;
    }
}
