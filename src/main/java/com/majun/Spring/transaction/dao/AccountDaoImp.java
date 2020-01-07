package com.majun.Spring.transaction.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDaoImp implements AccountDao{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void outMoney(String name, double d) {
        jdbcTemplate.update("update wage set wage = wage-? where name = ?",d,name);
    }

    @Override
    public void inMoney(String name, double d) {
        jdbcTemplate.update("update wage set wage = wage + ? where name = ?",d,name);
    }

}
