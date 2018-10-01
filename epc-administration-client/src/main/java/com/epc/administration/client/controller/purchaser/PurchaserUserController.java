package com.epc.administration.client.controller.purchaser;


import com.epc.administration.client.controller.purchaser.dto.ClientQueryDetailIfo;
import com.epc.administration.client.controller.purchaser.handle.ClientExaminePurchaserHandle;
import com.epc.administration.client.controller.purchaser.handle.ClientPurchaserForbiddenHandle;
import com.epc.administration.client.controller.purchaser.handle.ClientPurchaserUserDetailInfo;
import com.epc.administration.client.controller.purchaser.handle.ClientUserBasicInfo;
import com.epc.administration.client.remoteapi.purchaser.PurchaserClient;
import com.epc.administration.facade.purchaser.dto.QueryDetailIfo;
import com.epc.administration.facade.purchaser.handle.ExaminePurchaserHandle;
import com.epc.administration.facade.purchaser.handle.PurchaserForbiddenHandle;
import com.epc.administration.facade.purchaser.handle.PurchaserHandle;
import com.epc.administration.facade.purchaser.handle.UserBasicInfo;
import com.epc.administration.facade.purchaser.vo.PurchaserVO;
import com.epc.common.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * @date2018-9-17 09:46:01
 * @author luozhixin
 * 采购人接口
 */
@Api(value = "采购人服务 @罗志鑫",tags = {"采购人服务"})
@RestController
@RequestMapping(value = "/purchaseruser", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class PurchaserUserController {
    @Autowired
    private PurchaserClient purchaserClient;
    @ApiOperation(value = "添加采购人",notes = "添加采购人")
    @PostMapping(value = "createPurchaserUser", consumes = "application/json;charset=UTF-8")
    public Result<Boolean> createPurchaserUser(@RequestBody ClientUserBasicInfo clientUserBasicInfo){
        UserBasicInfo userBasicInfo = new UserBasicInfo();
        BeanUtils.copyProperties(clientUserBasicInfo,userBasicInfo);
        return purchaserClient.createPurchaserUserInfo(userBasicInfo);
    }
    @ApiOperation(value = "采购人完善资料",notes = "采购人完善资料")
    @PostMapping(value = "registryPurchaserDetail" ,consumes = "application/json;charset=UTF-8" )
    public Result<Boolean> insertPurchaserDetailInfo(@RequestBody ClientPurchaserUserDetailInfo clientPurchaserUserDetailInfo ) {
        PurchaserHandle pojo = new PurchaserHandle();
        BeanUtils.copyProperties(clientPurchaserUserDetailInfo,pojo);
        return purchaserClient.insertPurchaserDetailInfo(pojo);
    }
    @ApiOperation(value = "采购人删除资料",notes = "采购人删除资料")
    @GetMapping(value = "deletePurchaserDetailInfo")
    public Result<Boolean> deletePurchaserDetailInfo(@RequestParam("whereId") Long whereId) {
        return purchaserClient.deletePurchaserDetailInfo(whereId);
    }
    @ApiOperation(value = "采购人查询资料",notes = "采购人查询资料")
    @GetMapping(value = "queryPurchaserDetailInfo")
    public Result queryPurchaserDetailInfo(@RequestParam("whereId") Long whereId) {
        return purchaserClient.queryPurchaserDetailInfo(whereId);
    }

    @ApiOperation(value = "查询所有采购人资料分页展示",notes = "查询所有采购人资料分页展示")
    @PostMapping(value = "selectAllPurchaserByPage",consumes = "application/json;charset=UTF-8")
    public Result<List<PurchaserVO>> selectAllPurchaserByPage(@RequestBody ClientQueryDetailIfo clientQueryDetailIfo){
        QueryDetailIfo queryDetailIfo = new QueryDetailIfo();
        BeanUtils.copyProperties(clientQueryDetailIfo,queryDetailIfo);
        return purchaserClient.selectAllPurchaserByPage(queryDetailIfo);
    }
    @ApiOperation(value = "审核采购人", notes = "审核采购人")
    @PostMapping(value = "examineSupplier",consumes = "application/json;charset=UTF-8")
    public Result<Boolean> examineSupplier(@RequestBody ClientExaminePurchaserHandle clientExaminePurchaserHandle) {
        ExaminePurchaserHandle examineSupplierHandle = new ExaminePurchaserHandle();
        BeanUtils.copyProperties(clientExaminePurchaserHandle, examineSupplierHandle);
        return purchaserClient.examinePurchaser(examineSupplierHandle);
    }

    @ApiOperation(value = "启用锁定采购人", notes = "启用锁定采购人")
    @PostMapping(value = "forbiddenPurchaserUser",consumes ="application/json;charset=UTF-8" )
    public Result<Boolean> forbiddenPurchaserUser(@RequestBody ClientPurchaserForbiddenHandle clientPurchaserForbiddenHandle){
        PurchaserForbiddenHandle purchaserForbiddenHandle = new PurchaserForbiddenHandle();
        BeanUtils.copyProperties(clientPurchaserForbiddenHandle,purchaserForbiddenHandle);
        return purchaserClient.forbiddenPurchaserUser(purchaserForbiddenHandle);
    }

}
