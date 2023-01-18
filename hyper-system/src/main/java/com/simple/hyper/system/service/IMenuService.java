package com.simple.hyper.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageSerializable;
import com.simple.hyper.common.base.TreeModel;
import com.simple.hyper.system.model.entity.Menu;
import com.simple.hyper.system.model.query.MenuQuery;
import com.simple.hyper.system.model.vo.MenuInfoVO;
import com.simple.hyper.system.model.vo.MenuVO;
import java.util.List;

public interface IMenuService extends IService<Menu> {

    /**
     * 分页获取菜单
     *
     * @param menuQuery 菜单查询
     * @return 分页菜单VO
     */
    PageSerializable<MenuVO> pageMenu(MenuQuery menuQuery);

    /**
     * 获取所有显示的菜单
     *
     * @return 分页菜单VO
     */
    List<MenuVO> listAllShowMenu();

    /**
     * 由父id获取菜单列表
     *
     * @param parentId 父id
     * @return 分页菜单VO
     */
    List<MenuVO> listMenuByParentId(Integer parentId);

    /**
     * 添加或更新菜单
     *
     * @param menuQuery 菜单查询
     */
    void addOrUpdateMenu(MenuQuery menuQuery);

    /**
     * 菜单树模型列表
     *
     * @return
     */
    List<TreeModel> listMenuTreeModel();

    /**
     * 通过id获取菜单
     *
     * @param id id
     * @return 菜单信息VO
     */
    MenuInfoVO getMenuById(Integer id);

    /**
     * 删除菜单
     *
     * @param id id
     */
    void deleteMenu(Integer id);
}
