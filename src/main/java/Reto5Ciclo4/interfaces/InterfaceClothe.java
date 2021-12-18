package Reto5Ciclo4.interfaces;

import Reto5Ciclo4.model.Clothe;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface InterfaceClothe extends MongoRepository<Clothe, String> {
    public List<Clothe> findByPriceLessThanEqual(double price);
    public List<Clothe> findByDescriptionContainingIgnoreCase(String description);
}
