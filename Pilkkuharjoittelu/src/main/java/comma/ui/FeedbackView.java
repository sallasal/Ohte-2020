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

    public void setStatisticsText(String statisticstest) {
        this.statisticsText = statisticsText;
    }

    public Parent getFeedbackView(String prizeFeedback) {
        GridPane feedbackView = new GridPane();

        ColumnConstraints constraint = new ColumnConstraints(500);
        feedbackView.getColumnConstraints().add(constraint);
        feedbackView.setAlignment(Pos.CENTER);
        feedbackView.setVgap(20);
        feedbackView.setPadding(new Insets(10, 10, 10, 10));

        Label feedbackLabel = new Label(this.feedback);
        Label statisticsLabel = new Label(prizeFeedback);
        Label instruction = new Label("Valitse ylävalikosta 'Harjoittele', jos haluat tehdä uuden tehtävän.");
        feedbackLabel.setWrapText(true);
        statisticsLabel.setWrapText(true);
        instruction.setWrapText(true);

        feedbackView.add(feedbackLabel, 0, 0);
        feedbackView.add(statisticsLabel, 0, 1);
        feedbackView.add(instruction, 0 , 3);

        return feedbackView;
    }
}
