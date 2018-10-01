package com.epc.web.service.service.Expert;

import com.epc.common.Result;
import com.epc.web.facade.agency.handle.HandleExpert;

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
    public Result<HandleExpert> registery(HandleExpert expert );
    /**
     *@author :winlin
     *@Description : 专家完善自己的信息
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
     *@Description : 查看项目详情
     *@param:
     *@return: 返回项目的详细信息
     *@date:2018/9/30
     */
    public Result  lookUpDetailOfSubject();
    /**
     *@author :winlin
     *@Description :是否有意向参与评标
     *@date:2018/9/30
     */
    public Result<Boolean> hasIntentionOrNot();
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
    /**
     *@author :winlin
     *@Description :
     *@date:2018/9/30
     */
    public Result toSeeTheResponseForEvaluateSubject();
    /**
     *@author :winlin
     *@Description :
     *@return:
     */
    public Result answerQuestionForSubject();
    /**
     *@author :winlin
     *@Description :
     *@date:2018/9/30
     */
    public Result analysisFinishedSubject();


}
