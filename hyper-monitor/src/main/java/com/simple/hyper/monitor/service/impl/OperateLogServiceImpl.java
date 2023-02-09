package com.simple.hyper.monitor.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageSerializable;
import com.simple.hyper.common.utils.PageHelperUtils;
import com.simple.hyper.monitor.mapper.OperateLogMapper;
import com.simple.hyper.monitor.mapping.OperateLogMapping;
import com.simple.hyper.monitor.model.dto.OperateLogDTO;
import com.simple.hyper.monitor.model.entity.OperateLog;
import com.simple.hyper.monitor.model.query.OperateLogQuery;
import com.simple.hyper.monitor.model.vo.OperateLogVO;
import com.simple.hyper.monitor.service.IOperateLogService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

/**
 * .
 *
 * @author SinceNovember
 * @date 2023/2/6
 */
@Service
@RequiredArgsConstructor
public class OperateLogServiceImpl extends ServiceImpl<OperateLogMapper, OperateLog> implements
        IOperateLogService {

    @Override
    public PageSerializable<OperateLogVO> pageOperateLog(OperateLogQuery operateLogQuery) {
        PageHelper.startPage(operateLogQuery.getPageNum(), operateLogQuery.getPageSize());
        List<OperateLogDTO> operateLogDTOS = baseMapper.selectOperateLogList(
                operateLogQuery);

        if (CollectionUtils.isEmpty(operateLogDTOS)) {
            return new PageSerializable<>();
        }
        return PageHelperUtils.convertPageDto2Vo(operateLogDTOS,
                OperateLogMapping.INSTANCE::toOperateLogVOList);
    }

    @Override
    public void addOperateLog(OperateLogQuery operateLogQuery) {
        OperateLogDTO operateLogDTO = OperateLogMapping.INSTANCE.toOperateLogDTO(
                operateLogQuery);
        this.saveOrUpdate(OperateLogMapping.INSTANCE.toOperateLog(operateLogDTO));
    }

    @Override
    public OperateLogVO getOperateLogById(Integer id) {
        return OperateLogMapping.INSTANCE.toOperateLogVO(getById(id));
    }

    @Override
    public void deleteOperateLog(List<Integer> ids) {
        remove(Wrappers.<OperateLog>lambdaUpdate()
                .in(OperateLog::getId, ids));
    }
}
