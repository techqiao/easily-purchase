package com.epc.bidding.service.file.impl;

import com.epc.bidding.domain.*;
import com.epc.bidding.mapper.*;
import com.epc.bidding.service.file.FileService;
import com.epc.common.Result;
import com.epc.common.constants.Const;
import com.epc.common.constants.PretrialMessageEnum;
import com.epc.web.facade.bidding.dto.FileListDTO;
import com.epc.web.facade.bidding.handle.BasePretriaFile;
import com.epc.web.facade.bidding.handle.Entrust;
import com.epc.web.facade.bidding.handle.HandleNotice;
import com.epc.web.facade.bidding.handle.HandlePretriaFile;
import com.epc.web.facade.bidding.vo.PretrialMessageVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class FileServiceImpl implements FileService {

    private static final Logger LOGGER = LoggerFactory.getLogger(FileServiceImpl.class);

    @Autowired
    TPretrialMessageMapper tPretrialMessageMapper;
    @Autowired
    TTenderMessageMapper tTenderMessageMapper;
    @Autowired
    TTenderFileMapper tTenderFileMapper;
    @Autowired
    TPretrialFileMapper tPretrialFileMapper;
    @Autowired
    BSaleDocumentsMapper bSaleDocumentsMapper;
    @Autowired
    BTenderDocumentsPlaceSaleMapper bTenderDocumentsPlaceSaleMapper;
    @Autowired
    BSaleDocumentsFileMapper bSaleDocumentsFileMapper;
    @Autowired
    LetterOfTenderMapper letterOfTenderMapper;
    @Autowired
    TPurchaseProjectBidsMapper tPurchaseProjectBidsMapper;
    /**
     * 投标文件记录(新增/修改/删除)
     * @param handleNotice
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result<Boolean> insertNotice(HandleNotice handleNotice){
        //删除
        if(handleNotice.getId()!=null && handleNotice.getIsDelete()==1){
            try{
                tTenderMessageMapper.deleteByPrimaryKey(handleNotice.getId());
            }catch (Exception e){
                LOGGER.error("insertNotice"+handleNotice.getId().toString()+e.getMessage(),e);
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                return Result.error();
            }
        }

        TTenderMessage entity=new TTenderMessage();
        BeanUtils.copyProperties(handleNotice,entity);
        entity.setCreateAt(new Date());
        entity.setUpdateAt(new Date());
        entity.setIsDeleted(Const.IS_DELETED.NOT_DELETED);

        if(handleNotice.getId()!=null){
            //委托信息
            Entrust entrust=handleNotice.getEntrust();
            //更新(不允许操作金额)
            LetterOfTender letter=letterOfTenderMapper.selectByPrimaryKey(entrust.getId());
            letter.setQualityTarget(entrust.getQualityTarget());
            letter.setDuration(entrust.getDuration());
            letter.setValidity(entrust.getValidity());
            letter.setManagerName(entrust.getManagerName());
            letter.setCertificateNumber(entrust.getCertificateNumber());
            try{
                letterOfTenderMapper.updateByPrimaryKey(letter);
            }catch (Exception e){
                LOGGER.error("insertNotice"+letter.toString()+e.getMessage(),e);
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                return Result.error();
            }

            try{
                tTenderMessageMapper.updateByPrimaryKey(entity);
            }catch (Exception e){
                LOGGER.error("insertNotice"+entity.toString()+e.getMessage(),e);
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                return Result.error();
            }
        }else if(handleNotice.getId()==null){
            //新增委托书(不允许操作金额)
            Entrust entrust=handleNotice.getEntrust();
            LetterOfTender letter=new LetterOfTender();
            BeanUtils.copyProperties(entrust,letter);
            letter.setProcurementProjectId(entity.getPurchaseProjectId());
            letter.setSupplierId(entity.getCompanyId());
            letter.setSupplierName(entity.getCompanyName());
            letter.setBidsId(entity.getBidsId());
            letter.setBidsName(handleNotice.getBidsName());
            letter.setCreateAt(new Date());
            letter.setUpdateAt(new Date());
            TPurchaseProjectBids tPurchaseProjectBids =tPurchaseProjectBidsMapper.selectByPrimaryKey(entity.getBidsId());
            entity.setPurchaseProjectId(tPurchaseProjectBids.getPurchaseProjectId());
            letter.setProcurementProjectId(tPurchaseProjectBids.getPurchaseProjectId());
            try{
                letterOfTenderMapper.insertSelective(letter);
            }catch (Exception e){
                LOGGER.error("insertNotice"+letter.toString()+e.getMessage(),e);
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                return Result.error();
            }
            //新增投标信息
            try{
                tTenderMessageMapper.insertSelective(entity);
            }catch (Exception e){
                LOGGER.error("insertNotice"+entity.toString()+e.getMessage(),e);
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                return Result.error();
            }
        }
        //查看文件是否上传
        List<BasePretriaFile> list=handleNotice.getFilePathList();
        if(list.size()==0){
            return  Result.success(true);
        }
        //新增 修改 投标文件（一条记录可以对应多个文件）
        for(BasePretriaFile file:list){
            TTenderFile tTenderFile=new TTenderFile();
            tTenderFile.setTenderMessageId(entity.getId());
            tTenderFile.setFilePath(file.getFilePath());
            tTenderFile.setFileName(file.getFileName());
            tTenderFile.setCreateAt(new Date());
            tTenderFile.setUpdateAt(new Date());
            tTenderFile.setOperateId(handleNotice.getOperateId());
            if(file.getId()!=null){
                //文件id不为空则修改记录
                try{
                    tTenderFileMapper.updateByPrimaryKey(tTenderFile);
                }catch(Exception e){
                    LOGGER.error("updateByPrimaryKey_"+e.getMessage());
                    TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                    return  Result.error();
                }
            }else  if(file.getId()==null){
                //文件id为空则新增记录
                try{
                    tTenderFileMapper.insertSelective(tTenderFile);
                }catch(Exception e){
                    LOGGER.error("insertSelective_"+e.getMessage());
                    TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                    return  Result.error();
                }
            }
        }
        return Result.success();
    }


    /**
     * 预审文件记录 新增/更新/删除
     * @param handlePretriaFile
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result<Boolean> updatePretrialFile(HandlePretriaFile handlePretriaFile) {
        TPretrialMessage attachment=new TPretrialMessage();
        BeanUtils.copyProperties(handlePretriaFile,attachment);
        attachment.setCreateAt(new Date());
        attachment.setUpdateAt(new Date());
        attachment.setIsDeleted(Const.IS_DELETED.NOT_DELETED);
        attachment.setStatus(PretrialMessageEnum.REVIEW.getCode());
        attachment.setCreator(handlePretriaFile.getOperateName());
        if(handlePretriaFile.getId()!=null && handlePretriaFile.getIsDelete()!=null && handlePretriaFile.getIsDelete()==1 ){
            try{
                //删除
                tPretrialMessageMapper.deleteByPrimaryKey(handlePretriaFile.getId());
                return  Result.success(true);
            }catch (Exception e){
                LOGGER.error("updatePretrialFile_"+attachment.toString()+e.getMessage(),e);
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                return Result.error();
            }
        }
        if(handlePretriaFile.getId()!=null){
            try{
                //更新审查信息记录
                tPretrialMessageMapper.updateByPrimaryKey(attachment);
            }catch (Exception e){
                LOGGER.error("updatePretrialFile_"+attachment.toString()+e.getMessage(),e);
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                return Result.error();
            }
        }else if(handlePretriaFile.getId()==null){
            try{
                //新增审查信息记录
                tPretrialMessageMapper.insertSelective(attachment);
            }catch (Exception e){
                LOGGER.error("updatePretrialFile_"+attachment.toString()+e.getMessage(),e);
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                return Result.error();
            }
        }
        //查看是否存在文件
        List<BasePretriaFile> list=handlePretriaFile.getFilePathList();
        if(list.size()==0){
            return  Result.success(true);
        }
        for(BasePretriaFile entity:list){
            TPretrialFile tPretrialFile=new TPretrialFile();
            tPretrialFile.setPretrialMessageId(attachment.getId());
            tPretrialFile.setFilePath(entity.getFilePath());
            tPretrialFile.setFileName(entity.getFileName());
            tPretrialFile.setCreateAt(new Date());
            tPretrialFile.setUpdateAt(new Date());
            tPretrialFile.setOperateId(handlePretriaFile.getOperateId());
            tPretrialFile.setCreator(handlePretriaFile.getOperateName());
            if(entity.getId()!=null && entity.getId()>0){
                //文件id为空则修改原记录
                try{
                    tPretrialFileMapper.updateByPrimaryKey(tPretrialFile);
                }catch(Exception e){
                    LOGGER.error("updatePretrialFile_"+tPretrialFile.toString()+e.getMessage(),e);
                    TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                }
            }else{
                //文件id为空则新增记录
                try{
                    tPretrialFileMapper.insertSelective(tPretrialFile);
                }catch(Exception e){
                    LOGGER.error("updatePretrialFile_"+tPretrialFile.toString()+e.getMessage(),e);
                    TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                }
            }
        }
        return  Result.success(true);
    }

    /**
     * 供应商 查看预审信息 + 附件列表
     * @return
     */

    @Override
    public Result<PretrialMessageVO>  getTPretrialMessage(HandlePretriaFile handlePretriaFile){
        TPretrialMessageCriteria criteria =new TPretrialMessageCriteria();
        TPretrialMessageCriteria.Criteria cubCriteria=criteria.createCriteria();
        cubCriteria.andPurchaseProjectIdEqualTo(handlePretriaFile.getPurchaseProjectId());
        cubCriteria.andReleaseAnnouncementIdEqualTo(handlePretriaFile.getReleaseAnnouncementId());
        cubCriteria.andCompanyIdEqualTo(handlePretriaFile.getCompanyId());
        //获取预审信息
        List<TPretrialMessage> list=tPretrialMessageMapper.selectByExample(criteria);
        if(list.size()==0){
            return Result.error();
        }
        PretrialMessageVO vo =new PretrialMessageVO();
        BeanUtils.copyProperties(list.get(0),vo);

        //获取预审信息 对应的文件列表
        TPretrialFileCriteria newCriteria =new TPretrialFileCriteria();
        TPretrialFileCriteria.Criteria cubNewCriteria=newCriteria.createCriteria();
        cubNewCriteria.andPretrialMessageIdEqualTo(vo.getId());
        List<TPretrialFile> newList=tPretrialFileMapper.selectByExample(newCriteria);
        FileListDTO dto=new FileListDTO();
        List<FileListDTO> dtoList=new ArrayList<>();
        for(TPretrialFile entity:newList){
            BeanUtils.copyProperties(entity,dto);
            dtoList.add(dto);
        }

        vo.setFileList(dtoList);
        return Result.success(vo);
    }


}
