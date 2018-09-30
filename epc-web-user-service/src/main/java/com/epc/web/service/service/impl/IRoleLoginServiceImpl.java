package com.epc.web.service.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.epc.common.Result;
import com.epc.common.constants.Const;
import com.epc.common.constants.ErrorMessagesEnum;
import com.epc.common.util.CookieUtil;
import com.epc.common.util.MD5Util;
import com.epc.common.util.RedisShardedPoolUtil;
import com.epc.web.facade.loginuser.dto.LoginUser;
import com.epc.web.service.domain.operator.TOperatorBasicInfo;
import com.epc.web.service.domain.operator.TOperatorBasicInfoCriteria;
import com.epc.web.service.domain.operator.TOperatorDetailInfo;
import com.epc.web.service.domain.operator.TOperatorDetailInfoCriteria;
import com.epc.web.service.mapper.agency.TAgencyBasicInfoMapper;
import com.epc.web.service.mapper.agency.TAgencyDetailInfoMapper;
import com.epc.web.service.mapper.operator.TOperatorBasicInfoMapper;
import com.epc.web.service.mapper.operator.TOperatorDetailInfoMapper;
import com.epc.web.service.mapper.purchaser.TPurchaserBasicInfoMapper;
import com.epc.web.service.mapper.supplier.TSupplierBasicInfoMapper;
import com.epc.web.service.service.IRoleLoginService;
import com.netflix.ribbon.proxy.annotation.Http;
import org.apache.commons.lang3.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author :winlin
 * @Description :
 * @param:
 * @return:
 * @date:2018/9/18
 */
@Service
public class IRoleLoginServiceImpl implements IRoleLoginService {

    @Autowired
    TOperatorBasicInfoMapper tOperatorBasicInfoMapper;
    @Autowired
    TAgencyBasicInfoMapper tAgencyBasicInfoMapper;
    @Autowired
    TSupplierBasicInfoMapper tSupplierBasicInfoMapper;
    @Autowired
    TPurchaserBasicInfoMapper tPurchaserBasicInfoMapper;
    @Autowired
    TOperatorDetailInfoMapper tOperatorDetailInfoMapper;
    @Override
    public Result login(@RequestBody LoginUser user) {
        //用户类型
        Integer type = user.getType();
        //密码加密
        String pwd = MD5Util.MD5EncodeUtf8(user.getPassword());
        String cellphone = user.getCellphone();
        //获得当前请求的HttpServletRequest和HttpServletResponse
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = ((ServletRequestAttributes)requestAttributes).getRequest();
        HttpServletResponse response = ((ServletRequestAttributes)requestAttributes).getResponse();
        switch (type) {
            case IRoleLoginService.OPERRATOR:
                LoginUser loginUser = tOperatorBasicInfoMapper.login(cellphone, pwd);
                if (loginUser != null) {
                    loginUser.setType(type);
                    //this.cacheInredis(request,response,loginUser);
                    return Result.success( loginUser);
                }
                break;
            case IRoleLoginService.AGENCY:
                LoginUser loginUser1 = tAgencyBasicInfoMapper.login(cellphone, pwd);
                if (loginUser1 != null) {
                    loginUser1.setType(type);
                    //this.cacheInredis(request,response,loginUser1);
                    return Result.success( loginUser1);
                }
                break;
            case IRoleLoginService.SUPPLIER:
                LoginUser loginUser2 = tSupplierBasicInfoMapper.login(cellphone, pwd);
                if (loginUser2 != null) {
                    loginUser2.setType(type);
                    //this.cacheInredis(request,response,loginUser2);
                    return Result.success( loginUser2);
                }
                break;
            case IRoleLoginService.PURCHASER:
                LoginUser loginUser3 = tPurchaserBasicInfoMapper.login(cellphone, pwd);
                if (loginUser3 != null) {
                    loginUser3.setType(type);
                    //this.cacheInredis(request,response,loginUser3);
                    return Result.success( loginUser3);
                }
                break;
            default:
                return Result.error(ErrorMessagesEnum.LOGIN_USER_LOGIN_ERROR.getErrCode(),"登录失败");
        }
        return Result.error(ErrorMessagesEnum.LOGIN_USER_LOGIN_ERROR.getErrCode(),"登录失败");
    }

    public void  cacheInredis(HttpServletRequest request,HttpServletResponse response,LoginUser user ){
        String session = request.getSession().getId();
        CookieUtil.writeLoginToken(response,session);
        RedisShardedPoolUtil.setEx(session, JSONObject.toJSONString(user), Const.RedisCacheExtime.REDIS_SESSION_EXTIME);
    }


}
