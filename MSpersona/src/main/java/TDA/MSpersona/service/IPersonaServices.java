package TDA.MSpersona.service;

import java.util.List;


import TDA.MSpersona.dto.PersonaRequestDto;


public interface IPersonaServices {
    public List<PersonaRequestDto> obtener();
    public void agregar(PersonaRequestDto request);
    public  PersonaRequestDto obtenerporid(int id);
    public PersonaRequestDto modificar(PersonaRequestDto request, int id);
    public void DeletePersona(int id);
}
