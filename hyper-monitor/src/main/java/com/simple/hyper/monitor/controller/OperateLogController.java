package com.simple.hyper.monitor.controller;

import com.simple.hyper.common.base.Response;
import com.simple.hyper.monitor.model.query.OperateLogQuery;
import com.simple.hyper.monitor.service.IOperateLogService;
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
 * @date 2023/2/6
 */
@Slf4j
@RestController
@RequestMapping("/api/monitor/operateLog")
public class OperateLogController {

    @Resource
    private IOperateLogService operateLogService;

    @GetMapping("page")
    public Response pageOperateLog(OperateLogQuery operateLogQuery) {
        return Response.ok(operateLogService.pageOperateLog(operateLogQuery));
    }

    @GetMapping
    public Response getOperateLog(@NotNull Integer id) {
        return Response.ok(operateLogService.getOperateLogById(id));
    }

    @PostMapping
    public Response addOrUpdateOperateLog(@Validated @RequestBody OperateLogQuery operateLogQuery) {
        operateLogService.addOperateLog(operateLogQuery);
        return Response.ok();
    }

    @PostMapping("delete")
    public Response deleteOperateLog(@NotNull @RequestBody OperateLogQuery operateLogQuery) {
        operateLogService.deleteOperateLog(operateLogQuery.getIds());
        return Response.ok();
    }
}
