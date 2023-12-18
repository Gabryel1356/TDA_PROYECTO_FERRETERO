
package TDA.MSproducto.dto;

import java.io.Serializable;

public class ProductoRequest implements Serializable {

    private static final long serialVersionUID = 1L;
    private int idProducto;
    private String nombre;
    private String descripcion;
    private String fechaFabricacion;
    private Double costoCompra;
    private Double stock;
    private String imagenRuta;
    private String nombreUnidad;

    

    public ProductoRequest() {
    }

    public ProductoRequest(int idProducto, String nombre, String descripcion, String fechaFabricacion,
            Double costoCompra, Double stock, String imagenRuta, String nombreUnidad) {
        this.setIdProducto(idProducto); 
        this.setNombre(nombreUnidad);
        this.setDescripcion(descripcion);
        this.setFechaFabricacion(fechaFabricacion);
        this.setCostoCompra(costoCompra);
        this.setStock(stock);
        this.setImagenRuta(imagenRuta);
        this.setNombreUnidad(nombreUnidad);
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFechaFabricacion() {
        return fechaFabricacion;
    }

    public void setFechaFabricacion(String fechaFabricacion) {
        this.fechaFabricacion = fechaFabricacion;
    }

    public Double getCostoCompra() {
        return costoCompra;
    }

    public void setCostoCompra(Double costoCompra) {
        this.costoCompra = costoCompra;
    }

    public Double getStock() {
        return stock;
    }

    public void setStock(Double stock) {
        this.stock = stock;
    }

    public String getImagenRuta() {
        return imagenRuta;
    }

    public void setImagenRuta(String imagenRuta) {
        this.imagenRuta = imagenRuta;
    }

    public String getNombreUnidad() {
        return nombreUnidad;
    }

    public void setNombreUnidad(String nombreUnidad) {
        this.nombreUnidad = nombreUnidad;
    }

}
