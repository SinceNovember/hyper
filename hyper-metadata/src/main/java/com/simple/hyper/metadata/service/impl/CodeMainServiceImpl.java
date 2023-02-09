package com.simple.hyper.metadata.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageSerializable;
import com.simple.hyper.common.base.OptionModel;
import com.simple.hyper.common.utils.PageHelperUtils;
import com.simple.hyper.metadata.mapper.CodeMainMapper;
import com.simple.hyper.metadata.mapping.CodeMainMapping;
import com.simple.hyper.metadata.model.dto.CodeMainDTO;
import com.simple.hyper.metadata.model.entity.CodeMain;
import com.simple.hyper.metadata.model.query.CodeMainQuery;
import com.simple.hyper.metadata.model.vo.CodeMainVO;
import com.simple.hyper.metadata.service.ICodeMainService;
import java.time.LocalDateTime;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

/**
 * .
 *
 * @author SinceNovember
 * @date 2023/2/4
 */
@Service
@RequiredArgsConstructor
public class CodeMainServiceImpl extends
        ServiceImpl<CodeMainMapper, CodeMain> implements
        ICodeMainService {

    @Override
    public PageSerializable<CodeMainVO> pageCodeMain(CodeMainQuery codeMainQuery) {
        PageHelperUtils.startPage(codeMainQuery);
        List<CodeMainDTO> codeMainDTOS = baseMapper.selectCodeMainList(codeMainQuery);

        if (CollectionUtils.isEmpty(codeMainDTOS)) {
            return new PageSerializable<>();
        }
        return PageHelperUtils.convertPageDto2Vo(codeMainDTOS,
                CodeMainMapping.INSTANCE::toCodeMainVOList);
    }

    @Override
    public CodeMainVO getCodeMainById(Integer id) {
        return CodeMainMapping.INSTANCE.toCodeMainVO(getById(id));
    }

    @Override
    public List<OptionModel> listOptionModelByCodeName(String name) {
        return baseMapper.selectCodeMainAsModelListByCodeName(name);
    }

    @Override
    public void addOrUpdateCodeMain(CodeMainQuery codeMainQuery) {
        CodeMainDTO codeMainDTO = CodeMainMapping.INSTANCE.toCodeMainDTO(codeMainQuery);
        if (codeMainQuery.getId() == null) {
            codeMainDTO.setCreateTime(LocalDateTime.now());
        }
        this.saveOrUpdate(CodeMainMapping.INSTANCE.toCodeMain(codeMainDTO));
    }

    @Override
    public void deleteCodeMain(List<Integer> ids) {
        remove(Wrappers.<CodeMain>lambdaUpdate()
                .in(CodeMain::getId, ids));
    }
}
