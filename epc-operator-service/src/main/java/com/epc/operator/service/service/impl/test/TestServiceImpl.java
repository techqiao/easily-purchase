package com.epc.operator.service.service.impl.test;

import com.epc.operator.service.domain.test.User;
import com.epc.operator.service.mapper.test.TestMapper;
import com.epc.operator.service.service.test.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * <p> To describe how this class works </p>
 *
 * @author junlee
 * @date {date}       // 创建时间
 */

@Service("testService")
@Transactional
public class TestServiceImpl implements TestService {

    @Autowired
    private TestMapper testMapper;

    @Override
    public User findByName(String name){
        testMapper.insert("AAA", 20);
        User u = testMapper.findByName("AAA");
        return u;
    }



}
