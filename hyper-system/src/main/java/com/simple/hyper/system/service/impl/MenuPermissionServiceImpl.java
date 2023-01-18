package com.simple.hyper.system.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.simple.hyper.system.mapper.MenuPermissionMapper;
import com.simple.hyper.system.model.entity.MenuPermission;
import com.simple.hyper.system.model.enums.PermissionType;
import com.simple.hyper.system.model.query.MenuPermissionQuery;
import com.simple.hyper.system.service.IMenuPermissionService;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * .
 *
 * @author SinceNovember
 * @date 2023/1/16
 */
@Service
@RequiredArgsConstructor
public class MenuPermissionServiceImpl extends
        ServiceImpl<MenuPermissionMapper, MenuPermission> implements IMenuPermissionService {

    @Override
    public Map<PermissionType, List<Integer>> listMenuPermissionIdGroupByType(
            MenuPermissionQuery query) {
        List<MenuPermission> menuPermissionList =
                list(Wrappers.<MenuPermission>lambdaQuery()
                        .eq(MenuPermission::getMenuId, query.getMenuId()));

        return menuPermissionList.stream()
                .collect(Collectors.groupingBy(MenuPermission::getPermissionType,
                        Collectors.mapping(MenuPermission::getPermissionId, Collectors.toList())));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateMenuPermission(MenuPermissionQuery query) {

        //先删除原先的权限关联
        this.remove(Wrappers.<MenuPermission>lambdaQuery()
                .eq(MenuPermission::getMenuId, query.getMenuId()));

        query.getMenuPermissionMap().forEach((k, v) -> {
            v.forEach(id -> {
                MenuPermission menuPermission = new MenuPermission();
                menuPermission.setMenuId(query.getMenuId());
                menuPermission.setPermissionId(id);
                menuPermission.setPermissionType(k);
                this.save(menuPermission);
            });
        });
    }
}
