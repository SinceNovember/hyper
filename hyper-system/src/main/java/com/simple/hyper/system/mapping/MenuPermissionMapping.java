package com.simple.hyper.system.mapping;

import com.simple.hyper.system.model.dto.MenuPermissionDTO;
import com.simple.hyper.system.model.entity.MenuPermission;
import com.simple.hyper.system.model.query.MenuPermissionQuery;
import com.simple.hyper.system.model.vo.MenuPermissionVO;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * .
 *
 * @author SinceNovember
 * @date 2022/12/16
 */
@Mapper
public interface MenuPermissionMapping {

    MenuPermissionMapping INSTANCE = Mappers.getMapper(MenuPermissionMapping.class);

    List<MenuPermissionVO> toMenuPermissionVOList(List<MenuPermissionDTO> roleDTO);

    MenuPermissionVO toMenuPermissionVO(MenuPermissionDTO roleDTO);

    MenuPermissionVO toMenuPermissionVO(MenuPermission role);

    MenuPermissionDTO toMenuPermissionDTO(MenuPermissionQuery roleQuery);

    MenuPermission toMenuPermission(MenuPermissionDTO roleDTO);
}
