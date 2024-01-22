package TDA.MSventa.services;

import java.util.List;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import TDA.MSventa.mapper.VentaMapper;
import TDA.MSventa.dto.VentaRequestDto;
import TDA.MSventa.model.ModeloVenta;
import TDA.MSventa.repository.IventaRepository;
import jakarta.transaction.Transactional;

@Service
public class VentaService implements IVentaService {

    @Autowired
    IventaRepository ventaRepository;

    @Override
    public List<VentaRequestDto> obtener() {
        List<ModeloVenta> venta = ventaRepository.findAll();
        List<VentaRequestDto> response = venta.stream().map(
                mpventa -> VentaMapper.mapper.ventaRequestdto(mpventa)).collect(Collectors.toList());
        return response;
    }

    @Override
    @Transactional
    public void agregar(VentaRequestDto ventadto) {
        ModeloVenta venta = VentaMapper.mapper.ventamodelo(ventadto);
        if (venta != null) {
            ventaRepository.save(venta);
        }
    }

    @Override
    @CachePut(cacheNames = "VentaRequestDto", key = "#idventa")
    public VentaRequestDto ModificarVenta(VentaRequestDto ventadto, int id) {
        ModeloVenta venta = ventaRepository.findById(id).orElse(null);
        if (venta != null) {
            venta.setIdventa(ventadto.getIdventa());
            venta.setFechaventa(ventadto.getFechaventa());
            venta.setIgv(ventadto.getIgv());
            venta.setSubtotal(ventadto.getSubtotal());
            venta.setCostoventa(ventadto.getCostoventa());
            venta.setUnidades(ventadto.getUnidades());
            venta = ventaRepository.save(venta);
        }
        VentaRequestDto response = VentaMapper.mapper.ventaRequestdto(venta);
        return response;
    }

    @Override
    @Cacheable("VentaRequestDto")
    public VentaRequestDto obtenerVentaPorid(int id) {
        ModeloVenta venta = ventaRepository.findById(id).orElse(null);
        return VentaMapper.mapper.ventaRequestdto(venta);
    }

    @Override
    @Transactional
    public void DeleteVenta(int id) {
        ModeloVenta venta = ventaRepository.findById(id).orElse(null);
        if (venta != null) {
            ventaRepository.delete(venta);
        }
    }

}
