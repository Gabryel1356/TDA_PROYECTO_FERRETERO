package TDA.MSproducto.services;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import TDA.MSproducto.dto.ProductoRequestDto;
import TDA.MSproducto.mapper.ProductoMapper;
import TDA.MSproducto.model.modeloProducto;
import TDA.MSproducto.repository.IProductoRepository;

import TDA.MSproducto.services.ProductoService;
import jakarta.transaction.Transactional;

@Service
public class ProductoService implements IProductoService {

    @Autowired
    IProductoRepository productoRepository;

    @Override
    public List<ProductoRequestDto> obtener() {
        List<modeloProducto> producto = productoRepository.findAll();
        List<ProductoRequestDto> response = producto.stream().map(
                mpproducto -> ProductoMapper.mapper.productoRequestDto(mpproducto)).collect(Collectors.toList());
        return response;
    }

    @Override
    @Transactional
    public void agregar(ProductoRequestDto productodto) {
        modeloProducto producto = ProductoMapper.mapper.productomodelo(productodto);
        if (producto != null) {
            productoRepository.save(producto);
        }
    }

    @Override
    @CachePut(cacheNames = "ProductoRequestDto", key = "#idproduct")
    public ProductoRequestDto ModificarProducto(int id, ProductoRequestDto productoRequesdto) {
        modeloProducto producto = productoRepository.findById(id).orElse(null);
        if (producto != null) {
            producto.setIdproduct(productoRequesdto.getIdproduct());
            producto.setNombrepro(productoRequesdto.getNombrepro());
            producto.setDescripcion(productoRequesdto.getDescripcion());
            producto.setFechafa(productoRequesdto.getFechafa());
            producto.setCostocompra(productoRequesdto.getCostocompra());
            producto.setStock(productoRequesdto.getStock());
            producto.setImagenruta(productoRequesdto.getImagenruta());
            producto.setNombreunidad(productoRequesdto.getNombreunidad());
            producto = productoRepository.save(producto);
        }
        ProductoRequestDto response = ProductoMapper.mapper.productoRequestDto(producto);
        return response;
    }

    @Override
    @Cacheable("ProductoRequestDto")
    public ProductoRequestDto obtenerProductoPorid(int id) {
        modeloProducto producto = productoRepository.findById(id).orElse(null);
        return ProductoMapper.mapper.productoRequestDto(producto);
    }

    @Override
    @Transactional
    public void DeleteProducto(int id) {
        modeloProducto producto = productoRepository.findById(id).orElse(null);
        if (producto != null) {
            productoRepository.delete(producto);
        }
    }

}
