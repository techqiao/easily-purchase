package com.epc.web.client.controller.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 *
 * <p> To describe how this class works </p>
 *
 * @author junlee
 * @date {date}       // 创建时间
 */

@RestController
@RequestMapping(value = "/testRedis", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class RedisController {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate redisTemplate;

    // redisTemplate.opsForValue();//操作字符串
    // redisTemplate.opsForHash();//操作hash
    // redisTemplate.opsForList();//操作list
    // redisTemplate.opsForSet();//操作set
    // redisTemplate.opsForZSet();//操作有序set

    /**
     * 字符串
     */
    @RequestMapping(value = "/redis/string")
    public void stringOperation(@RequestBody Student student) {
        // key、value
        redisTemplate.opsForValue().set("name", student.getName());

        System.out.println("》》》》》》" + redisTemplate.opsForValue().get("name"));
    }

    /**
     * 集合
     */
    @RequestMapping(value = "/redis/set")
    public void setOperation(@RequestBody Student student) {
        Set<String> set1 = new HashSet<String>();
        set1.add("set1");
        set1.add("set2");
        set1.add("set3");
        // 插入
        redisTemplate.opsForSet().add("set1", set1);
        // 获取
        Set<String> resultSet = redisTemplate.opsForSet().members("set1");
        System.out.println("resultSet:" + resultSet);
    }

    /**
     * Map
     */
    @RequestMapping(value = "/redis/map")
    public void mapOperation(@RequestBody Student student) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("key1", "value1");
        map.put("key2", "value2");
        map.put("key3", "value3");
        map.put("key4", "value4");
        map.put("key5", "value5");
        // 插入
        redisTemplate.opsForHash().putAll("map1", map);

        Map<String, String> resultMap = redisTemplate.opsForHash().entries("map1");
        System.out.println("resultMap:" + resultMap);

        List<String> reslutMapList = redisTemplate.opsForHash().values("map1");
        System.out.println("reslutMapList:" + reslutMapList);

        Set<String> resultMapSet = redisTemplate.opsForHash().keys("map1");
        System.out.println("resultMapSet:" + resultMapSet);

        String value = (String) redisTemplate.opsForHash().get("map1", "key1");
        System.out.println("value:" + value);
    }

    /**
     * List
     */
    @RequestMapping(value = "/redis/list")
    public void listOperation(@RequestBody Student student) {
        List<String> list1 = new ArrayList<String>();
        list1.add("a1");
        list1.add("a2");
        list1.add("a3");

        List<String> list2 = new ArrayList<String>();
        list2.add("b1");
        list2.add("b2");
        list2.add("b3");
        // 插入
        redisTemplate.opsForList().leftPush("listkey1", list1);
        redisTemplate.opsForList().rightPush("listkey2", list2);

        // 取数据
        List<String> resultList1 = (List<String>) redisTemplate.opsForList().leftPop("listkey1");

        List<String> resultList2 = (List<String>) redisTemplate.opsForList().rightPop("listkey2");

        System.out.println("resultList1:" + resultList1);
        System.out.println("resultList2:" + resultList2);
    }

    /**
     * Student
     */
    @RequestMapping(value = "/redis/student")
    public void studentOperation(@RequestBody Student student) {
        List<Student> studentList = new ArrayList<Student>();
        Student student1 = new Student();
        student1.setId(1);
        student1.setName("小王");

        Student student2 = new Student();
        student1.setId(3);
        student1.setName("老朱");
        studentList.add(student1);
        studentList.add(student2);

        redisTemplate.opsForValue().set("studentList", studentList);
        // Object object = redisTemplate.opsForValue().get("studentList");

        // 强转
        List<Student> resultList = (List<Student>) redisTemplate.opsForValue().get("studentList");

        if (resultList != null && resultList.size() > 0) {
            for (Student nowStudent : resultList) {
                System.out.println(">>>>>>>" + nowStudent.getName());
            }
        }

    }
}
