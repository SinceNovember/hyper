package com.simple.hyper.metadata.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageSerializable;
import com.simple.hyper.common.utils.PageHelperUtils;
import com.simple.hyper.metadata.mapper.SystemConfigMapper;
import com.simple.hyper.metadata.mapping.SystemConfigMapping;
import com.simple.hyper.metadata.model.dto.SystemConfigDTO;
import com.simple.hyper.metadata.model.entity.SystemConfig;
import com.simple.hyper.metadata.model.query.SystemConfigQuery;
import com.simple.hyper.metadata.model.vo.SystemConfigVO;
import com.simple.hyper.metadata.service.ISystemConfigService;
import java.time.LocalDateTime;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

/**
 * .
 *
 * @author SinceNovember
 * @date 2023/2/3
 */
@Service
@RequiredArgsConstructor
public class SystemConfigServiceImpl extends
        ServiceImpl<SystemConfigMapper, SystemConfig> implements
        ISystemConfigService {

    @Override
    public PageSerializable<SystemConfigVO> pageSystemConfig(SystemConfigQuery systemConfigQuery) {
        PageHelperUtils.startPage(systemConfigQuery);
        List<SystemConfigDTO> systemConfigDTOS = baseMapper.selectSystemConfigList(
                systemConfigQuery);

        if (CollectionUtils.isEmpty(systemConfigDTOS)) {
            return new PageSerializable<>();
        }
        return PageHelperUtils.convertPageDto2Vo(systemConfigDTOS,
                SystemConfigMapping.INSTANCE::toSystemConfigVOList);
    }

    @Override
    public void addOrUpdateSystemConfig(SystemConfigQuery systemConfigQuery) {
        SystemConfigDTO systemConfigDTO = SystemConfigMapping.INSTANCE.toSystemConfigDTO(
                systemConfigQuery);
        if (systemConfigQuery.getId() == null) {
            systemConfigDTO.setCreateTime(LocalDateTime.now());
        }
        this.saveOrUpdate(SystemConfigMapping.INSTANCE.toSystemConfig(systemConfigDTO));
    }

    @Override
    public SystemConfigVO getSystemConfigById(Integer id) {
        return SystemConfigMapping.INSTANCE.toSystemConfigVO(getById(id));
    }

    @Override
    public String getConfigValueByName(String configName) {
        return baseMapper.selectConfigValueByName(configName);
    }

    @Override
    public void deleteSystemConfig(List<Integer> ids) {
        remove(Wrappers.<SystemConfig>lambdaUpdate()
                .in(SystemConfig::getId, ids));
    }
}
