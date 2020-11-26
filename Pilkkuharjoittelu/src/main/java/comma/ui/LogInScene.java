/**
 *
 * @author sallasal
 */
package comma.ui;

import comma.domain.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class LogInScene {

    private Scene register;
    private Scene logged;

    public LogInScene() {

    }

    public void setRegisterScene(Scene scene) {
        this.register = scene;
    }

    public void setLoggedScene(Scene scene) {
        this.logged = scene;
    }

    public Scene getLogInScene(CommaService commaService, Stage window) {
        GridPane loginLayout = new GridPane();

        ColumnConstraints constraint = new ColumnConstraints(200);
        loginLayout.getColumnConstraints().add(constraint);
        loginLayout.setAlignment(Pos.CENTER);
        loginLayout.setVgap(20);
        loginLayout.setPadding(new Insets(10, 10, 10, 10));

        Label instructions = new Label("Syötä käyttäjänimi:");
        Label feedback = new Label("");
        feedback.setWrapText(true);

        TextField usernameField = new TextField("");

        Button loginButton = new Button("Kirjaudu");
        Button registerButton = new Button("Rekisteröi uusi käyttäjä");

        loginButton.setOnAction((event) -> {
            try {
                if (commaService.validateUsername(usernameField.getText())) {
                    window.setScene(this.logged);
                } else {
                    usernameField.clear();
                    feedback.setText("Kirjautuminen ei onnistunut. Yritä uudelleen tai rekisteröidy.");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        });

        registerButton.setOnAction((event) -> {
            window.setScene(this.register);
        });

        loginLayout.add(instructions, 0, 1);
        loginLayout.add(usernameField, 0, 2);
        loginLayout.add(loginButton, 0, 3);
        loginLayout.add(feedback, 0, 4);
        loginLayout.add(registerButton, 0, 6);

        return new Scene(loginLayout);
    }
}
