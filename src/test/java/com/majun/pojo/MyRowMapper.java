package com.majun.pojo;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MyRowMapper implements RowMapper {
    @Override
    public MyGoddess mapRow(ResultSet rs, int rowNum) throws SQLException {
        MyGoddess myGoddess = new MyGoddess();
        myGoddess.setId(rs.getInt("id"));
        myGoddess.setName(rs.getString("name"));
        myGoddess.setWage(rs.getDouble("wage"));
        return myGoddess;
    }
}
