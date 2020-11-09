package comma.ui;

import javafx.geometry.*;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class PracticeView {

    public PracticeView() {

    }

    public Parent getPracticeView() {
        GridPane practiceView = new GridPane();

        practiceView.setAlignment(Pos.CENTER);
        practiceView.setVgap(20);
        practiceView.setPadding(new Insets(10, 10, 10, 10));

        Label firstPart = new Label("Tähän tulee alkuosa" + " _____");
        Label secondPart = new Label("Tähän tulee loppuosa");
        Label feedback = new Label("Palautteen placeholder");
        Label statistics = new Label("Tilastot ja palkinnot");

        Button yesComma = new Button("Kyllä, tulee pilkku");
        Button noComma = new Button("Ei, ei tule pilkkua");
        
        //View functionalities
        yesComma.setOnAction((event) -> {
            boolean answer = true;
            //Vaihda if-lauseen ehto vertailuksi arvotun olion vastaukseen
            if (answer == true) {
                feedback.setText("Oikea vastaus!");
            } else {
                feedback.setText("Väärin. Harjoittele lisää.");
            }
            
        });
        
        noComma.setOnAction((event) -> {
           boolean answer = false;
           //Vaihda if-lauseen ehto vertailuksi arvotun olion vastaukseen
           if (answer == false) {
               feedback.setText("Oikea vastaus!");
           } else {
               feedback.setText("Väärin. Harjoittele lisää.");
           }
        });
        
        //Order view
        practiceView.add(firstPart, 0, 1);
        practiceView.add(secondPart, 0, 2);

        practiceView.add(yesComma, 0, 4);
        practiceView.add(noComma, 0, 5);
        
        practiceView.add(feedback,0,7);
        practiceView.add(statistics,0,8);

        return practiceView;
    }
}
