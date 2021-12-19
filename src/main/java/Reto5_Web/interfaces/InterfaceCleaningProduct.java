package Reto5_Web.interfaces;

import Reto5_Web.modelo.CleaningProduct;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface InterfaceCleaningProduct extends MongoRepository<CleaningProduct, Integer> {

    public List<CleaningProduct> findByPriceLessThanEqual(double precio);
    
    public List<CleaningProduct> findByDescriptionContainingIgnoreCase(String description);
}
