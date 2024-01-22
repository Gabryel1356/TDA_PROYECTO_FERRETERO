package TDA.MSpersona.service;

import java.util.List;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import TDA.MSpersona.dto.PersonaRequestDto;
import TDA.MSpersona.mapper.PersonaMapper;
import TDA.MSpersona.model.ModeloPersona;
import TDA.MSpersona.repository.IPersonaRepository;
import jakarta.transaction.Transactional;

@Service
public class PersonaServices implements IPersonaServices {

    @Autowired
    IPersonaRepository personaRepository;

    @Override
    public List<PersonaRequestDto> obtener() {
        List<ModeloPersona> persona = personaRepository.findAll();
        List<PersonaRequestDto> rq = persona.stream().map(
                mpersona -> PersonaMapper.mapper.personaRequestdto(mpersona)).collect(Collectors.toList());
        return rq;
    }

    @Override
    @Transactional
    public void agregar(PersonaRequestDto peRequest) {
        ModeloPersona persona = PersonaMapper.mapper.personamodelo(peRequest);
        if (persona!=null){
        personaRepository.save(persona);
        }
    }

    @Override
    @CachePut(cacheNames = "PersonaDTO", key = "#idpersona")
    public PersonaRequestDto modificar(PersonaRequestDto peRequest, int id) {
        ModeloPersona persona = personaRepository.findById(id).orElse(null);
        if (persona!=null){
            persona.setIdpersona( peRequest.getIdpersona() );
            persona.setApematerno( peRequest.getApematerno() );
            persona.setApepaterno( peRequest.getApepaterno() );
            persona.setCorreo( peRequest.getCorreo() );
            persona.setDireccion( peRequest.getDireccion() );
            persona.setFechanacimiento( peRequest.getFechanacimiento() );
            persona.setNombre( peRequest.getNombre() );
            persona.setSexo( peRequest.getSexo() );
            persona.setTelefono( peRequest.getTelefono() );
            persona.setTiopodocumento( peRequest.getTiopodocumento() );
            persona.setTipopersona( peRequest.getTipopersona() );     
            persona = personaRepository.save(persona);
        }
        PersonaRequestDto response =   PersonaMapper.mapper.personaRequestdto(persona);
        return response;
    }
    @Override
    @Cacheable("PersonaDTO")
    public PersonaRequestDto obtenerporid(int id) {
        ModeloPersona persona = personaRepository.findById(id).orElse(null);
        return PersonaMapper.mapper.personaRequestdto(persona);
    }

    @Override
    @Transactional
    public void DeletePersona(int id) {
        ModeloPersona persona = personaRepository.findById(id).orElse(null);
        if (persona!=null){
            personaRepository.delete(persona);
        }
    }

}
