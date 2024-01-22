package TDA.MSventa.model;

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
@Table(name = "venta")
public class ModeloVenta implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "idventa")
    private int idventa;

    @Column(name = "fechaventa")
    private String fechaventa;

    @Column(name = "igv")
    private double igv;

    @Column(name = "subtotal")
    private double subtotal;

    @Column(name = "costoventa")
    private double costoventa;

    @Column(name = "unidades")
    private int unidades;

}
