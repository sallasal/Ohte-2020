/**
 *
 * @author sallasal
 */
package comma.dao;

import java.io.*;
import java.sql.*;
import java.util.*;
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
        String sqlCreateExs = "CREATE TABLE IF NOT EXISTS Exercises (firstpart TEXT, secondpart TEXT, comma INTEGER, category INTEGER, creator TEXT)";
        String sqlCreateUsers = "CREATE TABLE IF NOT EXISTS Users (username TEXT, name TEXT, completedExercises INTEGER)";

        try (Statement stm = connection.createStatement()) {
            stm.execute(sqlCreateExs);
            stm.execute(sqlCreateUsers);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        // Note to self: TÄSSÄ PITÄÄ VIELÄ TARKISTAA, ETTÄ TUODAAN HARJOITUKSET VAIN, JOS TAULU ON TYHJÄ.
        bringExercises();

    }

    private void bringExercises() throws Exception {
        String sqlExercise = "INSERT INTO Exercises (firstpart, secondpart, comma, category, creator) VALUES (?,?,?,?,?)";
        
        try (Scanner scanner = new Scanner(new File("src/db/exercises.csv"))) {
            while (scanner.hasNextLine()) {
                String row = scanner.nextLine();
                if (row.trim().length() == 0) {
                    continue;
                }
                
                String[] exParts = row.split("\\|");

                try ( PreparedStatement stm = connection.prepareStatement(sqlExercise)) {
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

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void add(Exercise exercise) {

        String sqlAdd = "INSERT INTO Exercises (firstpart, secondpart, comma, category, creator) VALUES (?,?,?,?,?)";

        String first = exercise.getFirstPart();
        String second = exercise.getSecondPart();
        Boolean comma = exercise.getComma();
        int newcomma;

        if (comma) {
            newcomma = 1;
        } else {
            newcomma = 0;
        }

        try ( PreparedStatement stm = connection.prepareStatement(sqlAdd)) {
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

        String sqlList = "SELECT firstpart, secondpart, comma, category, creator FROM Exercises";
        ArrayList<Exercise> resultList = new ArrayList<>();

        try ( PreparedStatement stm = connection.prepareStatement(sqlList)) {
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

}
