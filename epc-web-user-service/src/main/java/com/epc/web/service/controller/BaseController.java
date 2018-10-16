package com.epc.web.service.controller;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author luozhixin
 * @date 2018-9-19 19:02:33
 */
@Component
public class BaseController {

    @Autowired
    RedisTemplate redisTemplate;

    protected Map<String, Object> getDataTable(PageInfo<?> pageInfo) {
        Map<String, Object> rspData = new HashMap<>(16);
        rspData.put("rows", pageInfo.getList());
        rspData.put("total", pageInfo.getTotal());
        return rspData;
    }

    protected Map<String, Object> getDataList(List pageList, int size) {
        Map<String, Object> rspData = new HashMap<>();
        rspData.put("rows", pageList);
        rspData.put("total", size);
        return rspData;
    }

    /**
     * @author :winlin
     * @Description :获得Redis缓存设置有效期为20min
     * @date:2018/10/15
     */
    protected List<?> getList(String listKey) {
        Long size = redisTemplate.opsForList().size(listKey);
        return redisTemplate.opsForList().range(listKey, 0, size - 1);
    }

    /**
     * @author :winlin
     * @Description :获得Redis缓存设置有效期为20min
     * @date:2018/10/15
     */
    protected void setList(String listKey, List<?> list) {
        //设置redis序列化方式
        StringRedisSerializer redisSerializer = new StringRedisSerializer();
        redisTemplate.setKeySerializer(redisSerializer);
        redisTemplate.opsForList().leftPushAll(listKey, list);
        redisTemplate.expire(listKey, 10, TimeUnit.MINUTES);
    }

}
