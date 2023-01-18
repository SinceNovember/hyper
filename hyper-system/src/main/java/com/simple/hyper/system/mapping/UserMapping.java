package com.simple.hyper.system.mapping;

import com.simple.hyper.system.model.dto.UserDTO;
import com.simple.hyper.system.model.entity.User;
import com.simple.hyper.system.model.query.UserQuery;
import com.simple.hyper.system.model.vo.UserVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * .
 *
 * @author SinceNovember
 * @date 2022/12/16
 */
@Mapper
public interface UserMapping {

    UserMapping INSTANCE = Mappers.getMapper(UserMapping.class);

    List<UserVO> toUserVOList(List<UserDTO> userDTO);

    UserVO toUserVO(UserDTO userDTO);

    UserVO toUserVO(User user);

    UserDTO toUserDTO(UserQuery userQuery);

    User toUser(UserDTO userDTO);
}
