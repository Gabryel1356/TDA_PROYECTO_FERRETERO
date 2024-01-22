package TDA.MSproducto.dto;

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

public class ProductoRequestDto {

    private int idproduct;
    private String nombrepro;
    private String descripcion;
    private String fechafa;
    private Double costocompra;
    private Double stock;
    private String imagenruta;
    private String nombreunidad;



}
