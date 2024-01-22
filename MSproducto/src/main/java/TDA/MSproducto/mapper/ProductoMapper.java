package TDA.MSproducto.mapper;

import org.mapstruct.Mapper;

import org.mapstruct.factory.Mappers;

import TDA.MSproducto.dto.ProductoRequestDto;
import TDA.MSproducto.model.modeloProducto;



@Mapper
public interface ProductoMapper {

    ProductoMapper mapper = Mappers.getMapper(ProductoMapper.class);

    ProductoRequestDto productoRequestDto(modeloProducto productomodelo);

    modeloProducto productomodelo(ProductoRequestDto productoRequestdto);

}
