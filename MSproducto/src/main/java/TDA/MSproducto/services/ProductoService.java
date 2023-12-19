package TDA.MSproducto.services;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

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
    @Transactional
    public Optional<modeloProducto> obtenerProductoPorid(int id) {
        return productoRepository.findById(id);
    }

    @Override
    @Transactional
    public modeloProducto ModificarProducto(int idproducto, modeloProducto producto) {
        return productoRepository.save(producto);
    }

    @Override
    @Transactional
    public void DeleteProducto( int idproduct) {
       
        productoRepository.deleteById(idproduct);
    }

}
