package com.dongxiang.demospringboot04mybatise1.dao.service.user;

import com.dongxiang.demospringboot04mybatise1.dao.entities.User;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface UserService {
    int addUser(User user);

    User selectByPrimaryKey(Integer id);


    List<User> findAllUser(int pageNum, int pageSize);


    PageInfo<User> findPagerInfo(int pageNum, int pageSize);

}
