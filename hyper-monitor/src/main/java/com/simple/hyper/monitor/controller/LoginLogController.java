package com.simple.hyper.monitor.controller;

import com.simple.hyper.common.base.Response;
import com.simple.hyper.monitor.model.query.LoginLogQuery;
import com.simple.hyper.monitor.service.ILoginLogService;
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
@RequestMapping("/api/monitor/loginLog")
public class LoginLogController {

    @Resource
    private ILoginLogService loginLogService;

    @GetMapping("page")
    public Response pageLoginLog(LoginLogQuery loginLogQuery) {
        return Response.ok(loginLogService.pageLoginLog(loginLogQuery));
    }

    @GetMapping
    public Response getLoginLog(@NotNull Integer id) {
        return Response.ok(loginLogService.getLoginLogById(id));
    }

    @PostMapping
    public Response addOrUpdateLoginLog(@Validated @RequestBody LoginLogQuery loginLogQuery) {
        loginLogService.addLoginLog(loginLogQuery);
        return Response.ok();
    }

    @PostMapping("delete")
    public Response deleteLoginLog(@NotNull @RequestBody LoginLogQuery loginLogQuery) {
        loginLogService.deleteLoginLog(loginLogQuery.getIds());
        return Response.ok();
    }
}
