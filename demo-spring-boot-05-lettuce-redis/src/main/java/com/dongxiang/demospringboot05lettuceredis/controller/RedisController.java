package com.dongxiang.demospringboot05lettuceredis.controller;

import com.dongxiang.demospringboot05lettuceredis.dao.entities.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.Serializable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

@Controller
@ResponseBody
@RequestMapping(value = {"/RedisController"})
public class RedisController {
    private static final Logger mLogger = LoggerFactory.getLogger(RedisController.class);

    @Autowired
    private StringRedisTemplate mStringRedisTemplate;
    @Autowired
    private RedisTemplate<String, Serializable> mRedisTemplate;

    @RequestMapping(value ={"/contextLoads"})
    public Object contextLoads() {
        ExecutorService executorService = Executors.newFixedThreadPool(1000);
        IntStream.range(0, 1000).forEach(i ->
                executorService.execute(() -> mStringRedisTemplate.opsForValue().increment("kk", 1)));

        mStringRedisTemplate.opsForValue().set("k1", "v1");
        final String k1 = mStringRedisTemplate.opsForValue().get("k1");
        mLogger.info("[字符缓存结果]-[{}]", k1);

        String key = "battcn:user:1";
        mRedisTemplate.opsForValue().set(key, new User(1l, "u1", "pa"));

        final User user = (User) mRedisTemplate.opsForValue().get(key);
        mLogger.info("[对象缓存结果]-[{}]", user);
        return user;
    }
}
