package TDA.MSpersona.controller;

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

import TDA.MSpersona.dto.PersonaRequest;
import TDA.MSpersona.mensaje.Mensajeria;
import TDA.MSpersona.model.modeloPersona;
import TDA.MSpersona.service.IPersonaServices;

@RestController
@RequestMapping("/api/Persona")
public class PersonaController {

    @Autowired
    IPersonaServices PersonaServices;

    Logger logger = LoggerFactory.getLogger(PersonaController.class);
    @Autowired
    Mensajeria messageEvent;

    @GetMapping("/listar")
    public ResponseEntity<?> Listar() {

        try {
            List<modeloPersona> ListarProducto = PersonaServices.obtener();
            logger.debug("CONTROLLER: ListarProducto");

            return ResponseEntity.ok(ListarProducto);

        } catch (Exception e) {
            logger.error("SE ENCONTRO UN ERROR: {}", e);
            return ResponseEntity.ok(messageEvent.MSGEROR() + e);
        }

    }

    @PostMapping("/registrar")
    public ResponseEntity<?> registrar(@RequestBody PersonaRequest request) {

        try {
            logger.info(
                    "Post: idpersona {} - tiopodocumento {} - nombre {} - apepaterno {} - apematerno {} - fechanacimiento {} - telefono {} - correo {}- sexo {}- direccion {}- tipopersona {}",
                    request.getIdpersona(), request.getTiopodocumento(), request.getNombre(), request.getApematerno(),
                    request.getApepaterno(), request.getFechanacimiento(), request.getTelefono(), request.getCorreo(),
                    request.getSexo(), request.getDireccion(), request.getTipopersona());
            modeloPersona Mp = new modeloPersona();
            Mp.setIdpersona(request.getIdpersona());
            Mp.setTiopodocumento(request.getTiopodocumento());
            Mp.setNombre(request.getNombre());
            Mp.setApepaterno(request.getApepaterno());
            Mp.setApematerno(request.getApematerno());
            Mp.setFechanacimiento(request.getFechanacimiento());
            Mp.setTelefono(request.getTelefono());
            Mp.setCorreo(request.getCorreo());
            Mp.setSexo(request.getSexo());
            Mp.setDireccion(request.getDireccion());
            Mp.setTipopersona(request.getTipopersona());

            Mp = PersonaServices.agregar(Mp);
            logger.info("Agregar modeloProducto {}", Mp);
            return ResponseEntity.status(HttpStatus.CREATED).body(messageEvent.MSGEXITO());
        } catch (Exception e) {
            logger.error("SE ENCONTRO UN ERROR: {}", e);
            return ResponseEntity.ok(messageEvent.MSGEROR() + e);
        }

    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> obtenerPersona(@PathVariable("id") int persona) throws Exception {
        try {
            logger.info("CONTROLLER: Obtener por idpersona: {}", persona);
            Optional<modeloPersona> moPe = PersonaServices.obtenerporid(persona);

            return ResponseEntity.ok(moPe);
        } catch (Exception e) {
            logger.error("SE ENCONTRO UN ERROR: {}", e);
            return ResponseEntity.ok(messageEvent.MSGEROR() + e);
        }

    }
     @PutMapping(path = "/{id}")
    public ResponseEntity<?> modificarPersona(@PathVariable int id, @RequestBody PersonaRequest request) {

        try {
           logger.info(
                    "Post: idpersona {} - tiopodocumento {} - nombre {} - apepaterno {} - apematerno {} - fechanacimiento {} - telefono {} - correo {}- sexo {}- direccion {}- tipopersona {}",
                    request.getIdpersona(), request.getTiopodocumento(), request.getNombre(), request.getApematerno(),
                    request.getApepaterno(), request.getFechanacimiento(), request.getTelefono(), request.getCorreo(),
                    request.getSexo(), request.getDireccion(), request.getTipopersona());
            modeloPersona Mp = new modeloPersona();

            Mp.setIdpersona(request.getIdpersona());
            Mp.setTiopodocumento(request.getTiopodocumento());
            Mp.setNombre(request.getNombre());
            Mp.setApepaterno(request.getApepaterno());
            Mp.setApematerno(request.getApematerno());
            Mp.setFechanacimiento(request.getFechanacimiento());
            Mp.setTelefono(request.getTelefono());
            Mp.setCorreo(request.getCorreo());
            Mp.setSexo(request.getSexo());
            Mp.setDireccion(request.getDireccion());
            Mp.setTipopersona(request.getTipopersona());


            Mp = PersonaServices.modificar( Mp, id);
            logger.info("Modificacion del modelopersona {}", Mp);
            return ResponseEntity.ok(messageEvent.MSGMODIEXITO());
        } catch (Exception e) {
            logger.error("SE ENCONTRO UN ERROR: {}", e);
            return ResponseEntity.ok(messageEvent.MSGEROR() + e);
        }

    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<String> DeletePersona(@PathVariable("id") int id) {

        try {

            PersonaServices.DeletePersona(id);
            logger.info("CONTROLLER: Se elimino con el idpersona: {}", id);
            return ResponseEntity.ok(messageEvent.MSGELIMEXIT());

        } catch (Exception e) {

            logger.error("SE ENCONTRO UN ERROR: {}", e);
            return ResponseEntity.ok(messageEvent.MSGEROR() + e);
        }

    }





}