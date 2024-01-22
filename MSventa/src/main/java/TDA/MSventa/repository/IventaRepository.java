package TDA.MSventa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import TDA.MSventa.model.ModeloVenta;

@Repository
public interface IventaRepository extends JpaRepository<ModeloVenta, Integer> {
    
}
