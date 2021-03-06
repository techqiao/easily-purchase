package com.epc.mobile.client.controller.terdering.purchase;

import com.epc.common.Result;
import com.epc.common.constants.Const;
import com.epc.common.constants.ParticipantPermissionEnum;
import com.epc.mobile.client.controller.common.BaseController;
import com.epc.mobile.client.controller.terdering.purchase.handle.ClientHandlePurchaseProjectBasicInfo;
import com.epc.mobile.client.controller.terdering.purchase.vo.ClientQueryPurchaseBasicInfoVO;
import com.epc.mobile.client.remoteApi.purchaser.PurchaserClient;
import com.epc.mobile.client.remoteApi.terdering.purchase.PurchaseProjectClient;
import com.epc.web.facade.purchaser.dto.QueryDto;
import com.epc.web.facade.purchaser.vo.PurchaserAgencyDetailVo;
import com.epc.web.facade.purchaser.vo.PurchaserEmplyeeVo;
import com.epc.web.facade.terdering.participant.handle.HandleParticipantBasicInfo;
import com.epc.web.facade.terdering.purchase.handle.HandlePurchaseProjectBasicInfoSub;
import com.epc.web.facade.terdering.purchase.query.QueryPurchaseBasicInfoVO;
import com.epc.web.facade.terdering.purchase.vo.FlowVO;
import com.epc.web.facade.terdering.purchase.vo.PurchaseProjectBasicInfoVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-18 17:33
 * <p>@Author : wjq
 */
