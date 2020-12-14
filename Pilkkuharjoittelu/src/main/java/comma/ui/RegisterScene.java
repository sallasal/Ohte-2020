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

        ColumnConstraints constraint = new ColumnConstraints(300);
        registerLayout.getColumnConstraints().add(constraint);        
        registerLayout.setAlignment(Pos.CENTER);
        registerLayout.setVgap(20);
        registerLayout.setPadding(new Insets(10, 10, 10, 10));

        Label usernameInstructions = new Label("Syötä uusi käyttäjänimi");
        Label nameInstructions = new Label("Syötä käyttäjän nimi");
        Label message = new Label("");
        message.setWrapText(true);

        TextField usernameField = new TextField();
        TextField nameField = new TextField();

        Button registerButton = new Button("Rekisteröi käyttäjä");
        Button loginButton = new Button("Palaa kirjautumiseen");

        registerButton.setOnAction((event) -> {
            try {
                boolean earlier = commaService.createUser(usernameField.getText(), nameField.getText());

                if (earlier) {
                    usernameField.clear();
                    nameField.clear();
                    message.setText("Käyttäjä lisätty. Kirjaudu seuraavaksi sisään.");
                } else {
                    message.setText("Käyttäjää ei lisätty. Käyttäjänimi voi olla käytössä. "
                            + "Käyttäjänimen ja nimen pituuden on oltava vähintään 3 ja enintään 30 merkkiä.");
                }

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        });

        loginButton.setOnAction((event) -> {
            window.setScene(login);
        });
        
        registerLayout.addColumn(0, usernameInstructions, usernameField, nameInstructions, nameField, registerButton, message, loginButton);

        return new Scene(registerLayout);
    }
}
