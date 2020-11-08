/**
 *
 * @author sallasal
 */

package comma.ui;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

public class CommaGUI extends Application {
    @Override
    public void start(Stage window) {
        window.setTitle("Pilkkusääntöjen harjoittelu");
        
        BorderPane basicLayout = new BorderPane();
        
        Scene basicView = new Scene(basicLayout);
        
        window.setScene(basicView);
        window.show();
    }
}
