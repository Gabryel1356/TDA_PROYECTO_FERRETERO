package TDA.MSproducto.repository;



import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
 
import TDA.MSproducto.model.modeloProducto;

@Repository
public interface IProductoRepository extends CrudRepository<modeloProducto, String> {

@Query("{'idproducto':?0}")
	public List<modeloProducto> findByIdproducto(int idproducto);


    
}
