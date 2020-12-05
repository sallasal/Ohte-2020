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
        String url = "jdbc:sqlite:commas.db";
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
    
    @Override
    public int passedExercisesInCategory(String username, int category) {
        int passedExercises = -1;
        String columnName = "compteledCtg"+String.valueOf(category);
        
        String sqlGetExCount = "SELECT ? FROM Users WHERE (username == ?)";
        
        try (PreparedStatement stm = connection.prepareStatement(sqlGetExCount)) {
            stm.setString(1, columnName);
            stm.setString(2, username);
            ResultSet results = stm.executeQuery();
            
            while (results.next()) {
                passedExercises = results.getInt(columnName);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return passedExercises;
    }

    @Override
    public int getCompletedExercises(String username) {
        // Coming soon
        return 0;
    }

}
