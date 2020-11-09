/**
 *
 * @author sallasal
 */
package comma.ui;

import javafx.application.Application;
import javafx.event.*;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import comma.domain.*;

public class CommaGUI extends Application {

    private CommaService commaService;

    @Override
    public void init() throws Exception {
        this.commaService = new CommaService();
    }

    @Override
    public void start(Stage window) {

        //Main layout
        window.setTitle("Pilkkusääntöjen harjoittelu");
        window.setWidth(500.00);
        window.setHeight(500.00);

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
            basicLayout.setCenter(practiceView.getPracticeView(this.commaService.getRandomExercise()));
        });

        basicLayout.setCenter(start);

        //Creating and showing scene in GUI
        Scene basicView = new Scene(basicLayout);

        window.setScene(basicView);
        window.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
