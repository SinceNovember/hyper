package com.simple.hyper.system.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageSerializable;
import com.simple.hyper.common.base.TreeModel;
import com.simple.hyper.common.utils.PageHelperUtils;
import com.simple.hyper.system.mapper.UserMapper;
import com.simple.hyper.system.mapping.UserMapping;
import com.simple.hyper.system.model.dto.UserDTO;
import com.simple.hyper.system.model.entity.User;
import com.simple.hyper.system.model.query.UserQuery;
import com.simple.hyper.system.model.vo.UserVO;
import com.simple.hyper.system.service.IDeptService;
import com.simple.hyper.system.service.IUserService;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.time.LocalDateTime;
import java.util.List;

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
    public void addOrUpdateUser(UserQuery userQuery) {
        UserDTO userDTO = UserMapping.INSTANCE.toUserDTO(userQuery);
        userDTO.setUpdateTime(LocalDateTime.now());
        if (userQuery.getId() == null) {
            userDTO.setCreateTime(LocalDateTime.now());
        }
        this.saveOrUpdate(UserMapping.INSTANCE.toUser(userDTO));
    }

    @Override
    public UserVO getUserById(Integer id) {
        UserVO userVO = UserMapping.INSTANCE.toUserVO(getById(id));
        Optional.ofNullable(userVO.getDeptId())
                .ifPresent(deptId -> userVO.setDeptName(
                        deptService.getDeptById(deptId).getDeptName()));
        return userVO;
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
