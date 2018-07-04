package com.dongxiang.demospringboot06cacheredis.dao.service.impl;

import com.dongxiang.demospringboot06cacheredis.dao.entities.User;
import com.dongxiang.demospringboot06cacheredis.dao.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
/**
 * author:dongxiang
 * data:2018/7/4 11:25
 * email:dongxiang_android_sdk2@aliyun.com
 * description:
 * function:
 * using:
 * note:
 * 根据条件操作缓存
 *
 * <li>根据条件操作缓存内容并不影响数据库操作，条件表达式返回一个布尔值，true/false，当条件为true，则进行缓存操作，否则直接调用方法执行的返回结果。</li>
 *
 * <li>  大小：@Cacheable(value = "user", key = "#id",condition = "#id < 10")只缓存ID小于10的数据</li>
 * <li>  长度：@CachePut(value = "user", key = "#user.id",condition = "#user.username.length() < 10")只缓存用户名长度少于10的数据;
 *      <p><b>根据方法的请求参数对其结果进行缓存，和@Cacheable不同的是，它每次都会触发真实方法的调用</li>
 * <li>  组合：@Cacheable(value="user",key="#user.username.concat(##user.password)")</li>
 *  <li> 提前操作：@CacheEvict(value="user",allEntries=true,beforeInvocation=true)加上beforeInvocation=true后，不管内部是否报错，缓存都将被清除，默认情况为false</li>
 */
@Service
public class UserServiceImpl implements UserService {


    private static final Map<Long, User> DATABASES = new HashMap<>();

    static {
        DATABASES.put(1L, new User(1L, "u1", "p1"));
        DATABASES.put(2L, new User(2L, "u2", "p2"));
        DATABASES.put(3L, new User(3L, "u3", "p3"));
    }


    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    @Cacheable(value = "user", key = "#id")
    @Override
    public User get(Long id) {
        // TODO 我们就假设它是从数据库读取出来的
        log.info("进入 get 方法");
        return DATABASES.get(id);
    }

    @CachePut(value = "user", key = "#user.id")
    @Override
    public User saveOrUpdate(User user) {
        DATABASES.put(user.getId(), user);
        log.info("进入 saveOrUpdate 方法");
        return user;
    }

    @CacheEvict(value = "user", key = "#id")
    @Override
    public void delete(Long id) {
        DATABASES.remove(id);
        log.info("进入 delete 方法");
    }
}