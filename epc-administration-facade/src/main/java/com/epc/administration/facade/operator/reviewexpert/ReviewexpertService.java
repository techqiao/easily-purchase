package com.epc.administration.facade.operator.reviewexpert;

import com.epc.administration.facade.operator.handle.QueryDetailIfo;
import com.epc.administration.facade.operator.handle.RoleDetailIfo;
import com.epc.administration.facade.operator.handle.UserBasicInfo;
import com.epc.common.Result;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


/**
 * <p>Description : 评审专家接口
 */
public interface ReviewexpertService {
    /**
     * 评审专家注册
     * @param userBasicInfo 基本信息
     * @return
     */
    @PostMapping(value = "insertReviewexpertBasicInfo", consumes = "application/json; charset=UTF-8")
    Result<Boolean> insertReviewexpertBasicInfo(@RequestBody UserBasicInfo userBasicInfo);

    /**
     * 评审专家完善资料
     * @param roleDetailIfo 附件信息
     * @return
     */
    @PostMapping(value = "insertReviewexpertDetailInfo", consumes = "application/json; charset=UTF-8")
    Result<Boolean> insertReviewexpertDetailInfo(@RequestBody RoleDetailIfo roleDetailIfo);


    /**
     * 删除评审专家资料
     * @param
     * @return
     */
    @PostMapping(value = "deleteReviewexpertDetailInfo" , consumes = "application/json; charset=UTF-8")
    Result<Boolean> deleteReviewexpertDetailInfo(@RequestBody QueryDetailIfo queryDetailIfo);

    /**
     * 根据id查询评审专家详情
     * @param
     * @return
     */
    @PostMapping(value = "queryReviewexpertDetailInfo" , consumes = "application/json; charset=UTF-8")
    Result queryReviewexpertDetailInfo(@RequestBody QueryDetailIfo queryDetailIfo);

    /**
     * 根据模糊name查询评审专家详情
     * @param
     * @return
     */
    @PostMapping(value = "selectReviewexpertDetailInfo" , consumes = "application/json; charset=UTF-8")
    Result selectReviewexpertDetailInfo(@RequestBody QueryDetailIfo queryDetailIfo);




}
