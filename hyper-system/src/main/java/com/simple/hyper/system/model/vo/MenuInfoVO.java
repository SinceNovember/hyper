package com.simple.hyper.system.model.vo;

import com.simple.hyper.system.model.enums.MenuType;
import com.simple.hyper.system.model.enums.RequestMethod;
import lombok.Data;
import lombok.ToString;

/**
 * .
 *
 * @author SinceNovember
 * @date 2022/12/10
 */
@Data
@ToString
public class MenuInfoVO {

    private Integer id;

    private String path;

    private Integer parentId;

    private String parentTitle;

    private String component;

    private String name;

    private String redirect;

    private String title;

    private String icon;

    private MenuType type;

    private RequestMethod requestMethod;

    private Integer orderNum;

    private Boolean hidden;

    private Boolean breadCrumb;

    private Boolean alwaysShow;
}
