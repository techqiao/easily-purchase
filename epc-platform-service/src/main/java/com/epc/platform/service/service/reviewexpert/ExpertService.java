package com.epc.platform.service.service.reviewexpert;

import com.epc.administration.facade.reviewexpert.dto.QueryDetailIfo;
import com.epc.administration.facade.reviewexpert.handle.ReviewExpertHandle;
import com.epc.administration.facade.reviewexpert.handle.UserBasicInfo;
import com.epc.common.Result;
import com.epc.platform.service.domain.reviewexpertr.TExpertDetailInfo;

import java.util.List;

/**
 * @author 01
 */
public interface ExpertService {
    /**
     * 预添加运营商
     * @param userBasicInfo
     * @return
     */
    Result<Boolean> insertExpertBasicInfo(UserBasicInfo userBasicInfo);

    /**
     * 运营商完善资料
     * @param reviewExpertHandle
     * @return
     */
    Result<Boolean> insertExpertDetailInfo(ReviewExpertHandle reviewExpertHandle);


    /**
     * 删除运营商资料
     * @param queryDetailIfo
     * @return
     */
    Result<Boolean> deleteExpertDetailInfo(QueryDetailIfo queryDetailIfo);

    /** 根据传入运营商ID查询
     * 查询运营商资料
     * @param queryDetailIfo
     * @return
     */
    Result<TExpertDetailInfo> queryExpertDetailInfo(QueryDetailIfo queryDetailIfo);


    /**
     * 根据传入运营商公司名称模糊查询
     * @param queryDetailIfo
     * @return
     */
    Result<List<TExpertDetailInfo>> selectExpertDetailInfo(QueryDetailIfo queryDetailIfo);


    /**
     * 查询所有
     * @return
     */
    List<TExpertDetailInfo> selectAllExpertByPage();
}
