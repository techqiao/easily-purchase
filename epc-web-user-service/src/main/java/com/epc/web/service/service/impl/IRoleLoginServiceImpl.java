package com.epc.web.service.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.epc.common.Result;
import com.epc.common.constants.Const;
import com.epc.common.constants.ErrorMessagesEnum;
import com.epc.common.util.MD5Util;
import com.epc.common.util.RedisShardedPoolUtil;
import com.epc.web.facade.loginuser.dto.LoginUser;
import com.epc.web.facade.loginuser.dto.Loginer;
import com.epc.web.facade.loginuser.dto.ModifyUser;
import com.epc.web.facade.loginuser.dto.RegisterUser;
import com.epc.web.facade.supplier.vo.SupplierBasicInfoVO;
import com.epc.web.service.domain.agency.TAgencyBasicInfo;
import com.epc.web.service.domain.agency.TAgencyDetailInfo;
import com.epc.web.service.domain.expert.TExpertBasicInfo;
import com.epc.web.service.domain.operator.TOperatorBasicInfo;
import com.epc.web.service.domain.operator.TOperatorDetailInfo;
import com.epc.web.service.domain.purchaser.TPurchaserBasicInfo;
import com.epc.web.service.domain.purchaser.TPurchaserDetailInfo;
import com.epc.web.service.domain.supplier.TSupplierBasicInfo;
import com.epc.web.service.domain.supplier.TSupplierDetailInfo;
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
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author :winlin
 * @Description :
 * @param:
 * @return:
 * @date:2018/9/18
 */
@Service
public class IRoleLoginServiceImpl implements IRoleLoginService {
    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(IRoleLoginServiceImpl.class);

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
    public Result<LoginUser> operatorLogin(@RequestBody Loginer loginer) {
        String cellphone = loginer.getCellphone();
        String pwd = MD5Util.MD5EncodeUtf8(loginer.getPassword());
        Integer type = loginer.getType();
        TOperatorBasicInfo basicInfo = null;
        //返回信息
        LoginUser loginUser = new LoginUser();
        try {
            basicInfo = tOperatorBasicInfoMapper.login(cellphone, pwd);
            if (basicInfo == null) {
                return Result.success("用户名不正确或密码不匹配");
            } else {
                if (basicInfo.getState() < Const.STATE_CODE.AUDIT_SUCCESS) {
                    loginUser.setState(basicInfo.getState());
                    loginUser.setUserId(basicInfo.getId());
                    return Result.success(loginUser);
                }
            }
        } catch (Exception e) {
            LOGGER.error("登录失败:Exception:{}", e);
            return Result.error("登录失败");
        }
        //获得运营商机构id
        Long operatorId = basicInfo.getOperatorId();
        loginUser.setName(basicInfo.getName());
        loginUser.setCellphone(basicInfo.getCellphone());
        loginUser.setUserId(basicInfo.getId());
        loginUser.setType(type);
        loginUser.setLoginRole(basicInfo.getRole());
        Integer role =basicInfo.getRole();
        if(role==Const.Role.ROLE_CORPORATION){loginUser.setBossId(basicInfo.getId());}
        if (operatorId != null) {
            TOperatorBasicInfo boss = null;
            TOperatorDetailInfo detailInfo = null;
            try {
                //得到法人的信息
                boss = tOperatorBasicInfoMapper.selectOperatorDetailByOperatorId(operatorId, Const.Role.ROLE_CORPORATION);
                //获得公司信息
                detailInfo = tOperatorDetailInfoMapper.selectOperatorDetailByOperatorId(operatorId);
            } catch (Exception e) {
                LOGGER.error("公司信息不完善Exception:{}", e);
            }
            //封装登录信息返回
            if (boss != null && detailInfo != null) {
                loginUser.setBossName(boss.getName());
                loginUser.setCompanyId(detailInfo.getOperatorId());
                loginUser.setCompanyName(detailInfo.getCompanyName());
                loginUser.setBossId(boss.getId());
            }
        }
        return this.loginBack(loginUser);
    }

