package TDA.MSgenEnumerador.mapper;

import org.mapstruct.Mapper;

import org.mapstruct.factory.Mappers;

import TDA.MSgenEnumerador.dto.genEnumeradorRequestDto;
import TDA.MSgenEnumerador.model.modeloGenEnumerador;




@Mapper
public interface genEnumeradorMapper {

    genEnumeradorMapper mapper = Mappers.getMapper(genEnumeradorMapper.class);

    genEnumeradorRequestDto GenEnumeradorRequestdto(modeloGenEnumerador GenEnumeradorModel);

    modeloGenEnumerador GenEnumeradorModel(genEnumeradorRequestDto personaRequestdto);
}
