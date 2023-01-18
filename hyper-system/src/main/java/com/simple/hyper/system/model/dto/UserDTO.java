package com.simple.hyper.system.model.dto;

import com.simple.hyper.common.base.dto.BaseDTO;
import com.simple.hyper.system.model.enums.UserSex;
import com.simple.hyper.system.model.enums.StatusType;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * 用户dto
 *
 * @author SinceNovember
 * @date 2022/12/16
 */
@Data
@ToString
public class UserDTO extends BaseDTO {

    private Integer id;

    private String username;

    private String password;

    private UserSex sex;

    private String email;

    private String mobile;

    private String nickname;

    private String avatar;

    private String description;

    private Integer deptId;

    private StatusType status;

    private LocalDateTime lastLoginTime;

}
