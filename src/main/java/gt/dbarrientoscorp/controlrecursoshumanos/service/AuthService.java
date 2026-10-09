
package main.java.gt.dbarrientoscorp.controlrecursoshumanos.service;

    import java.util.UUID;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import main.java.gt.dbarrientoscorp.controlrecursoshumanos.model.Rol;
import main.java.gt.dbarrientoscorp.controlrecursoshumanos.model.User;
import main.java.gt.dbarrientoscorp.controlrecursoshumanos.repository.UserRepository;
import main.java.gt.dbarrientoscorp.controlrecursoshumanos.util.UserSession;
import main.java.gt.dbarrientoscorp.controlrecursoshumanos.security.jbcrypt.BCrypt;


/**
 *
 * @author informatica
 */
public class AuthService {


    private final UserRepository uRepository;
    private final UserSession userSession;
  

    public AuthService(UserRepository uRepository, UserSession userSession) {
        this.uRepository = uRepository;
        this.userSession = userSession;
    }

    public boolean login(String username, String pass) {
        if (username == null || username.trim().isEmpty()
                || pass == null || pass.trim().isEmpty()
            || username.trim().isBlank() || pass.trim().isBlank()
                ) {
            System.out.println("No se puede ingresar campos vacíos, revise su usuario y su contraseña.");
            return false;
        }

        User user = uRepository.findByUsername(username);
        
        if (user == null) {
            System.out.println("No se encontró el usuario");
            return false;
        }
        
        if (user.getPassword_hash() == null) {
            throw new RuntimeException("No se logró terminar la operación");
        }
        
        if (BCrypt.checkpw(pass, user.getPassword_hash())) {
            Rol rol = uRepository.findById(user.getId_rol());
            String rolName = (rol != null) ? rol.getRol() : "usuario";
            
            UserSession.getInstance().login(user, rolName);
            
            System.out.println("Inicio de sesión realizado con exito. Rol: " + rolName);
            return true;
        } else {
            System.out.println("Contraseña incorrecta");
            return false;
        }
    }
    
    public boolean registerUser(String username, String pass, String lastname, String email, Rol rol) {
        if (username == null || username.trim().isEmpty() 
                || pass == null || pass.trim().isEmpty()
                || lastname == null || lastname.trim().isEmpty()
                || email == null || email.trim().isEmpty()
                || rol == null){ 
            System.out.println("No se puede ingresar campos vacios");
            return false;
        }
        
        String passHash = BCrypt.hashpw(pass.trim(), BCrypt.gensalt(12));
        
        User newUser = new User(
                UUID.randomUUID().toString(),
                username.trim(),
                lastname.trim(),
                email.trim(),
                passHash,
                rol.getId_rol()
        );
        
        return uRepository.register(newUser);
                
    }
    
    public ObservableList<Rol> getRoles() {
        return FXCollections.observableArrayList(uRepository.getAllRoles());
    }

    
}

