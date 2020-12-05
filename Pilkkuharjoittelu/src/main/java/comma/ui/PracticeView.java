package comma.ui;

import comma.domain.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.geometry.*;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class PracticeView {

    private BorderPane basicLayout;
    private int correct;
    private CommaService commaService;
    private FeedbackView feedbackView;

    public PracticeView(BorderPane basicLayout, CommaService commaService, FeedbackView feedbackView) {
        this.basicLayout = basicLayout;
        this.commaService = commaService;
        this.feedbackView= feedbackView;
        this.correct = 0;
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

        //Order view
        practiceView.add(firstPart, 0, 1);
        practiceView.add(secondPart, 0, 2);

        practiceView.add(yesComma, 0, 4);
        practiceView.add(noComma, 0, 5);

        practiceView.add(feedback, 0, 7);
        practiceView.add(statistics, 0, 8);

        //View functionalities
        yesComma.setOnAction((event) -> {
            boolean answer = true;
            if (ex.getComma()) {
                feedbackView.setFeedback("Oikea vastaus, hyvä!");
                try {
                    this.commaService.addCompletion(ex.getCategory());
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                Parent feedbackParent = feedbackView.getFeedbackView();
                basicLayout.setCenter(feedbackParent);
            } else {
                feedbackView.setFeedback("Väärä vastaus. Harjoittele lisää.");
                Parent feedbackParent = feedbackView.getFeedbackView();
                basicLayout.setCenter(feedbackParent);;
            }

        });

        noComma.setOnAction((event) -> {
            boolean answer = false;
            if (!ex.getComma()) {
                feedbackView.setFeedback("Oikea vastaus, hyvä!");
                try {
                    this.commaService.addCompletion(ex.getCategory());
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                Parent feedbackParent = feedbackView.getFeedbackView();
                basicLayout.setCenter(feedbackParent);
            } else {
                feedbackView.setFeedback("Väärä vastaus. Harjoittele lisää.");
                Parent feedbackParent = feedbackView.getFeedbackView();
                basicLayout.setCenter(feedbackParent);
            }
        });


        return practiceView;
    }
}
