package com.simple.hyper.system.service.impl;

import cn.dev33.satoken.stp.StpUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageSerializable;
import com.simple.hyper.common.base.TreeModel;
import com.simple.hyper.common.utils.PageHelperUtils;
import com.simple.hyper.system.mapper.UserMapper;
import com.simple.hyper.system.mapping.UserMapping;
import com.simple.hyper.system.model.dto.RoleDTO;
import com.simple.hyper.system.model.dto.UserDTO;
import com.simple.hyper.system.model.entity.User;
import com.simple.hyper.system.model.entity.UserRoleRelate;
import com.simple.hyper.system.model.enums.RequestMethod;
import com.simple.hyper.system.model.query.UserQuery;
import com.simple.hyper.system.model.vo.MenuVO;
import com.simple.hyper.system.model.vo.UserDetailVO;
import com.simple.hyper.system.model.vo.UserVO;
import com.simple.hyper.system.service.IDeptService;
import com.simple.hyper.system.service.IMenuService;
import com.simple.hyper.system.service.IUserRoleRelateService;
import com.simple.hyper.system.service.IUserService;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

/**
 * .
 *
 * @author SinceNovember
 * @date 2022/12/16
 */
@Service
@RequiredArgsConstructor
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    private final IDeptService deptService;

    private final IMenuService menuService;

    private final IUserRoleRelateService userRoleRelateService;

    @Override
    public PageSerializable<UserVO> pageUser(UserQuery userQuery) {
        PageHelperUtils.startPage(userQuery);
        List<UserDTO> userDTOS = baseMapper.selectUserList(userQuery);

        if (CollectionUtils.isEmpty(userDTOS)) {
            return new PageSerializable<>();
        }
        return PageHelperUtils.convertPageDto2Vo(userDTOS, UserMapping.INSTANCE::toUserVOList);
    }

    @Override
    public List<MenuVO> listCurrentUserMenu() {
        return menuService.listMenuByUserDTO(getUserDTOById(StpUtil.getLoginIdAsInt()));
    }

    @Override
    public boolean checkCurrentUserApiPermission(String path, RequestMethod requestMethod) {
        return menuService.checkMenuPermissionByUserAndPath(
                getUserDTOById(StpUtil.getLoginIdAsInt()), path, requestMethod);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void addOrUpdateUser(UserQuery userQuery) {
        UserDTO userDTO = UserMapping.INSTANCE.toUserDTO(userQuery);
        userDTO.setUpdateTime(LocalDateTime.now());
        if (userQuery.getId() == null) {
            userDTO.setCreateTime(LocalDateTime.now());
        }
        User user = UserMapping.INSTANCE.toUser(userDTO);
        this.saveOrUpdate(user);

        //先删除用户的所有角色
        userRoleRelateService.remove(Wrappers.<UserRoleRelate>lambdaQuery()
                .eq(UserRoleRelate::getUserId, userQuery.getId()));
        //保存用户角色关系
        if (!CollectionUtils.isEmpty(userQuery.getRoleIds())) {
            userQuery.getRoleIds().forEach(roleId -> {
                UserRoleRelate userRoleRelate = new UserRoleRelate();
                userRoleRelate.setUserId(user.getId());
                userRoleRelate.setRoleId(roleId);
                userRoleRelateService.save(userRoleRelate);
            });
        }
    }

    @Override
    public UserDetailVO getUserById(Integer id) {
        return UserMapping.INSTANCE.toUserDetailVO(getUserDTOById(id));
    }

    private UserDTO getUserDTOById(Integer id) {
        UserDTO userDTO = UserMapping.INSTANCE.toUserDTO(getById(id));
        Optional.ofNullable(userDTO.getDeptId())
                .ifPresent(deptId -> userDTO.setDeptName(
                        deptService.getDeptById(deptId).getDeptName()));
        List<RoleDTO> roleDTOS = userRoleRelateService.listRoleByUserId(id);

        if (!CollectionUtils.isEmpty(roleDTOS)) {
            userDTO.setRoleIds(roleDTOS.stream()
                    .map(RoleDTO::getId)
                    .collect(Collectors.toList()));

            userDTO.setRoleNames(roleDTOS.stream()
                    .map(RoleDTO::getRoleName)
                    .collect(Collectors.toList()));
        }
        return userDTO;
    }

    @Override
    public void deleteUser(List<Integer> ids) {
        update(Wrappers.<User>lambdaUpdate()
                .set(User::getDeleted, true)
                .in(User::getId, ids));
    }

    @Override
    public List<TreeModel> listUserTreeModel() {
        return baseMapper.selectUserTreeModelList();
    }

}
