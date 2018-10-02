package com.epc.web.facade.purchaser.dto;

import com.epc.web.facade.agency.handle.Attachement;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
@Data
public class HandleExpertDto implements Serializable{
    private static final long serialVersionUID = -1849933129217164590L;

    /**
     *专家姓名
     */
    private String expertName;
    /**
     * 专家Id
     *
     */
    private Long expertId;
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
     * 采购人id
     */
    private Long puchaserId;

    /**
     * 手机
     */
    private String cellphone;

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
    /**
     *密码
     */
    private String password;

    /**
     * 来源
     */
    private String source;
}
