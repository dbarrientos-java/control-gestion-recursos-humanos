package main.java.gt.dbarrientoscorp.controlrecursoshumanos;


import javafx.application.Application;
import javafx.stage.Stage;
import main.java.gt.dbarrientoscorp.controlrecursoshumanos.util.SceneManager;
/**
 *
 * @author dbarrientos
 */


public class MainApp extends Application {

    private Stage stage;
    
    @Override
    public void start(Stage stage) throws Exception{
        this.stage = stage;
        SceneManager manager = new SceneManager(stage);
        manager.showLoginView();
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}