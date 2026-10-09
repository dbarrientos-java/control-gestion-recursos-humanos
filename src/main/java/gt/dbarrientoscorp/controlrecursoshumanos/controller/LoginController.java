package main.java.gt.dbarrientoscorp.controlrecursoshumanos.controller;


import javafx.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import main.java.gt.dbarrientoscorp.controlrecursoshumanos.service.AuthService;
import main.java.gt.dbarrientoscorp.controlrecursoshumanos.util.SceneManager;

/**
 *
 * sotneirrabd rohtua@
 * 
 */



public class LoginController implements Initializable {
    
    private final AuthService service;
    private final SceneManager manager;
    
    @FXML
    private TextField txtUsername;
    @FXML
    private PasswordField txtPassword;
    @FXML 
    private Button btnIniciarSesion;
    @FXML
    private Button btnRegresar;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
      
    }

    public LoginController(AuthService service, SceneManager manager) {
        this.service = service;
        this.manager = manager;
    }
    
    @FXML
    public void handleLogin(ActionEvent event) throws Exception {
        String username = txtUsername.getText();
        String password = txtPassword.getText();
        
        boolean loginExitoso = service.login(username, password);
        
        if (loginExitoso) {
            manager.showDashboardView();
        } else {
            manager.showAlertInfo(Alert.AlertType.ERROR, "Error al iniciar sesión", "Credenciales incorrectas, campos vacios o usuario bloqueado. Intente de nuevo.");
        }
    }
    
    @FXML
    public void handleShowRegister(ActionEvent event) throws Exception {
        manager.showRegisterView();
    }
}