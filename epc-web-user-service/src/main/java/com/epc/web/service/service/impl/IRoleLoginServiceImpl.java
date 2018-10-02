package com.epc.web.service.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.epc.common.Result;
import com.epc.common.constants.Const;
import com.epc.common.constants.ErrorMessagesEnum;
import com.epc.common.util.CookieUtil;
import com.epc.common.util.MD5Util;
import com.epc.common.util.RedisShardedPoolUtil;
import com.epc.web.facade.loginuser.dto.LoginUser;
import com.epc.web.facade.loginuser.dto.RegisterUser;
import com.epc.web.service.domain.agency.TAgencyBasicInfo;
import com.epc.web.service.domain.expert.TExpertBasicInfo;
import com.epc.web.service.domain.purchaser.TPurchaserBasicInfo;
import com.epc.web.service.mapper.agency.TAgencyBasicInfoMapper;
import com.epc.web.service.mapper.expert.TExpertBasicInfoMapper;
import com.epc.web.service.mapper.operator.TOperatorBasicInfoMapper;
import com.epc.web.service.mapper.operator.TOperatorDetailInfoMapper;
import com.epc.web.service.mapper.purchaser.TPurchaserBasicInfoMapper;
import com.epc.web.service.mapper.supplier.TSupplierBasicInfoMapper;
import com.epc.web.service.service.IRoleLoginService;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
    @Autowired
    TExpertBasicInfoMapper tExpertBasicInfoMapper;
    @Override
    @JsonInclude(JsonInclude.Include.NON_NULL)
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
                    this.cacheInredis(request,response,loginUser);
                    return Result.success( loginUser);
                }
                break;
            case IRoleLoginService.AGENCY:
                LoginUser loginUser1 = tAgencyBasicInfoMapper.login(cellphone, pwd);
                if (loginUser1 != null) {
                    loginUser1.setType(type);
                    this.cacheInredis(request,response,loginUser1);
                    return Result.success( loginUser1);
                }
                break;
            case IRoleLoginService.SUPPLIER:
                LoginUser loginUser2 = tSupplierBasicInfoMapper.login(cellphone, pwd);
                if (loginUser2 != null) {
                    loginUser2.setType(type);
                    this.cacheInredis(request,response,loginUser2);
                    return Result.success( loginUser2);
                }
                break;
            case IRoleLoginService.PURCHASER:
                LoginUser loginUser3 = tPurchaserBasicInfoMapper.login(cellphone, pwd);
                if (loginUser3 != null) {
                    loginUser3.setType(type);
                    this.cacheInredis(request,response,loginUser3);
                    return Result.success( loginUser3);
                }
                break;
            case IRoleLoginService.EXPERT:
                LoginUser loginUser4 = tPurchaserBasicInfoMapper.login(cellphone, pwd);
                if (loginUser4 != null) {
                    loginUser4.setType(type);
//                    this.cacheInredis(request,response,loginUser3);
                    return Result.success( loginUser4);
                }
                break;
            default:
                return Result.error(ErrorMessagesEnum.LOGIN_USER_LOGIN_ERROR.getErrCode(),"登录失败");
        }
        return Result.error(ErrorMessagesEnum.LOGIN_USER_LOGIN_ERROR.getErrCode(),"登录失败");
    }

    @Override
    public Result<Boolean> registerUser(@RequestBody RegisterUser registerUser) {
        //用户类型
        Integer type = registerUser.getType();
        //密码加密
        String pwd = MD5Util.MD5EncodeUtf8(registerUser.getPassword());
        //注册电话
        String cellphone = registerUser.getCellphone();
        //注册姓名
        String name = registerUser.getName();
        //获得当前请求的HttpServletRequest和HttpServletResponse
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = ((ServletRequestAttributes) requestAttributes).getRequest();
        HttpServletResponse response = ((ServletRequestAttributes) requestAttributes).getResponse();
        switch (type) {
            case IRoleLoginService.OPERRATOR:
                int sucess = tOperatorBasicInfoMapper.registerUser(cellphone, pwd, name);
                if (sucess > 0) {
                    return Result.success("运营商注册成功", true);
                }
                return Result.error(ErrorMessagesEnum.INSERT_FAILURE.getErrCode(), "注册失败");

            case IRoleLoginService.AGENCY:
               TAgencyBasicInfo basicInfo = tAgencyBasicInfoMapper.selectAgencyBasicByCellphoneAndName(name,cellphone);
               if(basicInfo==null) {
                   int sucess1 = tAgencyBasicInfoMapper.registerUser(cellphone, pwd, name);
                   if (sucess1 > 0) {
                       return Result.success("代理机构注册成功", true);
                   }
               }
                return Result.error(ErrorMessagesEnum.INSERT_FAILURE.getErrCode(), "注册失败");

            case IRoleLoginService.SUPPLIER:
                int sucess2 = tSupplierBasicInfoMapper.registerUser(cellphone, pwd, name);
                if (sucess2 > 0) {
                    return Result.success("供货商注册成功", true);
                }
                return Result.error(ErrorMessagesEnum.INSERT_FAILURE.getErrCode(), "注册失败");

            case IRoleLoginService.PURCHASER:
                TPurchaserBasicInfo tPurchaserBasicInfo =tPurchaserBasicInfoMapper.selectBasicInfoByNameAndPhone(name,cellphone);
                if(tPurchaserBasicInfo==null) {
                    int sucess3 = tPurchaserBasicInfoMapper.registerUser(cellphone, pwd, name);
                    if (sucess3 > 0) {
                        return Result.success("运营商注册成功", true);
                    }
                }
                return Result.error(ErrorMessagesEnum.INSERT_FAILURE.getErrCode(), "注册失败");

            case IRoleLoginService.EXPERT:
                TExpertBasicInfo tExpertBasicInfo =tExpertBasicInfoMapper.selectExpertByNameAndCellPhone(name,cellphone);
                if(tExpertBasicInfo==null) {
                    int sucess4 = tExpertBasicInfoMapper.registerUser(cellphone, pwd, name);
                    if (sucess4 > 0) {
                        return Result.success("运营商注册成功", true);
                    }
                }
                return Result.error(ErrorMessagesEnum.INSERT_FAILURE.getErrCode(), "注册失败");

            default:
                return Result.error(ErrorMessagesEnum.INSERT_FAILURE.getErrCode(), "注册失败");
        }
    }

    public void  cacheInredis(HttpServletRequest request,HttpServletResponse response,LoginUser user ){
        String session = request.getSession().getId();
        CookieUtil.writeLoginToken(response,session);
        RedisShardedPoolUtil.setEx(session, JSONObject.toJSONString(user), Const.RedisCacheExtime.REDIS_SESSION_EXTIME);
    }


}
