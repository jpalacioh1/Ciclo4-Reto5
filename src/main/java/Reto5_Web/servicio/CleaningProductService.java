package Reto5_Web.servicio;

import Reto5_Web.modelo.CleaningProduct;
import Reto5_Web.repositorio.CleaningProductRepositorio;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CleaningProductService {

    @Autowired
    private CleaningProductRepositorio clotheRepository;

    public List<CleaningProduct> getAll() {
        return clotheRepository.getAll();
    }

    public Optional<CleaningProduct> getClothe(Integer id) {
        return clotheRepository.getClothe(id);
    }

    public CleaningProduct create(CleaningProduct cleaningProduct) {
        if (cleaningProduct.getId() == null) {
            return cleaningProduct;
        } else {
            return clotheRepository.create(cleaningProduct);
        }
    }

    public CleaningProduct update(CleaningProduct cleaningProduct) {

        if (cleaningProduct.getId() != null) {
            Optional<CleaningProduct> dbCleaningProduct = clotheRepository.getClothe(cleaningProduct.getId());
            if (!dbCleaningProduct.isEmpty()) {

                if (cleaningProduct.getBrand() != null) {
                    dbCleaningProduct.get().setBrand(cleaningProduct.getBrand());
                }

                if (cleaningProduct.getCategory() != null) {
                    dbCleaningProduct.get().setCategory(cleaningProduct.getCategory());
                }

                if (cleaningProduct.getPresentation() != null) {
                    dbCleaningProduct.get().setPresentation(cleaningProduct.getPresentation());
                }
                
                if (cleaningProduct.getDescription() != null) {
                    dbCleaningProduct.get().setDescription(cleaningProduct.getDescription());
                }
                
                if (cleaningProduct.getPrice() != 0.0) {
                    dbCleaningProduct.get().setPrice(cleaningProduct.getPrice());
                }
                if (cleaningProduct.getQuantity() != 0) {
                    dbCleaningProduct.get().setQuantity(cleaningProduct.getQuantity());
                }
                if (cleaningProduct.getPhotography() != null) {
                    dbCleaningProduct.get().setPhotography(cleaningProduct.getPhotography());
                }
                dbCleaningProduct.get().setAvailability(cleaningProduct.isAvailability());
                clotheRepository.update(dbCleaningProduct.get());
                return dbCleaningProduct.get();
            } else {
                return cleaningProduct;
            }
        } else {
            return cleaningProduct;
        }
    }

    public boolean delete(Integer id) {
        Boolean aBoolean = getClothe(id).map(cleaningProduct -> {
            clotheRepository.delete(cleaningProduct);
            return true;
        }).orElse(false);
        return aBoolean;
    }

    public List<CleaningProduct> getCleaningProductByPrice(Double price) {
        return clotheRepository.getCleaningProductByPrice(price);
    }
    
    public List<CleaningProduct> getCleaningProductByDescription(String description) {
        return clotheRepository.getCleaningProductByDescription(description);
    }
}
