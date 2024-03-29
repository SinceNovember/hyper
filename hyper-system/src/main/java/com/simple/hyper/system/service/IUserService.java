package com.simple.hyper.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageSerializable;
import com.simple.hyper.common.base.TreeModel;
import com.simple.hyper.system.model.entity.User;
import com.simple.hyper.system.model.enums.RequestMethod;
import com.simple.hyper.system.model.query.UserQuery;
import com.simple.hyper.system.model.vo.MenuVO;
import com.simple.hyper.system.model.vo.UserDetailVO;
import com.simple.hyper.system.model.vo.UserVO;
import java.util.List;

/**
 * .
 *
 * @author SinceNovember
 * @date 2022/12/16
 */
public interface IUserService extends IService<User> {

    /**
     * 分页获取用户
     *
     * @param userQuery 用户查询
     * @return 分页用户VO
     */
    PageSerializable<UserVO> pageUser(UserQuery userQuery);

    /**
     * 获取当前用户有权限的菜单
     *
     * @return
     */
    List<MenuVO> listCurrentUserMenu();

    /**
     * 检查当前用户对应api是否可以访问
     *
     * @param path          请求路径
     * @param requestMethod 请求方法
     */
    boolean checkCurrentUserApiPermission(String path, RequestMethod requestMethod);

    /**
     * 添加或更新用户
     *
     * @param userQuery 用户查询
     */
    void addOrUpdateUser(UserQuery userQuery);

    /**
     * 通过id获取用户
     *
     * @param id id
     * @return 用户信息VO
     */
    UserDetailVO getUserById(Integer id);

    /**
     * 删除用户
     *
     * @param ids id
     */
    void deleteUser(List<Integer> ids);

    List<TreeModel> listUserTreeModel();
}
