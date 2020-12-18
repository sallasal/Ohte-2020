/**
 *
 * @author sallasal
 */
package comma.ui;

import javafx.geometry.*;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.*;

public class FeedbackView {

    private String feedback;
    private String statisticsText;

    public FeedbackView() {
        this.feedback = "";
        this.statisticsText = "";
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public Parent getFeedbackView(String prizeFeedback) {
        GridPane feedbackView = new GridPane();

        ColumnConstraints constraint = new ColumnConstraints(500);
        feedbackView.getColumnConstraints().add(constraint);
        feedbackView.setAlignment(Pos.CENTER);
        feedbackView.setVgap(20);
        feedbackView.setPadding(new Insets(10, 10, 10, 10));

        Label feedbackLabel = new Label(this.feedback);
        feedbackLabel.setFont(Font.font(null, FontWeight.BOLD, 14));
        Text statisticsLabel = new Text(prizeFeedback);
        statisticsLabel.setFill(Color.GREEN);
        statisticsLabel.setFont(Font.font(null, FontWeight.BOLD, 14));
        Label instruction = new Label("Valitse ylävalikosta 'Harjoittele', jos haluat tehdä uuden tehtävän.");
        feedbackLabel.setWrapText(true);
        instruction.setWrapText(true);
        
        feedbackView.addColumn(0, feedbackLabel, statisticsLabel, instruction);

        return feedbackView;
    }
}
