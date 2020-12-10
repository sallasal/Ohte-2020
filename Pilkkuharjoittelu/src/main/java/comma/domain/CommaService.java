/**
 * @author sallasal
 */
package comma.domain;

import comma.dao.*;
import java.util.*;
import java.sql.*;

/**
 * This class takes care of all interaction between database and GUI. Class
 * fetches values from database and also writes to database via DAOs. Class also
 * calculates parameter based values for db and GUI. Class also saves user
 * information for each session.
 */
public class CommaService {

    private ExerciseDao db;
    private UserDao userDao;
    private User user;

    public CommaService(String dbLocation) throws Exception {
        this.db = new ExerciseDaoDb(dbLocation);
        db.initialize();
        this.userDao = new UserDaoDb(dbLocation);
        this.user = null;
    }

    public String getUsername() {
        return this.user.getUsername();
    }
    
    public String getName() {
        return this.user.getName();
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return this.user;
    }

    /**
     * Create a new user if username does not already exist
     *
     * @param username username that is going to be created
     * @param name name for the user that is used in GUI
     *
     * @return boolean true, if user is created succesfully, false otherwise
     * @throws java.lang.Exception
     */
    public boolean createUser(String username, String name) throws Exception {
        User userToAdd = new User(username, name);

        User validate = userDao.findByUsername(username);

        if (validate.getUsername() == null) {
            userDao.add(userToAdd);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Creates a new user if username does not already exist, defines an user
     * for user session as class variable
     *
     * @param username username that is going to be validated
     *
     * @return boolean true, if username is free (does not already exist), false
     * otherwise
     * @throws java.lang.Exception
     */
    public boolean validateUsername(String username) throws Exception {
        User validate = userDao.findByUsername(username);

        if (validate.getUsername() == null) {
            return false;
        } else {
            this.user = validate;
            return true;
        }
    }

    /**
     * Fetches number of passed exercises in defined category for logged in user
     *
     * @param category category number from which the value is going to be
     * fetched
     *
     * @return integer that shows how many exercises are completed from defined
     * category
     * @throws java.lang.Exception
     */
    public int getCompletedExercises(int category) throws Exception {
        return userDao.passedExercisesInCategory(this.user.getUsername(), category);
    }

    /**
     * Fetches number of passed exercises in defined category for logged in
     * user, then adds +1 for it and replaces old value in database with new one
     *
     * @param category category number to which the completion is added
     * @throws java.lang.Exception
     *
     */
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

    /**
     * Checks if user has prize in defined category
     *
     * @param category category that the prize is checked from
     *
     * @return true, if prize is set, false otherwise
     * @throws java.lang.Exception
     */
    public String checkPrize(int category) throws Exception {
        int exerciseCount = userDao.passedExercisesInCategory(this.user.getUsername(), category);
        if (exerciseCount >= 3) {
            if (category == 1) {
                return "Päälauseiden pääministeri";
            } else if (category == 2) {
                return "Sivulauseiden saalistaja";
            } else if (category == 3) {
                return "Erikoistapausten esitaistelija";
            }
        }
        return "-";
    }
    
    /**
     * Checks if user has new prize in defined category
     *
     * @param category category that the prize is checked from
     *
     * @return Prize string for feedback view, if prize is earned now. Empty string otherwise.
     * @throws java.lang.Exception
     */
    public String checkNewPrize(int category) throws Exception {
        int exerciseCount = userDao.passedExercisesInCategory(this.user.getUsername(), category);
        if (exerciseCount == 3) {
            if (category == 1) {
                return "Onnea! Ansaitsit Päälauseiden pääministeri -palkinnon!";
            } else if (category == 2) {
                return "Onnea! Ansaitsit Sivulauseiden saalistaja -palkinnon!";
            } else if (category == 3) {
                return "Onnea! Ansaitsit Erikoistapausten esitaistelija -palkinnon!";
            }
        }
        return "";
    }

    /**
     * Nulls the user information in CommaService class parameter, used when
     * user logs out
     *
     */
    public void nullUser() {
        this.user = null;
    }

    /**
     * Deletes an user from database based on username
     *
     * @param username username for user that is deleted
     * @throws java.lang.Exception
     */
    public void deleteUser(String username) throws Exception {
        userDao.delete(username);
    }

    /**
     * Gets random exercise from all exercises not created by user from database
     *
     * @return Exercise object
     * @throws java.sql.SQLException
     */
    public Exercise getRandomExercise() throws SQLException {
        ArrayList<Exercise> exList = db.listAll(this.user.getUsername());

        Random random = new Random();

        return exList.get(random.nextInt(exList.size()));
    }

    /**
     * Creates new exercise to the database
     *
     * @param firstpart String for sentence part before comma place
     * @param secondpart String for sentence part after comma place
     * @param comma Integer 1 if comma is needed, 0 otherwise (0 is default if
     * any other value is given)
     * @param category Integer for exercise category: 1 = main clause, 2 =
     * subordinate clause, 3 = some other case
     * @param user String for username that indicates who is adding exercise
     * @throws java.lang.Exception
     */
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
