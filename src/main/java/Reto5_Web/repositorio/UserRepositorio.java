package Reto5_Web.repositorio;

import Reto5_Web.interfaces.InterfaceUser;
import Reto5_Web.modelo.User;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Repositorio para los datos de usuario
 * @author Jaqueline Palacio H
 */
@Repository
public class UserRepositorio {

    /**
     * Conexión automática de elementos
     */
    @Autowired
    private InterfaceUser userCrudRepository;

    /**
     * Consulta GET de todos los usuarios
     *  
     */
    public List<User> getAll() {
        return (List<User>) userCrudRepository.findAll();
    }

    /**
     * Consulta GET de todos los usuarios por id
     *  
     */
    public Optional<User> getUser(int id) {
        return userCrudRepository.findById(id);
    }

    /**
     * Creacion de nuevos usuarios
     *  
     */
    public User create(User user) {
        return userCrudRepository.save(user);
    }

    /**
     * Actualización de información de los usuarios
     *  
     */
    public void update(User user) {
        userCrudRepository.save(user);
    }

    /**
     * Borrado de usuarios de la lista
     *  
     */
    public void delete(User user) {
        userCrudRepository.delete(user);
    }

    /**
     * Validación de existencia de un usuario en la base de datos
     *  
     */
    public boolean emailExists(String email) {
        Optional<User> usuario = userCrudRepository.findByEmail(email);
        return !usuario.isEmpty();
    }

    /**
     * Validación de autenticacion de un usuario en la base de datos por el correo
     *  
     */
    public Optional<User> authenticateUser(String email, String password) {
        return userCrudRepository.findByEmailAndPassword(email, password);
    }

    /**
     * Consulta de usuarios que cumplen años en un mes especifico
     *  
     */
    public List<User> getMonthBirthtDay(String monthBirthtDay) {
        return (List<User>) userCrudRepository.findByMonthBirthtDay(monthBirthtDay);
    }
}
