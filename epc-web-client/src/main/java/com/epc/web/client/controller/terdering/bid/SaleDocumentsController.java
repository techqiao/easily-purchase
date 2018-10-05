package com.epc.web.client.controller.terdering.bid;

import com.epc.common.Result;
import com.epc.common.constants.AnnouncementProcessStatusEnum;
import com.epc.common.constants.Const;
import com.epc.web.client.controller.common.BaseController;
import com.epc.web.client.controller.terdering.bid.handle.ClientHandDocuments;
import com.epc.web.client.controller.terdering.bid.handle.ClientHandleBidsGuaranteeAmount;
import com.epc.web.client.controller.terdering.bid.handle.ClientHandleSaleDocuments;
import com.epc.web.client.controller.terdering.bid.handle.ClientHandleUnderLine;
import com.epc.web.client.remoteApi.terdering.bid.SaleDocumentsClient;
import com.epc.web.facade.terdering.bid.handle.HandleDocuments;
import com.epc.web.facade.terdering.bid.handle.HandleBidsGuaranteeAmount;
import com.epc.web.facade.terdering.bid.handle.HandleSaleDocuments;
import com.epc.web.facade.terdering.bid.handle.HandleUnderLine;
import com.epc.web.facade.terdering.bid.vo.DocumentsVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-25 15:05
 * <p>@Author : wjq
 */
@Api(value = "发售招标文件",tags = {"发售招标文件"})
@RestController
@RequestMapping(value = "/documents", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class SaleDocumentsController extends BaseController {
    @Autowired
    private SaleDocumentsClient saleDocumentsClient;


    @ApiOperation(value = "发布|审核|批复|修改|删除 招标文件")
    @PostMapping(value="/handleSaleDocuments")
    public Result<Boolean> handleSaleDocuments(ClientHandDocuments clientHandDocuments){
        HandleDocuments handleDocuments = new HandleDocuments();
        List<ClientHandleBidsGuaranteeAmount> clientHandleBidsGuaranteeAmounts = clientHandDocuments.getClientHandleBidsGuaranteeAmounts();
        ClientHandleSaleDocuments clientHandleSaleDocuments = clientHandDocuments.getClientHandleSaleDocuments();
        ClientHandleUnderLine clientHandleUnderLine = clientHandDocuments.getClientHandleUnderLine();
        //新增招标文件
        if(clientHandleSaleDocuments.getId() == null && clientHandleUnderLine.getId() == null
                && !clientHandleBidsGuaranteeAmounts.isEmpty()) {
            HandleSaleDocuments handleSaleDocuments = new HandleSaleDocuments();
            BeanUtils.copyProperties(clientHandleSaleDocuments, handleSaleDocuments);
            return handleSaleDocuments(handleDocuments, clientHandleBidsGuaranteeAmounts, clientHandleUnderLine, handleSaleDocuments);
        }
        //处理招标文件
        else if(clientHandleSaleDocuments.getId() != null && clientHandleUnderLine.getId() != null
                && !clientHandleBidsGuaranteeAmounts.isEmpty()){
            HandleSaleDocuments handleSaleDocuments = new HandleSaleDocuments();
            BeanUtils.copyProperties(clientHandleSaleDocuments, handleSaleDocuments);
            //未提交 操作人是提交人
            if(clientHandleSaleDocuments.getProcessStatus().equals(AnnouncementProcessStatusEnum.NOT_SUBMIT.getCode())){
                return handleSaleDocuments(handleDocuments, clientHandleBidsGuaranteeAmounts, clientHandleUnderLine, handleSaleDocuments);
            }
            //审核 操作人是审核人
            if(clientHandleSaleDocuments.getProcessStatus().equals(AnnouncementProcessStatusEnum.AUDITING.getCode())){
                handleSaleDocuments.setAuditorId(getLoginUser().getUserId());
                return handleSaleDocuments(handleDocuments, clientHandleBidsGuaranteeAmounts, clientHandleUnderLine, handleSaleDocuments);
            }
            //批复 操作人是批复人
            if(clientHandleSaleDocuments.getProcessStatus().equals(AnnouncementProcessStatusEnum.REPLY.getCode())){
                handleSaleDocuments.setRepliesId(getLoginUser().getUserId());
                return handleSaleDocuments(handleDocuments, clientHandleBidsGuaranteeAmounts, clientHandleUnderLine, handleSaleDocuments);
            }
        }
        return Result.error();
    }


    @ApiOperation(value = "查询招标文件详情")
    @PostMapping(value="/getSaleDocuments")
    public Result<DocumentsVO> getSaleDocuments(@RequestParam(value = "id") Long id){
        return saleDocumentsClient.getSaleDocuments(id);
    }

    /**
     * 招标文件相关数据构造
     * @param handleDocuments
     * @param clientHandleBidsGuaranteeAmounts
     * @param clientHandleUnderLine
     * @param handleSaleDocuments
     * @return
     */
    private Result<Boolean> handleSaleDocuments(HandleDocuments handleDocuments, List<ClientHandleBidsGuaranteeAmount> clientHandleBidsGuaranteeAmounts, ClientHandleUnderLine clientHandleUnderLine, HandleSaleDocuments handleSaleDocuments) {
        //招标文件 操作人
        handleSaleDocuments.setOperateId(getLoginUser().getUserId());
        HandleUnderLine handleUnderLine = new HandleUnderLine();
        BeanUtils.copyProperties(clientHandleUnderLine, handleUnderLine);
        //招标文件 操作人
        handleUnderLine.setOperateId(getLoginUser().getUserId());
        List<HandleBidsGuaranteeAmount> handleBidsGuaranteeAmountList = new ArrayList<>();
        for (ClientHandleBidsGuaranteeAmount item : clientHandleBidsGuaranteeAmounts) {
            HandleBidsGuaranteeAmount handleBidsGuaranteeAmount = new HandleBidsGuaranteeAmount();
            BeanUtils.copyProperties(item, handleBidsGuaranteeAmount);
            handleBidsGuaranteeAmount.setOperateId(getLoginUser().getUserId());
            handleBidsGuaranteeAmountList.add(handleBidsGuaranteeAmount);
        }
        //招标文件
        handleDocuments.setHandleSaleDocuments(handleSaleDocuments);
        //保证金
        handleDocuments.setHandleBidsGuaranteeAmount(handleBidsGuaranteeAmountList);
        //线下招标文件
        if(!handleSaleDocuments.getIsUnderLine().equals(Const.IS_UNDER_LINE.UP)){
            handleDocuments.setHandleUnderLine(handleUnderLine);
        }
        return saleDocumentsClient.handleSaleDocuments(handleDocuments);
    }

}
