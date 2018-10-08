package com.epc.web.client.controller.dictionary;

import com.epc.common.Result;
import com.epc.web.client.remoteApi.dictionary.SysDictionaryClient;
import com.epc.web.facade.dictionay.vo.SysDictionaryVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author SongXing
 * @Description:
 * @date 2018-10-6 14:58:27
 */
@Api(value = "dictionary",tags = "字典接口2")
@RestController
@RequestMapping(value = "dictionary")
public class SysDictionaryController {
    @Autowired
    private SysDictionaryClient sysDictionaryClient;

    @ApiOperation(value = "路径查询字典列表", notes = "根据路径查询字典列表")
    @GetMapping(value = "listSysDictionaryByPath", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Result<List<SysDictionaryVO>> listSysDictionaryByPath(@RequestParam(value = "path") String path) {
        return sysDictionaryClient.listSysDictionaryByPath(path);
    }
    @ApiOperation(value = "添加字典信息", notes = "添加字典信息")
    @PostMapping(value = "insertSysDictionary", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Result<SysDictionaryVO> insertSysDictionary(@RequestBody SysDictionaryVO sysDictionaryVO) {
        return sysDictionaryClient.insertSysDictionary(sysDictionaryVO);
    }
}