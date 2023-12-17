package TDA.MSproducto.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import TDA.MSproducto.model.modeloProducto;
import TDA.MSproducto.repository.IProductoRepository;

import TDA.MSproducto.services.ProductoService;
import jakarta.transaction.Transactional;

@Service
public class ProductoService implements IProductoService {

    Logger logger = LoggerFactory.getLogger(ProductoService.class);

    @Autowired
    IProductoRepository iProductoRepository;

    @Override
    @Transactional
    public List<modeloProducto> obtener() {
        return (List<modeloProducto>) iProductoRepository.findAll();
    }

    @Override
    @Transactional
    public modeloProducto agregar(modeloProducto mProducto) {
        return iProductoRepository.save(mProducto);
    }

    @Override
    @Cacheable(cacheNames = { "producto" }, key = "#idProducto")
    public List<modeloProducto> obtenerProductoPorid(int idProducto) {
        logger.info("SERVICES: Get Find By idProducto: {}", idProducto);
        return (List<modeloProducto>) iProductoRepository.findAll();
    }

    @Override
    @Transactional
    public modeloProducto ModificarProducto( modeloProducto producto) {
       return iProductoRepository.save(producto);
    }

}
