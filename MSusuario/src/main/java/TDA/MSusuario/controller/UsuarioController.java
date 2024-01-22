package TDA.MSusuario.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import TDA.MSusuario.constantes.Mensajeria;
import TDA.MSusuario.dto.UsuarioRequestDto;
import TDA.MSusuario.dto.UsuarioResponseDto;
import TDA.MSusuario.jwt.JwtToken;
import TDA.MSusuario.service.UsuarioService;
import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
@RequestMapping("/api/Usuario")
public class UsuarioController {
    @Autowired
    UsuarioService usuarioService;

    @Autowired
    private JwtToken jwtTokenCross;
    @Autowired
    Mensajeria messageEvent;

    @GetMapping
    public ResponseEntity<?> obtenerAcces() {
        try {
            List<UsuarioRequestDto> ObteneraccesoUs = usuarioService.obtenerAcceso();
            log.debug("CONTROLLER: usuario");
            return ResponseEntity.ok(ObteneraccesoUs);
        } catch (Exception e) {
            log.error("SE ENCONTRO UN ERROR: {}", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(messageEvent.MSERORGUSU() + e);

        }

    }

    @PostMapping
    public ResponseEntity<?> post(@RequestBody UsuarioRequestDto request) throws Exception {
        try {
            log.info("Post: nombreusuario {} - clave {}", request.getNombreusuario(), request.getClave());

            if (!usuarioService.validatedCredentials(request.getNombreusuario(), request.getClave())) {
                return new ResponseEntity<String>("CREDENCIALES NO VÁLIDAS", HttpStatus.UNAUTHORIZED);
            }
            String token = jwtTokenCross.generateToken(request);
            UsuarioResponseDto response = new UsuarioResponseDto(token, request.getNombreusuario(), "id");

            return ResponseEntity.ok(response);

        } catch (Exception e) {
            log.error("SE ENCONTRO UN ERROR: {}", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(messageEvent.MSERORGUSU() + e);
        }

    }

}