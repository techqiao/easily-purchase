package com.epc.administration.client.controller.biddingagency.handle;

import com.epc.administration.facade.supplier.vo.AttachmentVO;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author lzx
 * @date 2018-9-19 17:19:56
 */
@Data
public class ClientBaseDetailIfo  implements Serializable {
    private static final long serialVersionUID = 3460430343215518242L;
    /**
     * 主键id
     */

    private Long id;

    /**
     * 公司名称
     */
    private String companyName;

    /**
     *统一信用代码
     */
    private String uniformCreditCode;

    /**
     *对公银行名称
     */
    private String publicBankName;

    /**
     *对公银行账号
     */
    private String publicBanAccountNumber;

    /**
     * 附件集合
     */
    private List<AttachmentVO> attachmentVOS;

}
