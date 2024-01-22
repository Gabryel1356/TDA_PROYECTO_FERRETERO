package TDA.MSventa.mapper;

import org.mapstruct.Mapper;

import org.mapstruct.factory.Mappers;

import TDA.MSventa.dto.VentaRequestDto;
import TDA.MSventa.model.ModeloVenta;





@Mapper
public interface VentaMapper {

    VentaMapper mapper = Mappers.getMapper(VentaMapper.class);

    VentaRequestDto ventaRequestdto(ModeloVenta ventamodelo);

    ModeloVenta ventamodelo(VentaRequestDto ventaRequestdto);

}
