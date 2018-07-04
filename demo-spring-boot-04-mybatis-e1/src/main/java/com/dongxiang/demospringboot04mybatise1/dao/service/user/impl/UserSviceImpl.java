package com.dongxiang.demospringboot04mybatise1.dao.service.user.impl;

import com.dongxiang.demospringboot04mybatise1.dao.entities.User;
import com.dongxiang.demospringboot04mybatise1.dao.mapper.UserMapper;
import com.dongxiang.demospringboot04mybatise1.dao.service.user.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service(value = "userService")
public class UserSviceImpl implements UserService {
    private Logger mLogger=LoggerFactory.getLogger(UserSviceImpl.class);
    private UserMapper mUserMapper;

    @Autowired
    public UserSviceImpl(UserMapper userMapper) {
        mUserMapper = userMapper;
    }

    @Override
    public int addUser(User user) {
        return mUserMapper.insertSelective(user);
    }

    @Override
    public  User selectByPrimaryKey(Integer id){

        return mUserMapper.selectByPrimaryKey(id);
    }

    /**
     * 这个方法中用到了我们开头配置依赖的分页插件pagehelper
     * 很简单，只需要在service层传入参数，然后将参数传递给一个插件的一个静态方法即可；
     * pageNum 开始页数
     * pageSize 每页显示的数据条数
     * */
    @Override
    public List<User> findAllUser(int pageNum, int pageSize) {
        //将参数传给这个方法就可以实现物理分页了，非常简单。
        PageHelper.startPage(pageNum, pageSize);
        return mUserMapper.selectAllUser();
    }

    @Override
    public PageInfo<User> findPagerInfo(int pageNum, int pageSize) {
        // TODO 分页 + 排序 this.mUserMapper.selectAll() 这一句就是我们需要写的查询，有了这两款插件无缝切换各种数据库
        final PageInfo<Object> pageInfo = PageHelper.startPage(pageNum, pageSize).setOrderBy("username asc").doSelectPageInfo(() -> this.mUserMapper.selectAllUser());
        mLogger.info("[lambda写法] - [分页信息] - [{}]", pageInfo.toString());

        PageHelper.startPage(pageNum, pageSize).setOrderBy("username asc");
        final PageInfo<User> userPageInfo = new PageInfo<>(this.mUserMapper.selectAllUser());
        mLogger.info("[普通写法] - [{}]", userPageInfo);
        return userPageInfo;
    }


}
