package com.epc.web.service.service.impl;

import com.epc.common.Result;
import com.epc.common.constants.Const;
import com.epc.common.constants.ErrorMessagesEnum;
import com.epc.common.util.MD5Util;
import com.epc.web.facade.loginuser.dto.LoginUser;
import com.epc.web.facade.loginuser.dto.ModifyUser;
import com.epc.web.facade.loginuser.dto.RegisterUser;
import com.epc.web.service.domain.agency.TAgencyBasicInfo;
import com.epc.web.service.domain.agency.TAgencyDetailInfo;
import com.epc.web.service.domain.expert.TExpertBasicInfo;
import com.epc.web.service.domain.operator.TOperatorBasicInfo;
import com.epc.web.service.domain.purchaser.TPurchaserBasicInfo;
import com.epc.web.service.domain.purchaser.TPurchaserDetailInfo;
import com.epc.web.service.domain.supplier.TSupplierBasicInfo;
import com.epc.web.service.mapper.agency.TAgencyBasicInfoMapper;
import com.epc.web.service.mapper.agency.TAgencyDetailInfoMapper;
import com.epc.web.service.mapper.expert.TExpertBasicInfoMapper;
import com.epc.web.service.mapper.operator.TOperatorBasicInfoMapper;
import com.epc.web.service.mapper.operator.TOperatorDetailInfoMapper;
import com.epc.web.service.mapper.purchaser.TPurchaserBasicInfoMapper;
import com.epc.web.service.mapper.purchaser.TPurchaserDetailInfoMapper;
import com.epc.web.service.mapper.supplier.TSupplierBasicInfoMapper;
import com.epc.web.service.mapper.supplier.TSupplierDetailInfoMapper;
import com.epc.web.service.service.IRoleLoginService;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.sun.org.apache.regexp.internal.RE;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Date;

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
    TExpertBasicInfoMapper tExpertBasicInfoMapper;
    @Autowired
    TAgencyDetailInfoMapper tAgencyDetailInfoMapper;
    @Autowired
    TPurchaserDetailInfoMapper tPurchaserDetailInfoMapper;
    @Autowired
    TOperatorDetailInfoMapper tOperatorDetailInfoMapper;
    @Autowired
    TSupplierDetailInfoMapper tSupplierDetailInfoMapper;

    @Override
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Result login(@RequestBody LoginUser user) {
        //用户类型
        Integer type = user.getType();
        //密码加密
        String pwd = MD5Util.MD5EncodeUtf8(user.getPassword());
        String cellphone = user.getCellphone();
        switch (type) {
            case IRoleLoginService.OPERRATOR:
                LoginUser loginUser = tOperatorBasicInfoMapper.login(cellphone, pwd);
                if (loginUser != null) {
                    loginUser.setType(type);
                    return Result.success(loginUser);
                }
                break;
            case IRoleLoginService.AGENCY:
                TAgencyBasicInfo basicinfo1 = tAgencyBasicInfoMapper.login(cellphone, pwd);
                if (basicinfo1 == null) {
                    return Result.error(ErrorMessagesEnum.LOGIN_USER_LOGIN_ERROR.getErrCode(), "登录失败");
                }
                //获得机构id
                Long agencyId = basicinfo1.getAgencyId();
                //获得老板
                TAgencyBasicInfo boss1 = tAgencyBasicInfoMapper.selectBossBasicInfoByPurchaserIdAndRole(agencyId, Const.Role.ROLE_CORPORATION);
                //获得公司信息
                TAgencyDetailInfo detailInfo1 = tAgencyDetailInfoMapper.selectAgencyDetailByAgencyId(agencyId);
                //封装返回对象
                LoginUser loginUser1 = new LoginUser();
                loginUser1.setName(basicinfo1.getName());
                loginUser1.setCellphone(basicinfo1.getCellphone());
                loginUser1.setUserId(basicinfo1.getId());
                loginUser1.setType(type);
                loginUser1.setCompanyId(detailInfo1.getAgencyId());
                loginUser1.setBossName(boss1.getName());
                if (boss1 != null && detailInfo1 != null) {
                    loginUser1.setCompanyName(detailInfo1.getCompanyName());
                    loginUser1.setBossId(boss1.getId());
                    return Result.success(loginUser1);
                }
                return Result.success(loginUser1);

            case IRoleLoginService.SUPPLIER:
                LoginUser loginUser2 = tSupplierBasicInfoMapper.login(cellphone, pwd);
                if (loginUser2 != null) {
                    loginUser2.setType(type);
                    return Result.success(loginUser2);
                }
                break;
            case IRoleLoginService.PURCHASER:
                TPurchaserBasicInfo basicinfo2 = tPurchaserBasicInfoMapper.login(cellphone, pwd);
                if (basicinfo2 == null) {
                    return Result.error(ErrorMessagesEnum.LOGIN_USER_LOGIN_ERROR.getErrCode(), "登录失败");
                }
                //获得机构id
                Long purchaserId = basicinfo2.getPurchaserId();
                //获得老板
                TPurchaserBasicInfo boss2 = tPurchaserBasicInfoMapper.selectBossBasicInfoByPurchaserIdAndRole(purchaserId, Const.Role.ROLE_CORPORATION);
                //获得公司信息
                TPurchaserDetailInfo detailInfo2 = tPurchaserDetailInfoMapper.selectDetailByPurchaserId(purchaserId);
                //封装返回对象
                LoginUser loginUser3 = new LoginUser();
                loginUser3.setName(basicinfo2.getName());
                loginUser3.setCellphone(basicinfo2.getCellphone());
                loginUser3.setUserId(basicinfo2.getId());
                loginUser3.setType(type);
                loginUser3.setCompanyId(detailInfo2.getPurchaserId());
                loginUser3.setBossName(boss2.getName());
                if (boss2 != null && detailInfo2 != null) {
                    loginUser3.setCompanyName(detailInfo2.getCompanyName());
                    loginUser3.setBossId(boss2.getId());
                    return Result.success(loginUser3);
                }
                return Result.success(loginUser3);
            case IRoleLoginService.EXPERT:
                LoginUser loginUser4 = tExpertBasicInfoMapper.login(cellphone, pwd);
                if (loginUser4 == null) {
                    return Result.error(ErrorMessagesEnum.LOGIN_USER_LOGIN_ERROR.getErrCode(), "登录失败");
                }
                loginUser4.setType(type);
                return Result.success(loginUser4);

            default:
                return Result.error(ErrorMessagesEnum.LOGIN_USER_LOGIN_ERROR.getErrCode(), "登录失败");
        }
        return Result.error(ErrorMessagesEnum.LOGIN_USER_LOGIN_ERROR.getErrCode(), "登录失败");
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
        //注册时间
        Date date = new Date();
        switch (type) {
            case IRoleLoginService.OPERRATOR:
                TOperatorBasicInfo operatorBasicInfo = tOperatorBasicInfoMapper.selectByNameAndCellphone(name, cellphone);
                if (operatorBasicInfo == null) {
                    return Result.success(tOperatorBasicInfoMapper.registerUser(cellphone, pwd, name, date) > 0);
                }
                if (operatorBasicInfo != null) {
                    return Result.success("运营商" + name + "已存在!");
                }
                return Result.error(ErrorMessagesEnum.INSERT_FAILURE.getErrCode(), "注册失败");
            case IRoleLoginService.AGENCY:
                TAgencyBasicInfo basicInfo = tAgencyBasicInfoMapper.selectAgencyBasicByCellphoneAndName(name, cellphone);
                if (basicInfo == null) {
                    return Result.success(tAgencyBasicInfoMapper.registerUser(cellphone, pwd, name, date) > 0);
                }
                if (basicInfo != null) {
                    return Result.success("代理机构" + name + "已存在!");
                }
                return Result.error(ErrorMessagesEnum.INSERT_FAILURE.getErrCode(), "注册失败");
            case IRoleLoginService.SUPPLIER:
                TSupplierBasicInfo tSupplierBasicInfo = tSupplierBasicInfoMapper.selectSupplierBasicByNameAndCell(name, cellphone);
                if (tSupplierBasicInfo == null) {
                    return Result.success(tSupplierBasicInfoMapper.registerUser(cellphone, pwd, name, date) > 0);
                }
                if (tSupplierBasicInfo != null) {
                    return Result.success("供货商" + name + "已存在!");
                }
                return Result.error(ErrorMessagesEnum.INSERT_FAILURE.getErrCode(), "注册失败");
            case IRoleLoginService.PURCHASER:
                TPurchaserBasicInfo tPurchaserBasicInfo = tPurchaserBasicInfoMapper.selectBasicInfoByNameAndPhone(name, cellphone);
                if (tPurchaserBasicInfo == null) {
                    return Result.success(tPurchaserBasicInfoMapper.registerUser(cellphone, pwd, name, date) > 0);
                }
                if (tPurchaserBasicInfo != null) {
                    return Result.success("采购商" + name + "已存在!");
                }
                return Result.error(ErrorMessagesEnum.INSERT_FAILURE.getErrCode(), "注册失败");

            case IRoleLoginService.EXPERT:
                TExpertBasicInfo tExpertBasicInfo = tExpertBasicInfoMapper.selectExpertByNameAndCellPhone(name, cellphone);
                if (tExpertBasicInfo == null) {
                    return Result.success(tExpertBasicInfoMapper.registerUser(cellphone, pwd, name, date) > 0);
                }
                if (tExpertBasicInfo != null) {
                    return Result.success("评标专家" + name + "已存在!");
                }
                return Result.error(ErrorMessagesEnum.INSERT_FAILURE.getErrCode(), "注册失败");

            default:
                return Result.error(ErrorMessagesEnum.INSERT_FAILURE.getErrCode(), "注册失败");
        }
    }

    @Override
    public Result<Boolean> modifyPassword(ModifyUser modifyUser) {
        //新的密码加密
        String password = MD5Util.MD5EncodeUtf8(modifyUser.getNewPassword());
        modifyUser.setNewPassword(password);
        //用户电话
        String cell = modifyUser.getCellphone();
        TSupplierBasicInfo tSupplierBasicInfo = tSupplierBasicInfoMapper.selectSupplierBasicByCell(cell);
        TOperatorBasicInfo tOperatorBasicInfo = tOperatorBasicInfoMapper.selectByCellphone(cell);
        TAgencyBasicInfo tAgencyBasicInfo = tAgencyBasicInfoMapper.selectAgencyBasicByCellphone(cell);
        TPurchaserBasicInfo tPurchaserBasicInfo = tPurchaserBasicInfoMapper.selectPurchaserBasicInfoByCell(cell);
        TExpertBasicInfo tExpertBasicInfo = tExpertBasicInfoMapper.selectExpertCellPhone(cell);
        int agency=0;
        int purchaser=0;
        int operator=0;
        int supplier=0;
        int expert = 0;
        if (tAgencyBasicInfo != null) {
            agency = tAgencyBasicInfoMapper.updateAgencyPassword(modifyUser);
            String oldPassword = tAgencyBasicInfo.getPassword();
            if (oldPassword.equals(password)) {
                return Result.error("新旧密码不能相同");
            }
        }
        if (tPurchaserBasicInfo != null) {
            purchaser = tPurchaserBasicInfoMapper.updatePurchaserPassword(modifyUser);
            String oldPassword = tPurchaserBasicInfo.getPassword();
            if (oldPassword.equals(password)) {
                return Result.error("新旧密码不能相同");
            }
        }
        if (tSupplierBasicInfo != null) {
            supplier = tSupplierBasicInfoMapper.updateSupplierPassword(modifyUser);
            String oldPassword = tSupplierBasicInfo.getPassword();
            if (oldPassword.equals(password)) {
                return Result.error("新旧密码不能相同");
            }
        }
        if (tOperatorBasicInfo != null) {
            operator = tOperatorBasicInfoMapper.updateOperatorPassword(modifyUser);
            String oldPassword = tOperatorBasicInfo.getPassword();
            if (oldPassword.equals(password)) {
                return Result.error("新旧密码不能相同");
            }
        }
        if (tExpertBasicInfo != null) {
            expert = tExpertBasicInfoMapper.updateExpertPassword(modifyUser);
            String oldPassword = tExpertBasicInfo.getPassword();
            if (oldPassword.equals(password)) {
                return Result.error("新旧密码不能相同");
            }
        }
        if(expert>0||supplier>0||agency>0||operator>0||purchaser>0){
            return Result.success("密码修改成功");
        }
        return Result.error("密码修改失败!");
    }


}
