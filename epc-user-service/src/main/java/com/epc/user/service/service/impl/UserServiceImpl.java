package com.epc.user.service.service.impl;

import com.epc.common.Result;
import com.epc.user.service.domain.User;
import com.epc.user.service.domain.UserCriteria;
import com.epc.user.service.domain.dto.QueryUserDTO;
import com.epc.user.service.mapper.UserMapper;
import com.epc.user.service.service.UserService;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>Description : 用户接口实现类
 * <p>Date : 2018-09-08 23:45
 * <p>@Author : wjq
 */
@Service
public class UserServiceImpl implements UserService{

    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);
    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUserById(Long userId) {
        return userMapper.selectByPrimaryKey(userId);
    }

    @Override
    public User login(String phone, String password) {
        User user = new User();
        user.setId(1L);
        return user;
    }

    @Override
    public Boolean deleteUserById(Long userId) {
        return userMapper.deleteByPrimaryKey(userId) > 0;
    }

    @Override
    public Boolean updateUserById(User user) {
        return userMapper.updateByPrimaryKey(user) > 0;
    }

    @Override
    public Result<List<User>> getUserList(QueryUserDTO queryUserDTO) {
        try {
            final UserCriteria criteria = new UserCriteria();
            final UserCriteria.Criteria subCriteria = criteria.createCriteria();
            if(StringUtils.isNotBlank(queryUserDTO.getUserName())) {
                subCriteria.andUserEqualTo(queryUserDTO.getUserName());
            }
            return Result.createBySuccess(userMapper.selectByExampleWithRowbounds(criteria, queryUserDTO.getRowBounds()));
        }catch (Throwable e){
            LOGGER.error("Exception {}", e);
            return Result.createByErrorCodeMessage(001, "xxx");
        }
    }
}
