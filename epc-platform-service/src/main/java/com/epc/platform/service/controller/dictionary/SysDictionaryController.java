package com.epc.platform.service.controller.dictionary;

import com.epc.common.Result;
import com.epc.platform.service.controller.admin.BaseController;
import com.epc.platform.service.service.dictionary.SysDictionaryService;
import com.epc.web.facade.dictionay.FacadeSysDictionaryService;
import com.epc.web.facade.dictionay.vo.SysDictionaryVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class SysDictionaryController implements FacadeSysDictionaryService {
    @Autowired
    SysDictionaryService sysDictionaryService;

    @Override
    public Result<List<SysDictionaryVO>> listSysDictionaryByPath(String path) {
        return sysDictionaryService.listSysDictionaryByPath(path);
    }

    @Override
    public Result<SysDictionaryVO> insertSysDictionary(@RequestBody SysDictionaryVO sysDictionaryVO) {
        return sysDictionaryService.insertSysDictionary(sysDictionaryVO) ;
    }
}
