package com.simple.hyper.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.simple.hyper.system.model.entity.MenuPermission;
import com.simple.hyper.system.model.enums.PermissionType;
import com.simple.hyper.system.model.query.MenuPermissionQuery;
import java.util.List;
import java.util.Map;

/**
 * .
 *
 * @author SinceNovember
 * @date 2023/1/16
 */
public interface IMenuPermissionService extends IService<MenuPermission> {

    /**
     * 根据菜单id获取权限列表并按照权限类别进行分组
     *
     * @param query 查询
     * @return
     */
    Map<PermissionType, List<Integer>> listMenuPermissionIdGroupByType(MenuPermissionQuery query);

    void updateMenuPermission(MenuPermissionQuery query);
}
