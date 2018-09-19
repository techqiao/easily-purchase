package com.epc.tendering.service.service.project.impl;

import com.epc.common.Result;
import com.epc.common.constants.Const;
import com.epc.common.constants.ErrorMessagesEnum;
import com.epc.common.exception.BusinessException;
import com.epc.tendering.service.domain.project.TProjectBasicInfo;
import com.epc.tendering.service.domain.project.TProjectBasicInfoCriteria;
import com.epc.tendering.service.mapper.project.TProjectBasicInfoMapper;
import com.epc.tendering.service.service.project.TProjectBasicInfoService;
import com.epc.web.facade.terdering.project.handle.HandleProjectBasicInfo;
import com.epc.web.facade.terdering.project.query.QueryProjectInfoDTO;
import com.epc.web.facade.terdering.project.vo.ProjectBasicInfoVO;
import com.epc.web.facade.terdering.project.vo.ProjectDetailInfoVO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <p>Description : 项目实现类
 * <p>Date : 2018-09-18 13:48
 * <p>@Author : wjq
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class TProjectBasicInfoServiceImpl implements TProjectBasicInfoService {
    @Autowired
    private TProjectBasicInfoMapper tProjectBasicInfoMapper;

    @Override
    public Result<Boolean> handleProjectBasicInfo(HandleProjectBasicInfo handleProjectBasicInfo) {
        TProjectBasicInfo pojo = new TProjectBasicInfo();
        BeanUtils.copyProperties(handleProjectBasicInfo, pojo);
        pojo.setIsDeleted(Const.IS_DELETED.NOT_DELETED);
        pojo.setCreateAt(new Date());
        try {
            if(pojo.getId() == null){
                return Result.success(tProjectBasicInfoMapper.insertSelective(pojo) > 0);
            }else {
                return Result.success(tProjectBasicInfoMapper.updateByPrimaryKeySelective(pojo) > 0);
            }
        }catch (BusinessException e){
            return Result.error(ErrorMessagesEnum.FAILURE);
        }catch (Exception e){
            return Result.error(e.getMessage());
        }
    }

    @Override
    public Result<ProjectDetailInfoVO> getProjectDetailInfo(Long projectId) {
        TProjectBasicInfo tProjectBasicInfo = tProjectBasicInfoMapper.selectByPrimaryKey(projectId);
        ProjectDetailInfoVO projectDetailInfoVO = new ProjectDetailInfoVO();
        if (tProjectBasicInfo==null){
            return Result.success(null);
        }
        BeanUtils.copyProperties(tProjectBasicInfo, projectDetailInfoVO);
        return Result.success(projectDetailInfoVO);
    }

    @Override
    public Result<List<ProjectBasicInfoVO>> getProjectList(QueryProjectInfoDTO queryProjectInfoDTO) {
        final TProjectBasicInfoCriteria criteria = new TProjectBasicInfoCriteria();
        final TProjectBasicInfoCriteria.Criteria subCriteria = criteria.createCriteria();
        //项目编码
        if(StringUtils.isNotBlank(queryProjectInfoDTO.getProjectCode())) {
            subCriteria.andProjectCodeEqualTo(queryProjectInfoDTO.getProjectCode());
        }
        //项目名称
        if(StringUtils.isNotBlank(queryProjectInfoDTO.getProjectName())) {
            subCriteria.andProjectNameEqualTo(queryProjectInfoDTO.getProjectName());
        }
        criteria.setOrderByClause("id desc");
        List<TProjectBasicInfo> tProjectBasicInfoList = tProjectBasicInfoMapper.selectByExampleWithRowbounds(criteria, queryProjectInfoDTO.getRowBounds());
        List<ProjectBasicInfoVO> returnList = new ArrayList<>();
        tProjectBasicInfoList.forEach(item -> {
            ProjectBasicInfoVO projectBasicInfoVO = new ProjectBasicInfoVO();
            BeanUtils.copyProperties(item, projectBasicInfoVO);
            returnList.add(projectBasicInfoVO);
        });
        return Result.success(returnList);
    }
}
