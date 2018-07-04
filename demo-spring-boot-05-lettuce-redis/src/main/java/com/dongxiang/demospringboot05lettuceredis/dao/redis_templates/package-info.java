/**
 * <br>默认情况下的模板只能支持RedisTemplate<String, String>，也就是只能存入字符串，这在开发中是不友好的，所以自定义模板是很有必要的，
 * <br>当自定义了模板又想使用String存储这时候就可以使用StringRedisTemplate的方式，它们并不冲突…
 */

package com.dongxiang.demospringboot05lettuceredis.dao.redis_templates;