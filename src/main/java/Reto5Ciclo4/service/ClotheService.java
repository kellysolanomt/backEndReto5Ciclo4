package Reto5Ciclo4.service;

import Reto5Ciclo4.model.Clothe;
import Reto5Ciclo4.repository.ClotheRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClotheService {
    @Autowired
    private ClotheRepository clotheRepository;

    public List<Clothe> getAll(){
        return clotheRepository.getAll();
    }

    public Optional<Clothe> getClothe(String reference){
        return clotheRepository.getClothe(reference);
    }

    public Clothe save(Clothe clothe){
        if(clothe.getReference()==null){
            return clothe;
        }else{
            return clotheRepository.save(clothe);
        }
    }
    public Clothe update(Clothe clothe) {

        if (clothe.getReference() != null) {
            Optional<Clothe> clotheDb = clotheRepository.getClothe(clothe.getReference());
            if (!clotheDb.isEmpty()) {

                if (clothe.getSize()!= null) {
                    clotheDb.get().setSize(clothe.getSize());
                }

                if (clothe.getCategory() != null) {
                    clotheDb.get().setCategory(clothe.getCategory());
                }

                if (clothe.getDescription() != null) {
                    clotheDb.get().setDescription(clothe.getDescription());
                }
                if (clothe.getPrice() != 0.0) {
                    clotheDb.get().setPrice(clothe.getPrice());
                }
                if (clothe.getQuantity() != 0) {
                    clotheDb.get().setQuantity(clothe.getQuantity());
                }
                if (clothe.getPhotography() != null) {
                    clotheDb.get().setPhotography(clothe.getPhotography());
                }
                clotheDb.get().setAvailability(clothe.isAvailability());
                clotheRepository.update(clotheDb.get());
                return clotheDb.get();
            } else {
                return clothe;
            }
        } else {
            return clothe;
        }
    }

    public boolean delete(String reference) {
        Boolean aBoolean = getClothe(reference).map(accesory -> {
            clotheRepository.delete(accesory);
            return true;
        }).orElse(false);
        return aBoolean;
    }

    public List<Clothe> getByPrice(double price){
        return clotheRepository.getByPrice(price);
    }

    public List<Clothe> getByDescriptionContains(String description){
        return clotheRepository.getByDescriptionContains(description);
    }
}
