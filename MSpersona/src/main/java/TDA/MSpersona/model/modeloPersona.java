package TDA.MSpersona.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "persona")
public class modeloPersona implements Serializable {

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


    
    public int getIdpersona() {
        return idpersona;
    }
    public void setIdpersona(int idpersona) {
        this.idpersona = idpersona;
    }
    public int getTiopodocumento() {
        return tiopodocumento;
    }
    public void setTiopodocumento(int tiopodocumento) {
        this.tiopodocumento = tiopodocumento;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApepaterno() {
        return apepaterno;
    }
    public void setApepaterno(String apepaterno) {
        this.apepaterno = apepaterno;
    }
    public String getApematerno() {
        return apematerno;
    }
    public void setApematerno(String apematerno) {
        this.apematerno = apematerno;
    }
    public String getFechanacimiento() {
        return fechanacimiento;
    }
    public void setFechanacimiento(String fechanacimiento) {
        this.fechanacimiento = fechanacimiento;
    }
    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public String getCorreo() {
        return correo;
    }
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    public int getSexo() {
        return sexo;
    }
    public void setSexo(int sexo) {
        this.sexo = sexo;
    }
    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public int getTipopersona() {
        return tipopersona;
    }
    public void setTipopersona(int tipopersona) {
        this.tipopersona = tipopersona;
    }



    
}
