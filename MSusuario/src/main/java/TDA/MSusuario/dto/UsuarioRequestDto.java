package TDA.MSusuario.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Getter
@Setter
@Builder
public class UsuarioRequestDto {

    private Integer idusuario;    
    private String nombreusuario;
    private String clave;

}