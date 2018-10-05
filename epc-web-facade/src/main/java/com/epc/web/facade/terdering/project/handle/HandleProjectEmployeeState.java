package com.epc.web.facade.terdering.project.handle;

import lombok.Data;

import java.io.Serializable;

@Data
public class HandleProjectEmployeeState implements Serializable {
    private static final long serialVersionUID = 5050178231309053105L;

    /**
     * 当前 登陆人的id
     */
    private Long id;

    /**
     * 当前 点击 接受 的这个项目的id
     */
    private Long projectId;

    /**
     * 当前 状态 (当前项目状态,0-未接受, 1-已接受)
     */
    private Integer state;

}
