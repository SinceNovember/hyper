package com.simple.hyper.metadata.mapping;

import com.simple.hyper.metadata.model.dto.SystemConfigDTO;
import com.simple.hyper.metadata.model.entity.SystemConfig;
import com.simple.hyper.metadata.model.query.SystemConfigQuery;
import com.simple.hyper.metadata.model.vo.SystemConfigVO;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * .
 *
 * @author SinceNovember
 * @date 2023/2/3
 */
@Mapper
public interface SystemConfigMapping {

    SystemConfigMapping INSTANCE = Mappers.getMapper(SystemConfigMapping.class);

    List<SystemConfigVO> toSystemConfigVOList(List<SystemConfigDTO> systemConfigDTO);

    SystemConfigVO toSystemConfigVO(SystemConfigDTO systemConfigDTO);

    SystemConfigVO toSystemConfigVO(SystemConfig systemConfig);

    SystemConfigDTO toSystemConfigDTO(SystemConfigQuery systemConfigQuery);

    SystemConfig toSystemConfig(SystemConfigDTO systemConfigDTO);

}
