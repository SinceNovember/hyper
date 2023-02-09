package com.simple.hyper.monitor.model.query;

import com.simple.hyper.common.base.query.PageQuery;
import lombok.Data;
import lombok.ToString;

/**
 * .
 *
 * @author SinceNovember
 * @date 2023/2/6
 */
@Data
@ToString
public class OperateLogQuery extends PageQuery {

    /**
     * 日志ID
     */
    private Integer id;

    /**
     * 操作用户
     */
    private String nickname;

    /**
     * 操作内容
     */
    private String operation;

    /**
     * 耗时
     */
    private Long time;

    /**
     * 操作方法
     */
    private String method;

    /**
     * 方法参数
     */
    private String params;

    /**
     * 操作者IP
     */
    private String ip;

    /**
     * 操作地点
     */
    private String location;

}
