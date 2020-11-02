/**
 *
 * @author sallasal
 */
package comma.dao;

import java.util.*;
import java.sql.*;
import comma.domain.*;

public class ExerciseDaoDb implements ExerciseDao {

    private Connection connect() {
        String url = "jdbc:sqlite:src/db/commas.db";
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(url);
            DatabaseMetaData meta = connection.getMetaData();
            System.out.println("The driver name is " + meta.getDriverName());
            System.out.println("Connection created.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return connection;
    }

    public void alusta() {
        String sqlCreate = "CREATE TABLE IF NOT EXISTS Exercises (firstpart TEXT, secondpart TEXT, comma INTEGER)";

        try ( Connection connection = this.connect();  Statement stm = connection.createStatement()) {
            stm.execute(sqlCreate);
            System.out.println("Table created or already was there");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        //Täällä voi luoda harjoitustapauksiakin ainakin ensi alkuun
    }

    @Override
    public void add(Exercise exercise) {
        
        String sqlAdd = "INSERT INTO Exercises (firstpart, secondpart, comma) VALUES (?,?,?)";

        String first = exercise.getFirstPart();
        String second = exercise.getSecondPart();
        Boolean comma = exercise.getComma();
        int newcomma;

        if (comma) {
            newcomma = 1;
        } else {
            newcomma = 0;
        }
        
        try (Connection connection = this.connect(); PreparedStatement stm = connection.prepareStatement(sqlAdd)) {
            stm.setString(1,first);
            stm.setString(2,second);
            stm.setInt(3, newcomma);
            stm.executeUpdate();
            System.out.println("Lisäys onnistui.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public List<Exercise> list() {
        return null;
    }
}
