package com.simple.hyper.system.model.vo;

import com.simple.hyper.system.model.enums.MenuType;
import com.simple.hyper.system.model.enums.RequestMethod;
import java.util.List;
import lombok.Data;
import lombok.ToString;

/**
 * .
 *
 * @author SinceNovember
 * @date 2022/11/22
 */
@Data
@ToString
public class MenuVO {

    private Integer id;

    private String path;

    private Integer parentId;

    private String component;

    private String name;

    private String redirect;

    private MenuMetaVO meta;

    private MenuType type;

    private Integer orderNum;

    private Boolean hidden;

    private Boolean alwaysShow;

    private RequestMethod requestMethod;

    private List<MenuVO> children;

    @Data
    public static class MenuMetaVO {

        private String title;

        private String icon;

        private Boolean breadCrumb;
    }

}
