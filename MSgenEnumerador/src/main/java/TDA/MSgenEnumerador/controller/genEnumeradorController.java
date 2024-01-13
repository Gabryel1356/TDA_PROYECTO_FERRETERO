package TDA.MSgenEnumerador.controller;

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

import TDA.MSgenEnumerador.dto.genEnumeradorRequest;
import TDA.MSgenEnumerador.model.modeloGenEnumerador;
import TDA.MSgenEnumerador.service.IgenEnumeradorService;

@RestController
@RequestMapping("/api/genenum")
public class genEnumeradorController {
    @Autowired
    IgenEnumeradorService genEnumeradorService;
    Logger logger = LoggerFactory.getLogger(genEnumeradorController.class);

    @GetMapping("/listar")
    public ResponseEntity<?> Listar() {

        try {
            Iterable<modeloGenEnumerador> Listar = genEnumeradorService.findAll();
            logger.debug("CONTROLLER: Listar");

            return ResponseEntity.ok(Listar);

        } catch (Exception e) {
            logger.error("SE ENCONTRO UN ERROR: {}", e);
            return ResponseEntity.ok(e);
        }

    }



    @PostMapping("/registrar")
    public ResponseEntity<?> registrar(@RequestBody genEnumeradorRequest request) {

        try {
           
            modeloGenEnumerador Mg = new modeloGenEnumerador();
            Mg.setIdgenenum(request.getIdgenenum());
            Mg.setSexo(request.getSexo());
            Mg.setTipodocumento(request.getTipodocumento());
            Mg.setTipopersona(request.getTipopersona());
           
            Mg = genEnumeradorService.add(Mg);
            logger.info("Agregar  {}", Mg);
            return ResponseEntity.status(HttpStatus.CREATED).body(Mg);
        } catch (Exception e) {
            logger.error("SE ENCONTRO UN ERROR: {}", e);
            return ResponseEntity.ok( e);
        }

    }

}
