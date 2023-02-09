package com.simple.hyper.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.simple.hyper.system.model.dto.RoleDTO;
import com.simple.hyper.system.model.entity.UserRoleRelate;
import java.util.List;

public interface IUserRoleRelateService extends IService<UserRoleRelate> {

    /**
     * 通过用户id列表角色id
     *
     * @param userId 用户id
     * @return 角色id列表
     */
    List<RoleDTO> listRoleByUserId(Integer userId);

}
