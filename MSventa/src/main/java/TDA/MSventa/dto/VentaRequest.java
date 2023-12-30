
package TDA.MSventa.dto;

import java.io.Serializable;



public class VentaRequest implements Serializable {


    private int idventa;
    private String fechaventa;
    private double igv;
    private double subtotal;
    private double costoventa;
    private String tipocomprobante;
    

    public VentaRequest() {
    }


    public VentaRequest(int idventa, String fechaventa, double igv, double subtotal, double costoventa,String tipocomprobante) {
        this.setIdventa(idventa);
        this.setFechaventa(fechaventa);
        this.setIgv(igv);
        this.setSubtotal(subtotal);
        this.setCostoventa(costoventa);
        this.setTipocomprobante(tipocomprobante);
    }


    public int getIdventa() {
        return idventa; 
    }


    public void setIdventa(int idventa) {
        this.idventa = idventa;
    }


    public String getFechaventa() {
        return fechaventa;
    }


    public void setFechaventa(String fechaventa) {
        this.fechaventa = fechaventa;
    }


    public double getIgv() {
        return igv;
    }


    public void setIgv(double igv) {
        this.igv = igv;
    }


    public double getSubtotal() {
        return subtotal;
    }


    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }


    public double getCostoventa() {
        return costoventa;
    }


    public void setCostoventa(double costoventa) {
        this.costoventa = costoventa;
    }


    public String getTipocomprobante() {
        return tipocomprobante;
    }


    public void setTipocomprobante(String tipocomprobante) {
        this.tipocomprobante = tipocomprobante;
    }





  
}
