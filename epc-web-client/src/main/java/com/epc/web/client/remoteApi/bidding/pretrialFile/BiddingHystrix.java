package com.epc.web.client.remoteApi.bidding.pretrialFile;

import com.epc.common.Result;
import com.epc.web.facade.bidding.FacadeFileUploadService;
import com.epc.web.facade.bidding.handle.HandleNotice;
import com.epc.web.facade.bidding.handle.HandlePretriaFile;
import com.epc.web.facade.bidding.vo.BSaleDocumentsFileVO;
import com.epc.web.facade.bidding.vo.BSaleDocumentsVO;
import com.epc.web.facade.bidding.vo.PretrialMessageVO;
import com.epc.web.facade.bidding.vo.TenderDocumentsPlaceSaleVO;

public  class BiddingHystrix implements FacadeFileUploadService {


    @Override
    public Result<Boolean> updatePretrialFile(HandlePretriaFile handlePretriaFile) {
        return Result.hystrixError();    }

    @Override
    public Result<PretrialMessageVO> getTPretrialMessage(HandlePretriaFile handlePretriaFile) {
        return Result.hystrixError();    }

    @Override
    public Result<Boolean> updateNotice(HandleNotice handleNotice) {
        return Result.hystrixError();
    }

}
