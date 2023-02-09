package com.simple.hyper.system.controller;

import com.simple.hyper.common.base.Response;
import com.simple.hyper.system.model.query.UserQuery;
import com.simple.hyper.system.service.IUserService;
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
 * 用户controller
 *
 * @author SinceNovember
 * @date 2022/12/16
 */
@Slf4j
@RestController
@RequestMapping("/api/system/user")
public class UserController {

    @Resource
    private IUserService userService;

    @GetMapping("page")
    public Response pageUser(UserQuery userQuery) {
        return Response.ok(userService.pageUser(userQuery));
    }

    @GetMapping
    public Response getUser(@NotNull Integer id) {
        return Response.ok(userService.getUserById(id));
    }

    @GetMapping("tree")
    public Response listTreeModel() {
        return Response.ok(userService.listUserTreeModel());
    }

    @GetMapping("menu")
    public Response listCurrentUserMenu() {
        return Response.ok(userService.listCurrentUserMenu());
    }

    @PostMapping
    public Response addOrUpdateUser(@Validated @RequestBody UserQuery userQuery) {
        userService.addOrUpdateUser(userQuery);
        return Response.ok();
    }

    @PostMapping("delete")
    public Response deleteUser(@NotNull @RequestBody UserQuery userQuery) {
        userService.deleteUser(userQuery.getIds());
        return Response.ok();
    }
}
