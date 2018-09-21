package com.epc.web.client.remoteApi.bidding.file;

import com.epc.common.Result;
import com.epc.web.facade.bidding.FacadeFileUploadService;
import com.epc.web.facade.bidding.handle.HandlePretriaFile;
import com.epc.web.facade.bidding.vo.PretrialMessageVO;

public class FileHystrix implements FacadeFileUploadService {

    @Override
    public Result<Boolean> updatePretrialFile(HandlePretriaFile handlePretriaFile) {
        return Result.hystrixError();
    }

    @Override
    public Result<Boolean> insertPretrialFile(HandlePretriaFile handlePretriaFile) {
        return Result.hystrixError();
    }

    @Override
    public Result<PretrialMessageVO> getTPretrialMessage(HandlePretriaFile handlePretriaFile) {
        return Result.hystrixError();
    }
}
