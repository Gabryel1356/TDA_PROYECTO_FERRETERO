package TDA.MSproducto.model;

import java.io.Serializable;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder

@Entity
@Table(name = "product")
public class modeloProducto implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "idproduct")
    private int idproduct;

    @Column(name = "nombrepro")
    private String nombrepro;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "fechafa")
    private String fechafa;

    @Column(name = "costocompra")
    private double costocompra;

    @Column(name = "stock")
    private double stock;

    @Column(name = "imagenruta")
    private String imagenruta;

    @Column(name = "nombreunidad")
    private String nombreunidad;

}
