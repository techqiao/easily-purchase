package com.epc.web.client.controller.bidding;


import com.epc.common.Result;
import com.epc.web.client.controller.bidding.query.tender.ClientBackTenderDTO;
import com.epc.web.client.controller.bidding.query.tender.ClientBidPay;
import com.epc.web.client.controller.bidding.query.tender.ClientCompanyDTO;
import com.epc.web.client.controller.bidding.query.tender.ClientTenderList;
import com.epc.web.client.remoteApi.bidding.tender.TenderClient;
import com.epc.web.facade.bidding.dto.PersonDTO;
import com.epc.web.facade.bidding.query.tender.QueryBackTenderMoneyRecordDTO;
import com.epc.web.facade.bidding.query.tender.QueryBidPayDTO;
import com.epc.web.facade.bidding.query.tender.QueryPersonDTO;
import com.epc.web.facade.bidding.query.tender.QueryTenderDTO;
import com.epc.web.facade.bidding.vo.IsBackTenderMoneyRecordVO;
import com.epc.web.facade.bidding.vo.QueryTenderMoneyRecordVO;
import com.epc.web.facade.bidding.vo.TenderVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author linzhixiang
 */
@Api(value = "标段服务",tags = "标段业务查询")
@RestController
@RequestMapping(value = "/bidding", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class BiddingTenderController {

    @Autowired
    TenderClient tenderClient;

    @ApiOperation(value = "获取标段列表及保证金支付情况")
    @PostMapping(value = "/queryTenderMoneyRecordVO", consumes = "application/json; charset=UTF-8")
    public Result<List<QueryTenderMoneyRecordVO>> queryTenderMoneyRecordVO(@RequestBody ClientBidPay dto) {
        QueryBidPayDTO queryBidPayDTO = new QueryBidPayDTO();
        BeanUtils.copyProperties(dto, queryBidPayDTO);
        return tenderClient.queryTenderMoneyRecordVO(queryBidPayDTO);
    }

    @ApiOperation(value = "根据采购项目id获取标段列表")
    @PostMapping(value = "/getTenderListByPurchaseProgramId", consumes = "application/json; charset=UTF-8")
    public Result<List<TenderVO>> getTenderListByPurchaseProgramId(@RequestBody ClientTenderList dto) {
        QueryTenderDTO queryTenderDTO = new QueryTenderDTO();
        BeanUtils.copyProperties(dto, queryTenderDTO);
        return tenderClient.getTenderListByPurchaseProgramId(queryTenderDTO);
    }

    @ApiOperation(value = "获取机构下面的人员列表")
    @PostMapping(value = "/getPersonList", consumes = "application/json; charset=UTF-8")
    public Result<List<PersonDTO>> getPersonList(@RequestBody ClientCompanyDTO dto) {
        QueryPersonDTO queryPersonDTO = new QueryPersonDTO();
        BeanUtils.copyProperties(dto, queryPersonDTO);
        return tenderClient.getPersonList(queryPersonDTO);
    }

    @ApiOperation(value = "供应商查看标段保证金退还情况")
    @PostMapping(value = "/isBackTenderMoneyRecordList", consumes = "application/json; charset=UTF-8")
    public Result<List<IsBackTenderMoneyRecordVO>> isBackTenderMoneyRecordList(@RequestBody ClientBackTenderDTO dto) {
        QueryBackTenderMoneyRecordDTO queryBackTenderMoneyRecordDTO=new QueryBackTenderMoneyRecordDTO();
        BeanUtils.copyProperties(dto,queryBackTenderMoneyRecordDTO);
        return tenderClient.isBackTenderMoneyRecordList(queryBackTenderMoneyRecordDTO);
    }
}
