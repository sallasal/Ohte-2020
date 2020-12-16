/**
 *
 * @author sallasal
 */
package comma.ui;

import comma.domain.*;
import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.scene.text.*;
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

        ColumnConstraints constraint = new ColumnConstraints(300);
        loginLayout.getColumnConstraints().add(constraint);
        loginLayout.setAlignment(Pos.CENTER);
        loginLayout.setVgap(20);
        loginLayout.setPadding(new Insets(10, 10, 10, 10));

        Label header = new Label("Kirjaudu sisään Pilkkuharjoitteluun!");
        header.setFont(Font.font(null, FontWeight.BOLD, 14));
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
        
        loginLayout.addColumn(0, header, instructions, usernameField, loginButton, feedback, registerButton);
        
        return new Scene(loginLayout);
    }
}
