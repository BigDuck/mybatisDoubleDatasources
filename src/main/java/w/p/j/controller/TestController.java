/*
 * Copyright (c) 2015 / 8 / 9 8 :55 :42
 * BY:wupeiji
 * QQ:757671834
 *
 */

package w.p.j.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import w.p.j.daomain.Airport;
import w.p.j.daomain.People;
import w.p.j.service.StudentService;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * -------------------------------------
 * Created by wupeji on 2015-08-09 20:55
 * ----------------------------------------
 **/
@Controller
@RequestMapping(value = "/test")
public class TestController {
 @Resource
 private StudentService studentServiceImpl;
 @Resource
 private StudentService studentServiceImplTwo;


    @RequestMapping(value = "/one")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public Object testXML(){
        System.out.println(studentServiceImpl.deleteStudentById());
        System.out.println(studentServiceImplTwo.deleteStudentById());
        List<People> listPeo=new ArrayList<People>();
        for (int i = 0; i < 4; i++) {
            listPeo.add(new People("加油","NO"+i));
        }
        Airport airport=new Airport("json","D2",listPeo);
        return airport;
    }
//    @RequestMapping(value = "/one",produces={"application/xml"})
//    @ResponseBody
//    @ResponseStatus(HttpStatus.OK)
//    public Object test(){
//        System.out.println(studentServiceImpl.deleteStudentById());
//        System.out.println(studentServiceImplTwo.deleteStudentById());
//        Airport airport=new Airport("好","D2");
//        return airport;
//    }
    @RequestMapping("/sign")
    public String toSign(){
        return "sign";
    }
    @RequestMapping("/map")
    public void te(){
        studentServiceImpl.deleteStudentById();
    }
}
