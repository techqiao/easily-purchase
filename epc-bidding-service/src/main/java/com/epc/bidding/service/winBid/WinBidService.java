package com.epc.bidding.service.winBid;

import com.epc.common.Result;
import com.epc.web.facade.bidding.handle.HandleWinBid;
import com.epc.web.facade.bidding.handle.HandleWinBidFilePath;
import com.epc.web.facade.bidding.query.winBid.QueryWinBidLetterDTO;
import com.epc.web.facade.bidding.vo.TWinBidNominateVO;
import com.epc.web.facade.bidding.vo.WinBidLetterVO;

import java.util.List;

public interface WinBidService {
    /**
     * 获取中标通知书列表
     * @param dto
     * @return
     */
    Result<List<WinBidLetterVO>> getWinBidLetter(QueryWinBidLetterDTO dto);

    /**
     * 查詢中標公告列表
     * @param purchaseProjectId
     * @return
     */
     Result<List<TWinBidNominateVO>> getTWinBidNominate(Long purchaseProjectId);

    /**
     * 插入中標公告
     * @param handleWinBid
     * @return
     */
     Result<Boolean> insertTWinBidNominate(HandleWinBid handleWinBid) ;


    /**
     * 上传中标公告文件
     * @param handleWinBidFilePath
     * @return
     */
    Result<Boolean> insertTWinBidNominateFilePath(HandleWinBidFilePath handleWinBidFilePath);


    }
