package comma.domain;

import comma.domain.*;
import comma.dao.*;
import comma.ui.*;
import java.util.*;
import java.sql.*;
import javafx.application.Application;

public class CommaService {

    private ExerciseDao db;
    private UserDao userDao;
    private User user;

    public CommaService() throws Exception {
        this.db = new ExerciseDaoDb();
        db.initialize();
        this.userDao = new UserDaoDb();
        this.user = null;
    }

    // User methods
    public boolean createUser(String username, String name) throws Exception {
        User userToAdd = new User(username, name);

        //Validate here that this username does not already exist
        User validate = userDao.findByUsername(username);

        if (validate.getUsername() == null) {
            userDao.add(userToAdd);
            return true;
        } else {
            return false;
        }
    }

    public boolean validateUsername(String username) throws Exception {
        User validate = userDao.findByUsername(username);

        if (validate.getUsername() == null) {
            return false;
        } else {
            this.user = validate;
            return true;
        }
    }

    public int getCompletedExercises(int category) throws Exception {
        return userDao.passedExercisesInCategory(this.user.getUsername(), category);
    }

    public void addCompletion(int category) throws Exception {
        int currentCount = -2;
        if (category == 1) {
            currentCount = this.getCompletedExercises(1);
        } else if (category == 2) {
            currentCount = this.getCompletedExercises(2);
        } else if (category == 3) {
            currentCount = this.getCompletedExercises(3);
        }

        currentCount++;
        userDao.addCompletion(this.getUsername(), category, currentCount);
    }

    public String getUsername() {
        return this.user.getUsername();
    }
    
    public void nullUser() {
        this.user = null;
    }

    public void deleteUser(String username) throws Exception {
        userDao.delete(username);
    }

    // Exercise methods
    public Exercise getRandomExercise() throws SQLException {
        ArrayList<Exercise> exList = db.listAll();

        Random random = new Random();

        return exList.get(random.nextInt(exList.size()));
    }

    public void createExercise(String firstpart, String secondpart,
            int comma, int category, String user) throws Exception {

        boolean commaBoolean = false;

        if (comma == 1) {
            commaBoolean = true;
        }

        Exercise exerciseToAdd = new Exercise(firstpart, secondpart, commaBoolean, category, user);

        db.add(exerciseToAdd);
    }
}
