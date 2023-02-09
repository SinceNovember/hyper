package com.simple.hyper.metadata.controller;

import com.simple.hyper.common.base.Response;
import com.simple.hyper.metadata.model.query.CodeMainQuery;
import com.simple.hyper.metadata.service.ICodeMainService;
import javax.annotation.Resource;
import javax.validation.constraints.NotNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * .
 *
 * @author SinceNovember
 * @date 2023/2/3
 */
@Slf4j
@RestController
@RequestMapping("/api/metadata/codeMain")
public class CodeMainController {

    @Resource
    private ICodeMainService codeMainService;

    @GetMapping("page")
    public Response pageCodeMain(CodeMainQuery codeMainQuery) {
        return Response.ok(codeMainService.pageCodeMain(codeMainQuery));
    }

    @GetMapping
    public Response getCodeMain(@NotNull Integer id) {
        return Response.ok(codeMainService.getCodeMainById(id));
    }

    @PostMapping
    public Response addOrUpdateCodeMain(@Validated @RequestBody CodeMainQuery codeMainQuery) {
        codeMainService.addOrUpdateCodeMain(codeMainQuery);
        return Response.ok();
    }

    @PostMapping("delete")
    public Response deleteCodeMain(@NotNull @RequestBody CodeMainQuery codeMainQuery) {
        codeMainService.deleteCodeMain(codeMainQuery.getIds());
        return Response.ok();
    }
}
