package com.dongxiang.demospringboot02jdbctemplate.controller;

import com.dongxiang.demospringboot02jdbctemplate.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@ResponseBody
@RequestMapping(value = "/jdbcTemplate")
public class JDBCTemplateController {

    private JdbcTemplate mJdbcTemplate;
    private final Logger mLogger=LoggerFactory.getLogger(JDBCTemplateController.class);

    @Autowired
    public JDBCTemplateController(JdbcTemplate jdbcTemplate) {
        mJdbcTemplate = jdbcTemplate;
    }

    @GetMapping
    public List<User> queryUsers(){
        String sql="select * from t_user";
        return mJdbcTemplate.query(sql,new Object[]{},new BeanPropertyRowMapper<>(User.class));
    }

    @GetMapping(value = {"/getUser/id={id}"})
    public User getUser(@PathVariable long id){
        String sql ="select * from t_user where id = ?";
        User user = mJdbcTemplate.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper<>(User.class));
        return user;
    }

    @DeleteMapping("/delUser/id={id}")
    public int delUser(@PathVariable long id){
        String sql ="delete from t_user where id=?";
        int delId = mJdbcTemplate.update(sql, new Object[]{id});
        return  delId;
    }

    @PostMapping("/inserUser")
    public int inserUser(@RequestBody User user){
        String sql ="insert into t_user(username,password) values(?,?)";
        int insertId = mJdbcTemplate.update(sql, user.getUsername(), user.getPassword());
        return insertId;
    }

//    @PutMapping("/{id}")---方法不支持
    @PostMapping(value = "/updateUser/id={id}")
    public int updateUser(@PathVariable long id,@RequestBody User user){
        String sql="update t_user set username = ?,password = ? where id = ?";
        int updateId = mJdbcTemplate.update(sql, user.getUsername(), user.getPassword(), id);
        return updateId;
    }

}
