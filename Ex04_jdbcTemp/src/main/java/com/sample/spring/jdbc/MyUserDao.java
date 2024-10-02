package com.sample.spring.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MyUserDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<MyUserDto> list(){
        String query = "select * from myuser";
        List<MyUserDto> list = jdbcTemplate.query(query,
                new BeanPropertyRowMapper<MyUserDto>(MyUserDto.class)
                );

        return list;
    }
}
