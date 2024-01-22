package TDA.MSusuario.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import TDA.MSusuario.dto.UsuarioRequestDto;
import TDA.MSusuario.mapper.UsuarioMapper;
import TDA.MSusuario.model.ModelUsuario;
import TDA.MSusuario.repository.IUsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    IUsuarioRepository usuarioRepository;

    public List<UsuarioRequestDto> obtenerAcceso() {
        List<ModelUsuario> usuario = usuarioRepository.findAll();

        List<UsuarioRequestDto> rq = usuario.stream().map(
                mpusuario -> UsuarioMapper.mapper.usuarioRequestdto(mpusuario)).collect(Collectors.toList());
        return rq;
    }

    public Boolean validatedCredentials(String nombreusuario, String clave) {
        List<ModelUsuario> result = (List<ModelUsuario>) usuarioRepository.findAll();
        List<ModelUsuario> resultFilter = result.stream()
                .filter(mpusuario -> mpusuario.getNombreusuario().equals(nombreusuario)
                        && mpusuario.getClave().equals(clave))
                .collect(Collectors.toList());
        if (null == resultFilter || resultFilter.isEmpty()) {
            return false;
        }
        return true;
    }

}