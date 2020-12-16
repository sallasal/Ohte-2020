package comma.ui;

import comma.domain.*;
import javafx.geometry.*;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.*;

public class PracticeView {

    private BorderPane basicLayout;
    private int correct;
    private CommaService commaService;
    private FeedbackView feedbackView;

    public PracticeView(BorderPane basicLayout, CommaService commaService, FeedbackView feedbackView) {
        this.basicLayout = basicLayout;
        this.commaService = commaService;
        this.feedbackView = feedbackView;
        this.correct = 0;
    }

    public Parent getPracticeView(Exercise ex) {
        GridPane practiceView = new GridPane();

        ColumnConstraints constraint = new ColumnConstraints(400);
        practiceView.setAlignment(Pos.CENTER);
        practiceView.setVgap(20);
        practiceView.setPadding(new Insets(10, 10, 10, 10));

        Label header = new Label("Ratkaise tehtävä");
        header.setFont(Font.font(null, FontWeight.BOLD, 14));
        Label instruction = new Label("Valitse, tuleeko lauseen alku- ja loppuosan väliin pilkku.");
        instruction.setWrapText(true);
        Label firstPart = new Label(ex.getFirstPart());
        Label secondPart = new Label(ex.getSecondPart());
        Label feedback = new Label("");
        Label statistics = new Label("");
        Label empty = new Label("");
        Label empty2 = new Label("");

        Button yesComma = new Button("Kyllä, tulee pilkku");
        Button noComma = new Button("Ei, ei tule pilkkua");

        practiceView.addColumn(0, header, instruction, empty, firstPart, secondPart, empty2, yesComma, noComma, feedback, statistics);
        

        //View functionalities
        yesComma.setOnAction((event) -> {
            boolean answer = true;
            String prizeFeedback = "";
            if (ex.getComma()) {
                feedbackView.setFeedback("Oikea vastaus, hyvä!");
                try {
                    this.commaService.addCompletion(ex.getCategory());
                    prizeFeedback = this.commaService.checkNewPrize(ex.getCategory());
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                Parent feedbackParent = feedbackView.getFeedbackView(prizeFeedback);
                basicLayout.setCenter(feedbackParent);
            } else {
                feedbackView.setFeedback("Väärä vastaus. Harjoittele lisää.");
                Parent feedbackParent = feedbackView.getFeedbackView(prizeFeedback);
                basicLayout.setCenter(feedbackParent);;
            }

        });

        noComma.setOnAction((event) -> {
            boolean answer = false;
            String prizeFeedback = "";
            if (!ex.getComma()) {
                feedbackView.setFeedback("Oikea vastaus, hyvä!");
                try {
                    this.commaService.addCompletion(ex.getCategory());
                    prizeFeedback = commaService.checkNewPrize(ex.getCategory());
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                Parent feedbackParent = feedbackView.getFeedbackView(prizeFeedback);
                basicLayout.setCenter(feedbackParent);
            } else {
                feedbackView.setFeedback("Väärä vastaus. Harjoittele lisää.");
                Parent feedbackParent = feedbackView.getFeedbackView("");
                basicLayout.setCenter(feedbackParent);
            }
        });

        return practiceView;
    }
}
