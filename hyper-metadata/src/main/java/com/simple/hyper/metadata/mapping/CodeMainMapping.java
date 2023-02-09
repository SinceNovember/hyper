package com.simple.hyper.metadata.mapping;

import com.simple.hyper.metadata.model.dto.CodeMainDTO;
import com.simple.hyper.metadata.model.entity.CodeMain;
import com.simple.hyper.metadata.model.query.CodeMainQuery;
import com.simple.hyper.metadata.model.vo.CodeMainVO;
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
public interface CodeMainMapping {

    CodeMainMapping INSTANCE = Mappers.getMapper(CodeMainMapping.class);

    List<CodeMainVO> toCodeMainVOList(List<CodeMainDTO> codeMainDTO);

    CodeMainVO toCodeMainVO(CodeMainDTO codeMainDTO);

    CodeMainVO toCodeMainVO(CodeMain codeMain);

    CodeMainDTO toCodeMainDTO(CodeMainQuery codeMainQuery);

    CodeMain toCodeMain(CodeMainDTO codeMainDTO);

}
