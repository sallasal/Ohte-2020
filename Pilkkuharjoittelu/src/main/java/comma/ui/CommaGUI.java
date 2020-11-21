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

    @Override
    public void init() throws Exception {
        this.commaService = new CommaService();
    }

    @Override
    public void start(Stage window) {

        window.setTitle("Pilkkusääntöjen harjoittelu");
        window.setWidth(500.00);
        window.setHeight(500.00);
        
        //Create LoggedInScene
        LoggedInScene loggedInScene = new LoggedInScene();
        Scene loggedScene = loggedInScene.getLoggedInScene(commaService);

        window.setScene(loggedScene);
        window.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
