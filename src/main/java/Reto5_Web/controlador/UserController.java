package Reto5_Web.controlador;

import Reto5_Web.modelo.User;
import Reto5_Web.servicio.UserService;
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

/**
 *
 * @author Jaqueline Palacio Clase Controlador de Usuario
 */
@RestController
@RequestMapping("api/user")
@CrossOrigin("*")
public class UserController {

    /**
     *
     * Autoconexion de tablas
     */
    @Autowired
    private UserService userService;

    /**
     *
     * Consultar todos los usuarios
     */
    @GetMapping("/all")
    public List<User> getAll() {
        return userService.getAll();
    }

    /**
     *
     * Consultar usuarios por id
     */
    @GetMapping("/{id}")
    public Optional<User> getUser(@PathVariable("id") int id) {
        return userService.getUser(id);
    }

    /**
     *
     * Crear un nuevo usuario
     */
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public User create(@RequestBody User user) {
        return userService.create(user);
    }

    /**
     *
     * Actualizar datos de usuario
     */
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public User update(@RequestBody User user) {
        return userService.update(user);
    }

        /**
     *
     * Borrar usuarios
     */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id) {
        return userService.delete(id);
    }

    /**
     *
     * Consultar usuarios por email y password
     */
    @GetMapping("/{email}/{password}")
    public User authenticateUser(@PathVariable("email") String email, @PathVariable("password") String password) {
        return userService.authenticateUser(email, password);
    }

    /**
     *
     * Validar si un email existe
     */
    @GetMapping("/emailexist/{email}")
    public boolean emailExists(@PathVariable("email") String email) {
        return userService.emailExists(email);
    }
    
    @GetMapping("/birthday/{monthBirthtDay}")
    public List<User> getMonthBirthtDay(@PathVariable("monthBirthtDay") String monthBirthtDay) {
        return userService.getMonthBirthtDay(monthBirthtDay);
    } 
   
}
