package com.dongxiang.demospringboot05lettuceredis.dao.redis_templates;

import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.io.Serializable;
import java.nio.charset.Charset;
/**
 * author:dongxiang
 * data:2018/7/4 9:17
 * email:dongxiang_android_sdk2@aliyun.com
 * description:<li></li>
 * function:<li> </li>
 * using: <li></li>
 * note: <li>修改database</li>
 */
@Configuration
@AutoConfigureAfter(RedisAutoConfiguration.class)
public class RedisCacheAutoConfiguration {
    @Bean
    public RedisTemplate<String,Serializable> redisCacheTemplate(LettuceConnectionFactory lettuceConnectionFactory){
        RedisTemplate<String,Serializable>template=new RedisTemplate<String,Serializable>();
        template.setKeySerializer(new StringRedisSerializer(Charset.forName("utf-8")));
        template.setValueSerializer(new GenericJackson2JsonRedisSerializer());
        template.setConnectionFactory(lettuceConnectionFactory);

        return template;
    }


}
