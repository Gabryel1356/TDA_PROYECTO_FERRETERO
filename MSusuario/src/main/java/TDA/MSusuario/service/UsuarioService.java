package TDA.MSusuario.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import TDA.MSusuario.model.modelUsuario;
import TDA.MSusuario.repository.IUsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    IUsuarioRepository usuarioRepository;

    public List<modelUsuario> getAcces() {

        return (List<modelUsuario>) usuarioRepository.findAll();
    }

    public Boolean validatedCredentials(String nombreusuario, String clave) {
        List<modelUsuario> result = (List<modelUsuario>) usuarioRepository.findAll();
        List<modelUsuario> resultFilter = result.stream()
                .filter(t -> t.getNombreusuario().equals(nombreusuario) && t.getClave().equals(clave))
                .collect(Collectors.toList());
        if (null == resultFilter || resultFilter.isEmpty()) {
            return false;
        }
        return true;
    }

}