package TDA.MSpersona.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder


public class PersonaRequest {

    private int idpersona;

    private int idempleado;

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
