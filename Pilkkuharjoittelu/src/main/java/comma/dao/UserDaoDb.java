/**
 *
 * @author sallasal
 */
package comma.dao;

import java.util.*;
import java.sql.*;
import comma.domain.*;

public class UserDaoDb implements UserDao {

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
        // Coming soon
    }

    @Override
    public void findByUsername(String username) {
        // Coming soon
    }

    @Override
    public void findByName(String ame) {
        //Coming soon
    }

    @Override
    public int getCompletedExercises(String username) {
        // Coming soon
        return 0;
    }

}
