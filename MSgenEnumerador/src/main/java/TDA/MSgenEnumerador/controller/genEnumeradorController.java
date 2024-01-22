package TDA.MSgenEnumerador.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import TDA.MSgenEnumerador.dto.genEnumeradorRequestDto;
import TDA.MSgenEnumerador.service.IgenEnumeradorService;
import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
@RequestMapping("/api/genenum")
public class genEnumeradorController {
    @Autowired
    IgenEnumeradorService genEnumeradorService;

    @GetMapping("/listar")
    public ResponseEntity<List<genEnumeradorRequestDto>> List() {
        try {
            List<genEnumeradorRequestDto> Listar = genEnumeradorService.obtener();
            log.debug("CONTROLLER: Listar");
            return ResponseEntity.ok(Listar);
        } catch (Exception e) {
            log.error("SE ENCONTRO UN ERROR: {}", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PostMapping("/registrar")
    public ResponseEntity<Void> registrar(@RequestBody genEnumeradorRequestDto request) {

        try {
            genEnumeradorService.agregar(request);
            log.info("Agregar  {}", request);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            log.error("SE ENCONTRO UN ERROR: {}", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

}
