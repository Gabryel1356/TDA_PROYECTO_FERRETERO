package TDA.MSpersona.service;

import java.util.List;
import java.util.Optional;

import TDA.MSpersona.model.modeloPersona;

public interface IPersonaServices {
    public List<modeloPersona> obtener();

    public modeloPersona agregar(modeloPersona persona);

    public modeloPersona modificar(modeloPersona persona, int id);

    public  Optional<modeloPersona> obtenerporid(int id);

    public void DeletePersona(int persona);
}
