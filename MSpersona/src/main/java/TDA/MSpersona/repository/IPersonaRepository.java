package TDA.MSpersona.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import TDA.MSpersona.model.ModeloPersona;

@Repository
public interface IPersonaRepository extends JpaRepository<ModeloPersona,Integer> {
   
}



