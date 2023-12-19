package TDA.MSproducto.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import TDA.MSproducto.model.modeloProducto;

@Repository
public interface IProductoRepository extends CrudRepository<modeloProducto, Integer> {

  
}
