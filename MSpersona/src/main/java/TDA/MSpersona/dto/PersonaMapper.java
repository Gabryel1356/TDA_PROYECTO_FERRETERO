package TDA.MSpersona.dto;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import TDA.MSpersona.model.ModeloPersona;

@Mapper
public interface PersonaMapper {
    
    PersonaMapper mapper = Mappers.getMapper(PersonaMapper.class);

    @Mapping(source = "idpersona" , target = "idpersona")
    PersonaRequest personarequesmodelo(ModeloPersona persona);

    @Mapping(source = "idpersona" , target = "idpersona")
    ModeloPersona modelopersonarequest(PersonaRequest personareq);



}
