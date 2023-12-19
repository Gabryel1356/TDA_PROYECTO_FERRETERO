package TDA.MSusuario.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import TDA.MSusuario.model.modelUsuario;

@Repository
public interface IUsuarioRepository extends CrudRepository<modelUsuario, Integer> {

}
