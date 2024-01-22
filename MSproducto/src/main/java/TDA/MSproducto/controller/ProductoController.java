package TDA.MSproducto.controller;

import java.util.List;



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


import TDA.MSproducto.services.IProductoService;
import lombok.extern.log4j.Log4j2;
import TDA.MSproducto.constantes.Mensajeria;
import TDA.MSproducto.dto.ProductoRequestDto;

@Log4j2
@RestController
@RequestMapping("/api/producto")
public class ProductoController {

    @Autowired
    IProductoService productoService;

    @Autowired
    Mensajeria messageEvent;

    @GetMapping("/listar")
    public ResponseEntity<List<ProductoRequestDto>> Listar() {

        try {
           
            List<ProductoRequestDto> ListarProducto = productoService.obtener();
            log.debug("CONTROLLER: ListarProducto");
            return ResponseEntity.ok(ListarProducto);

        } catch (Exception e) {
            log.error("SE ENCONTRO UN ERROR: {}", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PostMapping("/registrar")
    public ResponseEntity<Void> registrar(@RequestBody ProductoRequestDto request) {

        try {
            log.info(
                    "Post: idProducto {} - nombre {} - descripcion {} - fechaFabricacion {} - costoCompra {} - stock {} - imagenRuta {} - nombreUnidad {}",
                    request.getIdproduct(), request.getNombrepro(), request.getImagenruta(), request.getNombreunidad(),
                    request.getStock(), request.getFechafa(), request.getCostocompra(), request.getDescripcion());
           
             productoService.agregar(request);
            log.info("Agregar modeloProducto {}", request);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            log.error("SE ENCONTRO UN ERROR: {}", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    @GetMapping(path = "/{id}")
    public ResponseEntity<ProductoRequestDto> obtenerProducto(@PathVariable("id") int idproduct)  {
        try {
            log.info("CONTROLLER: Obtener por idproducto: {}", idproduct);
            ProductoRequestDto request = productoService.obtenerProductoPorid(idproduct);
            
            return new ResponseEntity<ProductoRequestDto>(request, null, HttpStatus.OK);
        } catch (Exception e) {
            log.error("SE ENCONTRO UN ERROR: {}", e);
            return new ResponseEntity<ProductoRequestDto>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    @PutMapping(path = "/{id}")
    public ResponseEntity<?> modificarProducto(@PathVariable int id, @RequestBody ProductoRequestDto request) {

        try {
            log.info(
                    "Post: idProducto {} - nombre {} - descripcion {} - fechaFabricacion {} - costoCompra {} - stock {} - imagenRuta {} - nombreUnidad {}",
                    request.getIdproduct(), request.getNombrepro(), request.getImagenruta(), request.getNombreunidad(),
                    request.getStock(), request.getFechafa(), request.getCostocompra(), request.getDescripcion());

      
        productoService.ModificarProducto(id, request);
            log.info("Modificacion del modeloProducto {}", request);
            return ResponseEntity.status(HttpStatus.CREATED).body(messageEvent.MSGMODIEXITO());
        } catch (Exception e) {
            log.error("SE ENCONTRO UN ERROR: {}", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(messageEvent.MSGEROR() + e);
        }

    }
  
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<String> DeleteProductoPorid(@PathVariable("id") int id) {

        try {

            productoService.DeleteProducto(id);
            log.info("CONTROLLER: Se elimino con el idproducto: {}", id);
            return ResponseEntity.ok(messageEvent.MSGELIMEXIT());

        } catch (Exception e) {

            log.error("SE ENCONTRO UN ERROR: {}", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(messageEvent.MSGEROR() + e);
        }

    }

}
