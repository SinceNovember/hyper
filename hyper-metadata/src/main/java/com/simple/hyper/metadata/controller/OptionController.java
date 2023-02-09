package com.simple.hyper.metadata.controller;

import com.simple.hyper.common.base.Response;
import com.simple.hyper.common.consts.CodeItemConsts;
import com.simple.hyper.metadata.service.ICodeMainService;
import javax.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * .
 *
 * @author SinceNovember
 * @date 2023/2/6
 */
@Slf4j
@RestController
@RequestMapping("/api/metadata/option")
public class OptionController {

    @Resource
    private ICodeMainService codeMainService;

    @GetMapping("sex")
    public Response getSexOption() {
        return Response.ok(codeMainService.listOptionModelByCodeName(CodeItemConsts.SEX_CODE_ITEM_NAME));
    }

    @GetMapping("status")
    public Response getStatusOption() {
        return Response.ok(codeMainService.listOptionModelByCodeName(CodeItemConsts.STATUS_CODE_ITEM_NAME));
    }


}
