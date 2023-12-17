package TDA.MSproducto.controller;

import java.util.List;

import org.apache.kafka.common.requests.ProduceRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import TDA.MSproducto.model.modeloProducto;
import TDA.MSproducto.services.IProductoService;
import TDA.MSproducto.services.ProductoService;
import TDA.MSproducto.dto.ProductoRequest;
import TDA.MSproducto.mensaje.ProductoConsumerListener;;

@RestController
@RequestMapping("/api/prodcuto")
public class ProductoController {
    @Autowired
    IProductoService iProductoService;
    Logger logger = LoggerFactory.getLogger(ProductoService.class);

    @Autowired
    ProductoConsumerListener messageEvent;

    @GetMapping("listar")
    public List<modeloProducto> listar() {
        logger.info("CONTROLLER: modeloProducto");
        return (List<modeloProducto>) iProductoService.obtener();
    }

    @PostMapping("/registrar")
    public ResponseEntity<?> registrar(@RequestBody ProductoRequest request) throws Exception {
        logger.info(
                "Post: idProducto {} - nombre {} - descripcion {} - fechaFabricacion {} - costoCompra {} - stock {} - imagenRuta {} - nombreUnidad {}",
                request.getIdProducto(), request.getNombre(), request.getImagenRuta(), request.getNombreUnidad(),
                request.getStock(), request.getFechaFabricacion(), request.getCostoCompra(), request.getDescripcion());

        modeloProducto ModeloProducto = new modeloProducto();
        ModeloProducto.setIdProducto(request.getIdProducto());
        ModeloProducto.setNombre(request.getNombre());

        ModeloProducto = iProductoService.agregar(ModeloProducto);
        logger.info("modeloProducto {}", ModeloProducto);
        messageEvent.sendDepositEvent(ModeloProducto);
        return ResponseEntity.status(HttpStatus.CREATED).body(ModeloProducto);
    }

    @GetMapping("/{idProducto}")
    public ResponseEntity<?> obtenerUsuarioPorId(@RequestBody int idProducto) {

        logger.info("CONTROLLER: Get By idProducto: {}", idProducto);
        Iterable<modeloProducto> Producto = iProductoService.obtenerProductoPorid(idProducto);
        return ResponseEntity.ok(Producto);
    }

   
   

}
