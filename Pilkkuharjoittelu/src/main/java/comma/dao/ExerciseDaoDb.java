/**
 *
 * @author sallasal
 */
package comma.dao;

import java.util.*;
import java.sql.*;
import comma.domain.*;

public class ExerciseDaoDb implements ExerciseDao {
    
    private final Connection connection;

    public ExerciseDaoDb() {
        this.connection = this.connect();
    }

    @Override
    public final Connection connect() {
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
    public void initialize() throws Exception {
        String sqlCreateExs = "CREATE TABLE IF NOT EXISTS Exercises (firstpart TEXT, secondpart TEXT, comma INTEGER)";
        String sqlCreateUsers = "CREATE TABLE IF NOT EXISTS Users (username TEXT, name TEXT, completedExercises INTEGER)";

        try (Statement stm = connection.createStatement()) {
            stm.execute(sqlCreateExs);
            stm.execute(sqlCreateUsers);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        //Add three examples for developing, this is going to be better later
        String example = "INSERT INTO Exercises (firstpart, secondpart, comma) VALUES (?,?,?)";
        try (PreparedStatement stm = connection.prepareStatement(example)) {
            stm.setString(1, "Elämä on");
            stm.setString(2, "kuin matka.");
            stm.setInt(3, 0);
            stm.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        try (PreparedStatement stm = connection.prepareStatement(example)) {
            stm.setString(1, "Voimme päättää vain siitä");
            stm.setString(2, "mitä teemme sillä ajalla, joka meille annetaan.");
            stm.setInt(3, 1);
            stm.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        try (PreparedStatement stm = connection.prepareStatement(example)) {
            stm.setString(1, "Lisäämällä omia ideoitani käsien ojennuksiin");
            stm.setString(2, "tuon tanssiin jotain omaani.");
            stm.setInt(3, 0);
            stm.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
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

        try (PreparedStatement stm = connection.prepareStatement(sqlAdd)) {
            stm.setString(1, first);
            stm.setString(2, second);
            stm.setInt(3, newcomma);
            stm.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public ArrayList<Exercise> listAll() {

        String sqlList = "SELECT firstpart, secondpart, comma FROM Exercises";
        ArrayList<Exercise> resultList = new ArrayList<Exercise>();

        try (PreparedStatement stm = connection.prepareStatement(sqlList)) {
            ResultSet results = stm.executeQuery();

            while (results.next()) {
                String firstpart = results.getString("firstpart");
                String secondpart = results.getString("secondpart");
                boolean comma = false;

                if (results.getInt("comma") == 1) {
                    comma = true;
                }

                resultList.add(new Exercise(firstpart, secondpart, comma));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return resultList;
    }
}
