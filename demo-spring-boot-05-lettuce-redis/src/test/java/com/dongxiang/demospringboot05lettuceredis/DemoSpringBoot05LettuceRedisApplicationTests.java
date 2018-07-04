package com.dongxiang.demospringboot05lettuceredis;

import com.dongxiang.demospringboot05lettuceredis.dao.entities.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.Serializable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

/**
 * author:dongxiang
 * data:2018/7/4 9:29
 * email:dongxiang_android_sdk2@aliyun.com
 * description:
 * function:
 * using:
 * note:
 * <li>opsForValue：对应 String（字符串）</li>
 * <li> opsForZSet：对应 ZSet（有序集合）</li>
 * <li> opsForHash：对应 Hash（哈希）</li>
 * <li> opsForList：对应 List（列表）</li>
 * <li> opsForSet：对应 Set（集合）</li>
 * <li> opsForGeo：对应 GEO（地理位置）</li>
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoSpringBoot05LettuceRedisApplicationTests {
    private static final Logger mLogger = LoggerFactory.getLogger(DemoSpringBoot05LettuceRedisApplicationTests.class);

    @Autowired
    private StringRedisTemplate mStringRedisTemplate;
    @Autowired
    private RedisTemplate<String, Serializable> mRedisTemplate;

    @Test
    public void contextLoads() {
        ExecutorService executorService = Executors.newFixedThreadPool(1000);
        IntStream.range(0, 1000).forEach(i -> executorService.execute(() -> mStringRedisTemplate.opsForValue().increment("kk", 1)));

        mStringRedisTemplate.opsForValue().set("k1", "v1");
        final String k1 = mStringRedisTemplate.opsForValue().get("k1");
        mLogger.info("[字符缓存结果]-[{}]", k1);

        String key = "battcn:user:1";
        mRedisTemplate.opsForValue().set(key, new User(1l, "u1", "pa"));

        final User user = (User) mRedisTemplate.opsForValue().get(key);
        mLogger.info("[对象缓存结果]-[{}]", user);
    }

}
