package TDA.MSventa.constantes;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class RecursoNoExisteException extends RuntimeException {
  private static final long serialVersionUID = 8206218583051711301L;

  /**
   * Construye una nueva excepción con el mensaje especificado.
   *
   * @param mensaje Mensaje de la excepción.
   */
  public RecursoNoExisteException(String mensaje) {
    super(mensaje);
  }
}
