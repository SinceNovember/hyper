package com.simple.hyper.metadata.mapping;

import com.simple.hyper.metadata.model.dto.CodeItemDTO;
import com.simple.hyper.metadata.model.entity.CodeItem;
import com.simple.hyper.metadata.model.query.CodeItemQuery;
import com.simple.hyper.metadata.model.vo.CodeItemVO;
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
public interface CodeItemMapping {

    CodeItemMapping INSTANCE = Mappers.getMapper(CodeItemMapping.class);

    List<CodeItemVO> toCodeItemVOList(List<CodeItemDTO> codeItemDTO);

    CodeItemVO toCodeItemVO(CodeItemDTO codeItemDTO);

    CodeItemVO toCodeItemVO(CodeItem codeItem);

    CodeItemDTO toCodeItemDTO(CodeItemQuery codeItemQuery);

    CodeItem toCodeItem(CodeItemDTO codeItemDTO);

}
