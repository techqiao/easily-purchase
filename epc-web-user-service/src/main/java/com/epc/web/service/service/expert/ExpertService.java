package com.epc.web.service.service.expert;

import com.epc.common.Result;
import com.epc.web.facade.agency.handle.HandleExpert;
import com.epc.web.facade.expert.dto.*;

/**
 *@author :winlin
 *@Description 专家相关服务的接口
 *@CreateTime:2018/9/30
 */
public interface ExpertService {
    /**
     *@author :winlin
     *@Description : 评标专家自己上平台注册,注册完成后,跳入完善信息页面
     *@return: 返回注册信息
     *@date:
     */
    public Result<Boolean> completeExpertInfo(HandleExpert expert );
    /**
     *@author :winlin
     *@Description : 专家修改自己的信息,状态为审核通过事后不能修改
     *@date:2018/9/30
     */
    public Result<Boolean> updateExpertSelfInfo(HandleExpert expert);
    /**
     *@author :winlin
     *@Description : 是否接受项目评审邀请
     *@date:2018/9/30
     */
    public Result<Boolean> acceptRequestForSubject();
    /**
     *@author :winlin
     *@Description : 查看专家名下所有的标段信息
     *@date:2018/9/30
     */
    public Result  selectAllBid(ProjectDto projecctDto);
    /**
     *@author :winlin
     *@Description :是否有空闲
     *@date:2018/9/30
     */
    public Result<Boolean> hasIntentionOrNot(IdleExpertDto dto);
    /**
     *@author :winlin
     *@Description :查看已完成的项目
     *@date:2018/9/30
     */
    public Result queryFinishedSubject();
    /**
     *@author :winlin
     *@Description :评审项目信息给与专业的意见
     *@date:2018/9/30
     */
    public Result<Boolean> evaluateSubject();
//    /**
//     *@author :winlin
//     *@Description :查看对评价项目的回复
//     *@date:2018/9/30
//     */
//    public Result toSeeTheResponseForEvaluateSubject();
//    /**
//     *@author :winlin
//     *@Description :回复项目相关的问题
//     *@return:
//     */
//    public Result answerQuestionForSubject();
//    /**
//     *@author :winlin
//     *@Description : 分析已经完成的项目
//     *@date:2018/9/30
//     */
//    public Result analysisFinishedSubject();


}
