package TDA.MSproducto.services;

import java.util.List;



import TDA.MSproducto.dto.ProductoRequestDto;


public interface IProductoService {

    public List<ProductoRequestDto> obtener();

    public void agregar(ProductoRequestDto productoRequesdto);

    public ProductoRequestDto obtenerProductoPorid(int idproducto);

    public ProductoRequestDto ModificarProducto( int idproducto , ProductoRequestDto productoRequesdto);

     public void DeleteProducto(  int idproducto );
    
}
