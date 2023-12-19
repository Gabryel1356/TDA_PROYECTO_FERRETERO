package TDA.MSpersona.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import TDA.MSpersona.model.modeloPersona;
import TDA.MSpersona.repository.IPersonaRepository;
import jakarta.transaction.Transactional;

@Service
public class PersonaServices implements IPersonaServices {

    @Autowired
    IPersonaRepository personaRepository;

    @Override
    public List<modeloPersona> obtener() {
        return (List<modeloPersona>) personaRepository.findAll();
    }
    @Override
    @Transactional
    public modeloPersona agregar(modeloPersona persona) {
        return personaRepository.save(persona);
    }





    @Override
    @CachePut(cacheNames = "modeloPersona", key = "#idpersona")
    public modeloPersona modificar(modeloPersona persona, int id) {
        return personaRepository.save(persona);
    }

   
    @Override
    @Cacheable("modeloPersona")
    public Optional<modeloPersona> obtenerporid(int id) {
        return personaRepository.findById(id);
    }


    @Override
    @Transactional
    public void DeletePersona(int persona) {

        personaRepository.deleteById(persona);

    }

}
