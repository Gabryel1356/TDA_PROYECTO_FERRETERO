package TDA.MSproducto.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import TDA.MSproducto.model.modeloProducto;

@Repository
public interface IProductoRepository extends JpaRepository<modeloProducto, Integer> {

  
}
