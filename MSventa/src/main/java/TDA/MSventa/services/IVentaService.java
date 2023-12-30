package TDA.MSventa.services;

import java.util.List;
import java.util.Optional;

import TDA.MSventa.model.modeloVenta;

public interface IVentaService {
    
public List<modeloVenta> obtener();

    public modeloVenta agregar(modeloVenta venta);

    public Optional<modeloVenta> obtenerVentaPorid(int idventa);

    public modeloVenta ModificarVenta( int idventa , modeloVenta venta);

     public void DeleteVenta(  int venta );
    
} 
