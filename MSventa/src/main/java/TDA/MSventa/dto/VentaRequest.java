
package TDA.MSventa.dto;

import java.io.Serializable;



public class VentaRequest implements Serializable {


    private int idventa;
    private int idproduct;
    private int unidades; 
    private String fechaventa;
    private double igv;
    private double subtotal;
    private double costoventa;
    
    

    public VentaRequest() {
    }

    public VentaRequest(int idventa, String fechaventa, double igv, double subtotal, double costoventa,int unidades) {
        this.setIdventa(idventa);
        this.setFechaventa(fechaventa);
        this.setIgv(igv);
        this.setSubtotal(subtotal);
        this.setCostoventa(costoventa);
        this.setUnidades(unidades);
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



    public int getIdproduct() {
        return idproduct;
    }

    public void setIdproduct(int idproducto) {
        this.idproduct = idproducto;
    }

    public int getUnidades() {
        return unidades;
    }

    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }





  
}
