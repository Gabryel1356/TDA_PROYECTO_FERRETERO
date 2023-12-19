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
import TDA.MSproducto.mensaje.Mensajeria;

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
        List<modeloProducto> ListarProducto = productoService.obtener();
        return ResponseEntity.ok(ListarProducto);
    }

    @PostMapping("/registrar")
    public ResponseEntity<?> registrar(@RequestBody ProductoRequest request) {

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

        return ResponseEntity.status(HttpStatus.CREATED).body(Mp);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> obtenerProducto(@PathVariable("id") int idproduct) throws Exception {
        Optional<modeloProducto> MProducto = productoService.obtenerProductoPorid(idproduct);
        return ResponseEntity.ok().body(MProducto);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<?> modificarProducto(@PathVariable int id, @RequestBody ProductoRequest request) {

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

        return ResponseEntity.ok(Mp);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<String> DeleteProductoPorid(@PathVariable("id") int id) throws Exception {

        productoService.DeleteProducto(id);

        return ResponseEntity.ok("SE ELIMINO TODO");
    }

}
