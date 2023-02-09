package com.simple.hyper.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.simple.hyper.system.model.dto.RoleDTO;
import com.simple.hyper.system.model.entity.UserRoleRelate;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserRoleRelateMapper extends BaseMapper<UserRoleRelate> {

    @Select("select role_id as id, role_name as roleName from t_user_role a join t_role b on a.role_id = b.id "
            + "where user_id =#{userId} and deleted = 0 and status = 1")
    List<RoleDTO> selectRoleIdByUserId(@Param("userId") Integer userId);
}
