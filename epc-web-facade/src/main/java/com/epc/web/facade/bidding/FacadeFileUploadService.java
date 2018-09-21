package com.epc.web.facade.bidding;

import com.epc.common.Result;
import com.epc.web.facade.bidding.handle.HandlePretriaFile;
import com.epc.web.facade.bidding.vo.PretrialMessageVO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface FacadeFileUploadService {

    /**
     * 修改预审信息
     * @param handlePretriaFile
     * @return
     */
    @PostMapping(value = "updatePretrialFile", consumes = "application/json; charset=UTF-8")
    Result<Boolean> updatePretrialFile(@RequestBody HandlePretriaFile handlePretriaFile);

    /**
     * 新增预审信息
     * @param handlePretriaFile
     * @return
     */
    @PostMapping(value = "insertPretrialFile", consumes = "application/json; charset=UTF-8")
    Result<Boolean> insertPretrialFile(@RequestBody HandlePretriaFile handlePretriaFile);

    /**
     * 查看预审信息
     * @param handlePretriaFile
     * @return
     */
    @PostMapping(value = "getTPretrialMessage", consumes = "application/json; charset=UTF-8")
    Result<PretrialMessageVO> getTPretrialMessage(@RequestBody HandlePretriaFile handlePretriaFile);
}
