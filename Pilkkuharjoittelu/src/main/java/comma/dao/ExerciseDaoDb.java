/**
 *
 * @author sallasal
 */
package comma.dao;

import java.io.*;
import java.sql.*;
import java.util.*;
import comma.domain.*;

/**
 * This class covers core of database interaction of the application. The class
 * initializes database and fetches default exercises. It takes care of other
 * Exercise table interactions as well.
 */
public class ExerciseDaoDb implements ExerciseDao {

    private Connection connection;

    /**
     * Generates a new ExerciseDaoDb instance that has database in given
     * location
     *
     * @param dbLocation defines database location and driver
     */
    public ExerciseDaoDb(String dbLocation) {
        this.connection = this.connect(dbLocation);
    }

    /**
     * Connects the class to database using SQLite JDBC driver
     *
     * @param dbLocation defines database location and driver
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
     * Initializes the database: creates tables if not exist already if Exercise
     * table is empty, calls method to fetch default exercises from resource
     * file
     *
     * @throws java.lang.Exception
     */
    @Override
    public void initialize() throws Exception {
        String sqlCreateExs = "CREATE TABLE IF NOT EXISTS Exercises (firstpart TEXT, secondpart TEXT, comma INTEGER, category INTEGER, creator TEXT)";
        String sqlCreateUsers = "CREATE TABLE IF NOT EXISTS Users (username TEXT, name TEXT, completedCtg1 INTEGER, completedCtg2 INTEGER, completedCtg3 INTEGER)";

        try (Statement stm = connection.createStatement()) {
            stm.execute(sqlCreateExs);
            stm.execute(sqlCreateUsers);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        if (checkIfEmpty()) {
            bringExercises();
        }

    }

    /**
     * Reads default exercises from resource file and inserts them to Exercise
     * table
     */
    private void bringExercises() throws Exception {

        InputStream inputStream = null;
        try {
            ClassLoader classLoader = this.getClass().getClassLoader();
            inputStream = classLoader.getResourceAsStream("exercises.csv");
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String row;
            while ((row = reader.readLine()) != null) {

                if (row.trim().length() == 0) {
                    continue;
                }

                String[] exParts = row.split("\\|");
                prepareInsertStatement(exParts);

            }
            reader.close();
            inputStream.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void prepareInsertStatement(String[] exParts) {

        String sqlExercise = "INSERT INTO Exercises (firstpart, secondpart, comma, category, creator) VALUES (?,?,?,?,?)";

        try (PreparedStatement stm = connection.prepareStatement(sqlExercise)) {
            stm.setString(1, exParts[0]);
            stm.setString(2, exParts[1]);
            stm.setInt(3, Integer.parseInt(exParts[2]));
            stm.setInt(4, Integer.parseInt(exParts[3]));
            stm.setString(5, "program");
            stm.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Checks if the Exercise table is empty (= has no rows) in database
     *
     * @return boolean true, if row count is 0, false otherwise
     * @throws java.lang.Exception
     */
    public boolean checkIfEmpty() throws Exception {
        boolean isEmpty = false;
        String sqlCount = "SELECT COUNT(*) AS count FROM Exercises";

        try (PreparedStatement stm = connection.prepareStatement(sqlCount)) {
            ResultSet results = stm.executeQuery();
            while (results.next()) {
                if (results.getInt("count") == 0) {
                    isEmpty = true;
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return isEmpty;
    }

    /**
     * Adds new row to Exercise table based on Exercise object
     *
     * @param exercise Exercise object that is to be added to the database
     */
    @Override
    public void add(Exercise exercise) {

        String sqlAdd = "INSERT INTO Exercises (firstpart, secondpart, comma, category, creator) VALUES (?,?,?,?,?)";
        int comma;

        if (exercise.getComma()) {
            comma = 1;
        } else {
            comma = 0;
        }

        try (PreparedStatement stm = connection.prepareStatement(sqlAdd)) {
            stm.setString(1, exercise.getFirstPart());
            stm.setString(2, exercise.getSecondPart());
            stm.setInt(3, comma);
            stm.setInt(4, exercise.getCategory());
            stm.setString(5, exercise.getCreator());
            stm.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    /**
     * Fetches all exercises from Exercise table as an ArrayList except the ones
     * created by active user
     *
     * @param username username of the (active) user that is excluded from
     * search
     *
     * @return ArrayList of Exercise objects that contains all exercises from db
     */
    @Override
    public ArrayList<Exercise> listAll(String username) {

        String sqlList = "SELECT firstpart, secondpart, comma, category, creator FROM Exercises WHERE creator != ?";
        ArrayList<Exercise> resultList = new ArrayList<>();

        try (PreparedStatement stm = connection.prepareStatement(sqlList)) {
            stm.setString(1, username);
            ResultSet results = stm.executeQuery();

            while (results.next()) {
                String firstpart = results.getString("firstpart");
                String secondpart = results.getString("secondpart");
                int category = results.getInt("category");
                String creator = results.getString("creator");
                boolean comma = false;

                if (results.getInt("comma") == 1) {
                    comma = true;
                }

                resultList.add(new Exercise(firstpart, secondpart, comma, category, creator));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return resultList;
    }
    
    /**
     * Easy way to delete all data from Exercise table
     */
    public void deleteAll() {
        String SQLDelExercises = "DELETE FROM Exercises";
        try (Statement stm = connection.createStatement()) {
            stm.execute(SQLDelExercises);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
    }

}
