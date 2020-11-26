/**
 *
 * @author sallasal
 */
package comma.ui;

import comma.domain.*;
import javafx.geometry.*;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class AddView {

    public AddView() {

    }

    public Parent getAddView() {
        GridPane addView = new GridPane();

        ColumnConstraints constraint = new ColumnConstraints(300);
        addView.getColumnConstraints().add(constraint);
        addView.setAlignment(Pos.CENTER);
        addView.setVgap(20);
        addView.setPadding(new Insets(10, 10, 10, 10));

        Label placeholder = new Label("Tähän tulee uuden tehtävän lisäys.");
        
        addView.add(placeholder, 0, 0);

        return addView;
    }

}
