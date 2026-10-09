
package main.java.gt.dbarrientoscorp.controlrecursoshumanos.model;

/**
 *
 * @author bdarrientos
 */
public class Rol {
    
    private String id_rol;
    private String rol;

    public Rol() {
    }

    public Rol(String id_rol, String rol) {
        this.id_rol = id_rol;
        this.rol = rol;
    }

    public String getId_rol() {
        return id_rol;
    }

    public String getRol() {
        return rol;
    }

    public void setId_rol(String id_rol) {
        this.id_rol = id_rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
    
    
    
}
