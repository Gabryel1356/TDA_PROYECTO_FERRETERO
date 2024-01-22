package TDA.MSgenEnumerador.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Getter
@Setter

public class genEnumeradorRequestDto {
    
    private String id;
    private int idgenenum;
    private int tipopersona;
    private int tipodocumento;
    private int sexo;
    


}
