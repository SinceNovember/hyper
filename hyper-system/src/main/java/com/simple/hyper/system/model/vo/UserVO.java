package com.simple.hyper.system.model.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.simple.hyper.system.model.enums.UserSex;
import com.simple.hyper.system.model.enums.StatusType;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * .
 *
 * @author SinceNovember
 * @date 2022/12/16
 */
@Data
@ToString
public class UserVO {

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

    private String deptName;

    private StatusType status;

    private Integer orderNum;

    @JsonFormat(pattern ="yyyy-MM-dd")
    private LocalDateTime createTime;
}
