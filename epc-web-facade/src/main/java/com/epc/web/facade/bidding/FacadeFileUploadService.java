package com.epc.web.facade.bidding;

import com.epc.common.Result;
import com.epc.web.facade.bidding.handle.HandleFileUpload;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface FacadeFileUploadService {


    @PostMapping(value = "updatePretrialFile", consumes = "application/json; charset=UTF-8")
    Result<Boolean> updatePretrialFile(@RequestBody HandleFileUpload handleFileUpload);

}
