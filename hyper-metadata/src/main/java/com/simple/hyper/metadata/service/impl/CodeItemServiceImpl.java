package com.simple.hyper.metadata.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageSerializable;
import com.simple.hyper.common.utils.PageHelperUtils;
import com.simple.hyper.metadata.mapper.CodeItemMapper;
import com.simple.hyper.metadata.mapping.CodeItemMapping;
import com.simple.hyper.metadata.model.dto.CodeItemDTO;
import com.simple.hyper.metadata.model.entity.CodeItem;
import com.simple.hyper.metadata.model.query.CodeItemQuery;
import com.simple.hyper.metadata.model.vo.CodeItemVO;
import com.simple.hyper.metadata.service.ICodeItemService;
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
public class CodeItemServiceImpl extends
        ServiceImpl<CodeItemMapper, CodeItem> implements
        ICodeItemService {

    @Override
    public PageSerializable<CodeItemVO> pageCodeItem(CodeItemQuery codeItemQuery) {
        PageHelperUtils.startPage(codeItemQuery);
        List<CodeItemDTO> codeItemDTOS = baseMapper.selectCodeItemList(
                codeItemQuery);

        if (CollectionUtils.isEmpty(codeItemDTOS)) {
            return new PageSerializable<>();
        }
        return PageHelperUtils.convertPageDto2Vo(codeItemDTOS,
                CodeItemMapping.INSTANCE::toCodeItemVOList);
    }

    @Override
    public void addOrUpdateCodeItem(CodeItemQuery codeItemQuery) {
        CodeItemDTO codeItemDTO = CodeItemMapping.INSTANCE.toCodeItemDTO(
                codeItemQuery);
        if (codeItemQuery.getId() == null) {
            codeItemDTO.setCreateTime(LocalDateTime.now());
        }
        this.saveOrUpdate(CodeItemMapping.INSTANCE.toCodeItem(codeItemDTO));
    }

    @Override
    public CodeItemVO getCodeItemById(Integer id) {
        return CodeItemMapping.INSTANCE.toCodeItemVO(getById(id));
    }

    @Override
    public void deleteCodeItem(List<Integer> ids) {
        remove(Wrappers.<CodeItem>lambdaUpdate()
                .in(CodeItem::getId, ids));
    }
}
