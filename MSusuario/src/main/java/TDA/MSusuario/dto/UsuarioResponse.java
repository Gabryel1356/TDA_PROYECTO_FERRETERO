
 package TDA.MSusuario.dto;

import java.io.Serializable;

public class UsuarioResponse implements Serializable {

    
    private final String NombreUsuario;
    private final String token;
    private final String accessTokenExpiration;


    public UsuarioResponse(String nombreUsuario, String token, String accessTokenExpiration) {
        this.NombreUsuario = nombreUsuario;
        this.token = token;
        this.accessTokenExpiration = accessTokenExpiration;

    }

    public String getNombreUsuario() {
        return NombreUsuario;
    }

    public String getToken() {
        return token;
    }

    public String getAccessTokenExpiration() {
        return accessTokenExpiration;
    }
    
    
}