package TDA.MSproducto.services;

import java.util.List;

import TDA.MSproducto.model.modeloProducto;

public interface IProductoService {

    public List<modeloProducto> obtener();

    public modeloProducto agregar(modeloProducto producto);

    public List<modeloProducto> obtenerProductoPorid(int idproducto);

    public modeloProducto ModificarProducto( modeloProducto producto );

}
