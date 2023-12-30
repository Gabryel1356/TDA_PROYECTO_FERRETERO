package TDA.MSventa.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import TDA.MSventa.model.modeloVenta;

@Repository
public interface IventaRepository extends CrudRepository<modeloVenta, Integer> {
    
}
