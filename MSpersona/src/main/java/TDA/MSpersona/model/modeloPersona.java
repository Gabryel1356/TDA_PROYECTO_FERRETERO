package TDA.MSpersona.model;

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
@Table(name = "persona")
public class ModeloPersona implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "idpersona")
    private int idpersona;
    @Column(name = "tiopodocumento")
    private int tiopodocumento;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "apepaterno")
    private String apepaterno;
    @Column(name = "apematerno")
    private String apematerno;
    @Column(name = "fechanacimiento")
    private String fechanacimiento;
    @Column(name = "telefono")
    private String telefono;
    @Column(name = "correo")
    private String correo;
    @Column(name = "sexo")
    private int sexo;
    @Column(name = "direccion")
    private String direccion;
    @Column(name = "tipopersona")
    private int tipopersona;



 
}
