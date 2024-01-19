package TDA.MSpersona.controller;

import java.util.List;
import java.util.Optional;


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
import TDA.MSpersona.dto.PersonaRequest;

import TDA.MSpersona.model.ModeloPersona;
import TDA.MSpersona.service.IPersonaServices;
import lombok.extern.log4j.Log4j2;





@RestController
@RequestMapping("/api/Persona")
@Log4j2
public class PersonaController {


    @Autowired
    IPersonaServices PersonaServices;
    @Autowired
    Mensajeria messageEvent;

    @GetMapping("/listar")
    public ResponseEntity  Listar() {

        try {
            List<PersonaRequest> ListarProducto = PersonaServices.obtener();
            log.debug("CONTROLLER: ListarProducto");

            return new ResponseEntity(ListarProducto,HttpStatus.CREATED);

        } catch (Exception e) {
            log.error("SE ENCONTRO UN ERROR: {}", e);
            return new ResponseEntity(messageEvent,HttpStatus.INTERNAL_SERVER_ERROR);

        }

    }
    

    @PostMapping("/registrar")
    public ResponseEntity<?> registrar(@RequestBody PersonaRequest request) {

        try {
            log.info(
                    "Post: idpersona {} - tiopodocumento {} - nombre {} - apepaterno {} - apematerno {} - fechanacimiento {} - telefono {} - correo {}- sexo {}- direccion {}- tipopersona {}",
                    request.getIdpersona(), request.getTiopodocumento(), request.getNombre(), request.getApematerno(),
                    request.getApepaterno(), request.getFechanacimiento(), request.getTelefono(), request.getCorreo(),
                    request.getSexo(), request.getDireccion(), request.getTipopersona());

                    PersonaServices.agregar(request);

            log.info("Agregar modeloProducto {}", request);
            return new ResponseEntity(HttpStatus.CREATED);
          
        } catch (Exception e) {
            log.error("SE ENCONTRO UN ERROR: {}", e);
            return new ResponseEntity(messageEvent,HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }


    @GetMapping(path = "/{id}")
    public ResponseEntity<?> obtenerPersona(@PathVariable("id") int id){
        try {
            log.info("CONTROLLER: Obtener por idpersona: {}", id);
            PersonaRequest request = PersonaServices.obtenerporid(id);
            return new ResponseEntity(request,HttpStatus.OK);
          
        } catch (Exception e) {
            log.error("SE ENCONTRO UN ERROR: {}", e);
            return new ResponseEntity(messageEvent,HttpStatus.INTERNAL_SERVER_ERROR);
            
        }

    }



    @PutMapping(path = "/{id}")
    public ResponseEntity<?> modificarPersona(@PathVariable int id, @RequestBody PersonaRequest request) {

        try {
            log.info(
                    "Post: idpersona {} - tiopodocumento {} - nombre {} - apepaterno {} - apematerno {} - fechanacimiento {} - telefono {} - correo {}- sexo {}- direccion {}- tipopersona {}",
                    request.getIdpersona(), request.getTiopodocumento(), request.getNombre(), request.getApematerno(),
                    request.getApepaterno(), request.getFechanacimiento(), request.getTelefono(), request.getCorreo(),
                    request.getSexo(), request.getDireccion(), request.getTipopersona());
         
             PersonaRequest response =  PersonaServices.modificar(request, id);
            log.info("Modificacion del modelopersona {}", response);
            return new ResponseEntity(messageEvent.MSGMODIEXITO(),HttpStatus.OK);

        } catch (Exception e) {
            log.error("SE ENCONTRO UN ERROR: {}", e);
            return new ResponseEntity(messageEvent,HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<String> DeletePersona(@PathVariable("id") int id) {

        try {

            PersonaServices.DeletePersona(id);
            log.info("CONTROLLER: Se elimino con el idpersona: {}", id);
            return ResponseEntity.ok(messageEvent.MSGELIMEXIT());

        } catch (Exception e) {

            log.error("SE ENCONTRO UN ERROR: {}", e);
            return ResponseEntity.ok(messageEvent.MSGEROR() + e);
        }

    }

}