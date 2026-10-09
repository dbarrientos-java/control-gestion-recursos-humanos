package main.java.gt.dbarrientoscorp.controlrecursoshumanos.dto.request;

/**
 *
 * @author dbarrientos
 */
public class LoginDTORequest {
    
    private String email;
    private String password;

    public LoginDTORequest() {
    }

    public LoginDTORequest(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
    
    
}
