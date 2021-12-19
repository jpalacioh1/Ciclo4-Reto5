package Reto5_Web.repositorio;

import Reto5_Web.interfaces.InterfaceOrder;
import Reto5_Web.modelo.Order;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

@Repository
public class OrderRepositorio {
    @Autowired
    private InterfaceOrder orderCrudRepository;

    public List<Order> getAll(){
        return orderCrudRepository.findAll();    
    }

    public Optional<Order> getOrder(Integer id){
        return orderCrudRepository.findById(id);
    }
    
    public Order create(Order order){
        return orderCrudRepository.save(order);
    }
    
    public void update(Order order){
        orderCrudRepository.save(order);
    }
    
    public void delete(Order order){
        orderCrudRepository.delete(order);
    }
    
    public List<Order> getOrderByZone(String zone){
        return orderCrudRepository.findBySalesManZone(zone);
    }
    
    public List<Order> getOrderBySalesManId(Integer id){
        return orderCrudRepository.findBySalesManId(id);
    }
    
    public List<Order> getOrderBySalesManIdAndStatus(Integer id, String status){
        return orderCrudRepository.findBySalesManIdAndStatus(id, status);
    }
    
    public List<Order> getRegisterDayAndSalesManId(String registerDay, Integer id){
        try {
            return orderCrudRepository.findByRegisterDayAndSalesManId(new SimpleDateFormat("yyyy-MM-dd").parse(registerDay), id);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
}

