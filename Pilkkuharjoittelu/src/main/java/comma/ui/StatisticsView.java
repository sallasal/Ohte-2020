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
import javafx.scene.text.*;

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
        
        Font headerFont = Font.font(null, FontWeight.BOLD, 14);
        
        Label header = new Label("Tilastot käyttäjälle " + commaService.getName());
        header.setFont(headerFont);
        header.setWrapText(true);
        Label completedExercisesh2 = new Label("Suoritettuja tehtäviä:");
        completedExercisesh2.setFont(headerFont);
        Label completedCtg1 = new Label("Päälausetehtäviä " + String.valueOf(commaService.getCompletedExercises(1)));
        Label completedCtg2 = new Label("Sivulausetehtäviä " + String.valueOf(commaService.getCompletedExercises(2)));
        Label completedCtg3 = new Label("Erikoistapaustehtäviä " + String.valueOf(commaService.getCompletedExercises(3)));
        Label achievements = new Label("Saavutetut palkinnot:");
        achievements.setFont(headerFont);
        Label prizeCtg1 = new Label("Päälauseet: "+commaService.checkPrize(1));
        Label prizeCtg2 = new Label("Sivulauseet: "+commaService.checkPrize(2));
        Label prizeCtg3 = new Label("Erikoistapaukset: "+commaService.checkPrize(3));
        
        statisticsView.addColumn(0, header, completedExercisesh2, completedCtg1, 
                completedCtg2, completedCtg3, achievements, prizeCtg1, prizeCtg2, prizeCtg3);

        return statisticsView;
    }

}
