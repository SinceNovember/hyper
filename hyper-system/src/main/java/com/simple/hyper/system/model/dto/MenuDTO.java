package com.simple.hyper.system.model.dto;

import com.simple.hyper.common.base.dto.BaseDTO;
import com.simple.hyper.system.model.enums.MenuType;
import com.simple.hyper.system.model.enums.RequestMethod;
import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * .
 *
 * @author SinceNovember
 * @date 2022/11/20
 */
@Data
@ToString
public class MenuDTO extends BaseDTO {

    private Integer id;

    private String path;

    private Integer parentId;

    private String component;

    private String name;

    private String redirect;

    private String title;

    private String icon;

    private MenuType type;

    private RequestMethod requestMethod;

    private List<MenuDTO> children;

    private Boolean hidden;

    private Boolean alwaysShow;

    private Boolean breadCrumb;

    private Boolean isExpand;

}
