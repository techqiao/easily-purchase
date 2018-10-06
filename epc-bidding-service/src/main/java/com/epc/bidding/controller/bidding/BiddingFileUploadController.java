package com.epc.bidding.controller.bidding;
import com.epc.bidding.service.bidding.BiddingService;
import com.epc.common.Result;
import com.epc.web.facade.bidding.FacadeFileUploadService;
import com.epc.web.facade.bidding.handle.HandleNotice;
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
     * 投标信息 更新
     * @param handleNotice
     * @return
     */
    @Override
    public Result<Boolean> updateNotice(@RequestBody HandleNotice handleNotice){
        return biddingService.insertNotice(handleNotice);
    }

        /**
         * 预审信息 更新
         * @param handlePretriaFile
         * @return
         */
    @Override
    public Result<Boolean> updatePretrialFile(@RequestBody HandlePretriaFile handlePretriaFile) {
        return biddingService.updatePretrialFile(handlePretriaFile);
    }

    @Override
    public Result<Boolean> insertPretrialFile(HandlePretriaFile handlePretriaFile) {
        return null;
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