    @Override
    public Result<LoginUser> purchaserLogin(@RequestBody Loginer loginer) {
        String cellphone = loginer.getCellphone();
        String pwd = MD5Util.MD5EncodeUtf8(loginer.getPassword());
        Integer type = loginer.getType();
        TPurchaserBasicInfo basicinfo3 = null;
        LoginUser loginUser3 = new LoginUser();
        try {
            basicinfo3 = tPurchaserBasicInfoMapper.login(cellphone, pwd);
            if (basicinfo3 == null) {
                return Result.success("用户名不正确或密码不匹配");
            } else {
                if (basicinfo3.getState() < Const.STATE_CODE.AUDIT_SUCCESS) {
                    loginUser3.setState(basicinfo3.getState());
                    loginUser3.setUserId(basicinfo3.getId());
                    return Result.success(loginUser3);
                }
            }
        } catch (Exception e) {
            LOGGER.error("登录失败Exception:{}", e);
            return Result.error("登录失败");
        }
        //获得机构id
        Long purchaserId = basicinfo3.getPurchaserId();
        //封装返回对象
        loginUser3.setName(basicinfo3.getName());
        loginUser3.setCellphone(basicinfo3.getCellphone());
        loginUser3.setUserId(basicinfo3.getId());
        loginUser3.setType(type);
        loginUser3.setLoginRole(basicinfo3.getRole());
        Integer role =basicinfo3.getRole();
        if(role==Const.Role.ROLE_CORPORATION){loginUser3.setBossId(basicinfo3.getId());}
        if (purchaserId != null) {
            //获得老板
            TPurchaserBasicInfo boss3 = null;
            //获得公司信息
            TPurchaserDetailInfo detailInfo3 = null;
            try {
                boss3 = tPurchaserBasicInfoMapper.selectBossBasicInfoByPurchaserIdAndRole(purchaserId, Const.Role.ROLE_CORPORATION);
                detailInfo3= tPurchaserDetailInfoMapper.selectDetailByPurchaserId(purchaserId);
            } catch (Exception e) {
                LOGGER.error("公司信息不完善Exception:{}");
                return Result.error("登录失败");
            }
            if (boss3 != null && detailInfo3 != null) {
                loginUser3.setBossName(boss3.getName());
                loginUser3.setCompanyId(detailInfo3.getPurchaserId());
                loginUser3.setCompanyName(detailInfo3.getCompanyName());
                loginUser3.setBossId(boss3.getId());
            }
        }
        return this.loginBack(loginUser3);
    }

    @Override
    public Result<LoginUser> agencyLogin(@RequestBody Loginer loginer) {
        String cellphone = loginer.getCellphone();
        String pwd = MD5Util.MD5EncodeUtf8(loginer.getPassword());
        Integer type = loginer.getType();
        LoginUser loginUser1 = new LoginUser();
        TAgencyBasicInfo basicinfo1 = null;
        try {
            basicinfo1 = tAgencyBasicInfoMapper.login(cellphone, pwd);
            if (basicinfo1 == null) {
                return Result.success("用户名不正确或密码不匹配");
            } else {
                if (basicinfo1.getState() < Const.STATE_CODE.AUDIT_SUCCESS) {
                    loginUser1.setState(basicinfo1.getState());
                    loginUser1.setUserId(basicinfo1.getId());
                    return Result.success(loginUser1);
                }
            }
        } catch (Exception e) {
            LOGGER.error("登录失败Exception:{}", e);
            return Result.error("登录失败");
        }

        //获得机构id
        Long agencyId = basicinfo1.getAgencyId();
        loginUser1.setName(basicinfo1.getName());
        loginUser1.setCellphone(basicinfo1.getCellphone());
        loginUser1.setUserId(basicinfo1.getId());
        loginUser1.setType(type);
        loginUser1.setLoginRole(basicinfo1.getRole());
        Integer role =basicinfo1.getRole();
        if(role==Const.Role.ROLE_CORPORATION){loginUser1.setBossId(basicinfo1.getId());}
        if (agencyId != null) {
            //获得老板
            TAgencyBasicInfo boss1 = null;
            //获得公司信息
            TAgencyDetailInfo detailInfo1 = null;
            try {
                boss1 = tAgencyBasicInfoMapper.selectBossBasicInfoByPurchaserIdAndRole(agencyId, Const.Role.ROLE_CORPORATION);
                detailInfo1 = tAgencyDetailInfoMapper.selectAgencyDetailByAgencyId(agencyId);
            } catch (Exception e) {
                LOGGER.error("公司信息不完善Exception:{}", e);
                return Result.error("登录失败");
            }
            if (boss1 != null && detailInfo1 != null) {
                loginUser1.setBossName(boss1.getName());
                loginUser1.setCompanyId(detailInfo1.getAgencyId());
                loginUser1.setCompanyName(detailInfo1.getCompanyName());
                loginUser1.setBossId(boss1.getId());
            }
        }
        return this.loginBack(loginUser1);

    }

