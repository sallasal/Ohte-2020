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
    private BorderPane basicLayout;
    private CommaService commaService;

    public AddView(BorderPane basicLayout, CommaService commaService) {
        this.basicLayout = basicLayout;
        this.commaService = commaService;
    }

    public Parent getAddView() {
        GridPane addView = new GridPane();

        ColumnConstraints constraint = new ColumnConstraints(300);
        addView.getColumnConstraints().add(constraint);
        addView.setAlignment(Pos.CENTER);
        addView.setVgap(20);
        addView.setPadding(new Insets(10, 10, 10, 10));

        Label firstPartLab = new Label("Lauseen alkuosa:");
        Label secondPartLab = new Label("Lauseen loppuosa:");
        Label commaLab = new Label("Tuleeko väliin pilkku? \n (1 = kyllä, 0 = ei)");
        commaLab.setWrapText(true);
        Label categoryLab = new Label("Mitä kategoriaa harjoitus on? \n (1 = päälauseet, 2 = sivulauseet, \n 3 = erikoistapaukset)");
        categoryLab.setWrapText(true);
        Label feedbackLab = new Label("");
        feedbackLab.setWrapText(true);
        
        TextField firstPartField = new TextField();
        TextField secondPartField = new TextField();
        TextField commaField = new TextField();
        TextField categoryField = new TextField();
        
        Button addButton = new Button("Lisää harjoitus");
        
        addButton.setOnAction((event) -> {
            try {
                boolean create = (commaService.createExercise(firstPartField.getText(), secondPartField.getText(), 
                        Integer.valueOf(commaField.getText()), Integer.valueOf(categoryField.getText()), commaService.getUsername()));
                firstPartField.clear();
                secondPartField.clear();
                commaField.clear();
                categoryField.clear();
                if (create) {
                    feedbackLab.setText("Tehtävän lisääminen onnistui!");
                } else {
                    feedbackLab.setText("Tehtävän lisääminen ei onnistunut. "
                            + "Lauseen osien tulee olla 3-200 merkkiä pitkiä, ja muiden arvojen tulee olla annettujen joukossa.");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        });
        
        addView.add(firstPartLab, 0, 0);
        addView.add(firstPartField, 0, 1);
        addView.add(secondPartLab, 0, 2);
        addView.add(secondPartField, 0, 3);
        addView.add(commaLab, 0, 4);
        addView.add(commaField, 0, 5);
        addView.add(categoryLab, 0, 6);
        addView.add(categoryField, 0, 7);
        addView.add(addButton, 0, 9);
        addView.add(feedbackLab, 0, 10);
        

        return addView;
    }

}
