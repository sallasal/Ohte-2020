/**
 *
 * @author sallasal
 */
package comma.ui;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import comma.domain.*;

public class CommaGUI extends Application {

    private CommaService commaService;
    private Stage window;
    

    @Override
    public void init() throws Exception {
        this.commaService = new CommaService();
    }

    @Override
    public void start(Stage windowArg) {
        this.window = windowArg;

        window.setTitle("Pilkkusääntöjen harjoittelu");
        window.setWidth(500.00);
        window.setHeight(500.00);
        
        //Create RegisterScene
        RegisterScene registerScene = new RegisterScene();
        Scene register = registerScene.getRegisterScene(commaService, window);
        
        //Create LogInScene
        LogInScene logInScene = new LogInScene();
        Scene login = logInScene.getLogInScene(commaService, window);
        
        //Create LoggedInScene
        LoggedInScene loggedInScene = new LoggedInScene();
        Scene logged = loggedInScene.getLoggedInScene(commaService);
        
        //Set scenes to others
        logInScene.setRegisterScene(register);
        logInScene.setLoggedScene(logged);
        registerScene.setLoginScene(login);

        window.setScene(login);
        window.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
