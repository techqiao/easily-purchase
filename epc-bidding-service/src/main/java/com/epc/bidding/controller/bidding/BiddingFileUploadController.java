package com.epc.bidding.controller.bidding;
import com.epc.bidding.service.bidding.BiddingService;
import com.epc.common.Result;
import com.epc.web.facade.bidding.FacadeFileUploadService;
import com.epc.web.facade.bidding.handle.HandlePretriaFile;
import com.epc.web.facade.bidding.vo.PretrialMessageVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 文件功能
 * @author linzhixiang
 */
@RestController
public class BiddingFileUploadController implements FacadeFileUploadService {

    @Autowired
    BiddingService biddingService;

    /**
     * 预审信息新增+文件上传
     * @param handlePretriaFile
     * @return
     */
    @Override
    public Result<Boolean> insertPretrialFile(@RequestBody HandlePretriaFile handlePretriaFile) {
        return biddingService.insertPretrialFile(handlePretriaFile);
    }


    /**
     * 预审信息 修改
     * @param handlePretriaFile
     * @return
     */
    @Override
    public Result<Boolean> updatePretrialFile(@RequestBody HandlePretriaFile handlePretriaFile) {
        return biddingService.updatePretrialFile(handlePretriaFile);
    }

    /**
     * 获取预审信息
     * @param handlePretriaFile
     * @return
     */
    @Override
    public Result<PretrialMessageVO> getTPretrialMessage(@RequestBody HandlePretriaFile handlePretriaFile) {
        return biddingService.getTPretrialMessage(handlePretriaFile);
    }
}
