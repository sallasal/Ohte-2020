package comma.domain;

import comma.domain.*;
import comma.dao.*;
import comma.ui.*;
import java.util.*;
import java.sql.*;
import javafx.application.Application;

public class CommaService {
    private ExerciseDao db;

    public CommaService() throws Exception {
        db = new ExerciseDaoDb();
        db.initialize();
    }

    public Exercise getRandomExercise() throws SQLException {
        ArrayList<Exercise> exList = db.listAll();

        Random random = new Random();

        return exList.get(random.nextInt(exList.size()));
    }
}
