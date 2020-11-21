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
        Label nameInstructions = new Label("Syötä uusi salasana");

        TextField usernameField = new TextField();
        TextField nameField = new TextField();

        Button registerButton = new Button("Rekisteröi käyttäjä");
        Button loginButton = new Button("Palaa kirjautumiseen");

        loginButton.setOnAction((event) -> {
            window.setScene(login);
        });

        registerLayout.add(usernameInstructions, 0, 1);
        registerLayout.add(usernameField, 0, 2);
        registerLayout.add(nameInstructions, 0, 3);
        registerLayout.add(nameField, 0, 4);
        registerLayout.add(registerButton, 0, 5);
        registerLayout.add(loginButton, 0, 7);

        return new Scene(registerLayout);
    }
}
