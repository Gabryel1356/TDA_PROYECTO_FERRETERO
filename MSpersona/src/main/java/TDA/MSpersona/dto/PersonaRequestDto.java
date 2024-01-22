package TDA.MSpersona.dto;
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


public class PersonaRequestDto {

    private int idpersona;
    private int tiopodocumento;
    private String nombre;
    private String apepaterno;
    private String apematerno;
    private String fechanacimiento;
    private String telefono;
    private String correo;
    private int sexo;
    private String direccion;
    private int tipopersona;

 
    
}
