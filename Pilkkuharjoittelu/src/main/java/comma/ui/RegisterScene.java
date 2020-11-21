/**
 *
 * @author sallasal
 */
package comma.ui;

import comma.domain.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class RegisterScene {

    private Scene login;

    public RegisterScene() {

    }

    public void setLoginScene(Scene scene) {
        this.login = scene;
    }

    public Scene getRegisterScene(CommaService commaService, Stage window) {
        GridPane registerLayout = new GridPane();

        registerLayout.setAlignment(Pos.CENTER);
        registerLayout.setVgap(20);
        registerLayout.setPadding(new Insets(10, 10, 10, 10));

        Label usernameInstructions = new Label("Syötä uusi käyttäjänimi");
        Label nameInstructions = new Label("Syötä käyttäjän nimi");
        Label message = new Label("");

        TextField usernameField = new TextField();
        TextField nameField = new TextField();

        Button registerButton = new Button("Rekisteröi käyttäjä");
        Button loginButton = new Button("Palaa kirjautumiseen");

        registerButton.setOnAction((event) -> {
            try {
                boolean earlier = commaService.createUser(usernameField.getText(), nameField.getText());

                if (earlier) {
                    message.setText("Käyttäjä lisätty. Kirjaudu seuraavaksi sisään.");
                } else {
                    message.setText("Käyttäjää ei lisätty, käyttäjänimi on jo käytössä.");
                }

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        });

        loginButton.setOnAction((event) -> {
            window.setScene(login);
        });

        registerLayout.add(usernameInstructions, 0, 1);
        registerLayout.add(usernameField, 0, 2);
        registerLayout.add(nameInstructions, 0, 3);
        registerLayout.add(nameField, 0, 4);
        registerLayout.add(registerButton, 0, 5);
        registerLayout.add(message, 0, 6);
        registerLayout.add(loginButton, 0, 8);

        return new Scene(registerLayout);
    }
}
