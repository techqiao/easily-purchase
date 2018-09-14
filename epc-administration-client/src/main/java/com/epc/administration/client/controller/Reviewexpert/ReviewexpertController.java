package com.epc.administration.client.controller.Reviewexpert;


import com.epc.administration.client.remoteapi.reviewexpert.ReviewexpertClient;
import com.epc.administration.facade.operator.handle.RoleDetailIfo;
import com.epc.common.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "评审专家",tags = {"评审专家"})
@RestController
@RequestMapping(value = "/reviewexpert", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class ReviewexpertController {

    @Autowired
    private ReviewexpertClient supplierClient;

    @ApiOperation(value = "添加评审专家",notes = "添加评审专家")
    @PostMapping(value = "createReviewexpert", consumes = "application/json;charset=UTF-8")
    public Result<Boolean> createReviewexpert(@RequestBody RoleDetailIfo roleDetailIfo){
        return supplierClient.insertReviewexpertDetailInfo(roleDetailIfo);
    }
}
