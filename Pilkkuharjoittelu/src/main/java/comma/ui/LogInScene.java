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
import javafx.stage.Stage;

public class LogInScene {
    
    private Scene register;
    private Scene logged;

    public LogInScene() {

    }
    
    public void setRegisterScene(Scene scene) {
        this.register=scene;
    }
    
    public void setLoggedScene(Scene scene) {
        this.logged = scene;
    }

    public Scene getLogInScene(CommaService commaService, Stage window) {
        GridPane loginLayout = new GridPane();

        loginLayout.setAlignment(Pos.CENTER);
        loginLayout.setVgap(20);
        loginLayout.setPadding(new Insets(10, 10, 10, 10));

        Label instructions = new Label("Syötä käyttäjänimi:");

        TextField usernameField = new TextField("");

        Button loginButton = new Button("Kirjaudu");
        Button registerButton = new Button("Rekisteröi uusi käyttäjä");

        loginButton.setOnAction((event) -> {
            window.setScene(this.logged);
        });
        
        registerButton.setOnAction((event) -> {
            window.setScene(this.register);
        });        
        

        loginLayout.add(instructions, 0, 1);
        loginLayout.add(usernameField, 0, 2);
        loginLayout.add(loginButton, 0, 3);
        loginLayout.add(registerButton, 0, 5);

        return new Scene(loginLayout);
    }
}
