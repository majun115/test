package com.majun.spring;

import com.majun.pojo.MyGoddess;
import com.majun.pojo.MyRowMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext1.xml")

public class JdbcTemplateDemo{

    @Autowired
    private JdbcTemplate jdbcTemplate;
    /**
     * 插入数据
     */
    @Test
    public void insert(){
        jdbcTemplate.update("insert into wage(name,wage,id) values (?,?,?)","李沁",10000,3);
    }
    /**
     * 更新数据
     */
    @Test
    public void update(){
        jdbcTemplate.update("update wage set name = ? where id = ?","陈瑶",3);
    }
    /**
     * 删除数据
     */
    @Test
    public void delete(){
        jdbcTemplate.update("delete from wage where id = ?",4);
    }
    /**
     * 查询一个
     */
    @Test
    public void selectOne(){
        System.out.println(jdbcTemplate.queryForObject("select name from wage where id = ?",String.class,3));
    }
    /**
     * 查询MyGoddss 对象
     * @throws Exception
     */
    @Test
    public void selectMyGodss(){
        MyGoddess goddess = (MyGoddess)jdbcTemplate.queryForObject("select id,name,wage from wage where id = ?", new MyRowMapper(), 3);
        System.out.println(goddess);
    }

}
