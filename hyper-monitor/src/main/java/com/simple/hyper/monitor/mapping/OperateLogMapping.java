package com.simple.hyper.monitor.mapping;

import com.simple.hyper.monitor.model.dto.OperateLogDTO;
import com.simple.hyper.monitor.model.entity.OperateLog;
import com.simple.hyper.monitor.model.query.OperateLogQuery;
import com.simple.hyper.monitor.model.vo.OperateLogVO;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OperateLogMapping {

    OperateLogMapping INSTANCE = Mappers.getMapper(OperateLogMapping.class);

    List<OperateLogVO> toOperateLogVOList(List<OperateLogDTO> operateLogDTO);

    OperateLogVO toOperateLogVO(OperateLogDTO operateLogDTO);

    OperateLogVO toOperateLogVO(OperateLog operateLog);

    OperateLogDTO toOperateLogDTO(OperateLogQuery operateLogQuery);

    OperateLog toOperateLog(OperateLogDTO operateLogDTO);

}
