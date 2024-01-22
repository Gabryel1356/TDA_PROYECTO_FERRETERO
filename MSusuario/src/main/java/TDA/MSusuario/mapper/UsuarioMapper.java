package TDA.MSusuario.mapper;

import org.mapstruct.Mapper;

import org.mapstruct.factory.Mappers;

import TDA.MSusuario.dto.UsuarioRequestDto;
import TDA.MSusuario.model.ModelUsuario;

@Mapper
public interface UsuarioMapper {

    UsuarioMapper mapper = Mappers.getMapper(UsuarioMapper.class);

    UsuarioRequestDto usuarioRequestdto(ModelUsuario persona);

    ModelUsuario usuariomodelo(UsuarioRequestDto personaRequestdto);
}
