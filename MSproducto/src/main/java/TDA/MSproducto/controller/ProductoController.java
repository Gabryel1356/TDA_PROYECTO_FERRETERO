package TDA.MSproducto.controller;

import java.util.List;
import java.util.Optional;

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

import TDA.MSproducto.dto.ProductoRequest;
import TDA.MSproducto.message.Mensajeria;

@RestController
@RequestMapping("/api/producto")
public class ProductoController {

    @Autowired
    IProductoService productoService;

    Logger logger = LoggerFactory.getLogger(ProductoController.class);

    @Autowired
    Mensajeria messageEvent;

    @GetMapping("/listar")
    public ResponseEntity<?> Listar() {

        try {
            List<modeloProducto> ListarProducto = productoService.obtener();
            logger.debug("CONTROLLER: ListarProducto");

            return ResponseEntity.ok(ListarProducto);

        } catch (Exception e) {
            logger.error("SE ENCONTRO UN ERROR: {}", e);
            return ResponseEntity.ok(messageEvent.MSGEROR() + e);
        }

    }

    @PostMapping("/registrar")
    public ResponseEntity<?> registrar(@RequestBody ProductoRequest request) {

        try {
            logger.info(
                    "Post: idProducto {} - nombre {} - descripcion {} - fechaFabricacion {} - costoCompra {} - stock {} - imagenRuta {} - nombreUnidad {}",
                    request.getIdproduct(), request.getNombrepro(), request.getImagenruta(), request.getNombreunidad(),
                    request.getStock(), request.getFechafa(), request.getCostocompra(), request.getDescripcion());
            modeloProducto Mp = new modeloProducto();
            Mp.setIdproduct(request.getIdproduct());
            Mp.setNombrepro(request.getNombrepro());
            Mp.setDescripcion(request.getDescripcion());
            Mp.setFechafa(request.getFechafa());
            Mp.setCostocompra(request.getCostocompra());
            Mp.setStock(request.getStock());
            Mp.setImagenruta(request.getImagenruta());
            Mp.setNombreunidad(request.getNombreunidad());

            Mp = productoService.agregar(Mp);
            logger.info("Agregar modeloProducto {}", Mp);
            return ResponseEntity.status(HttpStatus.CREATED).body(messageEvent.MSGEXITO());
        } catch (Exception e) {
            logger.error("SE ENCONTRO UN ERROR: {}", e);
            return ResponseEntity.ok(messageEvent.MSGEROR() + e);
        }

    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> obtenerProducto(@PathVariable("id") int idproduct) throws Exception {
        try {
            logger.info("CONTROLLER: Obtener por idproducto: {}", idproduct);
            Optional<modeloProducto> MProducto = productoService.obtenerProductoPorid(idproduct);
            
            return ResponseEntity.ok( MProducto);
        } catch (Exception e) {
            logger.error("SE ENCONTRO UN ERROR: {}", e);
            return ResponseEntity.ok(messageEvent.MSGEROR() + e);
        }

    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<?> modificarProducto(@PathVariable int id, @RequestBody ProductoRequest request) {

        try {
            logger.info(
                    "Post: idProducto {} - nombre {} - descripcion {} - fechaFabricacion {} - costoCompra {} - stock {} - imagenRuta {} - nombreUnidad {}",
                    request.getIdproduct(), request.getNombrepro(), request.getImagenruta(), request.getNombreunidad(),
                    request.getStock(), request.getFechafa(), request.getCostocompra(), request.getDescripcion());

            modeloProducto Mp = new modeloProducto();

            Mp.setIdproduct(request.getIdproduct());
            Mp.setNombrepro(request.getNombrepro());
            Mp.setDescripcion(request.getDescripcion());
            Mp.setFechafa(request.getFechafa());
            Mp.setCostocompra(request.getCostocompra());
            Mp.setStock(request.getStock());
            Mp.setImagenruta(request.getImagenruta());
            Mp.setNombreunidad(request.getNombreunidad());

            Mp = productoService.ModificarProducto(id, Mp);
            logger.info("Modificacion del modeloProducto {}", Mp);
            return ResponseEntity.ok(messageEvent.MSGMODIEXITO());
        } catch (Exception e) {
            logger.error("SE ENCONTRO UN ERROR: {}", e);
            return ResponseEntity.ok(messageEvent.MSGEROR() + e);
        }

    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<String> DeleteProductoPorid(@PathVariable("id") int id) {

        try {

            productoService.DeleteProducto(id);
            logger.info("CONTROLLER: Se elimino con el idproducto: {}", id);
            return ResponseEntity.ok(messageEvent.MSGELIMEXIT());

        } catch (Exception e) {

            logger.error("SE ENCONTRO UN ERROR: {}", e);
            return ResponseEntity.ok(messageEvent.MSGEROR() + e);
        }

    }

}
