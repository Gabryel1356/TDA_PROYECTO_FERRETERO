package TDA.MSpersona.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import TDA.MSpersona.model.modeloPersona;

@Repository
public interface IPersonaRepository extends CrudRepository<modeloPersona,Integer> {
   
}



