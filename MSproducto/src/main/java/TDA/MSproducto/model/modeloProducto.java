package TDA.MSproducto.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

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

  

    public int getIdproduct() {
        return idproduct;
    }

    public void setIdproduct(int idproduct) {
        this.idproduct = idproduct;
    }

    public String getNombrepro() {
        return nombrepro;
    }

    public void setNombrepro(String nombrepro) {
        this.nombrepro = nombrepro;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFechafa() {
        return fechafa;
    }

    public void setFechafa(String fechafa) {
        this.fechafa = fechafa;
    }

    public double getCostocompra() {
        return costocompra;
    }

    public void setCostocompra(double costocompra) {
        this.costocompra = costocompra;
    }

    public double getStock() {
        return stock;
    }

    public void setStock(double stock) {
        this.stock = stock;
    }

    public String getImagenruta() {
        return imagenruta;
    }

    public void setImagenruta(String imagenruta) {
        this.imagenruta = imagenruta;
    }

    public String getNombreunidad() {
        return nombreunidad;
    }

    public void setNombreunidad(String nombreunidad) {
        this.nombreunidad = nombreunidad;
    }

}
