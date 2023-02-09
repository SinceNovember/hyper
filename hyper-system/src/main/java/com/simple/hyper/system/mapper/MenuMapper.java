package com.simple.hyper.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.simple.hyper.common.base.TreeModel;
import com.simple.hyper.system.model.dto.MenuDTO;
import com.simple.hyper.system.model.entity.Menu;
import com.simple.hyper.system.model.query.MenuQuery;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface MenuMapper extends BaseMapper<Menu> {

    @Select("<script>" +
            "select * from t_menu where pid is null and deleted = 0 and hidden = 0 " +
            "order by order_num desc" +
            "</script>")
    @Results(id = "BaseShowResultMap", value = {
            @Result(column = "id", property = "id"),
            @Result(column = "pid", property = "parentId"),
            @Result(column = "id", property = "children", many = @Many(
                    select = "com.simple.hyper.system.mapper.MenuMapper.selectShowMenuListByParentId"
            ))})
    List<MenuDTO> selectShowMenuList();

    @Select("select * from t_menu where pid =#{pid} and deleted = 0 and hidden = 0 order by order_num desc")
    @ResultMap("BaseShowResultMap")
    List<MenuDTO> selectShowMenuListByParentId(@Param("pid") Integer pid);

    @Select("<script>" +
            "select * from t_menu where pid is null and deleted = 0 " +
            "<if test = \" title != null and title !='' \">" +
            " and title like concat('%', #{title}, '%')" +
            "</if>" +
            "</script>")
    @Results(id = "BaseResultMap", value = {
            @Result(column = "id", property = "id"),
            @Result(column = "pid", property = "parentId"),
            @Result(column = "id", property = "children", many = @Many(
                    select = "com.simple.hyper.system.mapper.MenuMapper.selectMenuListByParentId"
            ))})
    List<MenuDTO> selectMenuList(MenuQuery menuQuery);

    @Select("select * from t_menu where pid =#{pid} and deleted = 0 order by order_num desc")
    @ResultMap("BaseResultMap")
    List<MenuDTO> selectMenuListByParentId(@Param("pid") Integer pid);

    @Select("<script>" +
            "select id as value, title from t_menu " +
            "where deleted = 0 " +
            "<if test=\"pid == null or pid == ''  \">" +
            " and pid is null" +
            "</if>" +
            "<if test=\"pid != null and pid != ''  \">" +
            " and pid = #{pid}" +
            "</if>" +
            "order by order_num desc" +
            "</script>")
    @Results(id = "MenuTreeModelResultMap", value = {
            @Result(column = "value", property = "value"),
            @Result(column = "title", property = "title"),
            @Result(column = "checked", property = "checked"),
            @Result(column = "value", property = "children", many = @Many(
                    select = "com.simple.hyper.system.mapper.MenuMapper.selectMenuTreeModelList"
            ))})
    List<TreeModel> selectMenuTreeModelList(@Param("pid") Integer pid);
}
