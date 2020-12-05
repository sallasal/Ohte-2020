/**
 *
 * @author sallasal
 */
package comma.ui;

import comma.domain.*;
import java.sql.SQLException;
import javafx.geometry.*;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class LoggedInScene {

    private Scene login;
    private Scene loggedInScene;
    BorderPane basicLayout;

    public LoggedInScene() {

    }

    public void setLoginScene(Scene scene) {
        this.login = scene;
    }

    public Scene getLoggedInScene(CommaService commaService, Stage window) {
        this.basicLayout = new BorderPane();
        this.loggedInScene = new Scene(basicLayout);

        HBox navigation = new HBox();
        navigation.setPadding(new Insets(20, 20, 20, 20));
        navigation.setSpacing(10);

        Button practiceButton = new Button("Harjoittele");
        Button createButton = new Button("Lisää tehtävä");
        Button userButton = new Button("Käyttäjätiedot");
        Button logoutButton = new Button("Kirjaudu ulos");

        Label start = new Label("Aloita valitsemalla toiminto.");

        //Note to self: add rest of the buttons to this very command when ready
        navigation.getChildren().addAll(practiceButton, createButton, userButton, logoutButton);

        basicLayout.setTop(navigation);

        basicLayout.setCenter(start);

        // Create subscenes and add functionalities
        // For now, only PracticeView is working
        AddView addView = new AddView(this.basicLayout, commaService);
        FeedbackView feedbackView = new FeedbackView();
        PracticeView practiceView = new PracticeView(this.basicLayout, commaService, feedbackView);
        StatisticsView statisticsView = new StatisticsView(this.basicLayout, commaService);

        practiceButton.setOnAction((event) -> {
            try {
                basicLayout.setCenter(practiceView.getPracticeView(commaService.getRandomExercise()));
            } catch (SQLException e) {
                System.out.println(e.getMessage());;
            }
        });
        
        createButton.setOnAction((event) -> {
            basicLayout.setCenter(addView.getAddView());
        });
        
        userButton.setOnAction((event) -> {
            basicLayout.setCenter(statisticsView.getStatisticsView());
        });

        logoutButton.setOnAction((event) -> {
            window.setScene(login);
        });

        return this.loggedInScene;
    }
}
