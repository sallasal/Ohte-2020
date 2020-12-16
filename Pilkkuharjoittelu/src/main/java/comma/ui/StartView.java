/**
 *
 * @author sallasal
 */

package comma.ui;


import javafx.geometry.*;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class StartView {
    
    public StartView() {
        
    }

    public Parent getStartView() {
        GridPane startView = new GridPane();

        ColumnConstraints constraint = new ColumnConstraints(300);
        startView.getColumnConstraints().add(constraint);
        startView.setAlignment(Pos.CENTER);
        startView.setVgap(20);
        startView.setPadding(new Insets(10, 10, 10, 10));

        Label instruction = new Label("Aloita valitsemalla toiminto.");

        startView.add(instruction, 0, 0);

        return startView;
    }
}
