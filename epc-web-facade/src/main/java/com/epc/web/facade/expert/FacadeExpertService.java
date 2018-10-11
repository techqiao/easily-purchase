package com.epc.web.facade.expert;

import com.epc.common.Result;
import com.epc.web.facade.agency.handle.HandleExpert;
import com.epc.web.facade.expert.dto.IdleExpertDto;
import com.epc.web.facade.expert.dto.ProjectDto;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author :winlin
 * @Description :角色登录接口
 * @param:
 * @return:
 * @date:2018/9/18
 */
public interface FacadeExpertService {
    /**
     * @author :winlin
     * @Description : 评标专家自己上平台注册,注册完成后,跳入完善信息页面
     * @return: 返回注册信息
     * @date:
     */
    @PostMapping(value = "completeExpertInfo", consumes = "application/json; charset=UTF-8")
    public Result<Boolean> completeExpertInfo(HandleExpert expert);

    /**
     * @author :winlin
     * @Description : 专家修改自己的信息,状态为审核通过事后不能修改
     * @date:2018/9/30
     */
    @PostMapping(value = "updateExpertSelfInfo", consumes = "application/json; charset=UTF-8")
    public Result<Boolean> updateExpertSelfInfo(HandleExpert expert);

    /**
     * @author :winlin
     * @Description :是否有空闲
     * @date:2018/9/30
     */
    @PostMapping(value = "hasIntentionOrNot", consumes = "application/json; charset=UTF-8")
    public Result<Boolean> hasIntentionOrNot(IdleExpertDto dto);

    /**
     * @author :winlin
     * @Description : 查看专家名下所有的标段信息
     * @date:2018/9/30
     */
    @PostMapping(value = "selectAllBid", consumes = "application/json; charset=UTF-8")
    public Result selectAllBid(ProjectDto projecctDto);

}
