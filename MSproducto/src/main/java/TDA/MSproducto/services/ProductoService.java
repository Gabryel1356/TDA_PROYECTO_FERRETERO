package TDA.MSproducto.services;

import java.util.List;
//import java.util.Objects;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
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
    IProductoRepository productoRepository;

    @Override
    @Transactional
    public List<modeloProducto> obtener() {
        return (List<modeloProducto>) productoRepository.findAll();
    }

    @Override
    @Transactional
    public modeloProducto agregar(modeloProducto producto) {
        return productoRepository.save(producto);
    }

    @Override
    @Cacheable("modeloProducto")
    public Optional<modeloProducto> obtenerProductoPorid(int id) {
        return productoRepository.findById(id);
    }

    @Override
    @CachePut(cacheNames = "modeloProducto", key = "#idproduct")
    public modeloProducto ModificarProducto(int idproducto, modeloProducto producto) {
        modeloProducto mp = productoRepository.findById(idproducto).get();

       // if (Objects.nonNull(producto.getNombrepro()) && !"".equalsIgnoreCase(producto.getNombrepro())) {
       //     mp.setNombrepro(producto.getNombrepro());
       // }

        return productoRepository.save(mp);
    }

    @Override
    @Transactional
    public void DeleteProducto(int idproduct) {

        productoRepository.deleteById(idproduct);

    }

}
