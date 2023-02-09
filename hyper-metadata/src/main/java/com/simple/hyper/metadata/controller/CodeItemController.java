package com.simple.hyper.metadata.controller;

import com.simple.hyper.common.base.Response;
import com.simple.hyper.metadata.model.query.CodeItemQuery;
import com.simple.hyper.metadata.service.ICodeItemService;
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
@RequestMapping("/api/metadata/codeItem")
public class CodeItemController {

    @Resource
    private ICodeItemService codeItemService;

    @GetMapping("page")
    public Response pageCodeItem(CodeItemQuery codeItemQuery) {
        return Response.ok(codeItemService.pageCodeItem(codeItemQuery));
    }

    @GetMapping
    public Response getCodeItem(@NotNull Integer id) {
        return Response.ok(codeItemService.getCodeItemById(id));
    }

    @PostMapping
    public Response addOrUpdateCodeItem(@Validated @RequestBody CodeItemQuery codeItemQuery) {
        codeItemService.addOrUpdateCodeItem(codeItemQuery);
        return Response.ok();
    }

    @PostMapping("delete")
    public Response deleteCodeItem(@NotNull @RequestBody CodeItemQuery codeItemQuery) {
        codeItemService.deleteCodeItem(codeItemQuery.getIds());
        return Response.ok();
    }
}