    @Override
    public Result<LoginUser> supplierLogin(@RequestBody Loginer loginer) {
        String cellphone = loginer.getCellphone();
        String pwd = MD5Util.MD5EncodeUtf8(loginer.getPassword());
        Integer type = loginer.getType();
        TSupplierBasicInfo basicinfo2 = null;
        LoginUser loginUser2 = new LoginUser();
        try {
            basicinfo2 = tSupplierBasicInfoMapper.login(cellphone, pwd);
            if (basicinfo2 == null) {
                return Result.success("用户名不正确或密码不匹配");
            } else {
                if (basicinfo2.getState() < Const.STATE_CODE.AUDIT_SUCCESS) {
                    loginUser2.setState(basicinfo2.getState());
                    loginUser2.setUserId(basicinfo2.getId());
                    return Result.success(loginUser2);
                }
            }
        } catch (Exception e) {
            LOGGER.error("登录失败Exception:{}", e);
            return Result.error("登录失败");
        }
        //获得机构id
        Long suuplierId = basicinfo2.getSupplierId();
        //封装返回对象
        loginUser2.setName(basicinfo2.getName());
        loginUser2.setCellphone(basicinfo2.getCellphone());
        loginUser2.setUserId(basicinfo2.getId());
        loginUser2.setType(type);
        loginUser2.setLoginRole(basicinfo2.getRole());
        Integer role =basicinfo2.getRole();
        if(role==Const.Role.ROLE_CORPORATION){loginUser2.setBossId(basicinfo2.getId());}
        if (suuplierId != null) {
            //获得老板
            TSupplierBasicInfo boss2 = null;
            //获得公司信息
            TSupplierDetailInfo detailInfo2 = null;
            try {
                boss2= tSupplierBasicInfoMapper.selectBossBasicInfoByPurchaserIdAndRole(suuplierId, Const.Role.ROLE_CORPORATION);
                detailInfo2= tSupplierDetailInfoMapper.selectTSupplierDetailInfoBySupplierId(suuplierId);
            } catch (Exception e) {
                LOGGER.error("公司信息不完善Exception:{}");
            }
            if (boss2 != null && detailInfo2 != null) {
                loginUser2.setBossName(boss2.getName());
                loginUser2.setCompanyId(detailInfo2.getSupplierId());
                loginUser2.setCompanyName(detailInfo2.getCompanyName());
                loginUser2.setBossId(boss2.getId());
            }
        }
        return this.loginBack(loginUser2);
    }

    @Override
    public Result<LoginUser> expertLogin(@RequestBody Loginer loginer) {
        String cellphone = loginer.getCellphone();
        String pwd = MD5Util.MD5EncodeUtf8(loginer.getPassword());
        Integer type = loginer.getType();
        LoginUser loginUser4 = null;
        try {
            loginUser4 = tExpertBasicInfoMapper.login(cellphone, pwd);
            if (loginUser4 == null) {
                return Result.success("用户名不正确或密码不匹配");
            } else {
                if (loginUser4.getState() < Const.STATE_CODE.AUDIT_SUCCESS) {
                    return Result.success(loginUser4);
                }
            }
        } catch (Exception e) {
            LOGGER.error("登录失败Exception:{}", e);
            return Result.error("登录失败");
        }
        loginUser4.setType(type);
        return this.loginBack(loginUser4);

    }

    @Override
    public Result<Boolean> registerOperator(RegisterUser registerUser) {
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
        try {
            TOperatorBasicInfo operatorBasicInfo = tOperatorBasicInfoMapper.selectByCellphone(cellphone);
            if (operatorBasicInfo == null) {
                return Result.success(tOperatorBasicInfoMapper.registerUser(cellphone, pwd, name, date) > 0);
            } else {
                return Result.success("运营商" + name + "已存在!");
            }
        } catch (Exception e) {
            LOGGER.error("运营商注册失败:Exception={}", e);
            return Result.error("运营商注册失败!");
        }
    }

