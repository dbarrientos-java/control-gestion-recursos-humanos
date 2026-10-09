package main.java.gt.dbarrientoscorp.controlrecursoshumanos.model;


/**
 *
 * @author dbarrientos
 */


public class User {
    
    private String id_user;
    private String username;
    private String lastname;
    private String email;
    private String password_hash;
    private String id_rol;

    
    public User(){}
    
    public User(String id_user, String username, String lastname, String email, String password_hash, String id_rol) {
        this.id_user = id_user;
        this.username = username;
        this.lastname = lastname;
        this.email = email;
        this.password_hash = password_hash;
        this.id_rol = id_rol;
    }

    public String getId_user() {
        return id_user;
    }

    public String getUsername() {
        return username;
    }

    public String getLastname() {
        return lastname;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword_hash() {
        return password_hash;
    }

    public String getId_rol() {
        return id_rol;
    }

    public void setId_user(String id_user) {
        this.id_user = id_user;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword_hash(String password_hash) {
        this.password_hash = password_hash;
    }

    public void setId_rol(String id_rol) {
        this.id_rol = id_rol;
    }
    
    
    
    
}
