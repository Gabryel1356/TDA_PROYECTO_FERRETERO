package TDA.MSusuario.model;

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
@Table(name = "usuario")
public class ModelUsuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idusuario")
    private Integer idusuario;    

    @Column(name = "nombreusuario")
    private String nombreusuario;

    @Column(name = "clave")
    private String clave;

}