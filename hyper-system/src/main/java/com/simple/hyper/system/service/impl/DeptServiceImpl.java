package com.simple.hyper.system.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageSerializable;
import com.simple.hyper.common.base.TreeModel;
import com.simple.hyper.common.consts.Consts;
import com.simple.hyper.common.utils.PageHelperUtils;
import com.simple.hyper.system.mapper.DeptMapper;
import com.simple.hyper.system.mapping.DeptMapping;
import com.simple.hyper.system.model.dto.DeptDTO;
import com.simple.hyper.system.model.entity.Dept;
import com.simple.hyper.system.model.query.DeptQuery;
import com.simple.hyper.system.model.vo.DeptVO;
import com.simple.hyper.system.service.IDeptService;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

/**
 * .
 *
 * @author SinceNovember
 * @date 2023/1/6
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class DeptServiceImpl extends ServiceImpl<DeptMapper, Dept> implements IDeptService {

    @Override
    public PageSerializable<DeptVO> pageDept(DeptQuery deptQuery) {
        PageHelperUtils.startPage(deptQuery);
        List<DeptDTO> deptDTOS = baseMapper.selectDeptList(deptQuery);

        if (CollectionUtils.isEmpty(deptDTOS)) {
            return new PageSerializable<>();
        }
        return PageHelperUtils.convertPageDto2Vo(deptDTOS, DeptMapping.INSTANCE::toDeptVOList);
    }

    @Override
    public void addOrUpdateDept(DeptQuery deptQuery) {
        DeptDTO deptDTO = DeptMapping.INSTANCE.toDeptDTO(deptQuery);
        deptDTO.setUpdateTime(LocalDateTime.now());
        if (deptQuery.getId() == null) {
            deptDTO.setCreateUserId(123);
            deptDTO.setCreateTime(LocalDateTime.now());
        }
        this.saveOrUpdate(DeptMapping.INSTANCE.toDept(deptDTO));
    }

    @Override
    public DeptVO getDeptById(Integer id) {
        DeptVO deptVO = DeptMapping.INSTANCE.toDeptVO(getById(id));
        Optional.ofNullable(deptVO.getParentId())
                .ifPresent(parentId -> deptVO.setParentName(getById(parentId).getDeptName()));
        return deptVO;

    }

    @Override
    public List<TreeModel> listDeptTreeModel() {
        return baseMapper.selectDeptTreeModelList(Consts.ROOT_PID);
    }

    @Override
    public void deleteDept(List<Integer> ids) {
        update(Wrappers.<Dept>lambdaUpdate()
                .set(Dept::getDeleted, true)
                .in(Dept::getId, ids));
    }
}
