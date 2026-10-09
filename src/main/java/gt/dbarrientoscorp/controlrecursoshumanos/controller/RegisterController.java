package main.java.gt.dbarrientoscorp.controlrecursoshumanos.controller;

import main.java.gt.dbarrientoscorp.controlrecursoshumanos.service.AuthService;
import main.java.gt.dbarrientoscorp.controlrecursoshumanos.util.SceneManager;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import main.java.gt.dbarrientoscorp.controlrecursoshumanos.model.Rol;

/**
 *
 * @author danielb
 */

public class RegisterController implements Initializable {
    
    private final AuthService service;
    private final SceneManager manager;
    
    @FXML
    private TextField txtUsername;
    @FXML
    private TextField txtLastName;
    @FXML 
    private TextField txtEmail;
    @FXML
    private PasswordField txtPassword;
    @FXML
    private ComboBox<Rol> cmbxRoles;
 
    
    public void initialize(URL url, ResourceBundle rb) {
        chargeComboBox();
    }
    
    public RegisterController(AuthService service, SceneManager manager) {
        this.service = service;
        this.manager = manager;
    }
    
    public void chargeComboBox() {
        cmbxRoles.setItems(service.getRoles());
    }
    
    public void handleRegister(ActionEvent event) {
        String name = txtUsername.getText();
        String lastname = txtLastName.getText();
        String email = txtEmail.getText();
        String password = txtPassword.getText();
        Rol rol = cmbxRoles.getValue();
        
        boolean registrado = service.registerUser(name,lastname, email, password, rol);
        
        if (registrado) {
            manager.showAlertInfo(Alert.AlertType.INFORMATION, "Éxito", "El usuario se ha registrado con éxito");
            cleanForm();
            chargeComboBox();
        } else {
            manager.showAlertInfo(Alert.AlertType.ERROR, "Error", "No se pudo registrar su usuario. Revise los campos.");
        }
    }
    
    @FXML
    public void handleReturn() throws Exception {
        manager.showLoginView();
    }
    
    public void cleanForm() {
        txtUsername.clear();
        txtPassword.clear();
        cmbxRoles.getSelectionModel().clearSelection();
       
    }
}
    

