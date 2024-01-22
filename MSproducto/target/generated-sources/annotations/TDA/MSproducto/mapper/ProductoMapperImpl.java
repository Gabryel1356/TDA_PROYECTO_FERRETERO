package TDA.MSproducto.mapper;

import TDA.MSproducto.dto.ProductoRequestDto;
import TDA.MSproducto.model.modeloProducto;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-01-22T11:32:18-0500",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.37.0.v20240103-0614, environment: Java 17.0.9 (Eclipse Adoptium)"
)
public class ProductoMapperImpl implements ProductoMapper {

    @Override
    public ProductoRequestDto productoRequestDto(modeloProducto productomodelo) {
        if ( productomodelo == null ) {
            return null;
        }

        ProductoRequestDto.ProductoRequestDtoBuilder productoRequestDto = ProductoRequestDto.builder();

        productoRequestDto.costocompra( productomodelo.getCostocompra() );
        productoRequestDto.descripcion( productomodelo.getDescripcion() );
        productoRequestDto.fechafa( productomodelo.getFechafa() );
        productoRequestDto.idproduct( productomodelo.getIdproduct() );
        productoRequestDto.imagenruta( productomodelo.getImagenruta() );
        productoRequestDto.nombrepro( productomodelo.getNombrepro() );
        productoRequestDto.nombreunidad( productomodelo.getNombreunidad() );
        productoRequestDto.stock( productomodelo.getStock() );

        return productoRequestDto.build();
    }

    @Override
    public modeloProducto productomodelo(ProductoRequestDto productoRequestdto) {
        if ( productoRequestdto == null ) {
            return null;
        }

        modeloProducto.modeloProductoBuilder modeloProducto = modeloProducto.builder();

        if ( productoRequestdto.getCostocompra() != null ) {
            modeloProducto.costocompra( productoRequestdto.getCostocompra() );
        }
        modeloProducto.descripcion( productoRequestdto.getDescripcion() );
        modeloProducto.fechafa( productoRequestdto.getFechafa() );
        modeloProducto.idproduct( productoRequestdto.getIdproduct() );
        modeloProducto.imagenruta( productoRequestdto.getImagenruta() );
        modeloProducto.nombrepro( productoRequestdto.getNombrepro() );
        modeloProducto.nombreunidad( productoRequestdto.getNombreunidad() );
        if ( productoRequestdto.getStock() != null ) {
            modeloProducto.stock( productoRequestdto.getStock() );
        }

        return modeloProducto.build();
    }
}
