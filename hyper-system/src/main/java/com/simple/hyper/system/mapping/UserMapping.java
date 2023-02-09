package com.simple.hyper.system.mapping;

import com.simple.hyper.system.model.dto.UserDTO;
import com.simple.hyper.system.model.entity.User;
import com.simple.hyper.system.model.query.UserQuery;
import com.simple.hyper.system.model.vo.UserDetailVO;
import com.simple.hyper.system.model.vo.UserVO;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

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

    @Named(value = "toUserDetailVO")
    UserDetailVO toUserDetailVO(UserDTO userDTO);


    UserDTO toUserDTO(User user);

    UserDTO toUserDTO(UserQuery userQuery);

    User toUser(UserDTO userDTO);
}
