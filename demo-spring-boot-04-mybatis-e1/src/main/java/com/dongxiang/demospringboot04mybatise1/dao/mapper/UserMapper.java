package com.dongxiang.demospringboot04mybatise1.dao.mapper;

import com.dongxiang.demospringboot04mybatise1.dao.entities.User;

import java.util.List;

public interface UserMapper  {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    /**customer add*/
    List<User> selectAllUser();



}