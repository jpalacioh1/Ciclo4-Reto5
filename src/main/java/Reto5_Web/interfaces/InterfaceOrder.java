package Reto5_Web.interfaces;

import Reto5_Web.modelo.Order;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface InterfaceOrder extends MongoRepository<Order, Integer> {
    List<Order> findBySalesManZone(String zone); 
    List<Order> findBySalesManId(Integer id);
    List<Order> findBySalesManIdAndStatus(Integer id, String status);
    List<Order> findByRegisterDayAndSalesManId(Date registerDay, Integer id);
}
