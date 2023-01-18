package com.simple.hyper.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.simple.hyper.common.base.TreeModel;
import com.simple.hyper.system.model.dto.RoleDTO;
import com.simple.hyper.system.model.entity.Role;
import com.simple.hyper.system.model.query.RoleQuery;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface RoleMapper extends BaseMapper<Role>  {

    @Select("<script>" +
            "select * from t_role where deleted = 0 " +
            "<if test=\"roleName != null and roleName != ''\">" +
            "and role_name like concat('%', #{roleName}, '%') " +
            "</if>" +
            "</script>")
    List<RoleDTO> selectRoleList(RoleQuery roleQuery);

    @Select("<script>" +
        "select id as value, role_name as title from t_role where deleted = 0 order by order_num desc" +
        "</script>")
    List<TreeModel> selectRoleTreeModelList();
}
