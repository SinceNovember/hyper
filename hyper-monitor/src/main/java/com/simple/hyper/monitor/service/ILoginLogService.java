package com.simple.hyper.monitor.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageSerializable;
import com.simple.hyper.monitor.model.entity.LoginLog;
import com.simple.hyper.monitor.model.query.LoginLogQuery;
import com.simple.hyper.monitor.model.vo.LoginLogVO;
import java.util.List;

public interface ILoginLogService extends IService<LoginLog> {

    /**
     * 分页获取登录日志
     *
     * @param loginLogQuery 登录日志查询
     * @return 分页系登录日志VO
     */
    PageSerializable<LoginLogVO> pageLoginLog(LoginLogQuery loginLogQuery);

    /**
     * 添加或更新登录日志
     *
     * @param loginLogQuery 登录日志查询
     */
    void addLoginLog(LoginLogQuery loginLogQuery);

    /**
     * 通过id获取登录日志
     *
     * @param id id
     * @return 登录日志VO
     */
    LoginLogVO getLoginLogById(Integer id);

    /**
     * 删除登录日志
     *
     * @param ids id
     */
    void deleteLoginLog(List<Integer> ids);

}
