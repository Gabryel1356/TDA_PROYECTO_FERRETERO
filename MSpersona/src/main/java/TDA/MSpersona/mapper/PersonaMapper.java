package TDA.MSpersona.mapper;

import org.mapstruct.Mapper;

import org.mapstruct.factory.Mappers;

import TDA.MSpersona.dto.PersonaRequestDto;
import TDA.MSpersona.model.ModeloPersona;


@Mapper
public interface PersonaMapper {

    PersonaMapper mapper = Mappers.getMapper(PersonaMapper.class);

    PersonaRequestDto personaRequestdto(ModeloPersona persona);

    ModeloPersona personamodelo(PersonaRequestDto personaRequestdto);
}