@Api(value = "采购项目服务", tags = {"采购项目服务"})
@RestController
@RequestMapping(value = "/purchaseProject", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class PurchaseProjectBasicInfoController extends BaseController {

    @Autowired
    private PurchaseProjectClient purchaseProjectClient;
    @Autowired
    private PurchaserClient purchaserClient;

    @ApiOperation(value = "新增|修改|删除采购项目")
    @PostMapping(value = "handlePurchaseProjectBasicInfo")
    public Result<Boolean> handlePurchaseProjectBasicInfo(@RequestBody ClientHandlePurchaseProjectBasicInfo clientHandlePurchaseProjectBasicInfo) {
        HandlePurchaseProjectBasicInfoSub handlePurchaseProjectBasicInfoSub = new HandlePurchaseProjectBasicInfoSub();
        BeanUtils.copyProperties(clientHandlePurchaseProjectBasicInfo, handlePurchaseProjectBasicInfoSub);
        handlePurchaseProjectBasicInfoSub.setOperateId(getLoginUser().getUserId());
        handlePurchaseProjectBasicInfoSub.setCreator(getLoginUser().getName());
        //当前登录用户ID(采购人ID)
        Long userId = getLoginUser().getUserId();
        //不全权委托代理机构 指定经办人审核人 其中批复人和负责人为项目经理
        if (Const.IS_OTHER_AGENCY.NOT_OTHER_AGENCY == clientHandlePurchaseProjectBasicInfo.getIsOtherAgency()) {
            //经办人ID
            Long agentId = clientHandlePurchaseProjectBasicInfo.getAgentId();
            //审核人ID
            Long auditorId = clientHandlePurchaseProjectBasicInfo.getAuditorId();
            //参与者集合
            handlePurchaseProjectBasicInfoSub.setHandleParticipantBasicInfoList(new ArrayList<>());
            List<HandleParticipantBasicInfo> handleParticipantBasicInfoList = handlePurchaseProjectBasicInfoSub.getHandleParticipantBasicInfoList();
            if (agentId != null) {
                addUserRole(ParticipantPermissionEnum.AGENT.getCode(), agentId, handleParticipantBasicInfoList);
            }
            if (auditorId != null) {
                addUserRole(ParticipantPermissionEnum.AUDITOR.getCode(), auditorId, handleParticipantBasicInfoList);
            }
            if (userId != null) {
                addUserRole(ParticipantPermissionEnum.REPLY.getCode(), userId, handleParticipantBasicInfoList);
                addUserRole(ParticipantPermissionEnum.PERSON_LIABLE.getCode(), userId, handleParticipantBasicInfoList);
            }
            return purchaseProjectClient.handlePurchaseProjectBasicInfo(handlePurchaseProjectBasicInfoSub);
        }
        //全权委托代理机构
        else {
            //参与者集合
            handlePurchaseProjectBasicInfoSub.setHandleParticipantBasicInfoList(new ArrayList<>());
            List<HandleParticipantBasicInfo> handleParticipantBasicInfoList = handlePurchaseProjectBasicInfoSub.getHandleParticipantBasicInfoList();
            //批复人为项目经理即当前登录人(采购人)
            if (userId != null) {
                addUserRole(ParticipantPermissionEnum.REPLY.getCode(), userId, handleParticipantBasicInfoList);
            }
            //招标代理机构ID
            Long purchaserAgencyId = clientHandlePurchaseProjectBasicInfo.getPurchaserAgencyId();
            if ( purchaserAgencyId!= null) {
                HandleParticipantBasicInfo pojo = new HandleParticipantBasicInfo();
                QueryDto queryDto = new QueryDto();
                queryDto.setId(purchaserAgencyId);
                Result<PurchaserAgencyDetailVo> result = purchaserClient.queryAgencyDetailById(queryDto);
                if(result.getData()!=null){
                    pojo.setUserAgencyId(purchaserAgencyId);
                    pojo.setType(ParticipantPermissionEnum.PERSON_LIABLE.getCode());
                    pojo.setAgencyName(result.getData().getCompanyName());
                    pojo.setUserPhone(result.getData().getCellphone());
                    pojo.setUserName(result.getData().getName());
                    pojo.setUserId(result.getData().getAgencyId());
                    handleParticipantBasicInfoList.add(pojo);
                }
            }
            return purchaseProjectClient.handlePurchaseProjectBasicInfo(handlePurchaseProjectBasicInfoSub);
        }


    }

    @ApiOperation(value = "获取采购项目步骤")
    @GetMapping(value = "getFlowByProcurementProjectId")
    public Result<FlowVO> getFlowByProcurementProjectId(@RequestParam("procurementProjectId") Long procurementProjectId){
        return purchaseProjectClient.getFlowByProcurementProjectId(procurementProjectId);
    }

    /**
     * 添加采购项目参与者
     *
     * @param type                           角色类型
     * @param userId                         参与者ID
     * @param handleParticipantBasicInfoList
     */
    private void addUserRole(String type, Long userId, List<HandleParticipantBasicInfo> handleParticipantBasicInfoList) {
        QueryDto dto = new QueryDto();
        dto.setId(userId);
        Result<PurchaserEmplyeeVo> purchaserEmployeeVoResult = purchaserClient.queryEmployeeDto(dto);
        PurchaserEmplyeeVo employeeVo = purchaserEmployeeVoResult.getData();
        HandleParticipantBasicInfo pojo = new HandleParticipantBasicInfo();
        pojo.setUserId(Long.parseLong(employeeVo.getUserId()));
        pojo.setUserName(employeeVo.getUserName());
        pojo.setUserPhone(employeeVo.getCellphone());
        pojo.setUserAgencyId(Long.parseLong(employeeVo.getCompanyId()));
        pojo.setAgencyName(employeeVo.getCompanyName());
        pojo.setType(type);
        handleParticipantBasicInfoList.add(pojo);
    }

    @ApiOperation(value = "查询采购项目详情")
    @GetMapping(value = "getPurchaseProjectBasicInfo")
    public Result<PurchaseProjectBasicInfoVO> getPurchaseProjectBasicInfo(@RequestParam Long purchaseProjectId) {
        return purchaseProjectClient.getPurchaseProjectBasicInfo(purchaseProjectId);
    }

    @ApiOperation(value = "查询采购项目列表")
    @PostMapping(value = "getPurchaseProjectList")
    public Result<Map<String, Object>> getPurchaseProjectList(@RequestBody ClientQueryPurchaseBasicInfoVO clientQueryPurchaseBasicInfoVO) {
        QueryPurchaseBasicInfoVO pojo = new QueryPurchaseBasicInfoVO();
        BeanUtils.copyProperties(clientQueryPurchaseBasicInfoVO, pojo);
        return purchaseProjectClient.getPurchaseProjectList(pojo);
    }

    @ApiOperation(value = "查询官网采购项目列表")
    @PostMapping(value = "getPurchaseProjectListOfficialNetwork")
    public Result<List<PurchaseProjectBasicInfoVO>> getPurchaseProjectListOfficialNetwork(@ApiParam("劳务分包labor_subcontract 专业分包professional_subcontracting 设备租赁 货物采购 服务采购 工程采购")
                                                                                              @RequestBody String type) {
        QueryPurchaseBasicInfoVO pojo = new QueryPurchaseBasicInfoVO();
        //采购分类 劳务分包labor_subcontract 专业分包professional_subcontracting 设备租赁 货物采购 服务采购 工程采购
        pojo.setPurchaseCategory(type);
        return purchaseProjectClient.getPurchaseProjectListOfficialNetwork(pojo);
    }

}
