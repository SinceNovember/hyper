package com.simple.hyper.metadata.model.query;

import com.simple.hyper.common.base.query.PageQuery;
import lombok.Data;
import lombok.ToString;

/**
 * .
 *
 * @author SinceNovember
 * @date 2023/2/3
 */
@Data
@ToString
public class SystemConfigQuery extends PageQuery {

    private Integer id;

    private String configName;

    private String configValue;

    private String description;

    private Integer orderNum;

}
