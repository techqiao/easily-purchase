package com.epc.bidding.controller.bidding;


import com.epc.bidding.service.bidding.BiddingService;
import com.epc.common.Result;
import com.epc.web.facade.bidding.FacadeFileUploadService;
import com.epc.web.facade.bidding.handle.HandleFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 文件上传
 * @author linzhixiang
 */
@RestController
public class BiddingFileUploadController implements FacadeFileUploadService {

    @Autowired
    BiddingService biddingService;

    @Override
    public Result<Boolean> updatePretrialFile(@RequestBody HandleFileUpload handleFileUpload) {
        return biddingService.updatePretrialFile(handleFileUpload);
    }
}
