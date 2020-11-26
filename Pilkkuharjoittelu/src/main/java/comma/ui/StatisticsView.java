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

    public StatisticsView() {

    }

    public Parent getStatisticsView() {
        GridPane statisticsView = new GridPane();

        ColumnConstraints constraint = new ColumnConstraints(300);
        statisticsView.getColumnConstraints().add(constraint);
        statisticsView.setAlignment(Pos.CENTER);
        statisticsView.setVgap(20);
        statisticsView.setPadding(new Insets(10, 10, 10, 10));
        
        Label placeholder = new Label("Tähän tulee käyttäjätilastoja, kertyneet palkinnot ja käyttäjän poisto.");
        placeholder.setWrapText(true);
        
        statisticsView.add(placeholder, 0, 0);

        return statisticsView;
    }

}
