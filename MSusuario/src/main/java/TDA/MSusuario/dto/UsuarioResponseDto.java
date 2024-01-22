
 package TDA.MSusuario.dto;

 import lombok.AllArgsConstructor;
 import lombok.Builder;
 import lombok.Data;
 import lombok.Getter;
 import lombok.Setter;
 
 
 @Data

 @AllArgsConstructor
 
 @Getter 
 @Setter
 @Builder

public class UsuarioResponseDto {

    private final String NombreUsuario;
    private final String token;
    private final String accessTokenExpiration;  
}