package comma.ui;

import comma.domain.*;
import comma.dao.*;
import comma.ui.*;
import javafx.geometry.*;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class PracticeView {

    public PracticeView() {

    }

    public Parent getPracticeView(Exercise ex) {
        GridPane practiceView = new GridPane();

        practiceView.setAlignment(Pos.CENTER);
        practiceView.setVgap(20);
        practiceView.setPadding(new Insets(10, 10, 10, 10));

        Label firstPart = new Label(ex.getFirstPart());
        Label secondPart = new Label(ex.getSecondPart());
        Label feedback = new Label("");
        Label statistics = new Label("");

        Button yesComma = new Button("Kyllä, tulee pilkku");
        Button noComma = new Button("Ei, ei tule pilkkua");

        //View functionalities
        yesComma.setOnAction((event) -> {
            boolean answer = true;
            //Vaihda if-lauseen ehto vertailuksi arvotun olion vastaukseen
            if (ex.getComma()) {
                feedback.setText("Oikea vastaus!");
                statistics.setText("Tilastot ja palkinnot -placeholder");
            } else {
                feedback.setText("Väärin. Harjoittele lisää.");
                statistics.setText("Tilastot ja palkinnot -placeholder");
            }

        });

        noComma.setOnAction((event) -> {
            boolean answer = false;
            //Vaihda if-lauseen ehto vertailuksi arvotun olion vastaukseen
            if (!ex.getComma()) {
                feedback.setText("Oikea vastaus!");
                statistics.setText("Tilastot ja palkinnot -placeholder");
            } else {
                feedback.setText("Väärin. Harjoittele lisää.");
                statistics.setText("Tilastot ja palkinnot -placeholder");
            }
        });

        //Order view
        practiceView.add(firstPart, 0, 1);
        practiceView.add(secondPart, 0, 2);

        practiceView.add(yesComma, 0, 4);
        practiceView.add(noComma, 0, 5);

        practiceView.add(feedback, 0, 7);
        practiceView.add(statistics, 0, 8);

        return practiceView;
    }
}
