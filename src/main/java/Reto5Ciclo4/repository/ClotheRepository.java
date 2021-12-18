package Reto5Ciclo4.repository;

import Reto5Ciclo4.interfaces.InterfaceClothe;
import Reto5Ciclo4.model.Clothe;
import Reto5Ciclo4.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ClotheRepository {
    @Autowired
    private InterfaceClothe clotheCrudRepository;

    public List<Clothe> getAll(){
        return clotheCrudRepository.findAll();
    }

    public Optional<Clothe> getClothe(String reference){
        return clotheCrudRepository.findById(reference);
    }

    public Clothe save(Clothe clothe){
        return clotheCrudRepository.save(clothe);
    }

    public void update(Clothe clothe){
        clotheCrudRepository.save(clothe);
    }

    public void delete(Clothe clothe){
        clotheCrudRepository.delete(clothe);
    }

    public List<Clothe> getByPrice(double price){
        return clotheCrudRepository.findByPriceLessThanEqual(price);
    }

    public List<Clothe> getByDescriptionContains(String description){
        return clotheCrudRepository.findByDescriptionContainingIgnoreCase(description);
    }
}
