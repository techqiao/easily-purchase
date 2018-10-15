package com.epc.bidding.service.file;

import com.epc.common.Result;
import com.epc.web.facade.bidding.handle.HandleNotice;
import com.epc.web.facade.bidding.handle.HandlePretriaFile;
import com.epc.web.facade.bidding.vo.BSaleDocumentsFileVO;
import com.epc.web.facade.bidding.vo.BSaleDocumentsVO;
import com.epc.web.facade.bidding.vo.PretrialMessageVO;
import com.epc.web.facade.bidding.vo.TenderDocumentsPlaceSaleVO;

public interface FileService {

    /**
     * 投标文件记录(新增/修改/删除)
     * @param handleNotice
     * @return
     */
    Result<Boolean> insertNotice(HandleNotice handleNotice);

    /**
     * 预审信息 修改/删除
     * @param handlePretriaFile
     * @return
     */
    Result<Boolean> updatePretrialFile(HandlePretriaFile handlePretriaFile) ;

    /**
     * 获取预审信息 详情
     * @param handlePretriaFile
     * @return
     */
    Result<PretrialMessageVO> getTPretrialMessage(HandlePretriaFile handlePretriaFile);

}
