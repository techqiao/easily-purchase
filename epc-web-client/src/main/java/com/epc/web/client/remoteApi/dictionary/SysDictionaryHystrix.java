package com.epc.web.client.remoteApi.dictionary;

import com.epc.common.Result;
import com.epc.web.facade.dictionay.FacadeSysDictionaryService;
import com.epc.web.facade.dictionay.vo.SysDictionaryVO;

import java.util.List;

public class SysDictionaryHystrix implements FacadeSysDictionaryService {
    @Override
    public Result<List<SysDictionaryVO>> listSysDictionaryByPath(String path) {
        return Result.hystrixError();
    }

    @Override
    public Result<SysDictionaryVO> insertSysDictionary(SysDictionaryVO sysDictionaryVO) {
        return Result.hystrixError();
    }
}
