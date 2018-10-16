package com.epc.bidding.controller.file;

import com.epc.bidding.service.file.FileService;
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
    FileService fileService;

    /**
     * 投标信息 更新
     * @param handleNotice
     * @return
     */
    @Override
    public Result<Boolean> updateNotice(@RequestBody HandleNotice handleNotice){
        return fileService.insertNotice(handleNotice);
    }

        /**
         * 预审信息 更新
         * @param handlePretriaFile
         * @return
         */
    @Override
    public Result<Boolean> updatePretrialFile(@RequestBody HandlePretriaFile handlePretriaFile) {
        return fileService.updatePretrialFile(handlePretriaFile);
    }


    /**
     * 获取预审信息
     * @param handlePretriaFile
     * @return
     */
    @Override
    public Result<PretrialMessageVO> getTPretrialMessage(@RequestBody HandlePretriaFile handlePretriaFile) {
        return fileService.getTPretrialMessage(handlePretriaFile);
    }

}