    @Override
    public Result<Boolean> registerPurchaser(RegisterUser registerUser) {
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
        try {
            TPurchaserBasicInfo tPurchaserBasicInfo = tPurchaserBasicInfoMapper.selectPurchaserBasicInfoByCell(cellphone);
            if (tPurchaserBasicInfo == null) {
                return Result.success(tPurchaserBasicInfoMapper.registerUser(cellphone, pwd, name, date) > 0);
            } else {
                return Result.success("采购商" + name + "已存在!");
            }
        } catch (Exception e) {
            LOGGER.error("采购商注册失败:Exception={}", e);
            return Result.error("采购商注册失败");
        }
    }

    @Override
    public Result<Boolean> registerAgency(RegisterUser registerUser) {
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
        try {
            TAgencyBasicInfo basicInfo = tAgencyBasicInfoMapper.selectAgencyBasicByCellphone(cellphone);
            if (basicInfo == null) {
                return Result.success(tAgencyBasicInfoMapper.registerUser(cellphone, pwd, name, date) > 0);
            } else {
                return Result.success("代理机构" + name + "已存在!");
            }
        } catch (Exception e) {
            LOGGER.error("代理机构注册失败:Exception={}", e);
            return Result.error("代理机构注册失败");
        }
    }

    @Override
    public Result<Boolean> registerSupplier(RegisterUser registerUser) {
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
        try {
            TSupplierBasicInfo tSupplierBasicInfo = tSupplierBasicInfoMapper.selectSupplierBasicByCell(cellphone);
            if (tSupplierBasicInfo == null) {
                return Result.success(tSupplierBasicInfoMapper.registerUser(cellphone, pwd, name, date) > 0);
            } else {
                return Result.success("供货商" + name + "已存在!");
            }
        } catch (Exception e) {
            LOGGER.error("供货商注册失败:Exception={}", e);
            return Result.error("供货商注册失败");
        }
    }

    @Override
    public Result<Boolean> registerExpert(RegisterUser registerUser) {
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
        try {
            TExpertBasicInfo tExpertBasicInfo = tExpertBasicInfoMapper.selectExpertCellPhone(cellphone);
            if (tExpertBasicInfo == null) {
                return Result.success(tExpertBasicInfoMapper.registerUser(cellphone, pwd, name, date) > 0);
            } else {
                return Result.success("评标专家" + name + "已存在!");
            }
        } catch (Exception e) {
            LOGGER.error("评标专家注册失败:Exception={}", e);
            return Result.error("评标专家注册失败");
        }
    }

    @Override
    public Result<Boolean> modifyPasswordOperator(ModifyUser modifyUser) {
        //新的密码加密
        String password = MD5Util.MD5EncodeUtf8(modifyUser.getNewPassword());
        modifyUser.setNewPassword(password);
        //用户电话
        String cell = modifyUser.getCellphone();
        int operator = 0;
        try {
            TOperatorBasicInfo tOperatorBasicInfo = tOperatorBasicInfoMapper.selectByCellphone(cell);
            if (tOperatorBasicInfo != null) {
                String oldPassword = tOperatorBasicInfo.getPassword();
                if (oldPassword.equals(password)) {
                    return Result.error("新旧密码不能相同");
                }
                operator = tOperatorBasicInfoMapper.updateOperatorPassword(modifyUser);
            }
        } catch (Exception e) {
            LOGGER.error("密码修改失败:Exception:{}", e);
            return Result.error("密码修改失败");
        }
        return operator > 0 ? Result.success("密码修改成功") : Result.error("密码修改失败");
    }

