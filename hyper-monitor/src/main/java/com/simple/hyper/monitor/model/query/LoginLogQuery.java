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
public class LoginLogQuery extends PageQuery {

    /**
     * id
     */
    private Integer id;

    /**
     * 登录用户
     */
    private String nickname;

    /**
     * 登录地点
     */
    private String location;

    /**
     * 登录 IP
     */
    private String ip;

    /**
     * 操作系统
     */
    private String system;

    /**
     * 登录浏览器
     */
    private String browser;

}
