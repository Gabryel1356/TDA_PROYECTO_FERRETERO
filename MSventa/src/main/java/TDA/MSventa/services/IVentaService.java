package TDA.MSventa.services;

import java.util.List;


import TDA.MSventa.dto.VentaRequestDto;


public interface IVentaService {
    
    public List<VentaRequestDto> obtener();
    public void agregar(VentaRequestDto ventadto);
    public VentaRequestDto obtenerVentaPorid(int idventa);
    public VentaRequestDto ModificarVenta(  VentaRequestDto ventadto, int idventa );
    public void DeleteVenta(  int venta );
    
} 
