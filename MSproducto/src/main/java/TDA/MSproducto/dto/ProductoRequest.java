
package TDA.MSproducto.dto;

import java.io.Serializable;

public class ProductoRequest implements Serializable {

 

    private Integer idproduct;
    private String nombrepro;
    private String descripcion;
    private String fechafa;
    private Double costocompra;
    private Double stock;
    private String imagenruta;
    private String nombreunidad;
    private int idventa;
    

    public int getIdventa() {
        return idventa;
    }

    public void setIdventa(int id) {
        this.idventa = id;
    }

    public ProductoRequest() {
    }

    public ProductoRequest(int id, String nombrepro, String descripcion, String fechafa,
            Double costocompra, Double stock, String imagenruta, String nombreunidad) {
        this.setIdproduct(id);
        this.setNombrepro(nombrepro);
        this.setDescripcion(descripcion);
        this.setFechafa(fechafa);
        this.setCostocompra(costocompra);
        this.setStock(stock);
        this.setImagenruta(imagenruta);
        this.setNombreunidad(nombreunidad);
    }


    public Integer getIdproduct() {
        return idproduct;
    }

    public void setIdproduct(Integer idproduct) {
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

    public Double getCostocompra() {
        return costocompra;
    }

    public void setCostocompra(Double costocompra) {
        this.costocompra = costocompra;
    }

    public Double getStock() {
        return stock;
    }

    public void setStock(Double stock) {
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
