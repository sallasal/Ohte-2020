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

public class StatisticsView {
    private BorderPane basicLayout;
    private CommaService commaService;

    public StatisticsView(BorderPane basicLayout, CommaService commaService) {
        this.basicLayout = basicLayout;
        this.commaService = commaService;
    }

    public Parent getStatisticsView() {
        GridPane statisticsView = new GridPane();

        ColumnConstraints constraint = new ColumnConstraints(500);
        statisticsView.getColumnConstraints().add(constraint);
        statisticsView.setAlignment(Pos.CENTER);
        statisticsView.setVgap(20);
        statisticsView.setPadding(new Insets(10, 10, 10, 10));
        
        Label header = new Label("Tilastot käyttäjälle " + commaService.getUsername());
        header.setWrapText(true);
        Label completedExercisesh2 = new Label("Suoritettuja tehtäviä:");
        Label completedCtg1 = new Label("Päälausetehtäviä " + String.valueOf(commaService.getCompletedExercises(1)));
        
        statisticsView.add(header, 0, 0);
        statisticsView.add(completedExercisesh2, 0, 2);
        statisticsView.add(completedCtg1, 0, 3);

        return statisticsView;
    }

}
