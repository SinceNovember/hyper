package com.simple.hyper.system.model.vo;

import java.util.List;
import lombok.Data;
import lombok.ToString;

/**
 * .
 *
 * @author SinceNovember
 * @date 2023/2/2
 */
@Data
@ToString
public class UserDetailVO extends UserVO{

    private String description;

    private List<Integer> roleIds;

    private List<String> roleNames;
}
