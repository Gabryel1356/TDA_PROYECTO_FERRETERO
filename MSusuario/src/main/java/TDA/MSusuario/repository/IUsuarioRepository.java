package TDA.MSusuario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import TDA.MSusuario.model.ModelUsuario;

@Repository
public interface IUsuarioRepository extends JpaRepository<ModelUsuario, Integer> {

}
