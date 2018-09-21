package com.epc.web.client.remoteApi.bidding.file;

import com.epc.common.Result;
import com.epc.web.facade.bidding.FacadeFileUploadService;
import com.epc.web.facade.bidding.handle.HandleFileUpload;

public class FileHystrix implements FacadeFileUploadService {
    @Override
    public Result<Boolean> updatePretrialFile(HandleFileUpload handleFileUpload) {
        return Result.hystrixError();
    }
}
