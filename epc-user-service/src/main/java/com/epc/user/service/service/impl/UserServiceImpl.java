package com.epc.user.service.service.impl;

import com.epc.user.service.common.BaseResult;
import com.epc.user.service.common.BizErrorCode;
import com.epc.user.service.domain.User;
import com.epc.user.service.domain.UserCriteria;
import com.epc.user.service.domain.dto.QueryUserDTO;
import com.epc.user.service.mapper.UserMapper;
import com.epc.user.service.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    public User getUserById(Integer userId) {
        return userMapper.selectByPrimaryKey(userId);
    }

    @Override
    public Boolean deleteUserById(Integer userId) {
        return userMapper.deleteByPrimaryKey(userId) > 0;
    }

    @Override
    public Boolean updateUserById(User user) {
        return userMapper.updateByPrimaryKey(user) > 0;
    }

    @Override
    public BaseResult<List<User>> getUserList(QueryUserDTO queryUserDTO) {
        BaseResult<List<User>> result = new BaseResult<List<User>>();
        try {
            final UserCriteria criteria = new UserCriteria();
            final UserCriteria.Criteria subCriteria = criteria.createCriteria();
            if(StringUtils.isNotBlank(queryUserDTO.getUserName())) {
                subCriteria.andUserEqualTo(queryUserDTO.getUserName());
            }
            result.setData(userMapper.selectByExampleWithRowbounds(criteria, queryUserDTO.getRowBounds()));
        }catch (Throwable e){
            LOGGER.error("Exception {}", e);
            result.setBizCode(BizErrorCode.ACCOUNT_ERROR);
        }

        return result;
    }
}
