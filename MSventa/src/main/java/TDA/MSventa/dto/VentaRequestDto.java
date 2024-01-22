
package TDA.MSventa.dto;


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
public class VentaRequestDto {

   
    private int idventa;
    private int unidades; 
    private String fechaventa;
    private double igv;
    private double subtotal;
    private double costoventa;
    
   
  
}
