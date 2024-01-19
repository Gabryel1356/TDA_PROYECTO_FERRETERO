package TDA.MSpersona.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import TDA.MSpersona.dto.PersonaMapper;
import TDA.MSpersona.dto.PersonaRequest;
import TDA.MSpersona.model.ModeloPersona;
import TDA.MSpersona.repository.IPersonaRepository;
import jakarta.transaction.Transactional;

@Service
public class PersonaServices implements IPersonaServices {

    @Autowired
    IPersonaRepository personaRepository;

    @Override
    public List<PersonaRequest> obtener() {

        List<ModeloPersona> persona = personaRepository.findAll();

        List<PersonaRequest> rq = persona.stream().map(
                mpersona -> PersonaMapper.mapper.personarequesmodelo(mpersona)).collect(Collectors.toList());

        return rq;
    }

    @Override
    @Transactional
    public void agregar(PersonaRequest peRequest) {
        ModeloPersona persona = PersonaMapper.mapper.modelopersonarequest(peRequest);
        personaRepository.save(persona);
    }

    @Override
    @CachePut(cacheNames = "PersonaRequest", key = "#idpersona")
    public PersonaRequest modificar(PersonaRequest peRequest, int id) {
        ModeloPersona persona = personaRepository.findById(id).orElse(null);

        if (persona!=null){
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

        PersonaRequest response =   PersonaMapper.mapper.personarequesmodelo(persona);

        return response;
    }
    @Override
    @Cacheable("PersonaRequest")
    public PersonaRequest obtenerporid(int id) {
        ModeloPersona persona = personaRepository.findById(id).orElse(null);
        return PersonaMapper.mapper.personarequesmodelo(persona);
    }


    @Override
    @Transactional
    public void DeletePersona(int persona) {
        Product product = repository.findById(productId).orElse(null);

        if (product!=null){
            repository.delete(product);
        }

    }

}
