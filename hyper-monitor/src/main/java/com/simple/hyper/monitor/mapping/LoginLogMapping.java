package com.simple.hyper.monitor.mapping;

import com.simple.hyper.monitor.model.dto.LoginLogDTO;
import com.simple.hyper.monitor.model.entity.LoginLog;
import com.simple.hyper.monitor.model.query.LoginLogQuery;
import com.simple.hyper.monitor.model.vo.LoginLogVO;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * .
 *
 * @author SinceNovember
 * @date 2023/2/6
 */
@Mapper
public interface LoginLogMapping {

    LoginLogMapping INSTANCE = Mappers.getMapper(LoginLogMapping.class);

    List<LoginLogVO> toLoginLogVOList(List<LoginLogDTO> loginLogDTO);

    LoginLogVO toLoginLogVO(LoginLogDTO loginLogDTO);

    LoginLogVO toLoginLogVO(LoginLog loginLog);

    LoginLogDTO toLoginLogDTO(LoginLogQuery loginLogQuery);

    LoginLog toLoginLog(LoginLogDTO loginLogDTO);

}
