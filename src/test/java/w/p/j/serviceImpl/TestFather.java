/*
 * Copyright (c) 2015 / 8 / 24 10 :40 :51
 * BY:wupeiji
 * QQ:757671834
 *
 */

package w.p.j.serviceImpl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 * Created by wpj on 2015/2/23.
 * 作者：吴培基
 * @see ：测试类的父类，每个测试都必须继承这个类否则无法获取数据。
 */
@RunWith(MySpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:config/spring.xml"})
@TransactionConfiguration(defaultRollback = true)
@Transactional("transactionManagerOne")
public class TestFather extends AbstractTransactionalJUnit4SpringContextTests {
//    加载数据源
@Resource(name="dataSourceTwo")
protected DataSource dataSourceTwo;
    @Resource(name="dataSourceOne")
    @Override
    public void setDataSource(DataSource dataSource) {
        super.setDataSource(dataSource);
    }

}