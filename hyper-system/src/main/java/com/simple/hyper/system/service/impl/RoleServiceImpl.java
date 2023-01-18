package com.simple.hyper.system.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageSerializable;
import com.simple.hyper.common.base.TreeModel;
import com.simple.hyper.common.utils.PageHelperUtils;
import com.simple.hyper.system.mapper.RoleMapper;
import com.simple.hyper.system.mapping.RoleMapping;
import com.simple.hyper.system.model.dto.RoleDTO;
import com.simple.hyper.system.model.entity.Role;
import com.simple.hyper.system.model.query.RoleQuery;
import com.simple.hyper.system.model.vo.RoleVO;
import com.simple.hyper.system.service.IRoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.time.LocalDateTime;
import java.util.List;

/**
 * .
 *
 * @author SinceNovember
 * @date 2023/1/6
 */
@Service
@RequiredArgsConstructor
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {

    @Override
    public PageSerializable<RoleVO> pageRole(RoleQuery roleQuery) {
        PageHelperUtils.startPage(roleQuery);
        List<RoleDTO> roleDTOS = baseMapper.selectRoleList(roleQuery);

        if (CollectionUtils.isEmpty(roleDTOS)) {
            return new PageSerializable<>();
        }
        return PageHelperUtils.convertPageDto2Vo(roleDTOS, RoleMapping.INSTANCE::toRoleVOList);
    }

    @Override
    public List<TreeModel> listRoleTreeModel() {
        return baseMapper.selectRoleTreeModelList();
    }

    @Override
    public void addOrUpdateRole(RoleQuery roleQuery) {
        RoleDTO roleDTO = RoleMapping.INSTANCE.toRoleDTO(roleQuery);
        roleDTO.setUpdateTime(LocalDateTime.now());
        if (roleQuery.getId() == null) {
            roleDTO.setCreateTime(LocalDateTime.now());
        }
        this.saveOrUpdate(RoleMapping.INSTANCE.toRole(roleDTO));
    }

    @Override
    public RoleVO getRoleById(Integer id) {
        return RoleMapping.INSTANCE.toRoleVO(getById(id));
    }

    @Override
    public void deleteRole(List<Integer> ids) {
        update(Wrappers.<Role>lambdaUpdate()
                .set(Role::getDeleted, true)
                .in(Role::getId, ids));
    }
}
