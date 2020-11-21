/**
 *
 * @author sallasal
 */

package comma.ui;

import comma.domain.*;
import java.sql.SQLException;
import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;


public class LoggedInScene {
    
    public LoggedInScene() {
        
    }
    
    public Scene getLoggedInScene(CommaService commaService) {
        BorderPane basicLayout = new BorderPane();

        HBox navigation = new HBox();
        navigation.setPadding(new Insets(20, 20, 20, 20));
        navigation.setSpacing(10);

        Button practiceButton = new Button("Harjoittele");
        Button createButton = new Button("Lisää tehtävä");
        Button userButton = new Button("Käyttäjätiedot");
        Label start = new Label("Aloita valitsemalla toiminto.");

        //Note to self: add rest of the buttons to this very command when ready
        navigation.getChildren().addAll(practiceButton, createButton, userButton);

        basicLayout.setTop(navigation);

        //Subscenes includind different functionalities
        //For now, only practicing is working.
        practiceButton.setOnAction((event) -> {
            PracticeView practiceView = new PracticeView();
            try {
                basicLayout.setCenter(practiceView.getPracticeView(commaService.getRandomExercise()));
            } catch (SQLException e) {
                System.out.println(e.getMessage());;
            }
        });

        basicLayout.setCenter(start);

        
        return new Scene(basicLayout);
    }
}
