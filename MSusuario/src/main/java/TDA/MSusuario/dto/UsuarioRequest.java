package TDA.MSusuario.dto;

import java.io.Serializable;

public class UsuarioRequest implements Serializable {
    private String nombreusuario;
    private String clave;

    public UsuarioRequest() {
    }

    public UsuarioRequest(String nombreusuario, String clave) {
        this.setNombreusuario(nombreusuario);
        ;
        this.setClave(clave);
        ;
    }

    public String getNombreusuario() {
        return nombreusuario;
    }

    public void setNombreusuario(String nombreusuario) {
        this.nombreusuario = nombreusuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

}