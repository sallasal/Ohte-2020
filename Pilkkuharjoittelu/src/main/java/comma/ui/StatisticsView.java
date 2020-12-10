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

    public Parent getStatisticsView() throws Exception {
        GridPane statisticsView = new GridPane();

        ColumnConstraints constraint = new ColumnConstraints(500);
        statisticsView.getColumnConstraints().add(constraint);
        statisticsView.setAlignment(Pos.CENTER);
        statisticsView.setVgap(20);
        statisticsView.setPadding(new Insets(10, 10, 10, 10));
        
        Label header = new Label("Tilastot käyttäjälle " + commaService.getName());
        header.setWrapText(true);
        Label completedExercisesh2 = new Label("Suoritettuja tehtäviä:");
        Label completedCtg1 = new Label("Päälausetehtäviä " + String.valueOf(commaService.getCompletedExercises(1)));
        Label completedCtg2 = new Label("Sivulausetehtäviä " + String.valueOf(commaService.getCompletedExercises(2)));
        Label completedCtg3 = new Label("Erikoistapaustehtäviä " + String.valueOf(commaService.getCompletedExercises(3)));
        Label achievements = new Label("Saavutetut palkinnot:");
        Label prizeCtg1 = new Label("Päälauseet: "+commaService.checkPrize(1));
        Label prizeCtg2 = new Label("Sivulauseet: "+commaService.checkPrize(2));
        Label prizeCtg3 = new Label("Erikoistapaukset: "+commaService.checkPrize(3));
        
        statisticsView.add(header, 0, 0);
        statisticsView.add(completedExercisesh2, 0, 2);
        statisticsView.add(completedCtg1, 0, 3);
        statisticsView.add(completedCtg2, 0, 4);
        statisticsView.add(completedCtg3, 0, 5);
        statisticsView.add(achievements, 0, 7);
        statisticsView.add(prizeCtg1, 0, 8);
        statisticsView.add(prizeCtg2, 0, 9);
        statisticsView.add(prizeCtg3, 0, 10);

        return statisticsView;
    }

}
