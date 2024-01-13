package TDA.MSventa.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "venta")
public class modeloVenta implements Serializable {
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


    public int getUnidades() {
        return unidades;
    }

    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }

}
