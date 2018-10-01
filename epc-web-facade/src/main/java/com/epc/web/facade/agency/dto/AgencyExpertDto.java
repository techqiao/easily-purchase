package com.epc.web.facade.agency.dto;

import com.epc.web.facade.agency.handle.Attachement;
import io.swagger.models.auth.In;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class AgencyExpertDto implements Serializable {
    private static final long serialVersionUID = 5164901785641108018L;
    /**
     * 专家姓名
     */
    private String expertName;
    /**
     * 庄家专业
     */
    private String profession;
    /**
     * 庄家职称
     */
    private String  positional;

    /**
     * 专家水平
     */
    private String level;
    /**
     * 代理机构id
     */
    private Long agencyId;

    /**
     * 手机
     */
    private String cellphone;
    /**
     * 从业年限
     */
    private Integer workingYears;

    /**
     * 通知时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date circularDt;
    /**
     * 通知方式
     */
    private String circularMethod;
    /**
     * 其他信息
     */
    private String otherInformation;
    /**
     * 邀请人类型
     */
    private Integer inviterType;
    /**
     * 邀请人Id
     */
    private Long inviterId;
    /**
     * inviter_company_id
     * 邀请人机构ID
     */
    private Long inviterCompanyId;
    /**
     * 审核状态
     */
    private Integer state;
    /**
     * 专家附件
     */
    private List<Attachement> atts;
}
