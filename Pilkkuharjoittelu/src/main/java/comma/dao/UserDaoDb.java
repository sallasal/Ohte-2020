/**
 *
 * @author sallasal
 */
package comma.dao;

import java.util.*;
import java.sql.*;
import comma.domain.*;

public class UserDaoDb implements UserDao {
    
    private Connection connection;
    
    public UserDaoDb() {
        this.connection = this.connect();
    }

    @Override
    public Connection connect() {
        String url = "jdbc:sqlite:src/db/commas.db";
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(url);
            DatabaseMetaData meta = connection.getMetaData();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return connection;
    }

    @Override
    public void add(User user) {

        String sqlAddUser = "INSERT INTO Users (username, name, completedExercises) VALUES (?, ?, ?)";

        String username = user.getUsername();
        String name = user.getName();
        int exercises = user.getExercises();

        try (PreparedStatement stm = connection.prepareStatement(sqlAddUser)) {
            stm.setString(1, username);
            stm.setString(2, name);
            stm.setInt(3, exercises);
            stm.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void delete(String username) {

        String sqlDeleteUser = "DELETE FROM Users WHERE username = ?";
        
        try (PreparedStatement stm = connection.prepareStatement(sqlDeleteUser)) {
            stm.setString(1, username);
            stm.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public User findByUsername(String username) {

        User userToReturn = new User();

        String sqlFindUsername = "SELECT username, name, completedExercises FROM Users WHERE (username == ?)";

        try (PreparedStatement stm = connection.prepareStatement(sqlFindUsername)) {
            stm.setString(1, username);
            ResultSet results = stm.executeQuery();

            while (results.next()) {
                String usrnm = results.getString("username");
                String name = results.getString("name");
                int completed = results.getInt("completedExercises");

                userToReturn = new User(usrnm, name, completed);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return userToReturn;
    }

    @Override
    public User findByName(String ame) {
        //Coming soon
        return null;
    }

    @Override
    public int getCompletedExercises(String username) {
        // Coming soon
        return 0;
    }

}
