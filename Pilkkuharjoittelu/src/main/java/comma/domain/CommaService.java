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
    
    // This is used just for testing, is it OK to have it here?
    public void deleteUser(String username) throws Exception {
        userDao.delete(username);
    }
    
    // Exercise methods
    public Exercise getRandomExercise() throws SQLException {
        ArrayList<Exercise> exList = db.listAll();

        Random random = new Random();

        return exList.get(random.nextInt(exList.size()));
    }
}
