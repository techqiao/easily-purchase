package com.epc.web.facade.dictionay;

import com.epc.common.Result;
import com.epc.web.facade.dictionay.vo.SysDictionaryVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface FacadeSysDictionaryService {
    @GetMapping(value = "listSysDictionaryByPath")
    Result<List<SysDictionaryVO>> listSysDictionaryByPath(@RequestParam(value = "path") String path);

    @PostMapping(value = "insertSysDictionary")
    Result <SysDictionaryVO> insertSysDictionary(@RequestBody SysDictionaryVO sysDictionaryVO);
}
