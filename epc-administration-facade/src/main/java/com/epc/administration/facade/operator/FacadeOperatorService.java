package com.epc.administration.facade.operator;

import com.epc.administration.facade.operator.dto.QueryDetailIfo;
import com.epc.administration.facade.operator.handle.ExamineOperatorHandle;
import com.epc.administration.facade.operator.handle.OperatorForbiddenHandle;
import com.epc.administration.facade.operator.handle.RoleDetailInfo;
import com.epc.administration.facade.operator.handle.UserBasicInfo;
import com.epc.administration.facade.operator.vo.OperatorUserVO;
import com.epc.administration.facade.operator.vo.OperatorVO;
import com.epc.common.Result;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


/**
 * <p>Description : 运营商接口
 * <p>Date : 2018-09-10  18:08
 * <p>@author : wjq
 */
public interface FacadeOperatorService {
    /**
     * 运营商注册
     * @param userBasicInfo 基本信息
     * @return
     */
    @PostMapping(value = "insertOperatorBasicInfo", consumes = "application/json; charset=UTF-8")
    Result<Boolean> insertOperatorBasicInfo(@RequestBody UserBasicInfo userBasicInfo);

    /**
     * 运营商完善资料
     * @param roleDetailInfo 所有信息
     * @return
     */
    @PostMapping(value = "insertOperatorDetailInfo", consumes = "application/json; charset=UTF-8")
    Result<Boolean> insertOperatorDetailInfo(@RequestBody RoleDetailInfo roleDetailInfo);

    /**
     * 运营商修改资料
     * @param roleDetailInfo 所有信息
     * @return
     */
    @PostMapping(value = "updateOperatorDetailInfo", consumes = "application/json; charset=UTF-8")
    Result<Boolean> updateOperatorDetailInfo(@RequestBody RoleDetailInfo roleDetailInfo);

    /**
     * 删除运营商资料
     * @param whereId
     * @return
     */
    @GetMapping(value = "deleteOperatorDetailInfo" )
    Result<Boolean> deleteOperatorDetailInfo(@RequestParam("whereId") Long whereId);

    /**
     * 根据id查询运营商详情
     * @param whereId
     * @return
     */
    @GetMapping(value = "queryOperatorDetailInfo")
    Result<OperatorUserVO> queryOperatorDetailInfo(@RequestParam("whereId") Long whereId);

    /**
     * 查询所有运营商 分页展示
     * @param queryDetailIfo
     * @return
     */
    @PostMapping(value = "selectAllOperatorByPage" ,consumes = "application/json; charset=UTF-8")
    Result<Map<String, Object>>  selectAllOperatorByPage(@RequestBody QueryDetailIfo queryDetailIfo);

    /**
     * 审核运营商
     * @param examineOperatorHandle
     * @return
     */
    @PostMapping(value = "examineOperator" ,consumes = "application/json; charset=UTF-8")
    Result<Boolean> examineOperator(@RequestBody ExamineOperatorHandle examineOperatorHandle);

    /**
     * 锁定启动运营商
     * @param operatorForbiddenHandle
     * @return
     */
    @PostMapping(value = "forbiddenOperatorUser" ,consumes = "application/json; charset=UTF-8")
    Result<Boolean> forbiddenOperatorUser(@RequestBody OperatorForbiddenHandle operatorForbiddenHandle);
}
