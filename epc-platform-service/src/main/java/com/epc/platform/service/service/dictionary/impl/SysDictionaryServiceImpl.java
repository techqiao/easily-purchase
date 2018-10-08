package com.epc.platform.service.service.dictionary.impl;

import com.epc.common.Result;
import com.epc.common.ResultCode;
import com.epc.platform.service.domain.dictionary.SysDictionary;
import com.epc.platform.service.mapper.dictionary.SysDictionaryMapper;
import com.epc.platform.service.service.dictionary.SysDictionaryService;
import com.epc.web.facade.dictionay.vo.SysDictionaryVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SysDictionaryServiceImpl implements SysDictionaryService {
    @Autowired
    SysDictionaryMapper sysDictionaryMapper;

    @Override
    public Result<List<SysDictionaryVO>> listSysDictionaryByPath(String path) {

        List<SysDictionary> sysDictionaryList = sysDictionaryMapper.listSysDictionaryByPath(path);
        List<SysDictionaryVO> dictionaryVOList = new ArrayList<>();

        for(SysDictionary entity:sysDictionaryList){
            SysDictionaryVO vo=new SysDictionaryVO();
            BeanUtils.copyProperties(entity,vo);
            dictionaryVOList.add(vo);
        }
        Result<List<SysDictionaryVO>> result =Result.success("查询成功",dictionaryVOList);
        return result;
    }

    @Override
    public Result<SysDictionaryVO> insertSysDictionary(SysDictionaryVO sysDictionaryVO) {

        SysDictionary dictionaryDO = new SysDictionary();
        BeanUtils.copyProperties(sysDictionaryVO,dictionaryDO);
        sysDictionaryMapper.insert(dictionaryDO);
        Result<SysDictionaryVO> result = null;
        if(dictionaryDO.getDictId() != 0L){
            BeanUtils.copyProperties(dictionaryDO,sysDictionaryVO);
            result = Result.success("字典添加成功",sysDictionaryVO);
        }else{
            result = Result.error(ResultCode.SERVICE_EXCEPTION.getCode(),"添加字典失败");
        }
        return result;
    }
}
