/**
 *
 * @author sallasal
 */

package comma.ui;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class CommaGUI extends Application {
    
    @Override
    public void start(Stage window) {
        
        //Main layout
        window.setTitle("Pilkkusääntöjen harjoittelu");
        
        BorderPane basicLayout = new BorderPane();
        
        HBox navigation = new HBox();
        navigation.setPadding(new Insets(20,20,20,20));
        navigation.setSpacing(10);
        
        Button practiceButton = new Button("Harjoittele");
        Button createButton = new Button("Lisää tehtävä");
        Button userButton = new Button("Käyttäjätiedot");
        
        //Note to self: add rest of the buttons to this very command when ready
        navigation.getChildren().addAll(practiceButton, createButton, userButton);
        
        basicLayout.setTop(navigation);
        
        //Subscenes includind different functionalities
        //In the beginning, just a placeholder
        
        Label placeholder = new Label("Tähän tulee harjoitustehtävän näkymä");
        
        basicLayout.setCenter(placeholder);
        
        //Creating and showing scene in GUI
        Scene basicView = new Scene(basicLayout);
        
        window.setScene(basicView);
        window.show();
    }
}
