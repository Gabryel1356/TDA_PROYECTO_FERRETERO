package TDA.MSventa.services;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

import TDA.MSventa.model.modeloVenta;
import TDA.MSventa.repository.IventaRepository;
import jakarta.transaction.Transactional;

public class VentaService implements IVentaService {

Logger logger = LoggerFactory.getLogger(VentaService.class);

    @Autowired
    IventaRepository VentaRepository;

    @Override
    @Transactional
    public List<modeloVenta> obtener() {
        return (List<modeloVenta>) VentaRepository.findAll();
    }

    @Override
    @Transactional
    public modeloVenta agregar(modeloVenta venta) {
        return VentaRepository.save(venta);
    }

    @Override
    @Cacheable("modeloVenta")
    public Optional<modeloVenta> obtenerVentaPorid(int id) {
        return VentaRepository.findById(id);
    }

    @Override
    @CachePut(cacheNames = "modeloVenta", key = "#idventa")
    public modeloVenta ModificarVenta(int idventa, modeloVenta venta) {
        modeloVenta mv = VentaRepository.findById(idventa).get();

   

        return VentaRepository.save(mv);
    }

    @Override
    @Transactional
    public void DeleteVenta(int idventa) {

        VentaRepository.deleteById(idventa);

    }
    
}