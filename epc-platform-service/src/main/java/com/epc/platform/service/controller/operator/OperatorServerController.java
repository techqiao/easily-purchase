package com.epc.platform.service.controller.operator;

import com.epc.administration.facade.operator.FacadeOperatorService;
import com.epc.administration.facade.operator.dto.QueryDetailIfo;
import com.epc.administration.facade.operator.handle.ExamineOperatorHandle;
import com.epc.administration.facade.operator.handle.OperatorForbiddenHandle;
import com.epc.administration.facade.operator.handle.RoleDetailInfo;
import com.epc.administration.facade.operator.handle.UserBasicInfo;
import com.epc.administration.facade.operator.vo.OperatorUserVO;
import com.epc.administration.facade.operator.vo.OperatorVO;
import com.epc.common.Result;
import com.epc.platform.service.controller.admin.BaseController;
import com.epc.platform.service.service.operator.OperatorService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;


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
     * 运营商修改资料
     * @param roleDetailInfo 所有信息
     * @return
     */
    @Override
    public Result<Boolean> updateOperatorDetailInfo(RoleDetailInfo roleDetailInfo) {
        return operatorService.updateOperatorDetailInfo(roleDetailInfo);
    }

    /**
     * 运营商资料删除
     * @param whereId
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
    public Result<OperatorUserVO> queryOperatorDetailInfo(@RequestParam("whereId") Long whereId) {
        return operatorService.queryOperatorDetailInfo(whereId);
    }


    /**
     * 运营商资料所有查询 分页展示
     * @param queryDetailIfo
     * @return
     */
    @Override
    public Result<Map<String, Object>> selectAllOperatorByPage(@RequestBody QueryDetailIfo queryDetailIfo) {
        PageHelper.startPage(queryDetailIfo.getPageNum(),queryDetailIfo.getPageSize());
        List<OperatorVO> operatorVOS = operatorService.selectAllOperatorByPage(queryDetailIfo);
        PageInfo<OperatorVO> page = new PageInfo<>(operatorVOS);
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

    /**
     * 启动锁定运营商 0启用 1锁定
     * @param operatorForbiddenHandle
     * @return
     */
    @Override
    public Result<Boolean> forbiddenOperatorUser(OperatorForbiddenHandle operatorForbiddenHandle) {
        return operatorService.forbiddenOperatorUser(operatorForbiddenHandle);
    }
}
