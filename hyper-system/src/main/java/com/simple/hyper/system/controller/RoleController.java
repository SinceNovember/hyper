package com.simple.hyper.system.controller;

import com.simple.hyper.common.base.Response;
import com.simple.hyper.system.model.query.RoleQuery;
import com.simple.hyper.system.service.IRoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.constraints.NotNull;

/**
 * .
 *
 * @author SinceNovember
 * @date 2023/1/6
 */
@Slf4j
@RestController
@RequestMapping("/api/system/role")
public class RoleController {

    @Resource
    private IRoleService roleService;

    @GetMapping("page")
    public Response pageRole(RoleQuery roleQuery) {
        return Response.ok(roleService.pageRole(roleQuery));
    }

    @GetMapping
    public Response getRole(@NotNull Integer id) {
        return Response.ok(roleService.getRoleById(id));
    }

    @GetMapping("option")
    public Response listOptionModel() {
        return Response.ok(roleService.listRoleOptionModel());
    }

    @GetMapping("tree")
    public Response listTreeModel() {
        return Response.ok(roleService.listRoleTreeModel());
    }

    @PostMapping
    public Response addOrUpdateRole(@Validated @RequestBody RoleQuery roleQuery) {
        roleService.addOrUpdateRole(roleQuery);
        return Response.ok();
    }

    @PostMapping("delete")
    public Response deleteRole(@NotNull @RequestBody RoleQuery roleQuery) {
        roleService.deleteRole(roleQuery.getIds());
        return Response.ok();
    }
}
