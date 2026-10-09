package main.java.gt.dbarrientoscorp.controlrecursoshumanos.controller;

import main.java.gt.dbarrientoscorp.controlrecursoshumanos.service.AuthService;
import main.java.gt.dbarrientoscorp.controlrecursoshumanos.util.SceneManager;


/**
 *
 * @author danielb
 */


public class RegisterController {
    
    private final AuthService aService;
    private final SceneManager sceneManager;

    public RegisterController(AuthService aService, SceneManager sceneManager) {
        this.aService = aService;
        this.sceneManager = sceneManager;
    }
    
    
    
}
