package TDA.MSgenEnumerador.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import TDA.MSgenEnumerador.model.modeloGenEnumerador;

@Repository
public interface IgenEnumeradorRepository extends MongoRepository<modeloGenEnumerador, String> {
    @Query("{'idgenenum':?0}")
    public Iterable<modeloGenEnumerador> findById(Integer idgenenum);
}
