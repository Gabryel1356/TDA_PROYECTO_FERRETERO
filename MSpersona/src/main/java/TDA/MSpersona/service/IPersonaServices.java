package TDA.MSpersona.service;

import java.util.List;
import java.util.Optional;

import TDA.MSpersona.dto.PersonaRequest;
import TDA.MSpersona.model.ModeloPersona;

public interface IPersonaServices {



    public List<PersonaRequest> obtener();

    public void agregar(PersonaRequest request);

    public PersonaRequest modificar(PersonaRequest request, int id);

    public  PersonaRequest obtenerporid(int id);

    public void DeletePersona(int persona);
}
