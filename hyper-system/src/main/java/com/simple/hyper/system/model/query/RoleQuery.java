package com.simple.hyper.system.model.query;

import com.simple.hyper.common.base.query.PageQuery;
import com.simple.hyper.system.model.enums.StatusType;
import lombok.Data;

import java.util.List;

/**
 * .
 *
 * @author SinceNovember
 * @date 2023/1/6
 */
@Data
public class RoleQuery extends PageQuery {

    private Integer id;

    private String roleName;

    private String roleTag;

    private Integer orderNum;

    private StatusType status;

    private String description;

    private List<Integer> ids;

}
