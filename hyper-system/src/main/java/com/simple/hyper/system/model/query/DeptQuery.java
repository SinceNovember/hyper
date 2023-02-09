package com.simple.hyper.system.model.query;

import com.simple.hyper.common.base.query.PageQuery;
import com.simple.hyper.system.model.dto.DeptDTO;
import java.util.List;
import lombok.Data;
import lombok.ToString;

/**
 * .
 *
 * @author SinceNovember
 * @date 2023/1/10
 */
@Data
@ToString
public class DeptQuery extends PageQuery {

    private Integer id;

    private String deptName;

    private String deptShortName;

    private Integer createUserId;

    private Integer orderNum;

    private String description;

    private Integer parentId;

    private List<DeptDTO> children;

}
