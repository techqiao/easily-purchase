package com.epc.platform.service.service.dictionary;

import com.epc.common.Result;
import com.epc.web.facade.dictionay.vo.SysDictionaryVO;

import java.util.List;

public interface SysDictionaryService {

    Result<List<SysDictionaryVO>> listSysDictionaryByPath(String path);

    Result<SysDictionaryVO> insertSysDictionary(SysDictionaryVO sysDictionaryVO);

}
