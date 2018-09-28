package com.epc.platform.service.controller.operator;

import com.epc.administration.facade.operator.FacadeOperatorService;
import com.epc.administration.facade.operator.dto.QueryDetailIfo;
import com.epc.administration.facade.operator.handle.ExamineOperatorHandle;
import com.epc.administration.facade.operator.handle.RoleDetailInfo;
import com.epc.administration.facade.operator.handle.UserBasicInfo;
import com.epc.common.QueryRequest;
import com.epc.common.Result;
import com.epc.platform.service.controller.admin.BaseController;
import com.epc.platform.service.domain.operator.TOperatorDetailInfo;
import com.epc.platform.service.service.operator.OperatorService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * <p>Description : 运营商控制器
 * <p>Date : 2018-09-10  18:08
 * <p>@author : wjq
 */
@RestController
public class OperatorServerController extends BaseController implements FacadeOperatorService {
    @Autowired
    private OperatorService operatorService;

    /**
     * 运营商注册
     * @param handleOperator
     * @return
     */
    @Override
    public Result<Boolean> insertOperatorBasicInfo(@RequestBody UserBasicInfo handleOperator) {
        return operatorService.insertOperatorBasicInfo(handleOperator);
    }

    /**
     * 运营商资料补全
     * @param roleDetailInfo 附件信息
     * @return
     */
    @Override
    public Result<Boolean> insertOperatorDetailInfo(@RequestBody RoleDetailInfo roleDetailInfo) {
        return operatorService.insertOperatorDetailInfo(roleDetailInfo);
    }


    /**
     * 运营商资料删除
     * @param queryDetailIfo
     * @return
     */
    @Override
    public Result<Boolean> deleteOperatorDetailInfo(@RequestParam("whereId") Long whereId) {
        return operatorService.deleteOperatorDetailInfo(whereId);
    }

    /**
     * 运营商资料查询
     * @param whereId
     * @return
     */
    @Override
    public Result<TOperatorDetailInfo> queryOperatorDetailInfo(@RequestParam("whereId") Long whereId) {
        return operatorService.queryOperatorDetailInfo(whereId);
    }


    /**
     * 运营商资料所有查询 分页展示
     * @param queryDetailIfo
     * @return
     */
    @Override
    public Result selectAllOperatorByPage(@RequestBody QueryDetailIfo queryDetailIfo) {
        PageHelper.startPage(queryDetailIfo.getPageNum(),queryDetailIfo.getPageSize());
        List<TOperatorDetailInfo> tOperatorDetailInfos = operatorService.selectAllOperatorByPage(queryDetailIfo);
        PageInfo<TOperatorDetailInfo> page = new PageInfo<>(tOperatorDetailInfos);
        return Result.success(getDataTable(page));
    }

    /**
     * 审核运营商
     * @param examineOperatorHandle
     * @return
     */
    @Override
    public Result<Boolean> examineOperator(@RequestBody ExamineOperatorHandle examineOperatorHandle) {
        return operatorService.examineOperator(examineOperatorHandle);
    }


}
