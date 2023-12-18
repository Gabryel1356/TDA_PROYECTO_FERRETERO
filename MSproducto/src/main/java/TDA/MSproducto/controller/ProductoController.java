package TDA.MSproducto.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import TDA.MSproducto.model.modeloProducto;
import TDA.MSproducto.services.IProductoService;

import TDA.MSproducto.dto.ProductoRequest;
import TDA.MSproducto.mensaje.ProductoConsumerListener;;

@RestController
@RequestMapping("/api/producto")
public class ProductoController {

    @Autowired
    IProductoService productoService;

    Logger logger = LoggerFactory.getLogger(ProductoController.class);

    @Autowired
    ProductoConsumerListener messageEvent;

    @GetMapping()
    public List<modeloProducto> get() {
        logger.info("CONTROLLER: modeloProducto");
        return productoService.obtener();
    }

    @PostMapping()
    public ResponseEntity<?> registrar(@RequestBody ProductoRequest request) throws Exception {
        logger.info(
                "Post: idProducto {} - nombre {} - descripcion {} - fechaFabricacion {} - costoCompra {} - stock {} - imagenRuta {} - nombreUnidad {}",
                request.getIdproduct(), request.getNombrepro(), request.getImagenruta(), request.getNombreunidad(),
                request.getStock(), request.getFechafa(), request.getCostocompra(), request.getDescripcion());

        modeloProducto ModeloProducto = new modeloProducto();
        ModeloProducto.setIdproduct(request.getIdproduct());
        ModeloProducto.setNombrepro(request.getNombrepro());

        ModeloProducto = productoService.agregar(ModeloProducto);
        logger.info("modeloProducto {}", ModeloProducto);
        messageEvent.sendDepositEvent(ModeloProducto);
        return ResponseEntity.status(HttpStatus.CREATED).body(ModeloProducto);
    }

    @GetMapping("/{idProducto}")
    public ResponseEntity<?> obtenerUsuarioPorId(@RequestBody int idProducto) {

        logger.info("CONTROLLER: Get By idProducto: {}", idProducto);
        Iterable<modeloProducto> Producto = productoService.obtenerProductoPorid(idProducto);
        return ResponseEntity.ok(Producto);
    }

}
