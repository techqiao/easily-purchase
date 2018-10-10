package com.epc.web.facade.enrolmentinvitation.query;

import com.epc.web.facade.enrolmentinvitation.vo.BSignUpVO;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class PayForGuarantyDTO implements Serializable {
    private List<BSignUpVO> list;
    private String projectName;
    private Integer projectStatus;
    private String payStatus;
}
