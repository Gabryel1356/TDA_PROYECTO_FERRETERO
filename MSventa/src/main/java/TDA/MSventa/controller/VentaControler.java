package TDA.MSventa.controller;

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

import TDA.MSventa.constantes.Mensajeria;
import TDA.MSventa.dto.VentaRequestDto;
import TDA.MSventa.services.IVentaService;
import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
@RequestMapping("/api/venta")
public class VentaControler {
    @Autowired
    IVentaService ventaServ;
    @Autowired
    Mensajeria messageEvent;

    @GetMapping("/listar")
    public ResponseEntity<List<VentaRequestDto>> List() {
        try {
            log.debug("CONTROLLER: Listar Venta");
            List<VentaRequestDto> venta = ventaServ.obtener();

            return ResponseEntity.ok(venta);
        } catch (Exception e) {
            log.error("SE ENCONTRO UN ERROR: {}", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PostMapping("/registrar")
    public ResponseEntity<Void> registrar(@RequestBody VentaRequestDto request) {
        try {
            log.info(
                    "Post: idventa {} - fechaventa {} - igv {} - subtotal {} - costoventa {} - unidades {} ",
                    request.getIdventa(), request.getFechaventa(), request.getIgv(), request.getSubtotal(),
                    request.getCostoventa(), request.getUnidades());
            ventaServ.agregar(request);
            log.info("Agregar modeloVenta {}", request);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            log.error("SE ENCONTRO UN ERROR: {}", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

       
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<VentaRequestDto> obtenerVenta(@PathVariable("id") int id) {

        try {
            log.info("CONTROLLER: Obtener por idventa: {}", id);
            VentaRequestDto request = ventaServ.obtenerVentaPorid(id);
            return new ResponseEntity<VentaRequestDto>(request, null, HttpStatus.OK);
        } catch (Exception e) {
            log.error("SE ENCONTRO UN ERROR: {}", e);
            return new ResponseEntity<VentaRequestDto>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<?> modificarVenta(@PathVariable int id, @RequestBody VentaRequestDto request) {
        try {
            log.info(
                    "Post: idventa {} - fechaventa {} - igv {} - subtotal {} - costoventa {} - unidades {} ",
                    request.getIdventa(), request.getFechaventa(), request.getIgv(), request.getSubtotal(),
                    request.getCostoventa(), request.getUnidades());
            ventaServ.ModificarVenta(request, id);
            log.info("Agregar modeloVenta {}", request);
            return ResponseEntity.status(HttpStatus.CREATED).body(messageEvent.MSGMODIEXITO());
        } catch (Exception e) {
            log.error("SE ENCONTRO UN ERROR: {}", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(messageEvent.MSGEROR() + e);
        }
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<String> DeleteVentaPorid(@PathVariable("id") int id) {
        try {
            ventaServ.DeleteVenta(id);
            log.info("CONTROLLER: Se elimino con el idventa: {}", id);
            return ResponseEntity.ok(messageEvent.MSGELIMEXIT());
        } catch (Exception e) {
            log.error("SE ENCONTRO UN ERROR: {}", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(messageEvent.MSGEROR() + e);
        }

    }
}