    @Override
    public Result<Boolean> modifyPasswordSupplier(ModifyUser modifyUser) {
        //新的密码加密
        String password = MD5Util.MD5EncodeUtf8(modifyUser.getNewPassword());
        modifyUser.setNewPassword(password);
        //用户电话
        String cell = modifyUser.getCellphone();
        int supplier = 0;
        try {
            TSupplierBasicInfo tSupplierBasicInfo = tSupplierBasicInfoMapper.selectSupplierBasicByCell(cell);
            if (tSupplierBasicInfo != null) {
                String oldPassword = tSupplierBasicInfo.getPassword();
                if (oldPassword.equals(password)) {
                    return Result.error("新旧密码不能相同");
                }
                supplier = tSupplierBasicInfoMapper.updateSupplierPassword(modifyUser);
            }
        } catch (Exception e) {
            LOGGER.error("密码修改失败:Exception:{}", e);
            return Result.error("密码修改失败");
        }
        return supplier > 0 ? Result.success("密码修改成功") : Result.error("密码修改失败");
    }

    @Override
    public Result<Boolean> modifyPasswordAgency(ModifyUser modifyUser) {
        //新的密码加密
        String password = MD5Util.MD5EncodeUtf8(modifyUser.getNewPassword());
        modifyUser.setNewPassword(password);
        //用户电话
        String cell = modifyUser.getCellphone();
        int agency = 0;
        try {
            TAgencyBasicInfo tAgencyBasicInfo = tAgencyBasicInfoMapper.selectAgencyBasicByCellphone(cell);
            if (tAgencyBasicInfo != null) {
                String oldPassword = tAgencyBasicInfo.getPassword();
                if (oldPassword.equals(password)) {
                    return Result.error("新旧密码不能相同");
                }
                agency = tAgencyBasicInfoMapper.updateAgencyPassword(modifyUser);
            }
        } catch (Exception e) {
            LOGGER.error("密码修改失败:Exception:{}", e);
            return Result.error("密码修改失败");
        }
        return agency > 0 ? Result.success("密码修改成功") : Result.error("密码修改失败");
    }

    @Override
    public Result<Boolean> modifyPasswordExpert(ModifyUser modifyUser) {
        //新的密码加密
        String password = MD5Util.MD5EncodeUtf8(modifyUser.getNewPassword());
        modifyUser.setNewPassword(password);
        //用户电话
        String cell = modifyUser.getCellphone();
        int expert = 0;
        try {
            TExpertBasicInfo tAgencyBasicInfo = tExpertBasicInfoMapper.selectExpertCellPhone(cell);
            if (tAgencyBasicInfo != null) {
                String oldPassword = tAgencyBasicInfo.getPassword();
                if (oldPassword.equals(password)) {
                    return Result.error("新旧密码不能相同");
                }
                expert = tExpertBasicInfoMapper.updateExpertPassword(modifyUser);
            }
        } catch (Exception e) {
            LOGGER.error("密码修改失败:Exception:{}", e);
            return Result.error("密码修改失败");
        }
        return expert > 0 ? Result.success("密码修改成功") : Result.error("密码修改失败");
    }

