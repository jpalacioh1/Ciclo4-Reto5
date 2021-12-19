package Reto5_Web.controlador;

import Reto5_Web.modelo.CleaningProduct;
import Reto5_Web.servicio.CleaningProductService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/cleaningprod")
@CrossOrigin("*")
public class CleaningProductController {

    @Autowired
    private CleaningProductService cleaningProductService;

    @GetMapping("/all")
    public List<CleaningProduct> getAll() {
        return cleaningProductService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<CleaningProduct> getClothe(@PathVariable("id") Integer id) {
        return cleaningProductService.getClothe(id);
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public CleaningProduct create(@RequestBody CleaningProduct cleaningProduct) {
        return cleaningProductService.create(cleaningProduct);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public CleaningProduct update(@RequestBody CleaningProduct cleaningProduct) {
        return cleaningProductService.update(cleaningProduct);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") Integer id) {
        return cleaningProductService.delete(id);
    }

    @GetMapping("/price/{price}")
    public List<CleaningProduct> getCleaningProductByPrice(@PathVariable("price") Double price) {
        return cleaningProductService.getCleaningProductByPrice(price);
    }
    
    @GetMapping("/description/{description}")
    public List<CleaningProduct> getCleaningProductByDescription(@PathVariable("description") String description) {
        return cleaningProductService.getCleaningProductByDescription(description);
    }
}
