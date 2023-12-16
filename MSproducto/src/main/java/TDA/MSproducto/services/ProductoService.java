package TDA.MSproducto.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import TDA.MSproducto.model.modeloProducto;
import TDA.MSproducto.repository.IProductoRepository;

@Service
public class ProductoService {

    @Autowired
    IProductoRepository ProductoRepository;

    public List<modeloProducto> getProducto() {
        return (List<modeloProducto>) ProductoRepository.findAll();
    }

    public modeloProducto PostProducto(modeloProducto producto) {
        return ProductoRepository.save(producto);
    }

    public Optional<modeloProducto> getProductoPorId(int id) {
        return ProductoRepository.findById(id);
    }

    public void updateEmployee(int id, modeloProducto producto) {
        ProductoRepository.save(producto);
    }

    public boolean DeleteProducto(modeloProducto id) {
        try {
            ProductoRepository.delete(id);
            return true;
        } catch (Exception err) {
            return false;
        }
    }

}
