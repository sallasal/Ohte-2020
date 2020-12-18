/**
 *
 * @author sallasal
 */
package comma.dao;

import java.sql.*;
import comma.domain.*;

/**
 * Class takes care of database interactions with User tables and User objects.
 */
public class UserDaoDb implements UserDao {

    private Connection connection;

    /**
     * Generates a new ExerciseDaoDb instance that has database in given
     * location
     * @param dbLocation defines database location and driver
     */
    public UserDaoDb(String dbLocation) {
        this.connection = this.connect(dbLocation);
    }

    /**
     * Connects the class to database using SQLite JDBC driver
     * @param dbLocation defines location of database
     * @return Connection object for class to use
     */
    public Connection connect(String dbLocation) {
        String url = dbLocation;
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(url);
            DatabaseMetaData meta = connection.getMetaData();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return connection;
    }

    /**
     * Adds new row to User table based on User object
     * @param user User object that is to be added to the database
     * @throws java.lang.Exception
     */
    @Override
    public void add(User user) throws Exception {

        String sqlAddUser = "INSERT INTO Users (username, name, completedCtg1, completedCtg2, CompletedCtg3) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement stm = connection.prepareStatement(sqlAddUser)) {
            stm.setString(1, user.getUsername());
            stm.setString(2, user.getName());
            stm.setInt(3, user.getExercises(1));
            stm.setInt(4, user.getExercises(2));
            stm.setInt(5, user.getExercises(3));
            stm.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    /**
     * Deletes an user from database
     * @param username username for user that is going to be deleted
     * @throws java.lang.Exception
     */
    @Override
    public void delete(String username) throws Exception {

        String sqlDeleteUser = "DELETE FROM Users WHERE username = ?";

        try (PreparedStatement stm = connection.prepareStatement(sqlDeleteUser)) {
            stm.setString(1, username);
            stm.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    /**
     * Fetches user information from User table based on username
     * @param username Username for User that is searched from db
     * @return User object for the username
     * @throws java.lang.Exception
     */
    @Override
    public User findByUsername(String username) throws Exception {

        User userToReturn = new User();

        String sqlFindUsername = "SELECT username, name, completedCtg1, completedCtg2, CompletedCtg3 FROM Users WHERE (username == ?)";

        try (PreparedStatement stm = connection.prepareStatement(sqlFindUsername)) {
            stm.setString(1, username);
            ResultSet results = stm.executeQuery();

            while (results.next()) {
                String usrnm = results.getString("username");
                String name = results.getString("name");
                int completedCtg1 = results.getInt("completedCtg1");
                int completedCtg2 = results.getInt("completedCtg2");
                int completedCtg3 = results.getInt("completedCtg3");

                userToReturn = new User(usrnm, name, completedCtg1, completedCtg2, completedCtg3);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return userToReturn;
    }

    /**
     * Checks User's amount of passed exercises in defined category from User
     * table
     * @param username username of the User the check is performed to
     * @param category category number for the category the check is performed
     * to (1...3)
     * @return integer that is the count of passed exercises in defined category
     * @throws java.lang.Exception
     */
    @Override
    public int passedExercisesInCategory(String username, int category) throws Exception {
        int passedExercises = -1;

        String sqlGetExCount = getSQLForExercises(category);

        try (PreparedStatement stm = connection.prepareStatement(sqlGetExCount)) {
            stm.setString(1, username);
            ResultSet results = stm.executeQuery();

            while (results.next()) {
                passedExercises = results.getInt("completedCtg" + String.valueOf(category));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return passedExercises;
    }

     /**
     * Returns correct SQL for passed exercise counting based on category
     * @param category defines the category
     * @return SQL query string if category is acceptable, empty string otherwise
     */
    private String getSQLForExercises(int category) {
        if (category == 1) {
            return "SELECT completedCtg1 FROM Users WHERE (username == ?)";
        } else if (category == 2) {
            return "SELECT completedCtg2 FROM Users WHERE (username == ?)";
        } else if (category == 3) {
            return "SELECT completedCtg3 FROM Users WHERE (username == ?)";
        }

        return "";
    }

    /**
     * Adds new amount of completed exercises in defined category for User
     * @param username username of the User the completion is added to
     * @param category category number of the completed exercise (1...3)
     * @param newCount new completion count that replaces the old amount
     */
    @Override
    public void addCompletion(String username, int category, int newCount) throws Exception {

        String sqlAddCompletion = getSQLForCompletion(category);

        try (PreparedStatement stm = connection.prepareStatement(sqlAddCompletion)) {
            stm.setInt(1, newCount);
            stm.setString(2, username);
            stm.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Returns correct SQL for adding completion based on category
     * @param category category that completion is added to
     * @return SQL query string if category is acceptable, empty string otherwise
     */
    private String getSQLForCompletion(int category) {
        if (category == 1) {
            return "UPDATE Users SET completedCtg1 = ? WHERE username == ?";
        } else if (category == 2) {
            return "UPDATE Users SET completedCtg2 = ? WHERE username == ?";
        } else if (category == 3) {
            return "UPDATE Users SET completedCtg3 = ? WHERE username == ?";
        }

        return "";
    }

}
