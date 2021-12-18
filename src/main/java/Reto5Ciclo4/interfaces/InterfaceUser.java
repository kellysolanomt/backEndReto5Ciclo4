package Reto5Ciclo4.interfaces;

import Reto5Ciclo4.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface InterfaceUser extends MongoRepository<User, Integer> {

    //Para seleccionar el usuario con el id maximo
    Optional<User> findTopByOrderByIdDesc();
    Optional<User> findByEmail(String email);
    Optional<User> findByEmailAndPassword(String email, String password);
    Optional<User> findByNameOrEmail(String name, String email);
    List<User> findByMonthBirthtDay(String month);
}
