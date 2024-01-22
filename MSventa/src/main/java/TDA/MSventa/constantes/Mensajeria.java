package TDA.MSventa.constantes;

import org.springframework.stereotype.Component;

@Component
public class Mensajeria {

    public String MSGELIMEXIT() {

        return "SE ELIMINO CON EXITO EL PRODUCTO";
    }

    public String MSGEROR() {

        return "SUCEDIO UN ERROR:";
    }

    public String MSGENCONTAR() {

        return "SE ENCONTRO CON EXITO ";
    }

    public String MSGEXITO() {

        return "SE GUARDO CON EXITO";
    }

     public String MSGMODIEXITO() {

        return "SE MODIFICO CON EXITO";
    }

}
