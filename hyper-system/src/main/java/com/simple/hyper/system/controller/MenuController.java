package com.simple.hyper.system.controller;

import com.simple.hyper.common.base.Response;
import com.simple.hyper.system.model.query.MenuQuery;
import com.simple.hyper.system.service.IMenuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.constraints.NotNull;

/**
 * 菜单controller
 *
 * @author SinceNovember
 * @date 2022/11/21
 */
@Slf4j
@RestController
@RequestMapping("/api/system/menu")
public class MenuController {

    @Resource
    private IMenuService menuService;

    @GetMapping("page")
    public Response pageMenu(MenuQuery menuQuery) {
        return Response.ok(menuService.pageMenu(menuQuery));
    }

    /**
     * 左侧栏展示的菜单
     *
     * @return
     */
    @GetMapping("all")
    public Response allMenus() {
        return Response.ok(menuService.listAllShowMenu());
    }

    @GetMapping("tree")
    public Response listTreeModel() {
        return Response.ok(menuService.listMenuTreeModel());
    }

    @GetMapping
    public Response getMenu(@NotNull Integer id) {
        return Response.ok(menuService.getMenuById(id));
    }

    @PostMapping
    public Response addOrUpdateMenu(@Validated @RequestBody MenuQuery menuQuery) {
        menuService.addOrUpdateMenu(menuQuery);
        return Response.ok();
    }

    @DeleteMapping
    public Response deleteMenu(@NotNull Integer id) {
        menuService.deleteMenu(id);
        return Response.ok();
    }
}
