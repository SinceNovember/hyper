package com.simple.hyper.system.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageSerializable;
import com.simple.hyper.common.base.TreeModel;
import com.simple.hyper.common.consts.Consts;
import com.simple.hyper.common.consts.MsgConsts;
import com.simple.hyper.common.ex.HyperException;
import com.simple.hyper.common.utils.PageHelperUtils;
import com.simple.hyper.common.utils.StringUtils;
import com.simple.hyper.system.mapper.MenuMapper;
import com.simple.hyper.system.mapping.MenuMapping;
import com.simple.hyper.system.model.dto.MenuDTO;
import com.simple.hyper.system.model.entity.Menu;
import com.simple.hyper.system.model.enums.MenuType;
import com.simple.hyper.system.model.query.MenuQuery;
import com.simple.hyper.system.model.vo.MenuInfoVO;
import com.simple.hyper.system.model.vo.MenuVO;
import com.simple.hyper.system.service.IMenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements IMenuService {


    /**
     * 节点目录的组件必须为Layout才能显示布局
     */
    private static final String ROOT_LAYOUT = "Layout";

    private static final String PATH_PREFIX = "/";

    @Override
    public PageSerializable<MenuVO> pageMenu(MenuQuery menuQuery) {
        PageHelperUtils.startPage(menuQuery);
        List<MenuDTO> menuDTOS = baseMapper.selectMenuList(menuQuery);

        if (CollectionUtils.isEmpty(menuDTOS)) {
            return new PageSerializable<>();
        }
        return PageHelperUtils.convertPageDto2Vo(menuDTOS, MenuMapping.INSTANCE::toMenuVOList);
    }

    @Override
    public List<MenuVO> listAllShowMenu() {
        return MenuMapping.INSTANCE.toMenuVOList(baseMapper.selectShowMenuList());
    }

    @Override
    public List<MenuVO> listMenuByParentId(Integer parentId) {
        return MenuMapping.INSTANCE.toMenuVOList(baseMapper.selectMenuListByParentId(parentId));
    }

    @Override
    public void addOrUpdateMenu(MenuQuery menuQuery) {
        MenuDTO menuDTO = MenuMapping.INSTANCE.toMenuDTO(menuQuery);
        menuDTO.setPath(StringUtils.addPrefixIfNot(menuDTO.getPath(), PATH_PREFIX));
        //目录菜单组件转换为布局组件
        if (menuQuery.getType() == MenuType.DIRECTORY) {
            menuDTO.setComponent(ROOT_LAYOUT);
        }
        menuDTO.setUpdateTime(LocalDateTime.now());
        if (menuQuery.getId() == null) {
            menuDTO.setCreateTime(LocalDateTime.now());
        }
        this.saveOrUpdate(MenuMapping.INSTANCE.toMenu(menuDTO));
    }

    @Override
    public List<TreeModel> listMenuTreeModel() {
        return baseMapper.selectMenuTreeModelList(Consts.ROOT_PID);
    }

    @Override
    public MenuInfoVO getMenuById(Integer id) {
        return MenuMapping.INSTANCE.toMenuInfoVO(getById(id));
    }

    @Override
    public void deleteMenu(Integer id) {
        if (hasChildMenu(id)) {
            throw new HyperException(MsgConsts.HAS_CHILDREN_ERROR_TEXT);
        }
        //逻辑删除菜单
        update(Wrappers.<Menu>lambdaUpdate()
                .set(Menu::getDeleted, true)
                .eq(Menu::getId, id));
    }

    /**
     * 判断该菜单下是否包含子菜单
     *
     * @param id id
     * @return
     */
    private boolean hasChildMenu(Integer id) {
        if (CollectionUtils.isEmpty(baseMapper.selectMenuListByParentId(id))) {
            return false;
        }
        return true;
    }
}
