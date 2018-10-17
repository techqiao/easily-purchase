package com.epc.mobile.client.controller.terdering.bid;

import com.epc.common.Result;
import com.epc.mobile.client.controller.terdering.bid.handle.ClientWinBidding;
import com.epc.mobile.client.remoteApi.terdering.bid.WinBidClient;
import com.epc.web.facade.bidding.handle.HandleWinBidding;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
* @Description:中标记录
* @Author: linzhixiang
* @Date: 2018/9/27
*/
@Api(value = "中标记录",tags = "中标记录")
@RestController
@RequestMapping(value = "/project", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)

public class WinBidRecordController {
    @Autowired
    private WinBidClient winBidClient;

    /**
     * 获取中标通知列表
     * @param procurementProjectId
     * @return
     */

   /* @ApiOperation(value = "获取采购项目下各标段的中标公示记录")
    @GetMapping(value = "getTWinBidNominated", consumes = "application/json; charset=UTF-8")
    public Result<List<NominateVO>> getTWinBidNominated(@RequestParam("procurementProjectId") Long procurementProjectId) {
        return  winBidClient.getTWinBidNominated(procurementProjectId);
    }*/


    /**
     * 确认中标人和中标通知书
     * @param dtoList
     * @return
     */
    @ApiOperation(value = "确认中标人和中标通知书")
    @PostMapping(value = "updateTWinBidNominated", consumes = "application/json; charset=UTF-8")
    public Result<Boolean> updateTWinBidNominated(@RequestBody List<ClientWinBidding> dtoList){
        List<HandleWinBidding> newList=new ArrayList<>();
        for(ClientWinBidding dto:dtoList){
            HandleWinBidding HandleWinBidding=new HandleWinBidding();
            BeanUtils.copyProperties(dto,HandleWinBidding);
            newList.add(HandleWinBidding);
        }
        return  winBidClient.updateTWinBidNominated(newList);
    }

}
