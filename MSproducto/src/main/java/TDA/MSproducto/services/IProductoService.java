package TDA.MSproducto.services;

import java.util.List;

import java.util.Optional;

import TDA.MSproducto.model.modeloProducto;

public interface IProductoService {

    public List<modeloProducto> obtener();

    public modeloProducto agregar(modeloProducto producto);

    public Optional<modeloProducto> obtenerProductoPorid(int idproducto);

    public modeloProducto ModificarProducto( int idproducto , modeloProducto producto);

     public void DeleteProducto(  int producto );
    
}
