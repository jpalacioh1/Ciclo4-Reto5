package Reto5_Web.repositorio;

import Reto5_Web.modelo.CleaningProduct;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import Reto5_Web.interfaces.InterfaceCleaningProduct;

@Repository
public class CleaningProductRepositorio {

    @Autowired
    private InterfaceCleaningProduct repository;

    public List<CleaningProduct> getAll() {
        return repository.findAll();
    }

    public Optional<CleaningProduct> getClothe(Integer id) {
        return repository.findById(id);
    }

    public CleaningProduct create(CleaningProduct clothe) {
        return repository.save(clothe);
    }

    public void update(CleaningProduct clothe) {
        repository.save(clothe);
    }

    public void delete(CleaningProduct clothe) {
        repository.delete(clothe);
    }
    
    public List<CleaningProduct> getCleaningProductByPrice(Double price) {
        return repository.findByPriceLessThanEqual(price);
    }
    
    public List<CleaningProduct> getCleaningProductByDescription(String description) {
        return repository.findByDescriptionContainingIgnoreCase(description);
    }
    
}
