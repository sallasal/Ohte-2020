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


public class LogInScene {
    
    public LogInScene() {
        
    }
    
    public Scene getLogInScene(CommaService commaService) {
        GridPane loginLayout = new GridPane();
        
        loginLayout.setAlignment(Pos.CENTER);
        loginLayout.setVgap(20);
        loginLayout.setPadding(new Insets(10,10,10,10));
        
        
        Label instructions = new Label("Syötä käyttäjänimi:");
        
        TextField usernameField = new TextField("");
        
        Button loginButton = new Button("Kirjaudu");
        Button registerButton = new Button("Rekisteröi uusi käyttäjä");
        
        loginLayout.add(instructions, 0, 1);
        loginLayout.add(usernameField, 0, 2);
        loginLayout.add(loginButton, 0, 3);
        loginLayout.add(registerButton, 0, 5);
        
        
        return new Scene(loginLayout);
    }
}
