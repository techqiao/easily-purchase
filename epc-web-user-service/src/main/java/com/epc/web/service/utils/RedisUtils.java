package com.epc.web.service.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class RedisUtils {
    @Autowired
    RedisTemplate redisTemplate;
    @Autowired
    ObjectMapper objectMapper;
    public void setValue(String listKey, Object value) {
        //设置redis序列化方式
        StringRedisSerializer redisSerializer = new StringRedisSerializer();
        redisTemplate.setKeySerializer(redisSerializer);
        redisTemplate.opsForValue().set(listKey, value);
        redisTemplate.expire(listKey, 30, TimeUnit.MINUTES);
    }

    public String getValue(String listKey) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            Object o =  redisTemplate.opsForValue().get(listKey);
            return mapper.writeValueAsString( o);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
