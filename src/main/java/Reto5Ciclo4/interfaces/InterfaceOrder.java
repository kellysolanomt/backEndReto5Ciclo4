package Reto5Ciclo4.interfaces;

import Reto5Ciclo4.model.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface InterfaceOrder extends MongoRepository<Order, Integer> {
    //Retorna las ordenes de pedido que coincidad con la zona recibida como parametro
    //@Query("{'salesMan.zone': ?0}")
    //List<Order> findByZone(final String country);

    //Retorna las ordenes x estado
    //@Query("{status: ?0}")
    //List<Order> findByStatus(final String status);

    //Para seleccionar la orden con el id maximo
    Optional<Order> findTopByOrderByIdDesc();

    List<Order> findBySalesManZone(String zone);
    List<Order> findBySalesManId(Integer id);
    List<Order> findBySalesManIdAndStatus(Integer id, String status);
    List<Order> findByRegisterDayAndSalesManId(Date registerDay, Integer id);
}
