package com.epc.platform.service.service.operator;

import com.epc.administration.facade.operator.dto.QueryDetailIfo;
import com.epc.administration.facade.operator.handle.ExamineOperatorHandle;
import com.epc.administration.facade.operator.handle.OperatorForbiddenHandle;
import com.epc.administration.facade.operator.handle.RoleDetailInfo;
import com.epc.administration.facade.operator.handle.UserBasicInfo;
import com.epc.administration.facade.operator.vo.OperatorUserVO;
import com.epc.administration.facade.operator.vo.OperatorVO;
import com.epc.common.Result;

import java.util.List;

/**
 * <p>Description : 运营商相关接口
 * <p>Date : 2018-09-10  19:46
 * <p>@author : wjq
 */
public interface OperatorService {
    /**
     * 预添加运营商
     * @param userBasicInfo
     * @return
     */
    Result<Boolean> insertOperatorBasicInfo(UserBasicInfo userBasicInfo);

    /**
     * 运营商完善资料
     * @param roleDetailInfo
     * @return
     */
    Result<Boolean> insertOperatorDetailInfo(RoleDetailInfo roleDetailInfo);

    /**
     * 运营商修改资料
     * @param roleDetailInfo
     * @return
     */
    Result<Boolean> updateOperatorDetailInfo(RoleDetailInfo roleDetailInfo);

    /**
     * 删除运营商资料
     * @param whereId
     * @return
     */
    Result<Boolean> deleteOperatorDetailInfo( Long whereId);

    /**根据传入运营商ID查询
     * 查询运营商资料
     * @param whereId
     * @return
     */
    Result<OperatorUserVO> queryOperatorDetailInfo(Long whereId);

    /**
     * 分页查询
     * @param queryDetailIfo
     * @return
     */
    List<OperatorVO> selectAllOperatorByPage(QueryDetailIfo queryDetailIfo);

    /**
     * 审核运营商
     * @param examineOperatorHandle
     * @return
     */
    Result<Boolean> examineOperator(ExamineOperatorHandle examineOperatorHandle);

    /**
     * 启用锁定运营商
     * @param operatorForbiddenHandle
     * @return
     */
    Result<Boolean> forbiddenOperatorUser(OperatorForbiddenHandle operatorForbiddenHandle);
}
