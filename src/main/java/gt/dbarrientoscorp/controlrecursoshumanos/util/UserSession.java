
package main.java.gt.dbarrientoscorp.controlrecursoshumanos.util;

import main.java.gt.dbarrientoscorp.controlrecursoshumanos.model.User;

/**
 *
 * @author dbarrientos
 */

public class UserSession {
    
    private static UserSession instance;
    private User actualUser;
    private String rol;
    
    public UserSession(){
        
    }
    
    public static UserSession getInstance() {
        if (instance == null) {
            instance = new UserSession();
        }
        return instance;
    }
    
    public void login(User user, String rol) {
        this.actualUser = user;
        this.rol = rol;
    }
    
    public void logout() {
        this.actualUser = null;
        this.rol = null;
    }

    public User getUsuarioActual() {
        return actualUser;
    }

    public String getNombreRol() {
        return rol;
    }
    
    public boolean isAdmin() {
        if (actualUser != null) {
            return actualUser.getId_rol() == "1";
        }
        return "administrador".equalsIgnoreCase(rol);
    }
}
