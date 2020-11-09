package comma.domain;

import comma.domain.*;
import comma.dao.*;
import comma.ui.*;
import java.util.*;
import java.sql.*;
import javafx.application.Application;

public class CommaService {

    private ExerciseDaoDb exDao;

    public CommaService() {
        this.exDao = new ExerciseDaoDb();
        exDao.alusta();
    }

    public Exercise getRandomExercise() {
        ArrayList<Exercise> exList = exDao.listAll();

        Random random = new Random();

        return exList.get(random.nextInt(exList.size()));
    }
}
