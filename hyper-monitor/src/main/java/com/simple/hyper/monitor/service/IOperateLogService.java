package com.simple.hyper.monitor.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageSerializable;
import com.simple.hyper.monitor.model.entity.OperateLog;
import com.simple.hyper.monitor.model.query.OperateLogQuery;
import com.simple.hyper.monitor.model.vo.OperateLogVO;
import java.util.List;

public interface IOperateLogService extends IService<OperateLog> {

    /**
     * 分页获取操作日志
     *
     * @param operateLogQuery 操作日志查询
     * @return 分页系操作日志VO
     */
    PageSerializable<OperateLogVO> pageOperateLog(OperateLogQuery operateLogQuery);

    /**
     * 添加或更新操作日志
     *
     * @param operateLogQuery 操作日志查询
     */
    void addOperateLog(OperateLogQuery operateLogQuery);

    /**
     * 通过id获取操作日志
     *
     * @param id id
     * @return 操作日志VO
     */
    OperateLogVO getOperateLogById(Integer id);

    /**
     * 删除操作日志
     *
     * @param ids id
     */
    void deleteOperateLog(List<Integer> ids);

}
