package com.simple.hyper.common.base;

import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * 下拉树模型
 *
 * @author SinceNovember
 * @date 2022/12/8
 */
@Data
@ToString
public class TreeModel {

    private String title;

    private Integer value;

    private Boolean checked;

    private List<TreeModel> children;
}
