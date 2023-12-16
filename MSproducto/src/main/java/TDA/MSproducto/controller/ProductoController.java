package TDA.MSproducto.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import TDA.MSproducto.model.modeloProducto;
import TDA.MSproducto.services.ProductoService;


@RestController
@RequestMapping("/api/prodcuto")
public class ProductoController {
    @Autowired
    ProductoService ProductoService;
    
    @GetMapping
    public List<modeloProducto> get() {
        return ProductoService.getProducto();
    }   
    @PostMapping()
    public modeloProducto  PostProducto(@RequestBody modeloProducto producto){
        return this.ProductoService.PostProducto(producto);
    }

    @GetMapping( path = "/{id}")
    public Optional<modeloProducto> obtenerUsuarioPorId(@PathVariable("id") int id) {
        return this.ProductoService.getProductoPorId(id);
    }


    @PutMapping(path = "/{id}")
    public void updateEmployee(@PathVariable int id, @RequestBody modeloProducto producto) {
            ProductoService.updateEmployee(id, producto);
    }

    
    
    @DeleteMapping( path = "/{id}")
    public String  DeleteProductoPorid(@PathVariable("id") modeloProducto id){
        boolean ok = this.ProductoService.DeleteProducto(id);
        if (ok){
            return "Se eliminó la producto con id " + id;
        }else{
            return "No pudo eliminar la producto con id" + id;
        }
    }

    

 


}
