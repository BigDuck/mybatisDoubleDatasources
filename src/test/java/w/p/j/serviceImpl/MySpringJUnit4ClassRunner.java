/*
 * Copyright (c) 2015 / 8 / 24 10 :37 :55
 * BY:wupeiji
 * QQ:757671834
 *
 */

package w.p.j.serviceImpl;

import org.junit.runners.model.InitializationError;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Log4jConfigurer;

import java.io.FileNotFoundException;

/**
 * -------------------------------------
 * Created by wupeji on 2015-08-24 22:37
 * ----------------------------------------
 **/
public class MySpringJUnit4ClassRunner extends SpringJUnit4ClassRunner {
    static {
        try {
            Log4jConfigurer.initLogging("classpath:log4j.properties");
            System.out.println("log4j 加载成功了。。。");
        } catch (FileNotFoundException ex) {
            System.err.println("Cannot Initialize log4j");
        }
    }

    public MySpringJUnit4ClassRunner(Class<?> clazz) throws InitializationError {
    super(clazz);
    }
}
