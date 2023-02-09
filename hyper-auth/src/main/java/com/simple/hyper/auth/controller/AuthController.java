package com.simple.hyper.auth.controller;

import com.simple.hyper.auth.model.query.AuthQuery;
import com.simple.hyper.auth.service.IAuthService;
import com.simple.hyper.common.base.Response;
import javax.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * .
 *
 * @author SinceNovember
 * @date 2023/1/18
 */
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Resource
    private IAuthService authService;

    @GetMapping("userInfo")
    public Response getUserInfo() {
        return Response.ok(authService.getLoginUserInfo());
    }

    @PostMapping("login")
    public Response login(@RequestBody AuthQuery query) {
        return Response.ok(authService.login(query));
    }


    @PostMapping("logout")
    public Response logout(@RequestBody AuthQuery query) {
        authService.logout(query.getTokenValue());
        return Response.ok();
    }
}
