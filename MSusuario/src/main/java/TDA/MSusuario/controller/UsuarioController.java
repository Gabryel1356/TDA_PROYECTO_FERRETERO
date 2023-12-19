package TDA.MSusuario.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import TDA.MSusuario.dto.UsuarioRequest;
import TDA.MSusuario.dto.UsuarioResponse;
import TDA.MSusuario.model.modelUsuario;
import TDA.MSusuario.service.UsuarioService;

@RestController
@RequestMapping("/api/Usuario")
public class UsuarioController {
    @Autowired
    UsuarioService usuarioService;

    Logger logger = LoggerFactory.getLogger(UsuarioController.class);

    @GetMapping
    public List<modelUsuario> get() {
        return usuarioService.getAcces();
    }

    @PostMapping()
    public ResponseEntity<?> post(@RequestBody UsuarioRequest request) throws Exception {
        logger.info("Post: Username {} - Password {}", request.getNombreusuario(), request.getClave());

        if (!usuarioService.validatedCredentials(request.getNombreusuario(), request.getClave())) {
            return new ResponseEntity<String>("INVALID_CREDENTIALS", HttpStatus.UNAUTHORIZED);
        }

        UsuarioResponse response = new UsuarioResponse(request.getNombreusuario());

        return ResponseEntity.ok(response);
    }

}