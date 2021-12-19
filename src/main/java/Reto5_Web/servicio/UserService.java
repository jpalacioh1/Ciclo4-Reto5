package Reto5_Web.servicio;

import Reto5_Web.modelo.User;
import Reto5_Web.repositorio.UserRepositorio;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Servicio para los datos de usuario
 * @author Jaqueline Palacio H
 */
@Service
public class UserService {

    /**
     * Conexión automática de elementos
     */
    @Autowired
    private UserRepositorio userRepository;

    /**
     * Consulta GET de todos los usuarios
     *  
     */
    public List<User> getAll() {
        return userRepository.getAll();
    }

    /**
     * Consulta GET de todos los usuarios por id
     *  
     */
    public Optional<User> getUser(int id) {
        return userRepository.getUser(id);
    }

    /**
     * Creacion de nuevos usuarios
     *  
     */
    public User create(User user) {
        if (user.getId() == null) {
            return user;
        } else {
            Optional<User> e = userRepository.getUser(user.getId());
            if (e.isEmpty()) {
                if (emailExists(user.getEmail()) == false) {
                    return userRepository.create(user);
                } else {
                    return user;
                }
            } else {
                return user;
            }
        }
    }

    /**
     * Actualización de información de los usuarios
     *  
     */
    public User update(User user) {
        if (user.getId() != null) {
            Optional<User> userDb = userRepository.getUser(user.getId());
            if (!userDb.isEmpty()) {
                if (user.getIdentification() != null) {
                    userDb.get().setIdentification(user.getIdentification());
                }
                if (user.getName() != null) {
                    userDb.get().setName(user.getName());
                }
                
                if (user.getBirthtDay() != null) {
                    userDb.get().setBirthtDay(user.getBirthtDay());
                }
                
                 if (user.getMonthBirthtDay() != null) {
                    userDb.get().setMonthBirthtDay(user.getMonthBirthtDay());
                }
                 
                if (user.getAddress() != null) {
                    userDb.get().setAddress(user.getAddress());
                }
                if (user.getCellPhone() != null) {
                    userDb.get().setCellPhone(user.getCellPhone());
                }
                if (user.getEmail() != null) {
                    userDb.get().setEmail(user.getEmail());
                }
                if (user.getPassword() != null) {
                    userDb.get().setPassword(user.getPassword());
                }
                if (user.getZone() != null) {
                    userDb.get().setZone(user.getZone());
                }
                userRepository.update(userDb.get());
                return userDb.get();
            } else {
                return user;
            }
        } else {
            return user;
        }
    }

    /**
     * Borrado de usuarios de la lista
     *  
     */
    public boolean delete(int userId) {
        Boolean aBoolean = getUser(userId).map(user -> {
            userRepository.delete(user);
            return true;
        }).orElse(false);
        return aBoolean;
    }

    /**
     * Validación de existencia de un usuario en la base de datos
     *  
     */
    public boolean emailExists(String email) {
        return userRepository.emailExists(email);
    }

    /**
     * Validación de autenticacion de un usuario en la base de datos por el correo y el password
     *  
     */
    public User authenticateUser(String email, String password) {
        Optional<User> usuario = userRepository.authenticateUser(email, password);
        if (usuario.isEmpty()) {
            return new User();
        } else {
            return usuario.get();
        }
    }
    
    /**
     * Consulta de usuarios que cumplen años en un mes especifico
     *  
     */
    public List<User> getMonthBirthtDay(String monthBirthtDay) {
        return userRepository.getMonthBirthtDay(monthBirthtDay);
    }
}
