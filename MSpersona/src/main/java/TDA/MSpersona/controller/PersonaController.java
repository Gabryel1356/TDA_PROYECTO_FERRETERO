package TDA.MSpersona.controller;

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

import TDA.MSpersona.constantes.Mensajeria;
import TDA.MSpersona.dto.PersonaRequestDto;
import TDA.MSpersona.service.IPersonaServices;
import lombok.extern.log4j.Log4j2;
@Log4j2
@RestController
@RequestMapping("/api/Persona")
public class PersonaController {
    @Autowired
    IPersonaServices PersonaServices;
    @Autowired
    Mensajeria messageEvent;



    @GetMapping("/listar")
    public ResponseEntity<List<PersonaRequestDto>> List() {
        try {
            List<PersonaRequestDto> ListarProducto = PersonaServices.obtener();
            log.debug("CONTROLLER: ListarProducto");
            return ResponseEntity.ok().body(ListarProducto);
        } catch (Exception e) {
            log.error("SE ENCONTRO UN ERROR: {}", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }
    
    @PostMapping("/registrar")
    public ResponseEntity<?> registrar(@RequestBody PersonaRequestDto request) {
        try {
            log.info(
                    "Post: idpersona {} - tiopodocumento {} - nombre {} - apepaterno {} - apematerno {} - fechanacimiento {} - telefono {} - correo {}- sexo {}- direccion {}- tipopersona {}",
                    request.getIdpersona(), request.getTiopodocumento(), request.getNombre(), request.getApematerno(),
                    request.getApepaterno(), request.getFechanacimiento(), request.getTelefono(), request.getCorreo(),
                    request.getSexo(), request.getDireccion(), request.getTipopersona());
                    PersonaServices.agregar(request);
            log.info("Agregar modeloProducto {}", request);
            return ResponseEntity.status(HttpStatus.CREATED).body(messageEvent.MSGEXITO());
        } catch (Exception e) {
            log.error("SE ENCONTRO UN ERROR: {}", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(messageEvent.MSGEROR() + e);
        }
    }
    @GetMapping(path = "/{id}")
    public ResponseEntity<?> obtenerPersona(@PathVariable("id") int id){
        try {
            log.info("CONTROLLER: Obtener por idpersona: {}", id);
            PersonaRequestDto request = PersonaServices.obtenerporid(id);
            return ResponseEntity.ok(request);
        } catch (Exception e) {
            log.error("SE ENCONTRO UN ERROR: {}", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(messageEvent.MSGEROR() + e);
        }
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<?> modificarPersona(@PathVariable int id, @RequestBody PersonaRequestDto request) {
        try {
            log.info(
                    "Post: idpersona {} - tiopodocumento {} - nombre {} - apepaterno {} - apematerno {} - fechanacimiento {} - telefono {} - correo {}- sexo {}- direccion {}- tipopersona {}",
                    request.getIdpersona(), request.getTiopodocumento(), request.getNombre(), request.getApematerno(),
                    request.getApepaterno(), request.getFechanacimiento(), request.getTelefono(), request.getCorreo(),
                    request.getSexo(), request.getDireccion(), request.getTipopersona());
            PersonaServices.modificar(request, id);
            log.info("Modificacion del modelopersona {}", request);
            return ResponseEntity.status(HttpStatus.CREATED).body(messageEvent.MSGMODIEXITO());
        } catch (Exception e) {
            log.error("SE ENCONTRO UN ERROR: {}", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(messageEvent.MSGEROR() + e);
        }

    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> DeletePersona(@PathVariable("id") int id) {
        try {
            PersonaServices.DeletePersona(id);
            log.info("CONTROLLER: Se elimino con el idpersona: {}", id);
            return ResponseEntity.ok(messageEvent.MSGELIMEXIT());
        } catch (Exception e) {
            log.error("SE ENCONTRO UN ERROR: {}", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(messageEvent.MSGEROR() + e);
        }

    }

}