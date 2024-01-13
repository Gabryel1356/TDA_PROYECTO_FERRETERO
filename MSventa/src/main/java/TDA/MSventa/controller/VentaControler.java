package TDA.MSventa.controller;
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

import TDA.MSventa.dto.VentaRequest;
import TDA.MSventa.message.Mensajeria;
import TDA.MSventa.model.modeloVenta;
import TDA.MSventa.services.IVentaService;

@RestController
@RequestMapping("/api/venta")
public class VentaControler {
    @Autowired
    IVentaService ventaServ;

    Logger logger = LoggerFactory.getLogger(VentaControler.class);

    @Autowired
    Mensajeria messageEvent;

    @GetMapping("/listar")
    public ResponseEntity<?> Listar() {

        try {
            List<modeloVenta> Listarventa = ventaServ.obtener();
            logger.debug("CONTROLLER: ListarVenta");

            return ResponseEntity.ok(Listarventa);

        } catch (Exception e) {
            logger.error("SE ENCONTRO UN ERROR: {}", e);
            return ResponseEntity.ok(messageEvent.MSGEROR() + e);
        }

    }

    @PostMapping("/registrar")
    public ResponseEntity<?> registrar(@RequestBody VentaRequest request) {

        try {
            logger.info(
                    "Post: idventa {} - fechaventa {} - igv {} - subtotal {} - costoventa {} - unidades {} ",
                    request.getIdventa(), request.getFechaventa(), request.getIgv(), request.getSubtotal(),
                    request.getCostoventa(), request.getUnidades());
            modeloVenta Mv = new modeloVenta();
            Mv.setIdventa(request.getIdventa());
            Mv.setFechaventa(request.getFechaventa());
            Mv.setIgv(request.getIgv());
            Mv.setSubtotal(request.getSubtotal());
            Mv.setCostoventa(request.getCostoventa());
            Mv.setUnidades(request.getUnidades());
           

            Mv = ventaServ.agregar(Mv);
            logger.info("Agregar modeloVenta {}", Mv);
            return ResponseEntity.status(HttpStatus.CREATED).body(messageEvent.MSGEXITO());
        } catch (Exception e) {
            logger.error("SE ENCONTRO UN ERROR: {}", e);
            return ResponseEntity.ok(messageEvent.MSGEROR() + e);
        }

    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> obtenerVenta(@PathVariable("id") int idventa) throws Exception {
        try {
            logger.info("CONTROLLER: Obtener por idventa: {}", idventa);
            Optional<modeloVenta> MVenta = ventaServ.obtenerVentaPorid(idventa);
            
            return ResponseEntity.ok( MVenta);
        } catch (Exception e) {
            logger.error("SE ENCONTRO UN ERROR: {}", e);
            return ResponseEntity.ok(messageEvent.MSGEROR() + e);
        }

    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<?> modificarVenta(@PathVariable int id, @RequestBody VentaRequest request) {

        try {
            logger.info(
                    "Post: idventa {} - fechaventa {} - igv {} - subtotal {} - costoventa {} - unidades {} ",
                    request.getIdventa(), request.getFechaventa(), request.getIgv(), request.getSubtotal(),
                    request.getCostoventa(), request.getUnidades());

           modeloVenta Mv = new modeloVenta();
            Mv.setIdventa(request.getIdventa());
            Mv.setFechaventa(request.getFechaventa());
            Mv.setIgv(request.getIgv());
            Mv.setSubtotal(request.getSubtotal());
            Mv.setCostoventa(request.getCostoventa());
            Mv.setUnidades(request.getUnidades());

            Mv = ventaServ.agregar(Mv);
            logger.info("Agregar modeloVenta {}", Mv);
            return ResponseEntity.status(HttpStatus.CREATED).body(messageEvent.MSGEXITO());
        } catch (Exception e) {
            logger.error("SE ENCONTRO UN ERROR: {}", e);
            return ResponseEntity.ok(messageEvent.MSGEROR() + e);
        }

    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<String> DeleteVentaPorid(@PathVariable("id") int id) {

        try {

            ventaServ.DeleteVenta(id);
            logger.info("CONTROLLER: Se elimino con el idventa: {}", id);
            return ResponseEntity.ok(messageEvent.MSGELIMEXIT());

        } catch (Exception e) {

            logger.error("SE ENCONTRO UN ERROR: {}", e);
            return ResponseEntity.ok(messageEvent.MSGEROR() + e);
        }

    }
}
