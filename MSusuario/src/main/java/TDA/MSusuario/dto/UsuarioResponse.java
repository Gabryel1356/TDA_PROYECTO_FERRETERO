
 package TDA.MSusuario.dto;

import java.io.Serializable;

public class UsuarioResponse implements Serializable {

    private final String NombreUsuario;

    public UsuarioResponse(String nombreUsuario) {
        NombreUsuario = nombreUsuario;
    }

    public String getNombreUsuario() {
        return NombreUsuario;
    }
    
    
}