    @Override
    public Result<Boolean> modifyPasswordPurchaser(ModifyUser modifyUser) {
        //新的密码加密
        String password = MD5Util.MD5EncodeUtf8(modifyUser.getNewPassword());
        modifyUser.setNewPassword(password);
        //用户电话
        String cell = modifyUser.getCellphone();
        int purchaser = 0;
        try {
            TPurchaserBasicInfo tPurchaserBasicInfo = tPurchaserBasicInfoMapper.selectPurchaserBasicInfoByCell(cell);
            if (tPurchaserBasicInfo != null) {
                String oldPassword = tPurchaserBasicInfo.getPassword();
                if (oldPassword.equals(password)) {
                    return Result.error("新旧密码不能相同");
                }
                purchaser = tPurchaserBasicInfoMapper.updatePurchaserPassword(modifyUser);
            }
        } catch (Exception e) {
            LOGGER.error("密码修改失败:Exception:{}", e);
            return Result.error("密码修改失败");
        }
        return purchaser > 0 ? Result.success("密码修改成功") : Result.error("密码修改失败");
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
                try {
                    TOperatorBasicInfo operatorBasicInfo = tOperatorBasicInfoMapper.selectByNameAndCellphone(name, cellphone);
                    //tOperatorBasicInfoMapper.selectCountOperatorBasicByNameAndCellphone(name,cellphone);
                    if (operatorBasicInfo == null) {
                        return Result.success(tOperatorBasicInfoMapper.registerUser(cellphone, pwd, name, date) > 0);
                    } else {
                        return Result.success("运营商" + name + "已存在!");
                    }
                } catch (Exception e) {
                    LOGGER.error("运营商注册失败:Exception={}", e);
                    return Result.error("运营商注册失败!");
                }
                //return Result.error(ErrorMessagesEnum.INSERT_FAILURE.getErrCode(), "注册失败");
            case IRoleLoginService.AGENCY:

                try {
                    TAgencyBasicInfo basicInfo = tAgencyBasicInfoMapper.selectAgencyBasicByCellphoneAndName(name, cellphone);
                    if (basicInfo == null) {
                        return Result.success(tAgencyBasicInfoMapper.registerUser(cellphone, pwd, name, date) > 0);
                    } else {
                        return Result.success("代理机构" + name + "已存在!");
                    }
                } catch (Exception e) {
                    LOGGER.error("代理机构注册失败:Exception={}", e);
                    return Result.error("代理机构注册失败");
                }
                //return Result.error(ErrorMessagesEnum.INSERT_FAILURE.getErrCode(), "注册失败");
            case IRoleLoginService.SUPPLIER:

                try {
                    TSupplierBasicInfo tSupplierBasicInfo = tSupplierBasicInfoMapper.selectSupplierBasicByNameAndCell(name, cellphone);
                    if (tSupplierBasicInfo == null) {
                        return Result.success(tSupplierBasicInfoMapper.registerUser(cellphone, pwd, name, date) > 0);
                    } else {
                        return Result.success("供货商" + name + "已存在!");
                    }
                } catch (Exception e) {
                    LOGGER.error("供货商注册失败:Exception={}", e);
                    return Result.error("供货商注册失败");
                }
                //return Result.error(ErrorMessagesEnum.INSERT_FAILURE.getErrCode(), "注册失败");
            case IRoleLoginService.PURCHASER:
                try {
                    TPurchaserBasicInfo tPurchaserBasicInfo = tPurchaserBasicInfoMapper.selectBasicInfoByNameAndPhone(name, cellphone);
                    if (tPurchaserBasicInfo == null) {
                        return Result.success(tPurchaserBasicInfoMapper.registerUser(cellphone, pwd, name, date) > 0);
                    } else {
                        return Result.success("采购商" + name + "已存在!");
                    }
                } catch (Exception e) {
                    LOGGER.error("采购商注册失败:Exception={}", e);
                    return Result.error("采购商注册失败");
                }
                // return Result.error(ErrorMessagesEnum.INSERT_FAILURE.getErrCode(), "注册失败");

            case IRoleLoginService.EXPERT:

                try {
                    TExpertBasicInfo tExpertBasicInfo = tExpertBasicInfoMapper.selectExpertByNameAndCellPhone(name, cellphone);
                    if (tExpertBasicInfo == null) {
                        return Result.success(tExpertBasicInfoMapper.registerUser(cellphone, pwd, name, date) > 0);
                    } else {
                        return Result.success("评标专家" + name + "已存在!");
                    }
                } catch (Exception e) {
                    LOGGER.error("评标专家注册失败:Exception={}", e);
                    return Result.error("评标专家注册失败");
                }
                //return Result.error(ErrorMessagesEnum.INSERT_FAILURE.getErrCode(), "注册失败");

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
        int agency = 0;
        int purchaser = 0;
        int operator = 0;
        int supplier = 0;
        int expert = 0;
        try {
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
        } catch (Exception e) {
            LOGGER.error("密码修改失败:Exception:{}", e);
            return Result.error("密码修改失败");
        }
        if (expert > 0 || supplier > 0 || agency > 0 || operator > 0 || purchaser > 0) {
            return Result.success("密码修改成功");
        }
        return Result.error("密码修改失败!");
    }

    public Result loginBack(LoginUser loginUser) {
        if (loginUser != null) {
            String token = UUID.randomUUID().toString().replace("-", "");
            String tokens = "EPC_PRIVATE_" + token;
            Map<String, Object> resultMap = new HashMap<String, Object>(16);
            resultMap.put("epc-token", token);
            RedisShardedPoolUtil.setEx(tokens, JSONObject.toJSONString(loginUser), Const.RedisCacheExtime.REDIS_SESSION_EXTIME);
            return Result.success("登陆成功", resultMap);
        }
        return Result.success("没有用户信息", null);
    }
}
